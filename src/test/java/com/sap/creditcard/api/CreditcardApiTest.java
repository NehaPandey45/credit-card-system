package com.sap.creditcard.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import com.sap.creditcard.model.Creditcard;
import com.sap.creditcard.service.CreditcardService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CreditcardApiTest {

  @InjectMocks private CreditcardApi creditcardApi;

  @Autowired private MockMvc mockMvc;

  @Mock private CreditcardService creditcardService;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
    this.mockMvc = MockMvcBuilders.standaloneSetup(creditcardApi).build();

    Creditcard creditcard = new Creditcard();
    creditcard.setUserName("testUser");
    creditcard.setCardNumber("12345678903555");
    creditcard.setCardLimit(BigDecimal.valueOf(100));
    List<Creditcard> creditcardList = new ArrayList<>();
    creditcardList.add(creditcard);

    Mockito.when(creditcardService.save(any(Creditcard.class))).thenReturn(creditcard);
    Mockito.when(creditcardService.findAll()).thenReturn(creditcardList);
  }

  @Test
  public void add_no_balance_default_should_be_zero() throws Exception {
    final String url = "/creditcard/add";

    final String requestJSONContent =
        "{\n"
            + " \"userName\" : \"test\",\n"
            + " \"cardNumber\" : \"12345678903555\",\n"
            + " \"cardLimit\": \"100.0\"\n"
            + "}";

    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post(url)
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .content(requestJSONContent);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    assertEquals(200, result.getResponse().getStatus());
  }

  @Test
  public void add_correct_data() throws Exception {
    final String url = "/creditcard/add";

    final String requestJSONContent =
        "{\n"
            + " \"userName\" : \"testUser\",\n"
            + " \"cardNumber\" : \"12345678903555\",\n"
            + " \"cardLimit\": \"100.0\",\n"
            + "  \"accountBalance\": \"100.0\"\n"
            + "}";

    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post(url)
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .content(requestJSONContent);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    assertEquals(200, result.getResponse().getStatus());
  }

  @Test(expected = Exception.class)
  public void add_blank_userName() throws Exception {
    final String url = "/creditcard/add";

    final String requestJSONContent =
        "{\n"
            + " \"userName\" : \"\",\n"
            + " \"cardNumber\" : \"12345678903555\",\n"
            + " \"cardlimit\": \"100.0\"\n"
            + "}";

    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post(url)
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .content(requestJSONContent);

    assertEquals(404, mockMvc.perform(requestBuilder).andReturn().getResponse().getStatus());
  }

  @Test(expected = Exception.class)
  public void add_wrongCardNumber() throws Exception {
    final String url = "/creditcard/add";

    final String requestJSONContent =
        "{\n"
            + " \"userName\" : \"testUser1\",\n"
            + " \"cardNumber\" : \"12345678903556\",\n"
            + " \"cardlimit\": \"100.0\"\n"
            + "}";

    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post(url)
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .content(requestJSONContent);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    assertEquals(404, result.getResponse().getStatus());
  }

  @Test(expected = Exception.class)
  public void add_no_creditLimit() throws Exception {
    final String url = "/creditcard/add";

    final String requestJSONContent =
        "{\n"
            + " \"userName\" : \"testUser3\",\n"
            + " \"cardNumber\" : \"12345678903555\",\n"
            + " \"cardlimit\": \"\"\n"
            + "}";

    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post(url)
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .content(requestJSONContent);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    assertEquals(404, result.getResponse().getStatus());
  }

  @Test
  public void getAll() throws Exception {
    final String url = "/creditcard/getAll";
    RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    final String contentAsString = result.getResponse().getContentAsString();
    assertEquals(200, result.getResponse().getStatus());
    assertNotNull(contentAsString);
    assertFalse(contentAsString.isEmpty());
  }
}
