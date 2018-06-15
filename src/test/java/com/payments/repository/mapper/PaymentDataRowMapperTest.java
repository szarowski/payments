package com.payments.repository.mapper;

import com.payments.util.Random;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.util.UUID;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class PaymentDataRowMapperTest {

    private static final String COL_TYPE ="type";
    private static final String COL_ID = "id";
    private static final String COL_VERSION = "version";
    private static final String COL_ORGANISATION_ID = "organisation_id";
    private static final String COL_AMOUNT = "amount";
    private static final String COL_BENEFICIARY_PARTY_ACCOUNT_NAME = "beneficiary_party_account_name";
    private static final String COL_BENEFICIARY_PARTY_ACCOUNT_NUMBER = "beneficiary_party_account_number";
    private static final String COL_BENEFICIARY_PARTY_ACCOUNT_NUMBER_CODE = "beneficiary_party_account_number_code";
    private static final String COL_BENEFICIARY_PARTY_ACCOUNT_TYPE = "beneficiary_party_account_type";
    private static final String COL_BENEFICIARY_PARTY_ADDRESS = "beneficiary_party_address";
    private static final String COL_BENEFICIARY_PARTY_BANK_ID = "beneficiary_party_bank_id";
    private static final String COL_BENEFICIARY_PARTY_BANK_ID_CODE = "beneficiary_party_bank_id_code";
    private static final String COL_BENEFICIARY_PARTY_NAME = "beneficiary_party_name";
    private static final String COL_BEARER_CODE = "bearer_code";
    private static final String COL_RECEIVER_CHARGES_AMOUNT = "receiver_charges_amount";
    private static final String COL_RECEIVER_CHARGES_CURRENCY = "receiver_charges_currency";
    private static final String COL_CURRENCY = "currency";
    private static final String COL_DEBTOR_PARTY_ACCOUNT_NAME = "debtor_party_account_name";
    private static final String COL_DEBTOR_PARTY_ACCOUNT_NUMBER = "debtor_party_account_number";
    private static final String COL_DEBTOR_PARTY_ACCOUNT_NUMBER_CODE = "debtor_party_account_number_code";
    private static final String COL_DEBTOR_PARTY_ADDRESS = "debtor_party_address";
    private static final String COL_DEBTOR_PARTY_BANK_ID = "debtor_party_bank_id";
    private static final String COL_DEBTOR_PARTY_BANK_ID_CODE = "debtor_party_bank_id_code";
    private static final String COL_DEBTOR_PARTY_NAME = "debtor_party_name";
    private static final String COL_END_TO_END_REFERENCE = "end_to_end_reference";
    private static final String COL_FX_CONTRACT_REFERENCE = "fx_contract_reference";
    private static final String COL_FX_EXCHANGE_RATE = "fx_exchange_rate";
    private static final String COL_FX_ORIGINAL_AMOUNT = "fx_original_amount";
    private static final String COL_FX_ORIGINAL_CURRENCY = "fx_original_currency";
    private static final String COL_NUMERIC_REFERENCE = "numeric_reference";
    private static final String COL_PAYMENT_ID = "payment_id";
    private static final String COL_PAYMENT_PURPOSE = "payment_purpose";
    private static final String COL_PAYMENT_SCHEME = "payment_scheme";
    private static final String COL_PAYMENT_TYPE = "payment_type";
    private static final String COL_PROCESSING_DATE = "processing_date";
    private static final String COL_REFERENCE = "reference";
    private static final String COL_SCHEME_PAYMENT_SUB_TYPE = "scheme_payment_sub_type";
    private static final String COL_SCHEME_PAYMENT_TYPE = "scheme_payment_type";
    private static final String COL_SPONSOR_PARTY_ACCOUNT_NUMBER = "sponsor_party_account_number";
    private static final String COL_SPONSOR_PARTY_BANK_ID = "sponsor_party_bank_id";
    private static final String COL_SPONSOR_PARTY_BANK_ID_CODE = "sponsor_party_bank_id_code";

    private ResultSet rs;
    private static final int ROW_NUM = 88;

    @Before
    public void setupMocks() {
        rs = mock(ResultSet.class);
    }

    @Test
    public void testInteractions() throws SQLException {
        when(rs.getBytes(any(String.class))).thenReturn(Random.uuid().toString().getBytes());
        when(rs.getString(COL_RECEIVER_CHARGES_CURRENCY)).thenReturn(Random.currency().getCurrencyCode());
        when(rs.getString(COL_CURRENCY)).thenReturn(Random.currency().getCurrencyCode());
        when(rs.getString(COL_FX_ORIGINAL_CURRENCY)).thenReturn(Random.currency().getCurrencyCode());

        final PaymentDataRowMapper rowMapper = new PaymentDataRowMapper();
        rowMapper.mapRow(rs, ROW_NUM);
        verify(rs, Mockito.times(1)).getString(COL_TYPE);
        verify(rs, Mockito.times(1)).getObject(COL_ID, UUID.class);
        verify(rs, Mockito.times(1)).getInt(COL_VERSION);
        verify(rs, Mockito.times(1)).getObject(COL_ORGANISATION_ID, UUID.class);
        verify(rs, Mockito.times(1)).getInt(COL_AMOUNT);
        verify(rs, Mockito.times(1)).getString(COL_BENEFICIARY_PARTY_ACCOUNT_NAME);
        verify(rs, Mockito.times(1)).getString(COL_BENEFICIARY_PARTY_ACCOUNT_NUMBER);
        verify(rs, Mockito.times(1)).getString(COL_BENEFICIARY_PARTY_ACCOUNT_NUMBER_CODE);
        verify(rs, Mockito.times(1)).getInt(COL_BENEFICIARY_PARTY_ACCOUNT_TYPE);
        verify(rs, Mockito.times(1)).getString(COL_BENEFICIARY_PARTY_ADDRESS);
        verify(rs, Mockito.times(1)).getString(COL_BENEFICIARY_PARTY_BANK_ID);
        verify(rs, Mockito.times(1)).getString(COL_BENEFICIARY_PARTY_BANK_ID_CODE);
        verify(rs, Mockito.times(1)).getString(COL_BENEFICIARY_PARTY_NAME);
        verify(rs, Mockito.times(1)).getString(COL_BEARER_CODE);
        verify(rs, Mockito.times(1)).getInt(COL_RECEIVER_CHARGES_AMOUNT);
        verify(rs, Mockito.times(1)).getString(COL_RECEIVER_CHARGES_CURRENCY);
        verify(rs, Mockito.times(1)).getString(COL_CURRENCY);
        verify(rs, Mockito.times(1)).getString(COL_DEBTOR_PARTY_ACCOUNT_NAME);
        verify(rs, Mockito.times(1)).getString(COL_DEBTOR_PARTY_ACCOUNT_NUMBER);
        verify(rs, Mockito.times(1)).getString(COL_DEBTOR_PARTY_ACCOUNT_NUMBER_CODE);
        verify(rs, Mockito.times(1)).getString(COL_DEBTOR_PARTY_ADDRESS);
        verify(rs, Mockito.times(1)).getString(COL_DEBTOR_PARTY_BANK_ID);
        verify(rs, Mockito.times(1)).getString(COL_DEBTOR_PARTY_BANK_ID_CODE);
        verify(rs, Mockito.times(1)).getString(COL_DEBTOR_PARTY_NAME);
        verify(rs, Mockito.times(1)).getString(COL_END_TO_END_REFERENCE);
        verify(rs, Mockito.times(1)).getString(COL_FX_CONTRACT_REFERENCE);
        verify(rs, Mockito.times(1)).getInt(COL_FX_EXCHANGE_RATE);
        verify(rs, Mockito.times(1)).getInt(COL_FX_ORIGINAL_AMOUNT);
        verify(rs, Mockito.times(1)).getString(COL_FX_ORIGINAL_CURRENCY);
        verify(rs, Mockito.times(1)).getString(COL_NUMERIC_REFERENCE);
        verify(rs, Mockito.times(1)).getString(COL_PAYMENT_ID);
        verify(rs, Mockito.times(1)).getString(COL_PAYMENT_PURPOSE);
        verify(rs, Mockito.times(1)).getString(COL_PAYMENT_SCHEME);
        verify(rs, Mockito.times(1)).getString(COL_PAYMENT_TYPE);
        verify(rs, Mockito.times(1)).getObject(COL_PROCESSING_DATE, OffsetDateTime.class);
        verify(rs, Mockito.times(1)).getString(COL_REFERENCE);
        verify(rs, Mockito.times(1)).getString(COL_SCHEME_PAYMENT_SUB_TYPE);
        verify(rs, Mockito.times(1)).getString(COL_SCHEME_PAYMENT_TYPE);
        verify(rs, Mockito.times(1)).getString(COL_SPONSOR_PARTY_ACCOUNT_NUMBER);
        verify(rs, Mockito.times(1)).getString(COL_SPONSOR_PARTY_BANK_ID);
        verify(rs, Mockito.times(1)).getString(COL_SPONSOR_PARTY_BANK_ID_CODE);

        verifyNoMoreInteractions(rs);
    }
}