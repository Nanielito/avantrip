package com.nanielito.avantrip.calculator.operator.spec;

/**
 * Defines the specification related to the {@code BinaryOperator}
 * interface.
 */
public interface BinaryOperator {

  /* METHODS DECLARATIONS *****************************************/

  /**
   * Get the precedence related to the binary operator.
   *
   * @return An {@code int} which represents the operator's precedence value.
   */
  int getPrecedence();

  /**
   * Checks whether a {@code char} is valid as an operator definition or not.
   *
   * @param operator A {@code char} which represents the operator to be checked.
   *
   * @return {@code true} if the input {@code char} is valid for an operator definition;
   * otherwise, {@code false}.
   */
  boolean isValid(char operator);

  /**
   * Applies the operator to the input values.
   *
   * @param left A {@code double} which represents the expression's left value.
   * @param right A {@code double} which represents the expression's right value.
   *
   * @return The {@code double} which represents the result of apply the operator
   * over the input values.
   */
  double apply(double left, double right);
}
