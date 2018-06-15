package com.payments.repository;

import com.payments.model.internal.PaymentData;
import com.payments.repository.mapper.PaymentDataRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static com.payments.util.MapBuilder.mapWith;

/**
 * Implementation of the Payment Repository providing persistence services for PaymentController.
 */
@Repository
public class PaymentRepositoryImpl implements PaymentRepository {

    private final NamedParameterJdbcTemplate jdbc;

    @Autowired
    public PaymentRepositoryImpl(final NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void savePaymentItems(final PaymentData data) {
        jdbc.update("INSERT INTO payment_data (type, id, version, organisation_id, amount, beneficiary_party_account_name, " +
                "beneficiary_party_account_number, beneficiary_party_account_number_code, beneficiary_party_account_type, " +
                "beneficiary_party_address, beneficiary_party_bank_id, beneficiary_party_bank_id_code, beneficiary_party_name, " +
                "bearer_code, receiver_charges_amount, receiver_charges_currency, currency, debtor_party_account_name, " +
                "debtor_party_account_number, debtor_party_account_number_code, debtor_party_address, debtor_party_bank_id, " +
                "debtor_party_bank_id_code, debtor_party_name, end_to_end_reference, fx_contract_reference, fx_exchange_rate, " +
                "fx_original_amount, fx_original_currency, numeric_reference, payment_id, payment_purpose, payment_scheme, " +
                "payment_type, processing_date, reference, scheme_payment_sub_type, scheme_payment_type, sponsor_party_account_number, " +
                "sponsor_party_bank_id, sponsor_party_bank_id_code) " +
                "VALUES (:type, :id, :version, :organisation_id, :amount, :beneficiary_party_account_name, :beneficiary_party_account_number, " +
                ":beneficiary_party_account_number_code, :beneficiary_party_account_type, :beneficiary_party_address, :beneficiary_party_bank_id, " +
                ":beneficiary_party_bank_id_code, :beneficiary_party_name, :bearer_code, :receiver_charges_amount, :receiver_charges_currency, " +
                ":currency, :debtor_party_account_name, :debtor_party_account_number, :debtor_party_account_number_code, :debtor_party_address, " +
                ":debtor_party_bank_id, :debtor_party_bank_id_code, :debtor_party_name, :end_to_end_reference, :fx_contract_reference, " +
                ":fx_exchange_rate, :fx_original_amount, :fx_original_currency, :numeric_reference, :payment_id, :payment_purpose, " +
                ":payment_scheme, :payment_type, :processing_date, :reference, :scheme_payment_sub_type, :scheme_payment_type, " +
                ":sponsor_party_account_number, :sponsor_party_bank_id, :sponsor_party_bank_id_code)",
                mapWith("type", (Object) data.getType())
                        .and("id", data.getId())
                        .and("version", data.getVersion())
                        .and("organisation_id", data.getOrganisationId())
                        .and("amount", data.getAmount())
                        .and("beneficiary_party_account_name", data.getBeneficiaryPartyAccountName())
                        .and("beneficiary_party_account_number", data.getBeneficiaryPartyAccountNumber())
                        .and("beneficiary_party_account_number_code", data.getBeneficiaryPartyAccountNumberCode())
                        .and("beneficiary_party_account_type", data.getBeneficiaryPartyAccountType())
                        .and("beneficiary_party_address", data.getBeneficiaryPartyAddress())
                        .and("beneficiary_party_bank_id", data.getBeneficiaryPartyBankId())
                        .and("beneficiary_party_bank_id_code", data.getBeneficiaryPartyBankIdCode())
                        .and("beneficiary_party_name", data.getBeneficiaryPartyName())
                        .and("bearer_code", data.getBearerCode())
                        .and("receiver_charges_amount", data.getReceiverChargesAmount())
                        .and("receiver_charges_currency", data.getReceiverChargesCurrency().getCurrencyCode())
                        .and("currency", data.getCurrency().getCurrencyCode())
                        .and("debtor_party_account_name", data.getDebtorPartyAccountName())
                        .and("debtor_party_account_number", data.getDebtorPartyAccountNumber())
                        .and("debtor_party_account_number_code", data.getDebtorPartyAccountNumberCode())
                        .and("debtor_party_address", data.getDebtorPartyAddress())
                        .and("debtor_party_bank_id", data.getDebtorPartyBankId())
                        .and("debtor_party_bank_id_code", data.getDebtorPartyBankIdCode())
                        .and("debtor_party_name", data.getDebtorPartyName())
                        .and("end_to_end_reference", data.getEndToEndReference())
                        .and("fx_contract_reference", data.getFxContractReference())
                        .and("fx_exchange_rate", data.getFxExchangeRate())
                        .and("fx_original_amount", data.getFxOriginalAmount())
                        .and("fx_original_currency", data.getFxOriginalCurrency().getCurrencyCode())
                        .and("numeric_reference", data.getNumericReference())
                        .and("payment_id", data.getPaymentId())
                        .and("payment_purpose", data.getPaymentPurpose())
                        .and("payment_scheme", data.getPaymentScheme())
                        .and("payment_type", data.getPaymentType())
                        .and("processing_date", data.getProcessingDate())
                        .and("reference", data.getReference())
                        .and("scheme_payment_sub_type", data.getSchemePaymentSubType())
                        .and("scheme_payment_type", data.getSchemePaymentType())
                        .and("sponsor_party_account_number", data.getSponsorPartyAccountNumber())
                        .and("sponsor_party_bank_id", data.getSponsorPartyBankId())
                        .and("sponsor_party_bank_id_code", data.getSponsorPartyBankIdCode()));
    }

    @Override
    public Optional<PaymentData> findPaymentItemsById(final UUID id) {
        final Map<String, ?> params = mapWith("id", id);
        return jdbc.query("SELECT * FROM payment_data WHERE id = :id", params, new PaymentDataRowMapper())
                .stream().findFirst();
    }

    @Override
    public List<PaymentData> findAllPaymentItems() {
        return jdbc.query("SELECT * FROM payment_data", new PaymentDataRowMapper());
    }

    @Override
    public int deletePaymentByPaymentId(final UUID id) {
        final Map<String, ?> params = mapWith("id", id);
        return jdbc.update("DELETE FROM payment_data WHERE id = :id", params);
    }
}
