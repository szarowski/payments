package com.payments.transform;

import com.payments.model.AttributesJson;
import com.payments.model.ChargesInformationJson;
import com.payments.model.DataJson;
import com.payments.model.FxJson;
import com.payments.model.PartyJson;
import com.payments.model.SenderChargesJson;
import com.payments.model.internal.PaymentData;
import com.payments.model.internal.SenderCharges;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * The implementation of the DataJson to PaymentData (and vice versa) transformer.
 */
@Component
public class PaymentJsonTransformerImpl implements PaymentJsonTransformer {

    @Override
    public PaymentData toPaymentData(final UUID id, final DataJson data) {
        return new PaymentData(data.getType(),
                id,
                data.getVersion(),
                data.getOrganisationId(),
                data.getAttributes().getAmount().multiply(new BigDecimal(100)).toBigInteger().intValue(),
                data.getAttributes().getBeneficiaryParty().getAccountName(),
                data.getAttributes().getBeneficiaryParty().getAccountNumber(),
                data.getAttributes().getBeneficiaryParty().getAccountNumberCode(),
                data.getAttributes().getBeneficiaryParty().getAccountType(),
                data.getAttributes().getBeneficiaryParty().getAddress(),
                data.getAttributes().getBeneficiaryParty().getBankId(),
                data.getAttributes().getBeneficiaryParty().getBankIdCode(),
                data.getAttributes().getBeneficiaryParty().getName(),
                data.getAttributes().getChargesInformation().getBearerCode(),
                data.getAttributes().getChargesInformation().getReceiverChargesAmount().multiply(new BigDecimal(100)).toBigInteger().intValue(),
                data.getAttributes().getChargesInformation().getReceiverChargesCurrency(),
                data.getAttributes().getCurrency(),
                data.getAttributes().getDebtorParty().getAccountName(),
                data.getAttributes().getDebtorParty().getAccountNumber(),
                data.getAttributes().getDebtorParty().getAccountNumberCode(),
                data.getAttributes().getDebtorParty().getAddress(),
                data.getAttributes().getDebtorParty().getBankId(),
                data.getAttributes().getDebtorParty().getBankIdCode(),
                data.getAttributes().getDebtorParty().getName(),
                data.getAttributes().getEndToEndReference(),
                data.getAttributes().getFx().getContractReference(),
                data.getAttributes().getFx().getExchangeRate().multiply(new BigDecimal(100000)).toBigInteger().intValue(),
                data.getAttributes().getFx().getOriginalAmount().multiply(new BigDecimal(100)).toBigInteger().intValue(),
                data.getAttributes().getFx().getOriginalCurrency(),
                data.getAttributes().getNumericReference(),
                data.getAttributes().getPaymentId(),
                data.getAttributes().getPaymentPurpose(),
                data.getAttributes().getPaymentScheme(),
                data.getAttributes().getPaymentType(),
                OffsetDateTime.ofInstant(Instant.ofEpochMilli(data.getAttributes().getProcessingDate().getTime()),
                        ZoneOffset.UTC),
                data.getAttributes().getReference(),
                data.getAttributes().getSchemePaymentSubType(),
                data.getAttributes().getSchemePaymentType(),
                data.getAttributes().getSponsorParty().getAccountNumber(),
                data.getAttributes().getSponsorParty().getBankId(),
                data.getAttributes().getSponsorParty().getBankIdCode()
        );
    }

    @Override
    public DataJson toDataJson(final PaymentData data, final List<SenderCharges> senderCharges) {
        return new DataJson(data.getType(),
                data.getId(),
                data.getVersion(),
                data.getOrganisationId(),
                new AttributesJson(
                        new BigDecimal(data.getAmount() / 100),
                        new PartyJson(data.getBeneficiaryPartyAccountName(),
                                data.getBeneficiaryPartyAccountNumber(),
                                data.getBeneficiaryPartyAccountNumberCode(),
                                data.getBeneficiaryPartyAccountType(),
                                data.getBeneficiaryPartyAddress(),
                                data.getBeneficiaryPartyBankId(),
                                data.getBeneficiaryPartyBankIdCode(),
                                data.getBeneficiaryPartyName()),
                        new ChargesInformationJson(data.getBearerCode(),
                                senderCharges.stream().map(a -> new SenderChargesJson(
                                        new BigDecimal(a.getAmount() / 100),
                                        a.getCurrency())).collect(Collectors.toList()),
                                new BigDecimal(data.getReceiverChargesAmount() / 100),
                                data.getReceiverChargesCurrency()),
                        data.getCurrency(),
                        new PartyJson(data.getDebtorPartyAccountName(),
                                data.getDebtorPartyAccountNumber(),
                                data.getDebtorPartyAccountNumberCode(),
                                null,
                                data.getDebtorPartyAddress(),
                                data.getDebtorPartyBankId(),
                                data.getDebtorPartyBankIdCode(),
                                data.getDebtorPartyName()),
                        data.getEndToEndReference(),
                        new FxJson(data.getFxContractReference(),
                                new BigDecimal(data.getFxExchangeRate() / 100000),
                                new BigDecimal(data.getFxOriginalAmount() / 100),
                                data.getFxOriginalCurrency()),
                        data.getNumericReference(),
                        data.getPaymentId(),
                        data.getPaymentPurpose(),
                        data.getPaymentScheme(),
                        data.getPaymentType(),
                        Date.from(data.getProcessingDate().toInstant()),
                        data.getReference(),
                        data.getSchemePaymentSubType(),
                        data.getSchemePaymentType(),
                        new PartyJson(null,
                                data.getSponsorPartyAccountNumber(),
                                null,
                                null,
                                null,
                                data.getSponsorPartyBankId(),
                                data.getSponsorPartyBankIdCode(),
                                null)
                )
        );
    }
}
