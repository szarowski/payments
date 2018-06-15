package com.payments.repository.mapper;

import com.payments.util.Random;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class SenderChargesRowMapperTest {

    private static final String COL_ID = "id";
    private static final String COL_AMOUNT = "amount";
    private static final String COL_CURRENCY = "currency";

    private ResultSet rs;
    private static final int ROW_NUM = 88;

    @Before
    public void setupMocks() {
        rs = mock(ResultSet.class);
    }

    @Test
    public void testInteractions() throws SQLException {
        when(rs.getBytes(any(String.class))).thenReturn(Random.uuid().toString().getBytes());
        when(rs.getString(COL_CURRENCY)).thenReturn(Random.currency().getCurrencyCode());

        final SenderChargesRowMapper rowMapper = new SenderChargesRowMapper();
        rowMapper.mapRow(rs, ROW_NUM);
        verify(rs, Mockito.times(1)).getObject(COL_ID, UUID.class);
        verify(rs, Mockito.times(1)).getInt(COL_AMOUNT);
        verify(rs, Mockito.times(1)).getString(COL_CURRENCY);

        verifyNoMoreInteractions(rs);
    }
}