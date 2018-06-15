package com.payments.model.internal;

import com.google.common.base.MoreObjects;

import java.util.Currency;
import java.util.Objects;
import java.util.UUID;

public final class SenderCharges {

    private final UUID id;

    private final int amount;

    private final Currency currency;

    public SenderCharges(final UUID id, final int amount, final Currency currency) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
    }

    public UUID getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SenderCharges senderCharges1 = (SenderCharges) o;
        return amount == senderCharges1.amount &&
                Objects.equals(id, senderCharges1.id) &&
                Objects.equals(currency, senderCharges1.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, currency);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("amount", amount)
                .add("currency", currency)
                .toString();
    }
}