package com.sap.creditcard.exception;

import static org.junit.Assert.*;
import static pl.pojo.tester.api.FieldPredicate.exclude;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

import java.util.Date;
import org.junit.jupiter.api.Test;
import pl.pojo.tester.api.assertion.Method;

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

  @Test
  public void hashcode_equals_test() {
    ErrorMessage e1 = new ErrorMessage(404, new Date(), "test", "test");
    ErrorMessage e2 = new ErrorMessage(404, new Date(), "test", "test");

    assertEquals(e1, e2);
    assertEquals(e1.hashCode(), e2.hashCode());
  }

  @Test
  public void hashcode_not_equals_test() {
    ErrorMessage e1 = new ErrorMessage(406, new Date(), "test1", "test");
    ErrorMessage e2 = new ErrorMessage(404, new Date(), "test", "test");

    assertNotEquals(e1, e2);
    assertNotEquals(e1.hashCode(), e2.hashCode());
  }
}
