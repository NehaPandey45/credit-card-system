package com.sap.creditcard.model;

import static pl.pojo.tester.api.FieldPredicate.exclude;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

import org.junit.jupiter.api.Test;
import pl.pojo.tester.api.assertion.Method;

public class CreditcardTest {

  @Test
  public void testFileSummaryWrapperModel() {
    final Class<?> model = Creditcard.class;

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
}
