package com.payments.repository.mapper;

import com.payments.model.internal.PaymentData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.util.Currency;
import java.util.UUID;

/**
 * Row mapper to retrieve mapped rows from the payment_data database
 */
public class PaymentDataRowMapper implements RowMapper<PaymentData> {

    @Override
    public PaymentData mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        return new PaymentData(
                rs.getString("type"),
                rs.getObject("id", UUID.class),
                rs.getInt("version"),
                rs.getObject("organisation_id", UUID.class),
                rs.getInt("amount"),
                rs.getString("beneficiary_party_account_name"),
                rs.getString("beneficiary_party_account_number"),
                rs.getString("beneficiary_party_account_number_code"),
                rs.getInt("beneficiary_party_account_type"),
                rs.getString("beneficiary_party_address"),
                rs.getString("beneficiary_party_bank_id"),
                rs.getString("beneficiary_party_bank_id_code"),
                rs.getString("beneficiary_party_name"),
                rs.getString("bearer_code"),
                rs.getInt("receiver_charges_amount"),
                Currency.getInstance(rs.getString("receiver_charges_currency")),
                Currency.getInstance(rs.getString("currency")),
                rs.getString("debtor_party_account_name"),
                rs.getString("debtor_party_account_number"),
                rs.getString("debtor_party_account_number_code"),
                rs.getString("debtor_party_address"),
                rs.getString("debtor_party_bank_id"),
                rs.getString("debtor_party_bank_id_code"),
                rs.getString("debtor_party_name"),
                rs.getString("end_to_end_reference"),
                rs.getString("fx_contract_reference"),
                rs.getInt("fx_exchange_rate"),
                rs.getInt("fx_original_amount"),
                Currency.getInstance(rs.getString("fx_original_currency")),
                rs.getString("numeric_reference"),
                rs.getString("payment_id"),
                rs.getString("payment_purpose"),
                rs.getString("payment_scheme"),
                rs.getString("payment_type"),
                rs.getObject("processing_date", OffsetDateTime.class),
                rs.getString("reference"),
                rs.getString("scheme_payment_sub_type"),
                rs.getString("scheme_payment_type"),
                rs.getString("sponsor_party_account_number"),
                rs.getString("sponsor_party_bank_id"),
                rs.getString("sponsor_party_bank_id_code"));
    }
}
