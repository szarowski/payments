package com.payments.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.base.MoreObjects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Objects;

@ApiModel("Charges Information")
public final class ChargesInformationJson {

    private final String bearerCode;

    @ApiModelProperty(notes = "Sender Charges")
    private final List<SenderChargesJson> senderCharges;

    @ApiModelProperty(notes = "Receiver Charges SenderCharges")
    private final BigDecimal receiverChargesAmount;

    @ApiModelProperty(notes = "Receiver Charges Currency")
    private final Currency receiverChargesCurrency;

    @JsonCreator
    public ChargesInformationJson(final String bearerCode, final List<SenderChargesJson> senderCharges, final BigDecimal receiverChargesAmount,
                                  final Currency receiverChargesCurrency) {
        this.bearerCode = bearerCode;
        this.senderCharges = senderCharges;
        this.receiverChargesAmount = receiverChargesAmount;
        this.receiverChargesCurrency = receiverChargesCurrency;
    }

    public String getBearerCode() {
        return bearerCode;
    }

    public List<SenderChargesJson> getSenderCharges() {
        return senderCharges;
    }

    public BigDecimal getReceiverChargesAmount() {
        return receiverChargesAmount;
    }

    public Currency getReceiverChargesCurrency() {
        return receiverChargesCurrency;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ChargesInformationJson that = (ChargesInformationJson) o;
        return Objects.equals(bearerCode, that.bearerCode) &&
                Objects.equals(senderCharges, that.senderCharges) &&
                Objects.equals(receiverChargesAmount, that.receiverChargesAmount) &&
                Objects.equals(receiverChargesCurrency, that.receiverChargesCurrency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bearerCode, senderCharges, receiverChargesAmount, receiverChargesCurrency);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("bearerCode", bearerCode)
                .add("senderCharges", senderCharges)
                .add("receiverChargesAmount", receiverChargesAmount)
                .add("receiverChargesCurrency", receiverChargesCurrency)
                .toString();
    }
}