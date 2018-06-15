package com.payments.model.internal;

import com.payments.util.Random;

import java.util.Currency;
import java.util.UUID;

public final class SenderChargesBuilder {
    private UUID id = Random.uuid();
    private int amount = Random.intVal();
    private Currency currency = Random.currency();

    private SenderChargesBuilder() {
    }

    public static SenderChargesBuilder senderChargesBuilder() {
        return new SenderChargesBuilder();
    }

    public SenderChargesBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public SenderChargesBuilder amount(int amount) {
        this.amount = amount;
        return this;
    }

    public SenderChargesBuilder currency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public SenderCharges build() {
        return new SenderCharges(id, amount, currency);
    }
}