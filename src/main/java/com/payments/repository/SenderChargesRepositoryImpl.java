package com.payments.repository;

import com.payments.model.internal.SenderCharges;
import com.payments.repository.mapper.SenderChargesRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.payments.util.MapBuilder.mapWith;

/**
 * Implementation of the Sender Charges Repository providing persistence services for PaymentController.
 */
@Repository
public class SenderChargesRepositoryImpl implements SenderChargesRepository {

    private final NamedParameterJdbcTemplate jdbc;

    @Autowired
    public SenderChargesRepositoryImpl(final NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void saveSenderCharges(final UUID id, final List<SenderCharges> data) {
        for (SenderCharges senderCharges : data) {
            jdbc.update("INSERT INTO sender_charges_amount (id, amount, currency)" +
                            "VALUES (:id, :amount, :currency)",
                    mapWith("id", (Object) id)
                            .and("amount", senderCharges.getAmount())
                            .and("currency", senderCharges.getCurrency().getCurrencyCode()));
        }
    }

    @Override
    public List<SenderCharges> findSenderChargesById(UUID id) {
        final Map<String, ?> params = mapWith("id", id);
        return jdbc.query("SELECT * FROM sender_charges_amount WHERE id = :id", params, new SenderChargesRowMapper());
    }
}
