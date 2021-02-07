package com.sap.creditcard.exception;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class InvalidCrediCardExceptionTest {

    @Test
    public void testInvalidCreditCardExceptionTestString() {
        InvalidCrediCardException exception =
                new InvalidCrediCardException("Invalid credit card number");
        Assert.assertTrue((exception.getMessage()).equalsIgnoreCase("Invalid credit card number"));
    }
}
