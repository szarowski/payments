package com.payments.service;

import com.payments.model.DataJson;
import com.payments.model.PaymentsJson;

import java.util.List;
import java.util.UUID;

/**
 * The Service to process requests from the Payment REST Controller.
 */
public interface PaymentService {

    /**
     * Fetch and store DataJson elements in the database (collected externally as PaymentsJson).
     *
     * @param dataId the ID of the PaymentsJson element in external API
     * @return the PaymentsJson object collected from the external source in case of success.
     */
    PaymentsJson fetchMockbinData(UUID dataId);

    /**
     * Create and store a DataJson element in the database.
     *
     * @param data the DataJson input data
     * @return the DataJson object created in case of success.
     */
    DataJson createPayment(DataJson data);

    /**
     * Retrieve a DataJson from the database based on the provided ID.
     *
     * @param dataId the ID of the DataJson element
     * @return the DataJson from the database based on the provided ID.
     */
    DataJson getPayment(UUID dataId);

    /**
     * Update a DataJson in the database based on the provided ID.
     *
     * @param dataId the ID of the DataJson element
     * @param data the DataJson from the database based on the provided ID.
     * @return true if update is successful, false otherwise
     */
    boolean updatePayment(UUID dataId, DataJson data);

    /**
     * Delete a DataJson in the database based on the provided ID.
     *
     * @param dataId the ID of the DataJson element
     * @return true if delete is successful, false otherwise
     */
    boolean deletePayment(UUID dataId);

    /**
     * Retrieve all payments from the database.
     *
     * @return the list of all DataJson elements in the database
     */
    List<DataJson> listPayments();
}