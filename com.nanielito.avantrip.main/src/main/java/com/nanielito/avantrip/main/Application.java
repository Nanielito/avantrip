package com.nanielito.avantrip.main;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Main application class.
 */
public class Application {

  /* DEFINITIONS **************************************************/

  private static final String MENU_SELECTOR_MESSAGE = "Select an option...\n" +
                                                      "\t1. FizzBuzz\n"       +
                                                      "\t2. Calculator\n"     +
                                                      "\t0. Exit\n";
  private static final String MENU_OPTION_SELECTED_MESSAGE = "Option: ";
  private static final String MENU_INVALID_OPTION_SELECTED = "Invalid option";
  private static final String FIZZ_BUZZ_MESSAGE = "FIZZ BUZZ";
  private static final String CALCULATOR_MESSAGE = "CALCULATOR";

  private static final int[] validOptions = new int[] { 0, 1, 2 };

  /* METHODS IMPLEMENTATIONS **************************************/

  /**
   * Executes the FizzBuzz application.
   */
  private static void executeFizzBuzz() {
    System.out.println(FIZZ_BUZZ_MESSAGE);
    com.nanielito.avantrip.fizzbuzz.Application.main(null);
  }

  /**
   * Executes the Calculator application.
   */
  private static void executeCalculator() {
    System.out.println(CALCULATOR_MESSAGE);
    com.nanielito.avantrip.calculator.Application.main(null);
  }

  /**
   * Checks whether a selected option is valid or not.
   *
   * @param option A {@code int} which represents the selected option.
   *
   * @return {@code true} if the selected option is valid; otherwise, {@code false}.
   */
  private static boolean isValidOption(int option) {
    return Arrays.stream(validOptions).anyMatch(validOption -> validOption == option);
  }

  /**
   * Displays the menu application selector.
   */
  private static void displayMenu() {
    System.out.println(MENU_SELECTOR_MESSAGE);
    System.out.print(MENU_OPTION_SELECTED_MESSAGE);

    Scanner scanner = new Scanner(System.in);
    int option;
    boolean incorrectOption = true;

    do {
      option = scanner.nextInt();

      if (isValidOption(option) == true) {
        incorrectOption = false;
      }
      else {
        System.out.println(MENU_INVALID_OPTION_SELECTED);
        System.out.print(MENU_OPTION_SELECTED_MESSAGE);
      }

    }
    while (incorrectOption);

    switch (option) {
      case 1:
        executeFizzBuzz();
        break;
      case 2:
        executeCalculator();
        break;
      default:
        System.exit(0);
    }

  }

  public static void main(String[] args) {
    displayMenu();
  }
}
