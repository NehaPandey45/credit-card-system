package com.sap.creditcard.validation;

import com.sap.creditcard.util.Constants;
import com.sap.creditcard.validation.annotation.CreditcardAnnotation;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * CreditCardValidator Class is a validator class that checks if the given Creditcard number is
 * valid according to the Luhn10 algorithm. 1. Starting with the second to last digit and moving
 * left, double the value of all the alternating digits. For any digits that thus become 10 or more,
 * add their digits together 2. Add all these digits together 3. If the total ends in 0 (if the
 * total modulus 10 is 0), then the number is valid according to the Luhn formula, else it is not
 * valid.
 *
 * <p>The Credit Card Number length cannot be greater than 19.
 */
public class CreditCardValidator implements ConstraintValidator<CreditcardAnnotation, String> {

  @Override
  public void initialize(CreditcardAnnotation constraintAnnotation) {}

  @Override
  public boolean isValid(
      String creditCardNumber, ConstraintValidatorContext constraintValidatorContext) {
    return checkLuhnTen(creditCardNumber);
  }

  private boolean checkLuhnTen(String creditCardNumber) {
    if (creditCardNumber == null
        || creditCardNumber.length() > Constants.CREDITCARDLENGTH
        || !Pattern.compile(Constants.DIGITREGEX).matcher(creditCardNumber).matches()) {
      return false;
    }

    int sum = 0;
    boolean alternate = false;
    for (int i = creditCardNumber.length() - 1; i >= 0; i--) {
      int n = Integer.parseInt(creditCardNumber.substring(i, i + 1));
      if (alternate) {
        n *= 2;
        if (n > 9) {
          n = (n % 10) + 1;
        }
      }
      sum += n;
      alternate = !alternate;
    }
    return (sum % 10 == 0);
  }
}
