package com.sap.creditcard.exception;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorMessage {
  private int statusCode;
  private Date timestamp;
  private String message;
  private String description;
}
