package com.sap.creditcard.service;

import com.sap.creditcard.model.Creditcard;
import com.sap.creditcard.repository.CreditcardRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is the service layer to Interact with Repository {@link CreditcardRepository} which further
 * insert/fetch data from DB
 */
@Service
public class CreditcardService {

  /** The Creditcard repository. */
  @Autowired public CreditcardRepository creditcardRepository;

  /**
   * Save creditcard.
   *
   * @param creditcard the creditcard
   * @return the creditcard
   */
  public Creditcard save(Creditcard creditcard) {
    return creditcardRepository.save(creditcard);
  }

  /**
   * Find all list.
   *
   * @return the list
   */
  public List<Creditcard> findAll() {
    return new ArrayList<>(creditcardRepository.findAll());
  }
}
