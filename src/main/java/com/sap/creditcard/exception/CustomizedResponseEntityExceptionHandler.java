package com.sap.creditcard.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Date;

/**
 * This is Customized response entity class that handles the exception and returns the Error as per
 * the format given in {@link ErrorMessage}
 */
@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * InvalidCrediCardException
   *
   * @param ex      the exception
   * @param request the request
   * @return ErrorMessage
   */
  @ExceptionHandler(InvalidCrediCardException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorMessage handleInvalidCrediCardException(
          InvalidCrediCardException ex, WebRequest request) {
    logger.error(ex.getMessage());
    return new ErrorMessage(
            HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage(), request.getDescription(false));
  }

  /**
   * InvalidUserNameException
   *
   * @param ex      the exception
   * @param request the request
   * @return the error message
   */
  @ExceptionHandler(InvalidUserNameException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorMessage handleInvalidUserNameException(
          InvalidUserNameException ex, WebRequest request) {
    logger.error(ex.getMessage());
    return new ErrorMessage(
            HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage(), request.getDescription(false));
  }

  /**
   * InvalidCreditLimitException
   *
   * @param ex      the exception
   * @param request the request
   * @return ErrorMessage
   */
  @ExceptionHandler(InvalidCreditLimitException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorMessage handleInvalidCreditLimitException(
          InvalidCreditLimitException ex, WebRequest request) {
    logger.error(ex.getMessage());
    return new ErrorMessage(
            HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage(), request.getDescription(false));
  }

  /**
   * InvalidBalanceException
   *
   * @param ex      the exception
   * @param request the request
   * @return ErrorMessage
   */
  @ExceptionHandler(InvalidBalanceException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorMessage handleInvalidBalanceException(
          InvalidBalanceException ex, WebRequest request) {
    logger.error(ex.getMessage());
    return new ErrorMessage(
            HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage(), request.getDescription(false));
  }

  /**
   * DataIntegrityViolationException
   *
   * @param ex      the exception
   * @param request the request
   * @return ErrorMessage
   */
  @ExceptionHandler(value = {DataIntegrityViolationException.class})
  @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
  protected ErrorMessage handleConflict(DataIntegrityViolationException ex, WebRequest request) {

    return new ErrorMessage(
            HttpStatus.NOT_ACCEPTABLE.value(),
            new Date(),
            "Unique index or primary key violation, please check Input parameters",
            request.getDescription(false));
  }

  /**
   * GlobalExceptionHandler
   *
   * @param ex      the exception
   * @param request the request
   * @return ErrorMessage
   */
  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorMessage handleGlobalExceptionHandler(Exception ex, WebRequest request) {
    logger.error(ex.getMessage());
    return new ErrorMessage(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            new Date(),
            ex.getMessage(),
            request.getDescription(false));
  }

  /**
   * @param ex      the exception
   * @param headers the header
   * @param status  the status
   * @param request the request
   * @return ErrorMessage
   */
  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
  public ErrorMessage handleHttpRequestMethodNotSupported(
          HttpRequestMethodNotSupportedException ex,
          HttpHeaders headers,
          HttpStatus status,
          WebRequest request) {
    logger.error(ex.getMessage());
    return new ErrorMessage(
            HttpStatus.METHOD_NOT_ALLOWED.value(),
            new Date(),
            ex.getMessage(),
            request.getDescription(false));
  }

  /**
   * @param ex      the exception
   * @param headers the headers
   * @param status  the status
   * @param request the request
   * @return ErrorMessage
   */
  @ExceptionHandler(NoHandlerFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorMessage handleNoHandlerFoundException(
          NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    logger.error(ex.getMessage());
    return new ErrorMessage(
            HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage(), request.getDescription(false));
  }

  /**
   * @param ex      the exception
   * @param headers the headers
   * @param status  the status
   * @param request the request
   * @return ErrorMessage
   */
  @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
  @ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
  public ErrorMessage handleHttpMediaTypeNotSupported(
          HttpMediaTypeNotSupportedException ex,
          HttpHeaders headers,
          HttpStatus status,
          WebRequest request) {
    logger.error(ex.getMessage());
    return new ErrorMessage(
            HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(),
            new Date(),
            ex.getMessage(),
            request.getDescription(false));
  }
}
