package com.sap.creditcard.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RunWith(SpringRunner.class)
public class CustomizedResponseEntityExceptionHandlerTest {

  @Mock WebRequest webRequest;

  @Mock HttpInputMessage httpInputMessage;

  @Test
  public void handleHttpRequestMethodNotSupported_test() {
    CustomizedResponseEntityExceptionHandler handler =
        new CustomizedResponseEntityExceptionHandler();
    final ErrorMessage errorMessage =
        handler.handleHttpRequestMethodNotSupported(
            new HttpRequestMethodNotSupportedException("PUT"), null, null, webRequest);
    assertEquals(HttpStatus.METHOD_NOT_ALLOWED.value(), errorMessage.getStatusCode());
  }

  @Test
  public void handleHttpMessageNotReadableException_test() {
    CustomizedResponseEntityExceptionHandler handler =
        new CustomizedResponseEntityExceptionHandler();
    final ErrorMessage errorMessage =
        handler.handleHttpMessageNotReadableException(
            new HttpMessageNotReadableException("message", httpInputMessage), webRequest);
    assertEquals(HttpStatus.NOT_FOUND.value(), errorMessage.getStatusCode());
  }

  @Test
  public void handleNoHandlerFoundException_test() {
    CustomizedResponseEntityExceptionHandler handler =
        new CustomizedResponseEntityExceptionHandler();
    final ErrorMessage errorMessage =
        handler.handleNoHandlerFoundException(
            new NoHandlerFoundException("GET", "http://url", null), null, null, webRequest);
    assertEquals(HttpStatus.NOT_FOUND.value(), errorMessage.getStatusCode());
  }

  @Test
  public void handleHttpMediaTypeNotSupported_test() {
    CustomizedResponseEntityExceptionHandler handler =
        new CustomizedResponseEntityExceptionHandler();
    final ErrorMessage errorMessage =
        handler.handleHttpMediaTypeNotSupported(
            new HttpMediaTypeNotSupportedException("message"), null, null, webRequest);
    assertEquals(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), errorMessage.getStatusCode());
  }

  @Test
  public void handleAllGlobalExceptionHandler_test() {
    CustomizedResponseEntityExceptionHandler handler =
        new CustomizedResponseEntityExceptionHandler();
    final ErrorMessage errorMessage =
        handler.handleGlobalExceptionHandler(new Exception("message"), webRequest);
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMessage.getStatusCode());
  }

  @Test
  public void handleAllGenericCreditCardAPIException_test() {
    CustomizedResponseEntityExceptionHandler handler =
        new CustomizedResponseEntityExceptionHandler();
    final ErrorMessage errorMessage =
        handler.handleGenericCreditCardAPIException(
            new GenericCreditCardAPIException("message"), webRequest);
    assertEquals(HttpStatus.NOT_FOUND.value(), errorMessage.getStatusCode());
  }

  @Test
  public void handleInvalidCrediCardException_test() {
    CustomizedResponseEntityExceptionHandler handler =
        new CustomizedResponseEntityExceptionHandler();
    final ErrorMessage errorMessage =
        handler.handleInvalidCrediCardException(
            new InvalidCrediCardException("message"), webRequest);
    assertEquals(HttpStatus.NOT_FOUND.value(), errorMessage.getStatusCode());
  }

  @Test
  public void handleInvalidUserNameException_test() {
    CustomizedResponseEntityExceptionHandler handler =
        new CustomizedResponseEntityExceptionHandler();
    final ErrorMessage errorMessage =
        handler.handleInvalidUserNameException(new InvalidUserNameException("message"), webRequest);
    assertEquals(HttpStatus.NOT_FOUND.value(), errorMessage.getStatusCode());
  }

  @Test
  public void handleInvalidCreditLimitException_test() {
    CustomizedResponseEntityExceptionHandler handler =
        new CustomizedResponseEntityExceptionHandler();
    final ErrorMessage errorMessage =
        handler.handleInvalidCreditLimitException(
            new InvalidCreditLimitException("message"), webRequest);
    assertEquals(HttpStatus.NOT_FOUND.value(), errorMessage.getStatusCode());
  }

  @Test
  public void handleInvalidBalanceException_test() {
    CustomizedResponseEntityExceptionHandler handler =
        new CustomizedResponseEntityExceptionHandler();
    final ErrorMessage errorMessage =
        handler.handleInvalidBalanceException(new InvalidBalanceException("message"), webRequest);
    assertEquals(HttpStatus.NOT_FOUND.value(), errorMessage.getStatusCode());
  }

  @Test
  public void handleDataIntegrityViolationException_test() {
    CustomizedResponseEntityExceptionHandler handler =
        new CustomizedResponseEntityExceptionHandler();
    final ErrorMessage errorMessage =
        handler.handleConflict(
            new DataIntegrityViolationException("Unique index or primary key violation"),
            webRequest);
    assertEquals(HttpStatus.NOT_ACCEPTABLE.value(), errorMessage.getStatusCode());
  }
}
