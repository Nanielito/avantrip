package com.nanielito.avantrip.calculator.operator.impl;

import com.nanielito.avantrip.calculator.operator.spec.BinaryOperator;

/**
 * Defines the {@code Addition} class for "+" operator.
 */
public class Addition implements BinaryOperator {

  /* DEFINITIONS **************************************************/

  private static final char ADD_OPERATOR = '+';
  private static final int ADD_PRECEDENCE = 1;

  /* MEMBERS DECLARATIONS *****************************************/


  /* CLASS CONSTRUCTORS *******************************************/


  /* METHODS IMPLEMENTATIONS **************************************/

  /**
   * {@inheritDoc}
   */
  @Override
  public int getPrecedence() {
    return ADD_PRECEDENCE;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isValid(char operator) {
    return ADD_OPERATOR == operator;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public double apply(double left, double right) {
    return left + right;
  }
}
