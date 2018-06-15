package com.payments.model;

import com.payments.util.Random;

import java.math.BigDecimal;
import java.util.Currency;

public final class FxJsonBuilder {

    private String contractReference = Random.string();
    private BigDecimal exchangeRate = Random.exchangeRateVal();
    private BigDecimal originalAmount = Random.amountVal();
    private Currency originalCurrency = Random.currency();

    private FxJsonBuilder() {
    }

    public static FxJsonBuilder fxJsonBuilder() {
        return new FxJsonBuilder();
    }

    public FxJsonBuilder contractReference(String contractReference) {
        this.contractReference = contractReference;
        return this;
    }

    public FxJsonBuilder exchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
        return this;
    }

    public FxJsonBuilder originalAmount(BigDecimal originalAmount) {
        this.originalAmount = originalAmount;
        return this;
    }

    public FxJsonBuilder originalCurrency(Currency originalCurrency) {
        this.originalCurrency = originalCurrency;
        return this;
    }

    public FxJson build() {
        return new FxJson(contractReference, exchangeRate, originalAmount, originalCurrency);
    }
}
