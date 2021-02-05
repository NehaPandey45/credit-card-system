package com.sap.creditcard.service;

import com.sap.creditcard.model.Creditcard;
import com.sap.creditcard.repository.CreditcardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditcardService {

    @Autowired
    public CreditcardRepository creditcardRepository;

    public Creditcard save(Creditcard creditcard) {
        return creditcardRepository.save(creditcard);
    }

    public List<Creditcard> findAll() {
        return new ArrayList<>(creditcardRepository.findAll());
    }
}
