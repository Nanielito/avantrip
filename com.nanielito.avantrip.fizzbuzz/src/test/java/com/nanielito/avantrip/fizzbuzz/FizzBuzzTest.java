package com.nanielito.avantrip.fizzbuzz;

import java.io.File;
import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Defines the unit test related to the {@link FizzBuzz} class.
 */
public class FizzBuzzTest {

  private static final String INPUT_FILE = "/input.txt";
  private static final String CORRECT_OUTPUT_FILE = "/correctOutput.txt";
  private static final String INCORRECT_OUTPUT_FILE = "/incorrectOutput.txt";
  private static final String FIZZ_BUZZ = "FizzBuzz";
  private static final String FIZZ = "Fizz";
  private static final String BUZZ = "Buzz";

  /**
   * Reads a file which contains an array definition to be used.
   *
   * @param filePath A {@code String} which represents the file path related to the file
   *                 which need to be read.
   *
   * @return A {@code List} of {@code String} which contains the values read from
   * the input file.
   *
   * @throws IOException If something goes wrong while trying to read the file.
   */
  private List<String> readArrayFile(String filePath) throws IOException {
    File file = new File(getClass().getResource(filePath).getPath());
    List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
    List<String> values = new ArrayList<>();

    lines.stream().forEach(line -> values.addAll(Arrays.asList(line.split("\\s"))));

    return values;
  }

  @Test
  public void isNumberIsDivisibleBy3And5_shouldReturnFizzBuzz() {
    int value = 15;
    String stringValue;

    stringValue = FizzBuzz.transformIntoString(value);

    Assertions.assertEquals(FIZZ_BUZZ, stringValue);
  }

  @Test
  public void isNumberIsDivisibleBy3AndNotBy5_shouldReturnFizz() {
    int value = 9;
    String stringValue;

    stringValue = FizzBuzz.transformIntoString(value);

    Assertions.assertEquals(FIZZ, stringValue);
  }

  @Test
  public void isNumberIsDivisibleBy5AndNotBy3_shouldReturnBuzz() {
    int value = 25;
    String stringValue;

    stringValue = FizzBuzz.transformIntoString(value);

    Assertions.assertEquals(BUZZ, stringValue);
  }

  @Test
  public void isNumberIsNotDivisibleBy3Or5_shouldReturnStringValueNumber() {
    int value = 13;
    String stringValue;

    stringValue = FizzBuzz.transformIntoString(value);

    Assertions.assertEquals(String.valueOf(value), stringValue);
  }

  @Test
  public void arrayNumber_shouldReturnCorrectArrayString() throws IOException {
    List<String> l = readArrayFile(INPUT_FILE);
    Integer[] values = l
        .stream()
        .map(Integer::parseInt)
        .toArray(Integer[]::new);
    String[] stringValuesExpected = readArrayFile(CORRECT_OUTPUT_FILE)
        .stream()
        .toArray(String[]::new);
    String[] stringValues;

    stringValues = FizzBuzz.execute(values);

    Assertions.assertArrayEquals(stringValuesExpected, stringValues);
  }

  @Test
  public void arrayNumber_shouldNotReturnIncorrectArrayString() throws IOException {
    Integer[] values = readArrayFile(INPUT_FILE)
        .stream()
        .map(Integer::parseInt)
        .toArray(Integer[]::new);
    String[] stringValuesExpected = readArrayFile(INCORRECT_OUTPUT_FILE)
        .stream()
        .toArray(String[]::new);
    String[] stringValues;

    stringValues = FizzBuzz.execute(values);

    Assertions.assertNotEquals(Arrays.toString(stringValuesExpected), Arrays.toString(stringValues));
  }
}
