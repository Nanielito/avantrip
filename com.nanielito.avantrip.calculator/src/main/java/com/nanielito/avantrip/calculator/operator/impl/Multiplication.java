package com.nanielito.avantrip.calculator.operator.impl;

import com.nanielito.avantrip.calculator.operator.spec.BinaryOperator;

/**
 * Defines the {@code Multiplication} class for "*" operator.
 */
public class Multiplication implements BinaryOperator {

  /* DEFINITIONS **************************************************/

  private static final char MULTIPLY_OPERATOR = '*';
  private static final int MULTIPLY_PRECEDENCE = 2;

  /* MEMBERS DECLARATIONS *****************************************/


  /* CLASS CONSTRUCTORS *******************************************/


  /* METHODS IMPLEMENTATIONS **************************************/

  /**
   * {@inheritDoc}
   */
  @Override
  public int getPrecedence() {
    return MULTIPLY_PRECEDENCE;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isValid(char operator) {
    return MULTIPLY_OPERATOR == operator;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public double apply(double left, double right) {
    return left * right;
  }
}
