package com.nanielito.avantrip.calculator.operator;

import com.nanielito.avantrip.calculator.operator.impl.Addition;
import com.nanielito.avantrip.calculator.operator.impl.Division;
import com.nanielito.avantrip.calculator.operator.impl.Multiplication;
import com.nanielito.avantrip.calculator.operator.impl.Subtraction;
import com.nanielito.avantrip.calculator.operator.spec.BinaryOperator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Defines the unit test related to the {@link BinaryOperator} interface.
 */
public class BinaryOperatorTest {

  @Test
  public void operatorPrecedenceForAdditionAndSubtraction_shouldBeTheSame() {
    Addition addition = new Addition();
    Subtraction subtraction = new Subtraction();

    boolean expectedResult = true;
    boolean comparisonResult = addition.getPrecedence() == subtraction.getPrecedence();

    Assertions.assertEquals(expectedResult, comparisonResult);
  }

  @Test
  public void operatorPrecedenceForMultiplicationAndDivision_shouldBeTheSame() {
    Multiplication multiplication = new Multiplication();
    Division division = new Division();

    boolean expectedResult = true;
    boolean comparisonResult = multiplication.getPrecedence() == division.getPrecedence();

    Assertions.assertEquals(expectedResult, comparisonResult);
  }

  @Test
  public void operatorPrecedenceForMultiplicationAndDivision_shouldBeHigherThanAdditionAndSubtraction() {
    Addition addition = new Addition();
    Subtraction subtraction = new Subtraction();
    Multiplication multiplication = new Multiplication();
    Division division = new Division();

    boolean multiplicationIsHigherThanAddition = true;
    boolean multiplicationIsHigherThanSubtraction = true;
    boolean divisionIsHigherThanAddition = true;
    boolean divisionIsHigherThanSubtraction = true;

    Assertions.assertEquals(
        multiplicationIsHigherThanAddition,
        multiplication.getPrecedence() > addition.getPrecedence());
    Assertions.assertEquals(
        multiplicationIsHigherThanSubtraction,
        multiplication.getPrecedence() > subtraction.getPrecedence());
    Assertions.assertEquals(
        divisionIsHigherThanAddition,
        division.getPrecedence() > addition.getPrecedence());
    Assertions.assertEquals(
        divisionIsHigherThanSubtraction,
        division.getPrecedence() > subtraction.getPrecedence());
  }

  @Test
  public void addSymbolForAddition_shouldBeValid() {
    Addition addition = new Addition();
    char addSymbol = '+';

    boolean expectedResult = true;

    Assertions.assertEquals(expectedResult, addition.isValid(addSymbol));
  }

  @Test
  public void nonAddSymbolForAddition_shouldBeInvalid() {
    Addition addition = new Addition();
    char nonAddSymbol = '*';

    boolean expectedResult = false;

    Assertions.assertEquals(expectedResult, addition.isValid(nonAddSymbol));
  }

  @Test
  public void subtractSymbolForSubtraction_shouldBeValid() {
    Subtraction subtraction = new Subtraction();
    char subtractSymbol = '-';

    boolean expectedResult = true;

    Assertions.assertEquals(expectedResult, subtraction.isValid(subtractSymbol));
  }

  @Test
  public void nonSubtractSymbolForSubtraction_shouldBeInvalid() {
    Subtraction subtraction = new Subtraction();
    char nonSubtractSymbol = '/';

    boolean expectedResult = false;

    Assertions.assertEquals(expectedResult, subtraction.isValid(nonSubtractSymbol));
  }

  @Test
  public void multiplySymbolForMultiplication_shouldBeValid() {
    Multiplication multiplication = new Multiplication();
    char multiplySymbol = '*';

    boolean expectedResult = true;

    Assertions.assertEquals(expectedResult, multiplication.isValid(multiplySymbol));
  }

  @Test
  public void nonMultiplySymbolForMultiplication_shouldBeInvalid() {
    Multiplication multiplication = new Multiplication();
    char nonMultiplySymbol = '+';

    boolean expectedResult = false;

    Assertions.assertEquals(expectedResult, multiplication.isValid(nonMultiplySymbol));
  }

  @Test
  public void divideSymbolForDivision_shouldBeValid() {
    Division division = new Division();
    char divideSymbol = '/';

    boolean expectedResult = true;

    Assertions.assertEquals(expectedResult, division.isValid(divideSymbol));
  }

  @Test
  public void nonDivideSymbolForDivision_shouldBeInvalid() {
    Division division = new Division();
    char nonDivideSymbol = '-';

    boolean expectedResult = false;

    Assertions.assertEquals(expectedResult, division.isValid(nonDivideSymbol));
  }

  @Test
  public void additionOperator_shouldReturnTheSumValue() {
    double left = 42;
    double right = 27;
    double expectedResult = 69;

    Addition addition = new Addition();

    double additionResult = addition.apply(left, right);

    Assertions.assertEquals(expectedResult, additionResult);
  }

  @Test
  public void subtractionOperator_shouldReturnTheDifferenceValue() {
    double left = 42;
    double right = 27;
    double expectedResult = 15;

    Subtraction subtraction = new Subtraction();

    double subtractionResult = subtraction.apply(left, right);

    Assertions.assertEquals(expectedResult, subtractionResult);
  }

  @Test
  public void multiplicationOperator_shouldReturnTheProductValue() {
    double left = 42;
    double right = 3.14;
    double expectedResult = 131.88;

    Multiplication multiplication = new Multiplication();

    double multiplicationResult = multiplication.apply(left, right);

    Assertions.assertEquals(expectedResult, multiplicationResult);
  }

  @Test
  public void divisionOperator_shouldReturnTheQuotientValue() {
    double left = 42;
    double right = 2;
    double expectedResult = 21;

    Division division = new Division();

    double divisionResult = division.apply(left, right);

    Assertions.assertEquals(expectedResult, divisionResult);
  }
}
