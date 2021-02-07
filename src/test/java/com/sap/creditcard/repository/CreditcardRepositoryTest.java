package com.sap.creditcard.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.sap.creditcard.model.Creditcard;
import java.math.BigDecimal;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CreditcardRepositoryTest {

  @Autowired private TestEntityManager entityManager;

  @Autowired private CreditcardRepository creditcardRepository;

  @Test
  public void givenSetOfCreditcards_whenFindAll_thenReturnAllCreditcards() {
    Creditcard test1 = new Creditcard();
    test1.setUserName("test1");
    test1.setCardNumber("12345678903555");
    test1.setAccountBalance(BigDecimal.valueOf(200.0));
    test1.setCardLimit(BigDecimal.valueOf(0.0));

    Creditcard test2 = new Creditcard();
    test2.setUserName("test1");
    test2.setCardNumber("12345674");
    test2.setAccountBalance(BigDecimal.valueOf(100.0));
    test2.setCardLimit(BigDecimal.valueOf(10.0));

    entityManager.persist(test1);
    entityManager.persist(test2);
    entityManager.flush();

    List<Creditcard> allCreditCards = creditcardRepository.findAll();
    assertThat(allCreditCards)
        .hasSize(2)
        .extracting(Creditcard::getUserName)
        .containsOnly(test1.getUserName(), test2.getUserName());
  }
}
