package com.sap.creditcard.repository;

import com.sap.creditcard.model.Creditcard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CreditcardRepositoryTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private CreditcardRepository creditcardRepository;

  @Test
  public void givenSetOfCreditcards_whenFindAll_thenReturnAllCreditcards() {
    Creditcard test1 = new Creditcard();
    test1.setUserName("test1");
    test1.setCardNumber("12345678903556");
    test1.setAccountBalance(200.0);
    test1.setCardLimit(0.0);

    Creditcard test2 = new Creditcard();
    test2.setUserName("test1");
    test2.setCardNumber("12345678903556");
    test2.setAccountBalance(200.0);
    test2.setCardLimit(0.0);

    Creditcard test3 = new Creditcard();
    test3.setUserName("test1");
    test3.setCardNumber("12345678903556");
    test3.setAccountBalance(200.0);
    test3.setCardLimit(0.0);

    entityManager.persist(test1);
    entityManager.persist(test2);
    entityManager.persist(test3);
    entityManager.flush();

    List<Creditcard> allCreditCards = creditcardRepository.findAll();
    assertThat(allCreditCards)
            .hasSize(3)
            .extracting(Creditcard::getUserName)
            .containsOnly(test1.getUserName(), test2.getUserName(), test3.getUserName());
  }
}
