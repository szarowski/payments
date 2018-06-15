package com.payments.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.base.MoreObjects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.Objects;

@ApiModel("Attributes")
public final class AttributesJson {

    @ApiModelProperty(notes = "SenderCharges")
    @NotNull
    private final BigDecimal amount;

    @ApiModelProperty(notes = "Beneficiary Party")
    private final PartyJson beneficiaryParty;

    @ApiModelProperty(notes = "Charges Information")
    private final ChargesInformationJson chargesInformation;

    @ApiModelProperty(notes = "Currency")
    @NotNull
    private final Currency currency;

    @ApiModelProperty(notes = "Debtor Party")
    private final PartyJson debtorParty;

    @ApiModelProperty(notes = "End to End Reference")
    private final String endToEndReference;

    @ApiModelProperty(notes = "FX")
    private final FxJson fx;

    @ApiModelProperty(notes = "Numeric Reference")
    private final String numericReference;

    @ApiModelProperty(notes = "Payment ID")
    private final String paymentId;

    @ApiModelProperty(notes = "Payment Purpose")
    private final String paymentPurpose;

    @ApiModelProperty(notes = "Payment Scheme")
    private final String paymentScheme;

    @ApiModelProperty(notes = "Payment Type")
    private final String paymentType;

    @ApiModelProperty(notes = "Processing Date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private final Date processingDate;

    @ApiModelProperty(notes = "Reference")
    private final String reference;

    @ApiModelProperty(notes = "Scheme Payment Subtype")
    private final String schemePaymentSubType;

    @ApiModelProperty(notes = "Scheme Payment Type")
    private final String schemePaymentType;

    @ApiModelProperty(notes = "Sponsor Party")
    private final PartyJson sponsorParty;

    @JsonCreator
    public AttributesJson(final BigDecimal amount, final PartyJson beneficiaryParty, final ChargesInformationJson chargesInformation,
                          final Currency currency, final PartyJson debtorParty, final String endToEndReference, final FxJson fx,
                          final String numericReference, final String paymentId, final String paymentPurpose,
                          final String paymentScheme, final String paymentType, final Date processingDate, final String reference,
                          final String schemePaymentSubType, final String schemePaymentType, final PartyJson sponsorParty) {
        this.amount = amount;
        this.beneficiaryParty = beneficiaryParty;
        this.chargesInformation = chargesInformation;
        this.currency = currency;
        this.debtorParty = debtorParty;
        this.endToEndReference = endToEndReference;
        this.fx = fx;
        this.numericReference = numericReference;
        this.paymentId = paymentId;
        this.paymentPurpose = paymentPurpose;
        this.paymentScheme = paymentScheme;
        this.paymentType = paymentType;
        this.processingDate = processingDate;
        this.reference = reference;
        this.schemePaymentSubType = schemePaymentSubType;
        this.schemePaymentType = schemePaymentType;
        this.sponsorParty = sponsorParty;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public PartyJson getBeneficiaryParty() {
        return beneficiaryParty;
    }

    public ChargesInformationJson getChargesInformation() {
        return chargesInformation;
    }

    public Currency getCurrency() {
        return currency;
    }

    public PartyJson getDebtorParty() {
        return debtorParty;
    }

    public String getEndToEndReference() {
        return endToEndReference;
    }

    public FxJson getFx() {
        return fx;
    }

    public String getNumericReference() {
        return numericReference;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getPaymentPurpose() {
        return paymentPurpose;
    }

    public String getPaymentScheme() {
        return paymentScheme;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public Date getProcessingDate() {
        return processingDate;
    }

    public String getReference() {
        return reference;
    }

    public String getSchemePaymentSubType() {
        return schemePaymentSubType;
    }

    public String getSchemePaymentType() {
        return schemePaymentType;
    }

    public PartyJson getSponsorParty() {
        return sponsorParty;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AttributesJson that = (AttributesJson) o;
        return Objects.equals(amount, that.amount) &&
                Objects.equals(beneficiaryParty, that.beneficiaryParty) &&
                Objects.equals(chargesInformation, that.chargesInformation) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(debtorParty, that.debtorParty) &&
                Objects.equals(endToEndReference, that.endToEndReference) &&
                Objects.equals(fx, that.fx) &&
                Objects.equals(numericReference, that.numericReference) &&
                Objects.equals(paymentId, that.paymentId) &&
                Objects.equals(paymentPurpose, that.paymentPurpose) &&
                Objects.equals(paymentScheme, that.paymentScheme) &&
                Objects.equals(paymentType, that.paymentType) &&
                Objects.equals(processingDate, that.processingDate) &&
                Objects.equals(reference, that.reference) &&
                Objects.equals(schemePaymentSubType, that.schemePaymentSubType) &&
                Objects.equals(schemePaymentType, that.schemePaymentType) &&
                Objects.equals(sponsorParty, that.sponsorParty);
    }

    @Override
    public int hashCode() {

        return Objects.hash(amount, beneficiaryParty, chargesInformation, currency, debtorParty, endToEndReference, fx, numericReference, paymentId, paymentPurpose, paymentScheme, paymentType, processingDate, reference, schemePaymentSubType, schemePaymentType, sponsorParty);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("amount", amount)
                .add("beneficiaryParty", beneficiaryParty)
                .add("chargesInformation", chargesInformation)
                .add("currency", currency)
                .add("debtorParty", debtorParty)
                .add("endToEndReference", endToEndReference)
                .add("fx", fx)
                .add("numericReference", numericReference)
                .add("paymentId", paymentId)
                .add("paymentPurpose", paymentPurpose)
                .add("paymentScheme", paymentScheme)
                .add("paymentType", paymentType)
                .add("processingDate", processingDate)
                .add("reference", reference)
                .add("schemePaymentSubType", schemePaymentSubType)
                .add("schemePaymentType", schemePaymentType)
                .add("sponsorParty", sponsorParty)
                .toString();
    }
}