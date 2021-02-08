package com.sap.creditcard.model;

import com.sap.creditcard.validation.annotation.CreditcardAnnotation;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is the base model of CreditCard id - Auto generated and acts as primary key userName - Name
 * of User cardNumber - This has to be a number less than 19 and should pass luhn10 algo cardLimit -
 * Max limit of Credit Card accountBalance - Balance in Credit Card and default value is 0.0 balance
 *
 * <p>cardNumber - is marked as Unique
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Creditcard {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @NotBlank(message = "userName cannot be blank")
  @NotNull
  private String userName;

  @Column(unique = true)
  @CreditcardAnnotation
  private String cardNumber;

  @NotNull
  @Digits(integer = 9, fraction = 2)
  private BigDecimal cardLimit;

  @NotNull
  @Digits(integer = 10, fraction = 2)
  private BigDecimal accountBalance = BigDecimal.valueOf(0.0);
}
