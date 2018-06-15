package com.payments.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.base.MoreObjects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

@ApiModel("Fx")
public final class FxJson {

    @ApiModelProperty(notes = "Contract Reference")
    private final String contractReference;

    @ApiModelProperty(notes = "Exchange Rate")
    private final BigDecimal exchangeRate;

    @ApiModelProperty(notes = "Original SenderCharges")
    @NotNull
    private final BigDecimal originalAmount;

    @ApiModelProperty(notes = "Original Currency")
    @NotNull
    private final Currency originalCurrency;

    @JsonCreator
    public FxJson(final String contractReference, final BigDecimal exchangeRate, final BigDecimal originalAmount,
                  final Currency originalCurrency) {
        this.contractReference = contractReference;
        this.exchangeRate = exchangeRate;
        this.originalAmount = originalAmount;
        this.originalCurrency = originalCurrency;
    }

    public String getContractReference() {
        return contractReference;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    public Currency getOriginalCurrency() {
        return originalCurrency;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final FxJson fxJson = (FxJson) o;
        return Objects.equals(contractReference, fxJson.contractReference) &&
                Objects.equals(exchangeRate, fxJson.exchangeRate) &&
                Objects.equals(originalAmount, fxJson.originalAmount) &&
                Objects.equals(originalCurrency, fxJson.originalCurrency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractReference, exchangeRate, originalAmount, originalCurrency);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("contractReference", contractReference)
                .add("exchangeRate", exchangeRate)
                .add("originalAmount", originalAmount)
                .add("originalCurrency", originalCurrency)
                .toString();
    }
}