package com.payments.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
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
import com.payments.util.Random;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.payments.model.DataJsonBuilder.dataJsonBuilder;
import static com.payments.model.PaymentsJsonBuilder.paymentsJsonBuilder;
import static com.payments.model.internal.PaymentDataBuilder.paymentDataBuilder;
import static com.payments.model.internal.SenderChargesBuilder.senderChargesBuilder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceImplTest {

    @Mock
    private PaymentJsonTransformer paymentTransformer;
    @Mock
    private SenderChargesJsonTransformer senderChargesTransformer;
    @Mock
    private PaymentRepository paymentRepository;
    @Mock
    private SenderChargesRepository senderChargesRepository;
    @Mock
    private ObjectMapper objectMapper;
    @Mock
    private MockbinClient mockbin;

    private PaymentServiceImpl service;

    @Before
    public void setUp() {
        service = new PaymentServiceImpl(paymentTransformer, senderChargesTransformer, paymentRepository,
                senderChargesRepository, objectMapper, mockbin);
    }

    @Test
    public void shouldFetchPaymentData() throws Exception {
        UUID dataId = Random.uuid();
        String paymentAsString = Random.string();
        PaymentsJson payments = paymentsJsonBuilder().build();

        given(mockbin.getPayments(dataId)).willReturn(paymentAsString);
        given(objectMapper.readValue(paymentAsString, PaymentsJson.class)).willReturn(payments);

        PaymentsJson storedPayments = service.fetchMockbinData(dataId);

        assertThat(storedPayments).isEqualTo(payments);
    }


    @Test
    public void shouldFailFetchingPaymentData() {
        UUID dataId = Random.uuid();
        String paymentAsString = Random.string();

        given(mockbin.getPayments(dataId)).willReturn(paymentAsString);

        assertThatThrownBy(() -> service.fetchMockbinData(dataId))
                .isInstanceOf(PaymentsDataNotFoundException.class);
    }

    @Test
    public void shouldCreatePaymentData() {
        DataJson data = dataJsonBuilder().build();

        given(paymentRepository.findPaymentItemsById(data.getId())).willReturn(Optional.empty());

        DataJson storedData = service.createPayment(data);

        assertThat(storedData).isEqualTo(data);
    }

    @Test
    public void shouldCreateAndGetPaymentData() {
        UUID id = Random.uuid();
        DataJson data = dataJsonBuilder().id(id).build();

        given(paymentRepository.findPaymentItemsById(data.getId())).willReturn(Optional.empty());

        DataJson storedData = service.createPayment(data);

        assertThat(storedData).isEqualTo(data);

        PaymentData paymentData = paymentDataBuilder().id(id).version(2).build();

        SenderCharges senderCharges = senderChargesBuilder().id(id).build();

        given(paymentRepository.findPaymentItemsById(id)).willReturn(Optional.of(paymentData));
        given(senderChargesRepository.findSenderChargesById(id)).willReturn(ImmutableList.of(senderCharges));
        given(paymentTransformer.toDataJson(paymentData, ImmutableList.of(senderCharges))).willReturn(data);

        DataJson actualData = service.getPayment(id);

        assertThat(actualData).isEqualTo(data);
    }

    @Test
    public void shouldCreateSelectAndUpdatePaymentData() {
        UUID id = Random.uuid();
        DataJson data = dataJsonBuilder().id(id).build();

        given(paymentRepository.findPaymentItemsById(data.getId())).willReturn(Optional.empty());

        DataJson storedData = service.createPayment(data);

        assertThat(storedData).isEqualTo(data);

        DataJson data2 = dataJsonBuilder().id(id).version(2).build();
        PaymentData paymentData = paymentDataBuilder().id(id).version(2).build();

        given(paymentRepository.deletePaymentByPaymentId(id)).willReturn(1);

        service.updatePayment(id, data2);

        SenderCharges senderCharges = senderChargesBuilder().id(id).build();

        given(paymentRepository.findPaymentItemsById(id)).willReturn(Optional.of(paymentData));
        given(senderChargesRepository.findSenderChargesById(id)).willReturn(ImmutableList.of(senderCharges));
        given(paymentTransformer.toDataJson(paymentData, ImmutableList.of(senderCharges))).willReturn(data2);

        DataJson actualData = service.getPayment(id);

        assertThat(actualData).isEqualTo(data2);
    }

    @Test
    public void shouldCreateSelectAndDeletePaymentData() {
        UUID id = Random.uuid();
        DataJson data = dataJsonBuilder().id(id).build();

        given(paymentRepository.findPaymentItemsById(data.getId())).willReturn(Optional.empty());

        DataJson storedData = service.createPayment(data);

        assertThat(storedData).isEqualTo(data);

        PaymentData paymentData = paymentDataBuilder().id(id).version(2).build();

        SenderCharges senderCharges = senderChargesBuilder().id(id).build();

        given(paymentRepository.findPaymentItemsById(id)).willReturn(Optional.of(paymentData));
        given(senderChargesRepository.findSenderChargesById(id)).willReturn(ImmutableList.of(senderCharges));
        given(paymentTransformer.toDataJson(paymentData, ImmutableList.of(senderCharges))).willReturn(data);

        DataJson actualData = service.getPayment(id);

        assertThat(actualData).isEqualTo(data);

        given(paymentRepository.deletePaymentByPaymentId(id)).willReturn(1);

        assertThat(service.deletePayment(id)).isTrue();
    }

    @Test
    public void shouldCreateAndListPaymentData() {
        UUID id = Random.uuid();
        DataJson data = dataJsonBuilder().id(id).build();

        given(paymentRepository.findPaymentItemsById(data.getId())).willReturn(Optional.empty());

        DataJson storedData = service.createPayment(data);

        assertThat(storedData).isEqualTo(data);

        PaymentData paymentData = paymentDataBuilder().id(id).version(2).build();

        SenderCharges senderCharges = senderChargesBuilder().id(id).build();

        given(paymentRepository.findAllPaymentItems()).willReturn(ImmutableList.of(paymentData));
        given(senderChargesRepository.findSenderChargesById(id)).willReturn(ImmutableList.of(senderCharges));
        given(paymentTransformer.toDataJson(paymentData, ImmutableList.of(senderCharges))).willReturn(data);

        List<DataJson> actualData = service.listPayments();

        assertThat(actualData).isNotEmpty();
    }

    @Test
    public void shouldReturnFalseDeletingNonExistingPaymentData() {
        UUID id = Random.uuid();

        given(paymentRepository.findPaymentItemsById(id)).willReturn(Optional.empty());

        assertThat(service.deletePayment(id)).isFalse();
    }

    @Test
    public void shouldReturnNullIfNotFoundPaymentDataById() {
        UUID id = Random.uuid();

        given(paymentRepository.findPaymentItemsById(id)).willReturn(Optional.empty());

        DataJson actualData = service.getPayment(id);

        assertThat(actualData).isNull();
    }
}
