package com.sap.creditcard.api;

import com.sap.creditcard.exception.InvalidCrediCardException;
import com.sap.creditcard.exception.InvalidUserNameException;
import com.sap.creditcard.model.Creditcard;
import com.sap.creditcard.service.CreditcardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "Credit card provider", produces = "application/json")
public class CreditcardApi {

  @Autowired
  CreditcardService creditcardService;

  Logger logger = LoggerFactory.getLogger(this.getClass());

  @ApiOperation(
          value = "Create a new credit card for a given name, card number, and limit",
          produces = "application/json"
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

      } else if (bindingResult.hasFieldErrors("userName")) {

        logger.error("Invalid userName passed");
        throw new InvalidUserNameException("Invalid userName passed, please check input request");

      } else if (bindingResult.hasFieldErrors("cardLimit")) {

        logger.error("Invalid cardLimit passed");
        throw new InvalidUserNameException("Invalid cardLimit passed, please check input request");

      } else if (bindingResult.hasFieldErrors("accountBalance")) {

        logger.error("Invalid accountBalance passed");
        throw new InvalidUserNameException(
                "Invalid accountBalance passed, please check input request");
      }
    }
  }

  @ApiOperation(value = "Returns all cards in the system", produces = "application/json")
  @GetMapping("/getAll")
  public List<Creditcard> getAll() {
    return creditcardService.findAll();
  }
}
