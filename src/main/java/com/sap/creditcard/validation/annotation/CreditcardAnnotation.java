package com.sap.creditcard.validation.annotation;

import com.sap.creditcard.validation.CreditCardValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This Annotation provides the basic credit card number check according to Luhn 10
 * script @CreditcardAnnotation can be used in the model class to perform the validation. Refer
 * {@link com.sap.creditcard.model.Creditcard}
 */
@Constraint(validatedBy = CreditCardValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CreditcardAnnotation {

    String message() default "Invalid Credit Card passed in Request, please check request.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
