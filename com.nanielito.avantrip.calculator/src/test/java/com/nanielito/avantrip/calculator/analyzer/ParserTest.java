package com.nanielito.avantrip.calculator.analyzer;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Defines the unit test related to the {@link Parser} class.
 */
public class ParserTest {

  @Test
  public void anEmptyParser_shouldNotContainsOperators() {
    Parser parser = new Parser();

    boolean expectedResult = true;


    Assertions.assertEquals(expectedResult, parser.isOperatorsEmpty());
    Assertions.assertThrows(NoSuchElementException.class, () -> parser.operatorsTop());
    Assertions.assertThrows(NoSuchElementException.class, () -> parser.popOperator());
  }

  @Test
  public void aNonEmptyParser_shouldNotContainsOperatorsWhenASymbolWasNotPushed() {
    Parser parser = new Parser();
    double value = 42;

    boolean expectedResult = true;

    parser.pushOperand(value);

    Assertions.assertEquals(expectedResult, parser.isOperatorsEmpty());
    Assertions.assertThrows(NoSuchElementException.class, () -> parser.operatorsTop());
    Assertions.assertThrows(NoSuchElementException.class, () -> parser.popOperator());
  }

  @Test
  public void aNonEmptyParser_shouldContainsOperatorsWhenASymbolWasPushed() {
    Parser parser = new Parser();
    double left = 42;
    double right = 27;
    char operator = '+';

    boolean expectedResult = false;
    char expectedOperator = '+';

    parser.pushOperand(left);
    parser.pushOperator(operator);
    parser.pushOperand(right);

    Assertions.assertEquals(expectedResult, parser.isOperatorsEmpty());
    Assertions.assertEquals(expectedOperator, parser.operatorsTop());
  }

  @Test
  public void anEmptyParser_shouldNotResolveOperations() {
    Parser parser = new Parser();

    Assertions.assertThrows(NoSuchElementException.class, () -> parser.resolveOperations());
  }

  @Test
  public void aNonEmptyParser_shouldResolveOperations() {
    Parser parser = new Parser();
    double left = 42;
    double right = 27;
    char operator = '+';

    double expectedResult = 69;

    parser.pushOperand(left);
    parser.pushOperator(operator);
    parser.pushOperand(right);
    parser.resolveOperations();

    Assertions.assertEquals(expectedResult, parser.popOperand());
  }
}
