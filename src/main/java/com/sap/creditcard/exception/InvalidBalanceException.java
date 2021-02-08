package com.sap.creditcard.exception;

/** The type Invalid credit card exception. */
public class InvalidBalanceException extends RuntimeException {

  /**
   * Instantiates a new InvalidBalanceException
   *
   * @param msg the msg
   */
  public InvalidBalanceException(String msg) {
    super(msg);
  }
}
