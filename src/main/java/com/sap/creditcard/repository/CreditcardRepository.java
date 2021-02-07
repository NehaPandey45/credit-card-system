package com.sap.creditcard.repository;

import com.sap.creditcard.model.Creditcard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * This Interface provides the crud operations to interact with DB
 */
public interface CreditcardRepository extends JpaRepository<Creditcard, Integer> {
    List<Creditcard> findAll();
}
