package com.sap.creditcard.exception;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class InvalidCreditLimitExceptionTest {

  @Test
  public void testInvalidCreditLimitException() {
    InvalidCreditLimitException exception = new InvalidCreditLimitException("Invalid credit limit");
    Assert.assertTrue((exception.getMessage()).equalsIgnoreCase("Invalid credit limit"));
  }
}
