package com.sap.creditcard.repository;

import com.sap.creditcard.model.Creditcard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditcardRepository extends JpaRepository<Creditcard, Integer> {
  List<Creditcard> findAll();
}
