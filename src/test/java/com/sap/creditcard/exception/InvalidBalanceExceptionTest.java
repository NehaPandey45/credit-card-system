package com.sap.creditcard.exception;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class InvalidBalanceExceptionTest {
    @Test
    public void testInvalidBalanceException() {
        InvalidBalanceException exception = new InvalidBalanceException("Invalid Balance");
        Assert.assertTrue((exception.getMessage()).equalsIgnoreCase("Invalid Balance"));
    }
}
