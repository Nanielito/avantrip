package com.nanielito.avantrip.calculator;

import com.nanielito.avantrip.calculator.analyzer.Lexer;

import java.util.Scanner;

/**
 * Main application class.
 */
public class Application {

  /* DEFINITIONS **************************************************/

  private static final String INPUT_EXPRESSION_MESSAGE_1 = "Arithmetic expression: ";
  private static final String INPUT_EXPRESSION_MESSAGE_2 = INPUT_EXPRESSION_MESSAGE_1 + "%s";
  private static final String OUTPUT_EXPRESSION_MESSAGE = "%s = %s";

  /* METHODS IMPLEMENTATIONS **************************************/

  /**
   * Creates a {@code String} from standard in to be used as input.
   *
   * @return An array of {@code Integer}s.
   */
  private static String createInputFromStdIn() {
    String inputExpression;
    Scanner scanner = new Scanner(System.in);

    System.out.print(INPUT_EXPRESSION_MESSAGE_1);
    inputExpression = scanner.nextLine();

    System.out.println(String.format(INPUT_EXPRESSION_MESSAGE_2, inputExpression));

    return inputExpression;
  }

  /**
   * Prints the {@code String} representation related to the input expression evaluated.
   *
   * @param expression The {@code String} which represents the arithmetic expression to be printed.
   * @param result     The {@code double} which represents the result of the arithmetic expression evaluated.
   */
  private static void printResults(String expression, double result) {
    System.out.print(String.format(OUTPUT_EXPRESSION_MESSAGE, expression, Double.toString(result)));
  }

  public static void main(String[] args) {
    Lexer lexer = new Lexer();
    String inputExpression = createInputFromStdIn();
    double result = lexer.evaluate(inputExpression);

    printResults(inputExpression, result);
  }
}
