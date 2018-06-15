package com.payments.repository;

import com.payments.model.internal.PaymentData;
import com.payments.util.RepositoryTest;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.util.Optional;
import java.util.UUID;

import static com.payments.model.internal.PaymentDataBuilder.paymentDataBuilder;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@RepositoryTest({ PaymentRepositoryImpl.class, SenderChargesRepositoryImpl.class })
public class PaymentRepositoryImplITest {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private JdbcTemplate jdbc;

    @After
    public void wipeDb() {
        JdbcTestUtils.deleteFromTables(jdbc, "sender_charges_amount");
        JdbcTestUtils.deleteFromTables(jdbc, "payment_data");
    }

    @Test
    public void shouldInsertSelectAndDelete() {
        UUID id = UUID.randomUUID();

        PaymentData expectedObject = paymentDataBuilder().id(id).build();
        paymentRepository.savePaymentItems(expectedObject);

        Optional<PaymentData> actualObject = paymentRepository.findPaymentItemsById(id);

        assertThat(actualObject.get()).isEqualTo(expectedObject);
        assertThat(actualObject.toString()).contains(expectedObject.toString());

        paymentRepository.deletePaymentByPaymentId(id);

        actualObject = paymentRepository.findPaymentItemsById(id);

        assertThat(actualObject).isNotPresent();
    }
}