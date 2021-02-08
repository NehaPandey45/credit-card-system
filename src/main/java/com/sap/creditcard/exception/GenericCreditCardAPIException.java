package com.sap.creditcard.exception;

/** The type Invalid credit card exception. */
public class GenericCreditCardAPIException extends RuntimeException {

  /**
   * Instantiates a new InvalidBalanceException
   *
   * @param msg the msg
   */
  public GenericCreditCardAPIException(String msg) {
    super(msg);
  }
}
