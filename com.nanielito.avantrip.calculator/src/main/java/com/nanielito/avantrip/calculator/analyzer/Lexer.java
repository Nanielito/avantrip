package com.nanielito.avantrip.calculator.analyzer;

import static com.nanielito.avantrip.calculator.analyzer.utils.AnalyzerConstants.CLOSE_PARENTHESIS;
import static com.nanielito.avantrip.calculator.analyzer.utils.AnalyzerConstants.OPEN_PARENTHESIS;
import static com.nanielito.avantrip.calculator.analyzer.utils.AnalyzerConstants.SPACE;

/**
 * Defines the {@code Lexer} class which reads the input expression to be
 * evaluated.
 */
public class Lexer {

  /* DEFINITIONS **************************************************/


  /* MEMBERS DECLARATIONS *****************************************/

  private Parser parser;

  /* CLASS CONSTRUCTORS *******************************************/

  /**
   * Initializes a default instance of the class.
   */
  public Lexer() {
    parser = new Parser();
  }

  /* METHODS IMPLEMENTATIONS **************************************/

  /**
   * Gets the precedence related to a symbol.
   *
   * @param operator A {@code char} which represents the operator which will be used.
   *
   * @return The {@code int} which represents the precedence related to the input symbol.
   * When the symbol is not part of the definitions, the value is 0.
   */
  private int precedence(char operator) {
    return parser.precedence(operator);
  }

  /**
   * Checks whether the {@link Parser}'s operators stack is empty or not.
   *
   * @return {@code true} if the {@link Parser}'s operators stack is empty; otherwhise, {@code false}.
   */
  private boolean isEmpty() {
    return parser.isOperatorsEmpty();
  }

  /**
   * Gets the operator placed at top of the {@link Parser}'s operators stack.
   *
   * @return The {@code char} which represents the operator placed at top of
   * the {@link Parser}'s operators stack.
   */
  private char top() {
    return parser.operatorsTop();
  }

  /**
   * Adds a symbol to the top of {@code Parser}'s operators stack.
   *
   * @param operator A {@code char} which represents the operator to be added.
   */
  private void addOperator(char operator) {
    parser.pushOperator(operator);
  }

  /**
   * Gets and removes an operator from the top of {@link Parser}'s operators stack.
   *
   * @return The {@code char} which represents the operator placed at top of
   * the {@link Parser}'s operators stack.
   */
  private char removeOperator() {
    return parser.popOperator();
  }

  /**
   * Adds a value to the top of {@code Parser}'s operands stack.
   *
   * @param operand A {@code double} which represents the operand to be added.
   */
  private void addOperand(double operand) {
    parser.pushOperand(operand);
  }

  /**
   * Gets and removes an operand from the top of {@link Parser}'s operands stack.
   *
   * @return The {@code double} which represents the operand placed at top of
   * the {@link Parser}'s operands stack.
   */
  private double removeOperand() {
    return parser.popOperand();
  }

  /**
   * Resolves an operator and its related operand values.
   */
  private void resolve() {
    parser.resolveOperations();
  }

  /**
   * Adds spaces before and after an operator occurrence in a expression.
   *
   * @param expression The {@code String} which represents the expression.
   *
   * @return The new {@code String} which represents the expression with spaces
   * added.
   */
  private String addSpaces(String expression) {
    return expression.replaceAll("\\(", " $0 ")
        .replaceAll("\\)", " $0 ")
        .replaceAll("\\+", " $0 ")
        .replaceAll("-", " $0 ")
        .replaceAll("\\*", " $0 ")
        .replaceAll("\\\\", " $0 ");
  }

  /**
   * Evaluates an input arithmetic expression.
   *
   * @param expression A {@code String} which represents the arithmetic expression to
   *                   be evaluated.
   *
   * @return The {@double} which represents the result of apply the arithmetic operators
   * found in the input expression.
   */
  public double evaluate(String expression) {
    char[] tokens = addSpaces(expression).toCharArray();

    for (int i = 0; i < tokens.length; i++) {
      if (tokens[i] == SPACE) {
        continue;
      }
      else if (tokens[i] == OPEN_PARENTHESIS) {
        addOperator(tokens[i]);
      }
      else if (Character.isDigit(tokens[i])) {
        StringBuilder sb = new StringBuilder();

        while (i < tokens.length && Character.isDigit(tokens[i])) {
          sb.append(tokens[i]);
          i++;
        }

        addOperand(Double.parseDouble(sb.toString()));
      }
      else if (tokens[i] == CLOSE_PARENTHESIS) {
        while (isEmpty() == false && top() != OPEN_PARENTHESIS) {
          resolve();
        }

        removeOperator();
      }
      else {
        while (isEmpty() == false && precedence(top()) >= precedence(tokens[i])) {
          resolve();
        }

        addOperator(tokens[i]);
      }
    }

    while (isEmpty() == false) {
      resolve();
    }

    return removeOperand();
  }
}
