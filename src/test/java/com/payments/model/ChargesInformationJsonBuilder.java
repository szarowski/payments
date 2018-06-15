package com.payments.model;

import com.payments.util.Random;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

import static com.payments.model.SenderChargesJsonBuilder.senderChargesJsonBuilder;

public final class ChargesInformationJsonBuilder {

    private String bearerCode = Random.string(64);
    private List<SenderChargesJson> senderCharges = Random.list(senderChargesJsonBuilder().build());
    private BigDecimal receiverChargesAmount = Random.amountVal();
    private Currency receiverChargesCurrency = Random.currency();

    private ChargesInformationJsonBuilder() {
    }

    public static ChargesInformationJsonBuilder chargesInformationJsonBuilder() {
        return new ChargesInformationJsonBuilder();
    }

    public ChargesInformationJsonBuilder bearerCode(String bearerCode) {
        this.bearerCode = bearerCode;
        return this;
    }

    public ChargesInformationJsonBuilder senderCharges(List<SenderChargesJson> senderCharges) {
        this.senderCharges = senderCharges;
        return this;
    }

    public ChargesInformationJsonBuilder receiverChargesAmount(BigDecimal receiverChargesAmount) {
        this.receiverChargesAmount = receiverChargesAmount;
        return this;
    }

    public ChargesInformationJsonBuilder receiverChargesCurrency(Currency receiverChargesCurrency) {
        this.receiverChargesCurrency = receiverChargesCurrency;
        return this;
    }

    public ChargesInformationJson build() {
        return new ChargesInformationJson(bearerCode, senderCharges, receiverChargesAmount, receiverChargesCurrency);
    }
}
