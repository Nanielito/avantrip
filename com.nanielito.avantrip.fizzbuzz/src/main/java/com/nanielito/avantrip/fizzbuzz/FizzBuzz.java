package com.nanielito.avantrip.fizzbuzz;

import java.util.Arrays;

/**
 * Defines the {@code FizzBuzz} class which contains the methods related to
 * the Fizz Buzz game.
 */
public class FizzBuzz {

  /* DEFINITIONS **************************************************/

  private static final String FIZZ_BUZZ = "FizzBuzz";
  private static final String FIZZ = "Fizz";
  private static final String BUZZ = "Buzz";

  /* MEMBERS DECLARATIONS *****************************************/


  /* CLASS CONSTRUCTORS *******************************************/


  /* METHODS IMPLEMENTATIONS **************************************/

  /**
   * Transforms an {@code Integer} into a {@code String} following the
   * basic rules of the Fizz Buzz game.
   *
   * @param value An {@code Integer} value to be transformed.
   *
   * @return The {@code String} related to the input.
   */
  static String transformIntoString(Integer value) {
    String stringValue;

    if (value % 3 == 0 && value % 5 == 0) { // Or value % 15 == 0
      stringValue = FIZZ_BUZZ;
    }
    else if (value % 3 == 0) {
      stringValue = FIZZ;
    }
    else if (value % 5 == 0) {
      stringValue = BUZZ;
    }
    else {
      stringValue = value.toString();
    }

    return stringValue;
  }

  /**
   * Executes the Fizz Buzz game.
   *
   * @param values The array of {@code Integer}s to be evaluated.
   *
   * @return The array of {@code String}s related to the input which was transformed
   * following the Fizz Buzz game rules.
   */
  public static String[] execute(Integer[] values) {
    String[] result = Arrays.asList(values)
        .stream()
        .map(value -> transformIntoString(value))
        .toArray(String[]::new);

    return result;
  }
}
