package com.payments.transform;

import com.payments.model.SenderChargesJson;
import com.payments.model.internal.SenderCharges;

import java.util.List;
import java.util.UUID;

/**
 * SenderChargesJson to SenderCharges transformer.
 */
public interface SenderChargesJsonTransformer {

    /**
     * Transforms a list of SenderChargesJson elements with id as UUID to a new SenderCharges internal element.
     *
     * @param id the id the ID of the DataJson object associated with the list to be transformed
     * @param data the list of SenderChargesJson objects
     * @return the list of the SenderCharges objects
     */
    List<SenderCharges> toSenderCharges(UUID id, List<SenderChargesJson> data);
}
