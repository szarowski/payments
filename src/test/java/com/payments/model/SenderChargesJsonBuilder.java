package com.payments.model;

import com.payments.util.Random;

import java.math.BigDecimal;
import java.util.Currency;

public final class SenderChargesJsonBuilder {

    private BigDecimal amount = Random.amountVal();
    private Currency currency = Random.currency();

    private SenderChargesJsonBuilder() {
    }

    public static SenderChargesJsonBuilder senderChargesJsonBuilder() {
        return new SenderChargesJsonBuilder();
    }

    public SenderChargesJsonBuilder amount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public SenderChargesJsonBuilder currency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public SenderChargesJson build() {
        return new SenderChargesJson(amount, currency);
    }
}
