package com.sap.creditcard;

import static com.sap.creditcard.Application.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

  @Test
  public void contextLoads() {
    main(new String[] {});
  }
}
