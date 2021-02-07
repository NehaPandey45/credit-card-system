package com.sap.creditcard.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RunWith(SpringRunner.class)
public class CustomizedResponseEntityExceptionHandlerTest {

  @Mock WebRequest webRequest;

  @Test
  public void handleHttpRequestMethodNotSupported() {
    CustomizedResponseEntityExceptionHandler handler =
        new CustomizedResponseEntityExceptionHandler();
    final ErrorMessage errorMessage =
        handler.handleHttpRequestMethodNotSupported(
            new HttpRequestMethodNotSupportedException("PUT"), null, null, webRequest);
    assertEquals(HttpStatus.METHOD_NOT_ALLOWED.value(), errorMessage.getStatusCode());
  }

  @Test
  public void handleNoHandlerFoundException() {
    CustomizedResponseEntityExceptionHandler handler =
        new CustomizedResponseEntityExceptionHandler();
    final ErrorMessage errorMessage =
        handler.handleNoHandlerFoundException(
            new NoHandlerFoundException("GET", "http://url", null), null, null, webRequest);
    assertEquals(HttpStatus.NOT_FOUND.value(), errorMessage.getStatusCode());
  }

  @Test
  public void handleHttpMediaTypeNotSupported() {
    CustomizedResponseEntityExceptionHandler handler =
        new CustomizedResponseEntityExceptionHandler();
    final ErrorMessage errorMessage =
        handler.handleHttpMediaTypeNotSupported(
            new HttpMediaTypeNotSupportedException("message"), null, null, webRequest);
    assertEquals(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), errorMessage.getStatusCode());
  }

  @Test
  public void handleAllGlobalExceptionHandler() {
    CustomizedResponseEntityExceptionHandler handler =
        new CustomizedResponseEntityExceptionHandler();
    final ErrorMessage errorMessage =
        handler.handleGlobalExceptionHandler(new Exception("message"), webRequest);
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMessage.getStatusCode());
  }

  @Test
  public void handleInvalidCrediCardException() {
    CustomizedResponseEntityExceptionHandler handler =
        new CustomizedResponseEntityExceptionHandler();
    final ErrorMessage errorMessage =
        handler.handleInvalidCrediCardException(
            new InvalidCrediCardException("message"), webRequest);
    assertEquals(HttpStatus.NOT_FOUND.value(), errorMessage.getStatusCode());
  }

  @Test
  public void handleDataIntegrityViolationException() {
    CustomizedResponseEntityExceptionHandler handler =
        new CustomizedResponseEntityExceptionHandler();
    final ErrorMessage errorMessage =
        handler.handleConflict(
            new DataIntegrityViolationException("Unique index or primary key violation"),
            webRequest);
    assertEquals(HttpStatus.NOT_ACCEPTABLE.value(), errorMessage.getStatusCode());
  }
}
