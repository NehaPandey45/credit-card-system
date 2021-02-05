package com.sap.creditcard.exception;

public class InvalidCreditCardException extends RuntimeException {
    public InvalidCreditCardException(String message) {
        super(message);
    }
}
