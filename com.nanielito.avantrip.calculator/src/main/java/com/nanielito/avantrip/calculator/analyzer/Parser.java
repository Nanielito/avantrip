package com.nanielito.avantrip.calculator.analyzer;

import static com.nanielito.avantrip.calculator.analyzer.utils.AnalyzerConstants.ADD;
import static com.nanielito.avantrip.calculator.analyzer.utils.AnalyzerConstants.MINUS;
import static com.nanielito.avantrip.calculator.analyzer.utils.AnalyzerConstants.MULTIPLY;
import static com.nanielito.avantrip.calculator.analyzer.utils.AnalyzerConstants.DIVIDE;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.NoSuchElementException;

import com.nanielito.avantrip.calculator.operator.impl.Addition;
import com.nanielito.avantrip.calculator.operator.impl.Division;
import com.nanielito.avantrip.calculator.operator.impl.Multiplication;
import com.nanielito.avantrip.calculator.operator.impl.Subtraction;
import com.nanielito.avantrip.calculator.operator.spec.BinaryOperator;

/**
 * Defines the {@code Parser} class which evaluates the operators from an
 * expression.
 */
public class Parser {

  /* DEFINITIONS **************************************************/

  private static final HashMap<Character, BinaryOperator> BINARY_OPERATORS = new HashMap<Character, BinaryOperator>() {{
    put(ADD, new Addition());
    put(MINUS, new Subtraction());
    put(MULTIPLY, new Multiplication());
    put(DIVIDE, new Division());
  }};

  /* MEMBERS DECLARATIONS *****************************************/

  private ArrayDeque<Character> operators = new ArrayDeque<>();
  private ArrayDeque<Double> operands = new ArrayDeque<>();

  /* CLASS CONSTRUCTORS *******************************************/


  /* METHODS IMPLEMENTATIONS **************************************/

  /**
   * Applies an operator over two values.
   *
   * @param left     A {@code double} which represents the expression's lef value.
   * @param operator A {@code char} which represents the expression's operator.
   * @param right    A {@code double} which represents the expression's right value.
   *
   * @return The {@code double} which represents the result of apply the operator
   * over the input values.
   *
   * @throws UnsupportedOperationException If the operator can be applied over the values.
   */
  private double apply(double left, char operator, double right) throws UnsupportedOperationException {
    for (BinaryOperator binaryOperator : BINARY_OPERATORS.values()) {
      if (binaryOperator.isValid(operator) == true) {
        return binaryOperator.apply(left, right);
      }
    }
    throw new UnsupportedOperationException("Can't apply binary operation " + operator);
  }

  /**
   * Gets the precedence related to an operator.
   *
   * @param operator A {@code char} which represents the operator to be searched.
   *
   * @return The {@code int} which represents the precedence related to the input operator.
   */
  int precedence(char operator) {
    BinaryOperator binaryOperator = BINARY_OPERATORS.get(operator);

    return binaryOperator != null ? binaryOperator.getPrecedence() : 0;
  }

  /**
   * Checks whether the {@code operators} stack is empty or not.
   *
   * @return {@code true} if the {@code operators} stack is empty; otherwise, {@code false}.
   */
  boolean isOperatorsEmpty() {
    return operators.isEmpty();
  }

  /**
   * Gets the operator placed at top of the {@code operators} stack.
   *
   * @return The {@code char} which represents the operator placed at top of
   * the {@code operators} stack.
   */
  char operatorsTop() {
    return operators.getFirst();
  }

  /**
   * Pushes an operator into the {@code operators} stack.
   *
   * @param operator A {@code char} which represents the operator to be pushed.
   */
  void pushOperator(char operator) {
    operators.push(operator);
  }

  /**
   * Pops an operator from the {@code operators} stack.
   *
   * @return The {@code char} which represents the operator placed at top of
   * the {@code operators} stack.
   */
  char popOperator() {
    return operators.pop();
  }

  /**
   * Pushes an operand into the {@code operands} stack.
   *
   * @param operand A {@code double} which represents the operand to be pushed.
   */
  void pushOperand(double operand) {
    operands.push(operand);
  }

  /**
   * Pops an operand from the {@code operands} stack.
   *
   * @return The {@code double} which represents the operand placed at top of
   * the {@code operands} stack.
   */
  double popOperand() {
    return operands.pop();
  }

  /**
   * Resolves an operator and its related operand values.
   */
  void resolveOperations() {
    double right = operands.pop();
    double left = operands.pop();
    char operator = operators.pop();

    operands.push(apply(left, operator, right));
  }
}
