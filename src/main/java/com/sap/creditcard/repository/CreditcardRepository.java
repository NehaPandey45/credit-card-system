package com.sap.creditcard.repository;

import com.sap.creditcard.model.Creditcard;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/** This Interface provides the crud operations to interact with DB */
public interface CreditcardRepository extends JpaRepository<Creditcard, Integer> {
  List<Creditcard> findAll();
}
