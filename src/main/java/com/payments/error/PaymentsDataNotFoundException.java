package com.payments.error;

/**
 * An exception thrown when fetching of the external data is failing.
 */
public class PaymentsDataNotFoundException extends RuntimeException {

    public PaymentsDataNotFoundException(final String error) {
        super(error);
    }
}