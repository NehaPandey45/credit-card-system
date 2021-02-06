package com.sap.creditcard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Creditcard {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String userName;

  private String cardNumber;

  private Double cardLimit = 0.0d;

  private Double accountBalance = 0.0d;
}
