package com.payments.model;

import com.payments.util.Random;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

import static com.payments.model.ChargesInformationJsonBuilder.chargesInformationJsonBuilder;
import static com.payments.model.FxJsonBuilder.fxJsonBuilder;
import static com.payments.model.PartyJsonBuilder.partyJsonBuilder;

public final class AttributesJsonBuilder {

    private BigDecimal amount = Random.amountVal();
    private PartyJson beneficiaryParty = partyJsonBuilder().build();
    private ChargesInformationJson chargesInformation = chargesInformationJsonBuilder().build();
    private Currency currency = Random.currency();
    private PartyJson debtorParty = partyJsonBuilder().accountType(null).build();
    private String endToEndReference = Random.string();
    private FxJson fx = fxJsonBuilder().build();
    private String numericReference = Random.string(64);
    private String paymentId = Random.string(64);
    private String paymentPurpose = Random.string();
    private String paymentScheme = Random.string(64);
    private String paymentType = Random.string(64);
    private Date processingDate = Random.pastDate();
    private String reference = Random.string();
    private String schemePaymentSubType = Random.string(64);
    private String schemePaymentType = Random.string(64);
    private PartyJson sponsorParty = partyJsonBuilder()
            .accountName(null).accountNumberCode(null).accountType(null).address(null).name(null).build();

    private AttributesJsonBuilder() {
    }

    public static AttributesJsonBuilder attributesJsonBuilder() {
        return new AttributesJsonBuilder();
    }

    public AttributesJsonBuilder amount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public AttributesJsonBuilder beneficiaryParty(PartyJson beneficiaryParty) {
        this.beneficiaryParty = beneficiaryParty;
        return this;
    }

    public AttributesJsonBuilder chargesInformation(ChargesInformationJson chargesInformation) {
        this.chargesInformation = chargesInformation;
        return this;
    }

    public AttributesJsonBuilder currency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public AttributesJsonBuilder debtorParty(PartyJson debtorParty) {
        this.debtorParty = debtorParty;
        return this;
    }

    public AttributesJsonBuilder endToEndReference(String endToEndReference) {
        this.endToEndReference = endToEndReference;
        return this;
    }

    public AttributesJsonBuilder fx(FxJson fx) {
        this.fx = fx;
        return this;
    }

    public AttributesJsonBuilder numericReference(String numericReference) {
        this.numericReference = numericReference;
        return this;
    }

    public AttributesJsonBuilder paymentId(String paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public AttributesJsonBuilder paymentPurpose(String paymentPurpose) {
        this.paymentPurpose = paymentPurpose;
        return this;
    }

    public AttributesJsonBuilder paymentScheme(String paymentScheme) {
        this.paymentScheme = paymentScheme;
        return this;
    }

    public AttributesJsonBuilder paymentType(String paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public AttributesJsonBuilder processingDate(Date processingDate) {
        this.processingDate = processingDate;
        return this;
    }

    public AttributesJsonBuilder reference(String reference) {
        this.reference = reference;
        return this;
    }

    public AttributesJsonBuilder schemePaymentSubType(String schemePaymentSubType) {
        this.schemePaymentSubType = schemePaymentSubType;
        return this;
    }

    public AttributesJsonBuilder schemePaymentType(String schemePaymentType) {
        this.schemePaymentType = schemePaymentType;
        return this;
    }

    public AttributesJsonBuilder sponsorParty(PartyJson sponsorParty) {
        this.sponsorParty = sponsorParty;
        return this;
    }

    public AttributesJson build() {
        return new AttributesJson(amount, beneficiaryParty, chargesInformation, currency, debtorParty, endToEndReference,
                fx, numericReference, paymentId, paymentPurpose, paymentScheme, paymentType, processingDate, reference,
                schemePaymentSubType, schemePaymentType, sponsorParty);
    }
}
