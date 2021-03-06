package com.nanielito.avantrip.calculator.operator.impl;

import com.nanielito.avantrip.calculator.operator.spec.BinaryOperator;

/**
 * Defines the {@code Division} class for "-" operator.
 */
public class Division implements BinaryOperator {

  /* DEFINITIONS **************************************************/

  private static final char DIVIDE_OPERATOR = '/';
  private static final int DIVIDE_PRECEDENCE = 2;

  /* MEMBERS DECLARATIONS *****************************************/


  /* CLASS CONSTRUCTORS *******************************************/


  /* METHODS IMPLEMENTATIONS **************************************/

  /**
   * {@inheritDoc}
   */
  @Override
  public int getPrecedence() {
    return DIVIDE_PRECEDENCE;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isValid(char operator) {
    return DIVIDE_OPERATOR == operator;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public double apply(double left, double right) {
    return left / right;
  }
}
