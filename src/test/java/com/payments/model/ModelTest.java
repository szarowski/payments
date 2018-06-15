package com.payments.model;


import be.joengenduvel.java.verifiers.ToStringVerifier;
import com.payments.model.internal.PaymentData;
import com.payments.model.internal.SenderCharges;
import com.payments.swagger.SwaggerApi;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import java.util.Currency;

import static com.payments.model.AttributesJsonBuilder.attributesJsonBuilder;
import static com.payments.model.ChargesInformationJsonBuilder.chargesInformationJsonBuilder;
import static com.payments.model.DataJsonBuilder.dataJsonBuilder;
import static com.payments.model.FxJsonBuilder.fxJsonBuilder;
import static com.payments.model.LinksJsonBuilder.linksJsonBuilder;
import static com.payments.model.PartyJsonBuilder.partyJsonBuilder;
import static com.payments.model.PaymentsJsonBuilder.paymentsJsonBuilder;
import static com.payments.model.SenderChargesJsonBuilder.senderChargesJsonBuilder;
import static com.payments.model.internal.PaymentDataBuilder.paymentDataBuilder;
import static com.payments.model.internal.SenderChargesBuilder.senderChargesBuilder;
import static com.payments.swagger.SwaggerApiBuilder.swaggerApiBuilder;

public class ModelTest {

    @Test
    public void shouldTestEqualsAndHashCode() {
        EqualsVerifier.forClass(PaymentData.class)
                .withPrefabValues(Currency.class, Currency.getInstance("CZK"), Currency.getInstance("EUR"))
                .verify();
        EqualsVerifier.forClass(SenderCharges.class)
                .withPrefabValues(Currency.class, Currency.getInstance("CZK"), Currency.getInstance("EUR"))
                .verify();

        EqualsVerifier.forClass(AttributesJson.class)
                .withPrefabValues(Currency.class, Currency.getInstance("CZK"), Currency.getInstance("EUR"))
                .verify();
        EqualsVerifier.forClass(ChargesInformationJson.class)
                .withPrefabValues(Currency.class, Currency.getInstance("CZK"), Currency.getInstance("EUR"))
                .verify();
        EqualsVerifier.forClass(DataJson.class)
                .withPrefabValues(Currency.class, Currency.getInstance("CZK"), Currency.getInstance("EUR"))
                .verify();
        EqualsVerifier.forClass(FxJson.class)
                .withPrefabValues(Currency.class, Currency.getInstance("CZK"), Currency.getInstance("EUR"))
                .verify();
        EqualsVerifier.forClass(LinksJson.class).verify();
        EqualsVerifier.forClass(PartyJson.class).verify();
        EqualsVerifier.forClass(PaymentsJson.class)
                .withPrefabValues(Currency.class, Currency.getInstance("CZK"), Currency.getInstance("EUR"))
                .verify();
        EqualsVerifier.forClass(SenderChargesJson.class)
                .withPrefabValues(Currency.class, Currency.getInstance("CZK"), Currency.getInstance("EUR"))
                .verify();

        EqualsVerifier.forClass(SwaggerApi.class);
    }

    @Test
    public void shouldTestToString() {
        ToStringVerifier.forClass(PaymentData.class).containsAllPrivateFields(paymentDataBuilder().build());
        ToStringVerifier.forClass(SenderCharges.class).containsAllPrivateFields(senderChargesBuilder().build());

        ToStringVerifier.forClass(AttributesJson.class).containsAllPrivateFields(attributesJsonBuilder().build());
        ToStringVerifier.forClass(ChargesInformationJson.class).containsAllPrivateFields(chargesInformationJsonBuilder().build());
        ToStringVerifier.forClass(DataJson.class).containsAllPrivateFields(dataJsonBuilder().build());
        ToStringVerifier.forClass(FxJson.class).containsAllPrivateFields(fxJsonBuilder().build());
        ToStringVerifier.forClass(LinksJson.class).containsAllPrivateFields(linksJsonBuilder().build());
        ToStringVerifier.forClass(PartyJson.class).containsAllPrivateFields(partyJsonBuilder().build());
        ToStringVerifier.forClass(PaymentsJson.class).containsAllPrivateFields(paymentsJsonBuilder().build());
        ToStringVerifier.forClass(SenderChargesJson.class).containsAllPrivateFields(senderChargesJsonBuilder().build());

        ToStringVerifier.forClass(SwaggerApi.class).containsAllPrivateFields(swaggerApiBuilder().build());
    }
}