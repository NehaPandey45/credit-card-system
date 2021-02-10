package com.sap.creditcard.api;

import com.sap.creditcard.exception.InvalidBalanceException;
import com.sap.creditcard.exception.InvalidCrediCardException;
import com.sap.creditcard.exception.InvalidCreditLimitException;
import com.sap.creditcard.exception.InvalidUserNameException;
import com.sap.creditcard.model.Creditcard;
import com.sap.creditcard.service.CreditcardService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The Creditcard Controller Class. It provides 2 API to Save and add data. Please refer swagger
 * documentation for more details
 */
@RestController
@RequestMapping(value = "/creditcard")
@Api(value = "Credit card provider, Protected by JWT", produces = "application/json")
public class CreditcardController {

  @Autowired
  CreditcardService creditcardService;

  Logger logger = LoggerFactory.getLogger(this.getClass());

  @ApiOperation(
          value =
                  "Create a new credit card for a given name, card number that passes luhn10 algorithm, limit and balance",
          authorizations = {@Authorization(value = "swaggertoken")}
  )
  @ApiResponses(
    value = {
      @ApiResponse(code = 200, message = "created"),
      @ApiResponse(code = 400, message = "Bad request"),
      @ApiResponse(code = 404, message = "Not Found"),
      @ApiResponse(code = 405, message = "Method Not Allowed"),
      @ApiResponse(code = 406, message = "Not Acceptable"),
      @ApiResponse(code = 415, message = "Unsupported Media Type"),
      @ApiResponse(code = 500, message = "Internal Server Error")
    }
  )
  @PostMapping("/add")
  public Creditcard save(
      @Valid @RequestBody final Creditcard creditcard, BindingResult bindingResult) {

    errorHandler(bindingResult);
    return creditcardService.save(creditcard);
  }

  private void errorHandler(BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      logger.error("error in request");
      if (bindingResult.hasFieldErrors("cardNumber")) {

        logger.error("Invalid Credit card Number passed");
        throw new InvalidCrediCardException(
            "Invalid Credit card Number passed, please check input request");

      } else if (bindingResult.hasFieldErrors("accountBalance")) {

        logger.error("Invalid accountBalance passed");
        throw new InvalidBalanceException(
            "Invalid accountBalance passed, please check input request");
      } else if (bindingResult.hasFieldErrors("userName")) {

        logger.error("Invalid userName passed");
        throw new InvalidUserNameException("Invalid userName passed, please check input request");

      } else if (bindingResult.hasFieldErrors("cardLimit")) {

        logger.error("Invalid cardLimit passed");
          throw new InvalidCreditLimitException(
                  "Invalid cardLimit passed, please check input request");
      }
    }
  }

  @ApiOperation(
          value = "Returns all cards in the system, Protected by JWT",
          authorizations = {@Authorization(value = "swaggertoken")}
  )
  @GetMapping("/getAll")
  public List<Creditcard> getAll() {
    return creditcardService.findAll();
  }
}
