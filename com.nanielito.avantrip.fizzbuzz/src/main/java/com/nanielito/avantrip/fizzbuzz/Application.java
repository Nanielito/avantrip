package com.nanielito.avantrip.fizzbuzz;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Main application class definition.
 */
public class Application {

  /* DEFINITIONS **************************************************/

  private static final String INPUT_ARRAY_LENGTH_MESSAGE = "Array length: ";
  private static final String INPUT_ARRAY_VALUE_MESSAGE = "Value %d: ";
  private static final String INPUT_ARRAY_MESSAGE = "Input array:\n%s";
  private static final String OUTPUT_ARRAY_MESSAGE = "Output array:\n%s";

  /* METHODS IMPLEMENTATIONS **************************************/

  /**
   * Creates an array of {@code Integer}s from standard in to be used as input.
   *
   * @return An array of {@code Integer}s.
   */
  private static Integer[] createInputFromStdIn() {
    Integer[] inputValues;
    Scanner scanner = new Scanner(System.in);

    System.out.print(INPUT_ARRAY_LENGTH_MESSAGE);
    int length = scanner.nextInt();

    inputValues = new Integer[length];

    int i = 0;
    int value;

    while (i < length) {
      System.out.print(String.format(INPUT_ARRAY_VALUE_MESSAGE, i));
      value = scanner.nextInt();
      inputValues[i++] = value;
    }
    scanner.close();

    System.out.println(String.format(INPUT_ARRAY_MESSAGE, Arrays.toString(inputValues)));

    return inputValues;
  }

  /**
   * Prints the {@code String} representation related to an array of {@code String}s.
   *
   * @param values The array of {@code String}s to be printed.
   */
  private static void printResults(String[] values) {
    System.out.println(String.format(OUTPUT_ARRAY_MESSAGE, Arrays.toString(values)));
  }

  public static void main(String[] args) {
    Integer[] inputValues = createInputFromStdIn();
    String[] outputValues = FizzBuzz.execute(inputValues);

    printResults(outputValues);
  }
}
