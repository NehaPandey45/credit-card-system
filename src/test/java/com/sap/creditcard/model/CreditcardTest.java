package com.sap.creditcard.model;

import static org.junit.Assert.*;
import static pl.pojo.tester.api.FieldPredicate.exclude;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import pl.pojo.tester.api.assertion.Method;

public class CreditcardTest {

  @Test
  public void creditcardtest() {
    final Class<?> model = Creditcard.class;

    assertPojoMethodsFor(model).testing(Method.CONSTRUCTOR).quickly().areWellImplemented();

    assertPojoMethodsFor(model, exclude("TYPE"))
        .testing(Method.EQUALS)
        .quickly()
        .areWellImplemented();

    assertPojoMethodsFor(model, exclude("TYPE"))
        .testing(Method.HASH_CODE)
        .quickly()
        .areWellImplemented();

    assertPojoMethodsFor(model, exclude("TYPE"))
        .testing(Method.GETTER)
        .quickly()
        .areWellImplemented();

    assertPojoMethodsFor(model, exclude("TYPE"))
        .testing(Method.SETTER)
        .quickly()
        .areWellImplemented();

    assertPojoMethodsFor(model, exclude("TYPE"))
        .testing(Method.TO_STRING)
        .quickly()
        .areWellImplemented();
  }

  @Test
  public void hashcode_equals_test() {
    Creditcard c1 =
        new Creditcard(1, "t1", "123", BigDecimal.valueOf(1.0), BigDecimal.valueOf(1.0));
    Creditcard c2 =
        new Creditcard(1, "t1", "123", BigDecimal.valueOf(1.0), BigDecimal.valueOf(1.0));

    assertEquals(c1, c2);
    assertEquals(c1.hashCode(), c2.hashCode());
  }

  @Test
  public void hashcode_not_equals_test() {
    Creditcard c1 =
        new Creditcard(1, "t1", "1234", BigDecimal.valueOf(1.0), BigDecimal.valueOf(1.0));
    Creditcard c2 =
        new Creditcard(2, "t1", "123", BigDecimal.valueOf(1.0), BigDecimal.valueOf(1.0));

    assertNotEquals(c1, c2);
    assertNotEquals(c1.hashCode(), c2.hashCode());
  }
}
