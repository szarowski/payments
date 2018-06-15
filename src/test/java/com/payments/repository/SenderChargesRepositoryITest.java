package com.payments.repository;

import com.google.common.collect.ImmutableList;
import com.payments.model.internal.PaymentData;
import com.payments.model.internal.SenderCharges;
import com.payments.util.RepositoryTest;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.util.List;
import java.util.UUID;

import static com.payments.model.internal.PaymentDataBuilder.paymentDataBuilder;
import static com.payments.model.internal.SenderChargesBuilder.senderChargesBuilder;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@RepositoryTest({ PaymentRepositoryImpl.class, SenderChargesRepositoryImpl.class })
public class SenderChargesRepositoryITest {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private SenderChargesRepository senderChargesRepository;

    @Autowired
    private JdbcTemplate jdbc;

    @After
    public void wipeDb() {
        JdbcTestUtils.deleteFromTables(jdbc, "sender_charges_amount");
        JdbcTestUtils.deleteFromTables(jdbc, "payment_data");
    }

    @Test
    public void shouldInsertAndSelectTwoSenderCharges() {
        UUID id = UUID.randomUUID();

        PaymentData expectedObject = paymentDataBuilder().id(id).build();
        paymentRepository.savePaymentItems(expectedObject);

        SenderCharges expectedObject1 = senderChargesBuilder().id(id).build();
        SenderCharges expectedObject2 = senderChargesBuilder().id(id).build();
        senderChargesRepository.saveSenderCharges(id, ImmutableList.of(expectedObject1, expectedObject2));

        List<SenderCharges> actualObject = senderChargesRepository.findSenderChargesById(id);

        assertThat(actualObject.size()).isEqualTo(2);

        paymentRepository.deletePaymentByPaymentId(id);

        actualObject = senderChargesRepository.findSenderChargesById(id);

        assertThat(actualObject).isEmpty();
    }
}