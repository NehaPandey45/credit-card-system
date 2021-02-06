package com.sap.creditcard.service;

import com.sap.creditcard.model.Creditcard;
import com.sap.creditcard.repository.CreditcardRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class CreditcardServiceTest {

    @Mock
    CreditcardRepository creditcardRepository;

    @InjectMocks
    CreditcardService creditcardService;

    private List<Creditcard> creditcardList = new ArrayList<>();
    private Creditcard creditcardUser1 = new Creditcard();
    private Creditcard creditcardUser2 = new Creditcard();

    @Before
    public void setUp() {
        creditcardUser1.setUserName("testing user");
        creditcardUser1.setCardNumber("1234567");
        creditcardUser1.setCardLimit(200.0d);

        creditcardUser2.setUserName("premium user");
        creditcardUser2.setCardNumber("12345678903555");
        creditcardUser2.setCardLimit(500.0d);
        creditcardUser2.setAccountBalance(100.0d);

        creditcardList.add(creditcardUser1);
        creditcardList.add(creditcardUser2);

        when(creditcardRepository.findAll()).thenReturn(creditcardList);
        when(creditcardRepository.save(any(Creditcard.class))).thenReturn(creditcardUser2);
    }

    @Test
    public void save() {
        final Creditcard got = creditcardService.save(new Creditcard());
        Assert.assertNotNull(got);
        Assert.assertEquals(got.getCardNumber(), "12345678903555");
        Assert.assertEquals(got.getUserName(), "premium user");
        Assert.assertEquals(got.getAccountBalance(), equals(100.0));
        Assert.assertTrue(got.getCardLimit().equals(500.0));
    }

    @Test
    public void findAll() {
        final List<Creditcard> creditcards = creditcardService.findAll();
        Assert.assertNotNull(creditcards);
        Assert.assertTrue(creditcards.size() > 0);
        Assert.assertTrue(creditcards.get(0).getUserName().equalsIgnoreCase("testing user"));
    }
}
