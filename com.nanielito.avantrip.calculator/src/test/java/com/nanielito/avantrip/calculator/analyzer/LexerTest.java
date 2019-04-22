package com.nanielito.avantrip.calculator.analyzer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Defines the unit test related to the {@link Lexer} class.
 */
public class LexerTest {

  @Test
  public void aWellFormedExpression_shouldReturnAResult() {
    Lexer lexer = new Lexer();
    String expression = "100 * ( 2 + 12 ) / 14";

    double expectedResult = 100;

    Assertions.assertEquals(expectedResult, lexer.evaluate(expression));
  }

  @Test
  public void aWrongFormedExpression_shouldNotReturnAResult() {
    Lexer lexer = new Lexer();
    String expression = "100 * ( 2 & 12 ) / 14";

    Assertions.assertThrows(Exception.class, () -> lexer.evaluate(expression));
  }
}
