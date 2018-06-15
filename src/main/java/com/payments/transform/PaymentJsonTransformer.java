package com.payments.transform;

import com.payments.model.DataJson;
import com.payments.model.internal.PaymentData;
import com.payments.model.internal.SenderCharges;

import java.util.List;
import java.util.UUID;

/**
 * DataJson to PaymentData (and vice versa) transformer.
 */
public interface PaymentJsonTransformer {

    /**
     * Transforms a DataJson element with id as UUID to a new PaymentData internal element.
     *
     * @param id the ID of the DataJson object
     * @param data the DataJson object
     * @return the PaymentData object
     */
    PaymentData toPaymentData(UUID id, DataJson data);

    /**
     * Transforms a PaymentData element with a list of associated SenderCharges to a new DataJson element.
     *
     * @param data the PaymentData object
     * @param senderCharges the list of SenderCharges objects
     * @return the DataJson object
     */
    DataJson toDataJson(PaymentData data, List<SenderCharges> senderCharges);
}