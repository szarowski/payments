package com.payments.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payments.client.MockbinClient;
import com.payments.error.PaymentsDataNotFoundException;
import com.payments.model.DataJson;
import com.payments.model.PaymentsJson;
import com.payments.model.internal.PaymentData;
import com.payments.model.internal.SenderCharges;
import com.payments.repository.PaymentRepository;
import com.payments.repository.SenderChargesRepository;
import com.payments.transform.PaymentJsonTransformer;
import com.payments.transform.SenderChargesJsonTransformer;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * The Implementation of the Service to process requests from the Payment REST Controller.
 */
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    private static final Logger LOG = getLogger(PaymentServiceImpl.class);

    private final PaymentJsonTransformer paymentTransformer;
    private final SenderChargesJsonTransformer senderChargesTransformer;
    private final PaymentRepository paymentRepository;
    private final SenderChargesRepository senderChargesRepository;
    private final ObjectMapper objectMapper;
    private final MockbinClient mockbin;

    @Autowired
    public PaymentServiceImpl(final PaymentJsonTransformer paymentTransformer,
                              final SenderChargesJsonTransformer senderChargesTransformer,
                              final PaymentRepository paymentRepository,
                              final SenderChargesRepository senderChargesRepository,
                              final ObjectMapper objectMapper,
                              final MockbinClient mockbin) {
        this.paymentTransformer = paymentTransformer;
        this.senderChargesTransformer = senderChargesTransformer;
        this.paymentRepository = paymentRepository;
        this.senderChargesRepository = senderChargesRepository;
        this.objectMapper = objectMapper;
        this.mockbin = mockbin;
    }

    @Override
    public PaymentsJson fetchMockbinData(final UUID dataId) {
        LOG.info("Fetching payment data {}", dataId);
        try {
            final String paymentAsString = mockbin.getPayments(dataId);
            final PaymentsJson payments = objectMapper.readValue(paymentAsString, PaymentsJson.class);
            for (DataJson d : payments.getData()) {
                savePayment(d, d.getId());
            }
            return payments;
        } catch (Exception ioe) {
            throw new PaymentsDataNotFoundException("Cannot fetch the payments");
        }
    }

    @Override
    public DataJson createPayment(final DataJson data) {
        LOG.info("Creating payment data {}", data.getId());
        if (paymentRepository.findPaymentItemsById(data.getId()).isPresent()) {
            return null;
        }
        savePayment(data, data.getId());
        return data;
    }

    @Override
    public DataJson getPayment(final UUID id) {
        final Optional<PaymentData> data = paymentRepository.findPaymentItemsById(id);
        if (data.isPresent()) {
            final List<SenderCharges> senderCharges = senderChargesRepository.findSenderChargesById(id);
            return paymentTransformer.toDataJson(data.get(), senderCharges);
        }
        return null;
    }

    @Override
    public boolean updatePayment(final UUID id, final DataJson data) {
        LOG.info("Updating data {}", data.getId());
        final int itemsDeleted = paymentRepository.deletePaymentByPaymentId(id);
        if (itemsDeleted == 0) {
            return false;
        }
        savePayment(data, id);
        return true;
    }

    @Override
    public boolean deletePayment(final UUID id) {
        LOG.info("Deleting payment {}", id);
        final int itemsDeleted = paymentRepository.deletePaymentByPaymentId(id);
        return itemsDeleted != 0;
    }

    @Override
    public List<DataJson> listPayments() {
        LOG.info("Getting all payments");
        return paymentRepository.findAllPaymentItems().stream()
                .map(p -> paymentTransformer.toDataJson(
                        p, senderChargesRepository.findSenderChargesById(p.getId())))
                .collect(Collectors.toList());
    }

    private void savePayment(final DataJson data, final UUID dataId) {
        paymentRepository.savePaymentItems(paymentTransformer.toPaymentData(dataId, data));
        senderChargesRepository.saveSenderCharges(dataId, senderChargesTransformer.toSenderCharges(dataId,
                data.getAttributes().getChargesInformation().getSenderCharges()));
    }
}
