package com.payments.model.internal;

import com.payments.util.Random;

import java.time.OffsetDateTime;
import java.util.Currency;
import java.util.UUID;

public final class PaymentDataBuilder {

    private String type = Random.string();
    private UUID id = Random.uuid();
    private Integer version = Random.intVal();
    private UUID organisationId = Random.uuid();
    private int amount = Random.intVal();
    private String beneficiaryPartyAccountName = Random.string();
    private String beneficiaryPartyAccountNumber = Random.accountNumber();
    private String beneficiaryPartyAccountNumberCode = Random.string(64);
    private Integer beneficiaryPartyAccountType = Random.intVal();
    private String beneficiaryPartyAddress = Random.string();
    private String beneficiaryPartyBankId = Random.string(64);
    private String beneficiaryPartyBankIdCode = Random.string(64);
    private String beneficiaryPartyName = Random.string();
    private String bearerCode = Random.string(64);
    private int receiverChargesAmount = Random.intVal();
    private Currency receiverChargesCurrency = Random.currency();
    private Currency currency = Random.currency();
    private String debtorPartyAccountName = Random.string();
    private String debtorPartyAccountNumber = Random.accountNumber();
    private String debtorPartyAccountNumberCode = Random.string(64);
    private String debtorPartyAddress = Random.string();
    private String debtorPartyBankId = Random.string(64);
    private String debtorPartyBankIdCode = Random.string(64);
    private String debtorPartyName = Random.string();
    private String endToEndReference = Random.string();
    private String fxContractReference = Random.string();
    private int fxExchangeRate = Random.intVal();
    private int fxOriginalAmount = Random.intVal();
    private Currency fxOriginalCurrency = Random.currency();
    private String numericReference = Random.string(64);
    private String paymentId = Random.string(64);
    private String paymentPurpose = Random.string();
    private String paymentScheme = Random.string(64);
    private String paymentType = Random.string(64);
    private OffsetDateTime processingDate = Random.pastOffsetDateTime();
    private String reference = Random.string();
    private String schemePaymentSubType = Random.string(64);
    private String schemePaymentType = Random.string(64);
    private String sponsorPartyAccountNumber = Random.accountNumber();
    private String sponsorPartyBankId = Random.string(64);
    private String sponsorPartyBankIdCode = Random.string(64);

    private PaymentDataBuilder() {
    }

    public static PaymentDataBuilder paymentDataBuilder() {
        return new PaymentDataBuilder();
    }

    public PaymentDataBuilder type(String type) {
        this.type = type;
        return this;
    }

    public PaymentDataBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public PaymentDataBuilder version(Integer version) {
        this.version = version;
        return this;
    }

    public PaymentDataBuilder organisationId(UUID organisationId) {
        this.organisationId = organisationId;
        return this;
    }

    public PaymentDataBuilder amount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public PaymentDataBuilder beneficiaryPartyAccountName(String beneficiaryPartyAccountName) {
        this.beneficiaryPartyAccountName = beneficiaryPartyAccountName;
        return this;
    }

    public PaymentDataBuilder beneficiaryPartyAccountNumber(String beneficiaryPartyAccountNumber) {
        this.beneficiaryPartyAccountNumber = beneficiaryPartyAccountNumber;
        return this;
    }

    public PaymentDataBuilder beneficiaryPartyAccountNumberCode(String beneficiaryPartyAccountNumberCode) {
        this.beneficiaryPartyAccountNumberCode = beneficiaryPartyAccountNumberCode;
        return this;
    }

    public PaymentDataBuilder beneficiaryPartyAccountType(Integer beneficiaryPartyAccountType) {
        this.beneficiaryPartyAccountType = beneficiaryPartyAccountType;
        return this;
    }

    public PaymentDataBuilder beneficiaryPartyAddress(String beneficiaryPartyAddress) {
        this.beneficiaryPartyAddress = beneficiaryPartyAddress;
        return this;
    }

    public PaymentDataBuilder beneficiaryPartyBankId(String beneficiaryPartyBankId) {
        this.beneficiaryPartyBankId = beneficiaryPartyBankId;
        return this;
    }

    public PaymentDataBuilder beneficiaryPartyBankIdCode(String beneficiaryPartyBankIdCode) {
        this.beneficiaryPartyBankIdCode = beneficiaryPartyBankIdCode;
        return this;
    }

    public PaymentDataBuilder beneficiaryPartyName(String beneficiaryPartyName) {
        this.beneficiaryPartyName = beneficiaryPartyName;
        return this;
    }

    public PaymentDataBuilder bearerCode(String bearerCode) {
        this.bearerCode = bearerCode;
        return this;
    }

    public PaymentDataBuilder receiverChargesAmount(Integer receiverChargesAmount) {
        this.receiverChargesAmount = receiverChargesAmount;
        return this;
    }

    public PaymentDataBuilder receiverChargesCurrency(Currency receiverChargesCurrency) {
        this.receiverChargesCurrency = receiverChargesCurrency;
        return this;
    }

    public PaymentDataBuilder currency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public PaymentDataBuilder debtorPartyAccountName(String debtorPartyAccountName) {
        this.debtorPartyAccountName = debtorPartyAccountName;
        return this;
    }

    public PaymentDataBuilder debtorPartyAccountNumber(String debtorPartyAccountNumber) {
        this.debtorPartyAccountNumber = debtorPartyAccountNumber;
        return this;
    }

    public PaymentDataBuilder debtorPartyAccountNumberCode(String debtorPartyAccountNumberCode) {
        this.debtorPartyAccountNumberCode = debtorPartyAccountNumberCode;
        return this;
    }

    public PaymentDataBuilder debtorPartyAddress(String debtorPartyAddress) {
        this.debtorPartyAddress = debtorPartyAddress;
        return this;
    }

    public PaymentDataBuilder debtorPartyBankId(String debtorPartyBankId) {
        this.debtorPartyBankId = debtorPartyBankId;
        return this;
    }

    public PaymentDataBuilder debtorPartyBankIdCode(String debtorPartyBankIdCode) {
        this.debtorPartyBankIdCode = debtorPartyBankIdCode;
        return this;
    }

    public PaymentDataBuilder debtorPartyName(String debtorPartyName) {
        this.debtorPartyName = debtorPartyName;
        return this;
    }

    public PaymentDataBuilder endToEndReference(String endToEndReference) {
        this.endToEndReference = endToEndReference;
        return this;
    }

    public PaymentDataBuilder fxContractReference(String fxContractReference) {
        this.fxContractReference = fxContractReference;
        return this;
    }

    public PaymentDataBuilder fxExchangeRate(Integer fxExchangeRate) {
        this.fxExchangeRate = fxExchangeRate;
        return this;
    }

    public PaymentDataBuilder fxOriginalAmount(Integer fxOriginalAmount) {
        this.fxOriginalAmount = fxOriginalAmount;
        return this;
    }

    public PaymentDataBuilder fxOriginalCurrency(Currency fxOriginalCurrency) {
        this.fxOriginalCurrency = fxOriginalCurrency;
        return this;
    }

    public PaymentDataBuilder numericReference(String numericReference) {
        this.numericReference = numericReference;
        return this;
    }

    public PaymentDataBuilder paymentId(String paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public PaymentDataBuilder paymentPurpose(String paymentPurpose) {
        this.paymentPurpose = paymentPurpose;
        return this;
    }

    public PaymentDataBuilder paymentScheme(String paymentScheme) {
        this.paymentScheme = paymentScheme;
        return this;
    }

    public PaymentDataBuilder paymentType(String paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public PaymentDataBuilder processingDate(OffsetDateTime processingDate) {
        this.processingDate = processingDate;
        return this;
    }

    public PaymentDataBuilder reference(String reference) {
        this.reference = reference;
        return this;
    }

    public PaymentDataBuilder schemePaymentSubType(String schemePaymentSubType) {
        this.schemePaymentSubType = schemePaymentSubType;
        return this;
    }

    public PaymentDataBuilder schemePaymentType(String schemePaymentType) {
        this.schemePaymentType = schemePaymentType;
        return this;
    }

    public PaymentDataBuilder sponsorPartyAccountNumber(String sponsorPartyAccountNumber) {
        this.sponsorPartyAccountNumber = sponsorPartyAccountNumber;
        return this;
    }

    public PaymentDataBuilder sponsorPartyBankId(String sponsorPartyBankId) {
        this.sponsorPartyBankId = sponsorPartyBankId;
        return this;
    }

    public PaymentDataBuilder sponsorPartyBankIdCode(String sponsorPartyBankIdCode) {
        this.sponsorPartyBankIdCode = sponsorPartyBankIdCode;
        return this;
    }

    public PaymentData build() {
        return new PaymentData(type, id, version, organisationId, amount, beneficiaryPartyAccountName, beneficiaryPartyAccountNumber, beneficiaryPartyAccountNumberCode, beneficiaryPartyAccountType, beneficiaryPartyAddress, beneficiaryPartyBankId, beneficiaryPartyBankIdCode, beneficiaryPartyName, bearerCode, receiverChargesAmount, receiverChargesCurrency, currency, debtorPartyAccountName, debtorPartyAccountNumber, debtorPartyAccountNumberCode, debtorPartyAddress, debtorPartyBankId, debtorPartyBankIdCode, debtorPartyName, endToEndReference, fxContractReference, fxExchangeRate, fxOriginalAmount, fxOriginalCurrency, numericReference, paymentId, paymentPurpose, paymentScheme, paymentType, processingDate, reference, schemePaymentSubType, schemePaymentType, sponsorPartyAccountNumber, sponsorPartyBankId, sponsorPartyBankIdCode);
    }
}
