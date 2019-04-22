package com.nanielito.avantrip.calculator.operator.impl;

import com.nanielito.avantrip.calculator.operator.spec.BinaryOperator;

/**
 * Defines the {@code Subtraction} class for "-" operator.
 */
public class Subtraction implements BinaryOperator{

  /* DEFINITIONS **************************************************/

  private static final char SUBTRACT_OPERATOR = '-';
  private static final int SUBTRACT_PRECEDENCE = 1;

  /* MEMBERS DECLARATIONS *****************************************/


  /* CLASS CONSTRUCTORS *******************************************/


  /* METHODS IMPLEMENTATIONS **************************************/

  /**
   * {@inheritDoc}
   */
  @Override
  public int getPrecedence() {
    return SUBTRACT_PRECEDENCE;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isValid(char operator) {
    return SUBTRACT_OPERATOR == operator;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public double apply(double left, double right) {
    return left - right;
  }
}
