package com.sap.creditcard.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.sap.creditcard.model.Creditcard;
import com.sap.creditcard.repository.CreditcardRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CreditcardServiceTest {

  @Mock CreditcardRepository creditcardRepository;

  @InjectMocks CreditcardService creditcardService;

  private List<Creditcard> creditcardList = new ArrayList<>();
  private Creditcard creditcardUser1 = new Creditcard();
  private Creditcard creditcardUser2 = new Creditcard();

  @Before
  public void setUp() {
    creditcardUser1.setUserName("testing user");
    creditcardUser1.setCardNumber("12345678903555");
    creditcardUser1.setCardLimit(BigDecimal.valueOf(200.0));

    creditcardUser2.setUserName("premium user");
    creditcardUser2.setCardNumber("12345674");
    creditcardUser2.setCardLimit(BigDecimal.valueOf(500));
    creditcardUser2.setAccountBalance(BigDecimal.valueOf(100));

    creditcardList.add(creditcardUser1);
    creditcardList.add(creditcardUser2);

    when(creditcardRepository.findAll()).thenReturn(creditcardList);
    when(creditcardRepository.save(any(Creditcard.class))).thenReturn(creditcardUser2);
  }

  @Test
  public void save() {
    final Creditcard got = creditcardService.save(new Creditcard());
    Assert.assertNotNull(got);
    Assert.assertEquals(got.getCardNumber(), "12345674");
    Assert.assertEquals(got.getUserName(), "premium user");
  }

  @Test
  public void findAll() {
    final List<Creditcard> creditcards = creditcardService.findAll();
    Assert.assertNotNull(creditcards);
    Assert.assertTrue(creditcards.size() > 0);
    Assert.assertTrue(creditcards.get(0).getUserName().equalsIgnoreCase("testing user"));
  }
}
