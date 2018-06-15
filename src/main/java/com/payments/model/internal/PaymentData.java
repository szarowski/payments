package com.payments.model.internal;

import com.google.common.base.MoreObjects;

import java.time.OffsetDateTime;
import java.util.Currency;
import java.util.Objects;
import java.util.UUID;

public final class PaymentData {

    private final String type;
    private final UUID id;
    private final Integer version;
    private final UUID organisationId;
    private final Integer amount;
    private final String beneficiaryPartyAccountName;
    private final String beneficiaryPartyAccountNumber;
    private final String beneficiaryPartyAccountNumberCode;
    private final Integer beneficiaryPartyAccountType;
    private final String beneficiaryPartyAddress;
    private final String beneficiaryPartyBankId;
    private final String beneficiaryPartyBankIdCode;
    private final String beneficiaryPartyName;
    private final String bearerCode;
    private final Integer receiverChargesAmount;
    private final Currency receiverChargesCurrency;
    private final Currency currency;
    private final String debtorPartyAccountName;
    private final String debtorPartyAccountNumber;
    private final String debtorPartyAccountNumberCode;
    private final String debtorPartyAddress;
    private final String debtorPartyBankId;
    private final String debtorPartyBankIdCode;
    private final String debtorPartyName;
    private final String endToEndReference;
    private final String fxContractReference;
    private final Integer fxExchangeRate;
    private final Integer fxOriginalAmount;
    private final Currency fxOriginalCurrency;
    private final String numericReference;
    private final String paymentId;
    private final String paymentPurpose;
    private final String paymentScheme;
    private final String paymentType;
    private final OffsetDateTime processingDate;
    private final String reference;
    private final String schemePaymentSubType;
    private final String schemePaymentType;
    private final String sponsorPartyAccountNumber;
    private final String sponsorPartyBankId;
    private final String sponsorPartyBankIdCode;

    public PaymentData(final String type, final UUID id, final Integer version, final UUID organisationId, final Integer amount,
                       final String beneficiaryPartyAccountName, final String beneficiaryPartyAccountNumber,
                       final String beneficiaryPartyAccountNumberCode, final Integer beneficiaryPartyAccountType,
                       final String beneficiaryPartyAddress, final String beneficiaryPartyBankId, final String beneficiaryPartyBankIdCode,
                       final String beneficiaryPartyName, final String bearerCode, final Integer receiverChargesAmount,
                       final Currency receiverChargesCurrency, final Currency currency, final String debtorPartyAccountName,
                       final String debtorPartyAccountNumber, final String debtorPartyAccountNumberCode, final String debtorPartyAddress,
                       final String debtorPartyBankId, final String debtorPartyBankIdCode, final String debtorPartyName,
                       final String endToEndReference, final String fxContractReference, final Integer fxExchangeRate,
                       final Integer fxOriginalAmount, final Currency fxOriginalCurrency, final String numericReference,
                       final String paymentId, final String paymentPurpose, final String paymentScheme, final String paymentType,
                       final OffsetDateTime processingDate, final String reference, final String schemePaymentSubType,
                       final String schemePaymentType, final String sponsorPartyAccountNumber, final String sponsorPartyBankId,
                       final String sponsorPartyBankIdCode) {
        this.type = type;
        this.id = id;
        this.version = version;
        this.organisationId = organisationId;
        this.amount = amount;
        this.beneficiaryPartyAccountName = beneficiaryPartyAccountName;
        this.beneficiaryPartyAccountNumber = beneficiaryPartyAccountNumber;
        this.beneficiaryPartyAccountNumberCode = beneficiaryPartyAccountNumberCode;
        this.beneficiaryPartyAccountType = beneficiaryPartyAccountType;
        this.beneficiaryPartyAddress = beneficiaryPartyAddress;
        this.beneficiaryPartyBankId = beneficiaryPartyBankId;
        this.beneficiaryPartyBankIdCode = beneficiaryPartyBankIdCode;
        this.beneficiaryPartyName = beneficiaryPartyName;
        this.bearerCode = bearerCode;
        this.receiverChargesAmount = receiverChargesAmount;
        this.receiverChargesCurrency = receiverChargesCurrency;
        this.currency = currency;
        this.debtorPartyAccountName = debtorPartyAccountName;
        this.debtorPartyAccountNumber = debtorPartyAccountNumber;
        this.debtorPartyAccountNumberCode = debtorPartyAccountNumberCode;
        this.debtorPartyAddress = debtorPartyAddress;
        this.debtorPartyBankId = debtorPartyBankId;
        this.debtorPartyBankIdCode = debtorPartyBankIdCode;
        this.debtorPartyName = debtorPartyName;
        this.endToEndReference = endToEndReference;
        this.fxContractReference = fxContractReference;
        this.fxExchangeRate = fxExchangeRate;
        this.fxOriginalAmount = fxOriginalAmount;
        this.fxOriginalCurrency = fxOriginalCurrency;
        this.numericReference = numericReference;
        this.paymentId = paymentId;
        this.paymentPurpose = paymentPurpose;
        this.paymentScheme = paymentScheme;
        this.paymentType = paymentType;
        this.processingDate = processingDate;
        this.reference = reference;
        this.schemePaymentSubType = schemePaymentSubType;
        this.schemePaymentType = schemePaymentType;
        this.sponsorPartyAccountNumber = sponsorPartyAccountNumber;
        this.sponsorPartyBankId = sponsorPartyBankId;
        this.sponsorPartyBankIdCode = sponsorPartyBankIdCode;
    }

    public String getType() {
        return type;
    }

    public UUID getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public UUID getOrganisationId() {
        return organisationId;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getBeneficiaryPartyAccountName() {
        return beneficiaryPartyAccountName;
    }

    public String getBeneficiaryPartyAccountNumber() {
        return beneficiaryPartyAccountNumber;
    }

    public String getBeneficiaryPartyAccountNumberCode() {
        return beneficiaryPartyAccountNumberCode;
    }

    public Integer getBeneficiaryPartyAccountType() {
        return beneficiaryPartyAccountType;
    }

    public String getBeneficiaryPartyAddress() {
        return beneficiaryPartyAddress;
    }

    public String getBeneficiaryPartyBankId() {
        return beneficiaryPartyBankId;
    }

    public String getBeneficiaryPartyBankIdCode() {
        return beneficiaryPartyBankIdCode;
    }

    public String getBeneficiaryPartyName() {
        return beneficiaryPartyName;
    }

    public String getBearerCode() {
        return bearerCode;
    }

    public Integer getReceiverChargesAmount() {
        return receiverChargesAmount;
    }

    public Currency getReceiverChargesCurrency() {
        return receiverChargesCurrency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public String getDebtorPartyAccountName() {
        return debtorPartyAccountName;
    }

    public String getDebtorPartyAccountNumber() {
        return debtorPartyAccountNumber;
    }

    public String getDebtorPartyAccountNumberCode() {
        return debtorPartyAccountNumberCode;
    }

    public String getDebtorPartyAddress() {
        return debtorPartyAddress;
    }

    public String getDebtorPartyBankId() {
        return debtorPartyBankId;
    }

    public String getDebtorPartyBankIdCode() {
        return debtorPartyBankIdCode;
    }

    public String getDebtorPartyName() {
        return debtorPartyName;
    }

    public String getEndToEndReference() {
        return endToEndReference;
    }

    public String getFxContractReference() {
        return fxContractReference;
    }

    public Integer getFxExchangeRate() {
        return fxExchangeRate;
    }

    public Integer getFxOriginalAmount() {
        return fxOriginalAmount;
    }

    public Currency getFxOriginalCurrency() {
        return fxOriginalCurrency;
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

    public OffsetDateTime getProcessingDate() {
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

    public String getSponsorPartyAccountNumber() {
        return sponsorPartyAccountNumber;
    }

    public String getSponsorPartyBankId() {
        return sponsorPartyBankId;
    }

    public String getSponsorPartyBankIdCode() {
        return sponsorPartyBankIdCode;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PaymentData that = (PaymentData) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(id, that.id) &&
                Objects.equals(version, that.version) &&
                Objects.equals(organisationId, that.organisationId) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(beneficiaryPartyAccountName, that.beneficiaryPartyAccountName) &&
                Objects.equals(beneficiaryPartyAccountNumber, that.beneficiaryPartyAccountNumber) &&
                Objects.equals(beneficiaryPartyAccountNumberCode, that.beneficiaryPartyAccountNumberCode) &&
                Objects.equals(beneficiaryPartyAccountType, that.beneficiaryPartyAccountType) &&
                Objects.equals(beneficiaryPartyAddress, that.beneficiaryPartyAddress) &&
                Objects.equals(beneficiaryPartyBankId, that.beneficiaryPartyBankId) &&
                Objects.equals(beneficiaryPartyBankIdCode, that.beneficiaryPartyBankIdCode) &&
                Objects.equals(beneficiaryPartyName, that.beneficiaryPartyName) &&
                Objects.equals(bearerCode, that.bearerCode) &&
                Objects.equals(receiverChargesAmount, that.receiverChargesAmount) &&
                Objects.equals(receiverChargesCurrency, that.receiverChargesCurrency) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(debtorPartyAccountName, that.debtorPartyAccountName) &&
                Objects.equals(debtorPartyAccountNumber, that.debtorPartyAccountNumber) &&
                Objects.equals(debtorPartyAccountNumberCode, that.debtorPartyAccountNumberCode) &&
                Objects.equals(debtorPartyAddress, that.debtorPartyAddress) &&
                Objects.equals(debtorPartyBankId, that.debtorPartyBankId) &&
                Objects.equals(debtorPartyBankIdCode, that.debtorPartyBankIdCode) &&
                Objects.equals(debtorPartyName, that.debtorPartyName) &&
                Objects.equals(endToEndReference, that.endToEndReference) &&
                Objects.equals(fxContractReference, that.fxContractReference) &&
                Objects.equals(fxExchangeRate, that.fxExchangeRate) &&
                Objects.equals(fxOriginalAmount, that.fxOriginalAmount) &&
                Objects.equals(fxOriginalCurrency, that.fxOriginalCurrency) &&
                Objects.equals(numericReference, that.numericReference) &&
                Objects.equals(paymentId, that.paymentId) &&
                Objects.equals(paymentPurpose, that.paymentPurpose) &&
                Objects.equals(paymentScheme, that.paymentScheme) &&
                Objects.equals(paymentType, that.paymentType) &&
                Objects.equals(processingDate, that.processingDate) &&
                Objects.equals(reference, that.reference) &&
                Objects.equals(schemePaymentSubType, that.schemePaymentSubType) &&
                Objects.equals(schemePaymentType, that.schemePaymentType) &&
                Objects.equals(sponsorPartyAccountNumber, that.sponsorPartyAccountNumber) &&
                Objects.equals(sponsorPartyBankId, that.sponsorPartyBankId) &&
                Objects.equals(sponsorPartyBankIdCode, that.sponsorPartyBankIdCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, version, organisationId, amount, beneficiaryPartyAccountName, beneficiaryPartyAccountNumber,
                beneficiaryPartyAccountNumberCode, beneficiaryPartyAccountType, beneficiaryPartyAddress, beneficiaryPartyBankId,
                beneficiaryPartyBankIdCode, beneficiaryPartyName, bearerCode, receiverChargesAmount, receiverChargesCurrency, currency,
                debtorPartyAccountName, debtorPartyAccountNumber, debtorPartyAccountNumberCode, debtorPartyAddress, debtorPartyBankId,
                debtorPartyBankIdCode, debtorPartyName, endToEndReference, fxContractReference, fxExchangeRate, fxOriginalAmount,
                fxOriginalCurrency, numericReference, paymentId, paymentPurpose, paymentScheme, paymentType, processingDate,
                reference, schemePaymentSubType, schemePaymentType, sponsorPartyAccountNumber, sponsorPartyBankId, sponsorPartyBankIdCode);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("type", type)
                .add("id", id)
                .add("version", version)
                .add("organisationId", organisationId)
                .add("amount", amount)
                .add("beneficiaryPartyAccountName", beneficiaryPartyAccountName)
                .add("beneficiaryPartyAccountNumber", beneficiaryPartyAccountNumber)
                .add("beneficiaryPartyAccountNumberCode", beneficiaryPartyAccountNumberCode)
                .add("beneficiaryPartyAccountType", beneficiaryPartyAccountType)
                .add("beneficiaryPartyAddress", beneficiaryPartyAddress)
                .add("beneficiaryPartyBankId", beneficiaryPartyBankId)
                .add("beneficiaryPartyBankIdCode", beneficiaryPartyBankIdCode)
                .add("beneficiaryPartyName", beneficiaryPartyName)
                .add("bearerCode", bearerCode)
                .add("receiverChargesAmount", receiverChargesAmount)
                .add("receiverChargesCurrency", receiverChargesCurrency)
                .add("currency", currency)
                .add("debtorPartyAccountName", debtorPartyAccountName)
                .add("debtorPartyAccountNumber", debtorPartyAccountNumber)
                .add("debtorPartyAccountNumberCode", debtorPartyAccountNumberCode)
                .add("debtorPartyAddress", debtorPartyAddress)
                .add("debtorPartyBankId", debtorPartyBankId)
                .add("debtorPartyBankIdCode", debtorPartyBankIdCode)
                .add("debtorPartyName", debtorPartyName)
                .add("endToEndReference", endToEndReference)
                .add("fxContractReference", fxContractReference)
                .add("fxExchangeRate", fxExchangeRate)
                .add("fxOriginalAmount", fxOriginalAmount)
                .add("fxOriginalCurrency", fxOriginalCurrency)
                .add("numericReference", numericReference)
                .add("paymentId", paymentId)
                .add("paymentPurpose", paymentPurpose)
                .add("paymentScheme", paymentScheme)
                .add("paymentType", paymentType)
                .add("processingDate", processingDate)
                .add("reference", reference)
                .add("schemePaymentSubType", schemePaymentSubType)
                .add("schemePaymentType", schemePaymentType)
                .add("sponsorPartyAccountNumber", sponsorPartyAccountNumber)
                .add("sponsorPartyBankId", sponsorPartyBankId)
                .add("sponsorPartyBankIdCode", sponsorPartyBankIdCode)
                .toString();
    }
}