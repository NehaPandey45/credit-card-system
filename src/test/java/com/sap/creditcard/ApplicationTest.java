package com.sap.creditcard;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.sap.creditcard.Application.main;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

  @Test
  public void contextLoads() {
    main(new String[]{});
  }
}
