package com.payments.repository;

import com.payments.model.internal.SenderCharges;

import java.util.List;
import java.util.UUID;

/**
 * Sender Charges Repository providing persistence services for PaymentController.
 */
public interface SenderChargesRepository {

    /**
     * Saves the Sender Charges into the database.
     *
     * @param id the ID of the SenderCharges element associated with Payment data as UUID
     * @param data the List<SenderCharges> list object to save
     */
    void saveSenderCharges(UUID id, List<SenderCharges> data);

    /**
     * Finds the List<SenderCharges> of all sender charges elements associated with Payment data by ID.
     *
     * @return the List<SenderCharges> of all sender charges elements associated with Payment data by ID
     */
    List<SenderCharges> findSenderChargesById(UUID id);
}