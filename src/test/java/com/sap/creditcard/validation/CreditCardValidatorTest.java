package com.sap.creditcard.validation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.validation.ConstraintValidatorContext;

@RunWith(MockitoJUnitRunner.class)
public class CreditCardValidatorTest {

  @Mock
  ConstraintValidatorContext constraintValidatorContext;

  @InjectMocks
  CreditCardValidator creditCardValidator;

  @Test
  public void correct_creditcard() {
    final String correctCreditCardNumber = "12345678903555";
    final boolean got =
            creditCardValidator.isValid(correctCreditCardNumber, constraintValidatorContext);
    Assert.assertTrue(got);
  }

  @Test
  public void invalid_luhn_creditcard() {
    final String incorrectCrediCardNumber = "22345678903545";
    final boolean got =
            creditCardValidator.isValid(incorrectCrediCardNumber, constraintValidatorContext);
    Assert.assertFalse(got);
  }

  @Test
  public void invalid_empty_creditcard() {
    final String incorrectCrediCardNumber = "";
    final boolean got =
            creditCardValidator.isValid(incorrectCrediCardNumber, constraintValidatorContext);
    Assert.assertFalse(got);
  }

  @Test
  public void invalid_null_creditcard() {
    final String incorrectCrediCardNumber = null;
    final boolean got =
            creditCardValidator.isValid(incorrectCrediCardNumber, constraintValidatorContext);
    Assert.assertFalse(got);
  }

  @Test
  public void invalid_creditcard_length_greater_than_19_() {
    final String incorrectCrediCardNumber = "11223344556677889900";
    final boolean got =
            creditCardValidator.isValid(incorrectCrediCardNumber, constraintValidatorContext);
    Assert.assertFalse(got);
  }

  @Test
  public void invalid_creditcard_with_alphabets() {
    final String incorrectCrediCardNumber = "12345678912345678uu";
    final boolean got =
            creditCardValidator.isValid(incorrectCrediCardNumber, constraintValidatorContext);
    Assert.assertFalse(got);
  }
}
