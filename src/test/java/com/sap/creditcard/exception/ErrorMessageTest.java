package com.sap.creditcard.exception;

import org.junit.jupiter.api.Test;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.FieldPredicate.exclude;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

public class ErrorMessageTest {

  @Test
  public void testFileSummaryWrapperModel() {
    final Class<?> model = ErrorMessage.class;

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
