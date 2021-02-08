package com.sap.creditcard.exception;

/** The type Invalid credit card exception. */
public class InvalidCreditLimitException extends RuntimeException {

  /**
   * Instantiates a new InvalidCreditLimitException
   *
   * @param msg the msg
   */
  public InvalidCreditLimitException(String msg) {
    super(msg);
  }
}
