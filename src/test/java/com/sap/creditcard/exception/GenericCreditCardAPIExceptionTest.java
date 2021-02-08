package com.sap.creditcard.exception;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class GenericCreditCardAPIExceptionTest {
    @Test
    public void testGenericCreditCardAPIExceptionTest() {
        GenericCreditCardAPIException exception =
                new GenericCreditCardAPIException("GenericCreditCardAPIExceptionTest");
        Assert.assertTrue(
                (exception.getMessage()).equalsIgnoreCase("GenericCreditCardAPIExceptionTest"));
    }
}
