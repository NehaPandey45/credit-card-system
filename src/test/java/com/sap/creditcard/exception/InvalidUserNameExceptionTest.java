package com.sap.creditcard.exception;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class InvalidUserNameExceptionTest {
  @Test
  public void testInvalidUserNameExceptiont() {
    InvalidUserNameException exception = new InvalidUserNameException("Invalid userName");
    Assert.assertTrue((exception.getMessage()).equalsIgnoreCase("Invalid userName"));
  }
}
