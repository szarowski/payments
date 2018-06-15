package com.payments.repository;

import com.payments.model.internal.PaymentData;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Payment Repository providing persistence services for PaymentController.
 */
public interface PaymentRepository {

    /**
     * Saves the Payment data into the database.
     *
     * @param data the PaymentData object to save
     */
    void savePaymentItems(PaymentData data);

    /**
     * Finds an PaymentData in the database.
     *
     * @param id the ID to find as UUID
     * @return the Optional<PaymentData> object
     */
    Optional<PaymentData> findPaymentItemsById(UUID id);

    /**
     * Finds the List<PaymentData> of all payment data elements.
     *
     * @return the List<PaymentData> of all payment data
     */
    List<PaymentData> findAllPaymentItems();

    /**
     * Deletes the PaymentData element from the database.
     *
     * @param id the ID of the element to delete as UUID
     * @return A number of elements deleted
     */
    int deletePaymentByPaymentId(UUID id);
}