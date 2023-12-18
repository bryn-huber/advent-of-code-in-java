package aoc;

import static java.lang.System.Logger.Level.INFO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class DayOne {

  private static final System.Logger LOGGER = System.getLogger("DayOne.DefaultLogger");

  public static void main(String[] args) {
    LOGGER.log(INFO, "Starting DayOne Computation");

    // the stream holding the file content
    InputStream inputStream = DayOne.class.getClassLoader().getResourceAsStream("day_one_data.txt");

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(
        Objects.requireNonNull(inputStream)))) {
      String line;
      int count = 0;
      while ((line = reader.readLine()) != null) {
        LOGGER.log(INFO, line);
        String firstDigit = getFirstNumber(line);
        String reverse = new StringBuilder(line).reverse().toString();
        String lastDigit = getFirstNumber(reverse);
        LOGGER.log(INFO, firstDigit + " & " + lastDigit);
        String number =  firstDigit + lastDigit;
        LOGGER.log(INFO, number);
        count += Integer.parseInt(number);
        LOGGER.log(INFO, count);
      }
      LOGGER.log(INFO, "Final Count is " + count);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static String getFirstNumber(String s) {
    return s.replaceFirst(".*?(\\d+).*", "$1").substring(0, 1);
  }
}