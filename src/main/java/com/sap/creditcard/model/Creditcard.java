package com.sap.creditcard.model;

import com.sap.creditcard.validation.annotation.CreditcardAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

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
  private BigDecimal cardLimit;

  @NotNull
  private BigDecimal accountBalance = BigDecimal.valueOf(0.0);
}
