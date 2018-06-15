package com.payments.repository.mapper;

import com.payments.model.internal.SenderCharges;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Currency;
import java.util.UUID;

/**
 * Row mapper to retrieve mapped rows from the sender_charges_amount database
 */
public class SenderChargesRowMapper implements RowMapper<SenderCharges> {

    @Override
    public SenderCharges mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        return new SenderCharges(
                rs.getObject("id", UUID.class),
                rs.getInt("amount"),
                Currency.getInstance(rs.getString("currency")));
    }
}