package com.sap.creditcard.api;

import com.sap.creditcard.model.Creditcard;
import com.sap.creditcard.service.CreditcardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
  public Creditcard save(@RequestBody final Creditcard creditcard) {
    return creditcardService.save(creditcard);
  }

  @ApiOperation(value = "Returns all cards in the system", produces = "application/json")
  @GetMapping("/getAll")
  public List<Creditcard> getAll() {
    return creditcardService.findAll();
  }
}
