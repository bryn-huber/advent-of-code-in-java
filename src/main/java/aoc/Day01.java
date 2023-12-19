package aoc;

import static java.lang.System.Logger.Level.INFO;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

public class Day01 {

  private static final System.Logger LOGGER = System.getLogger("Day01.DefaultLogger");

  private static final Map<String, Integer> DIGIT_NAMES = Map.of("one", 1, "two", 2, "three", 3,
      "four", 4, "five", 5, "six", 6, "seven", 7, "eight", 8, "nine", 9);

  public static void main(String[] args) {

    LOGGER.log(INFO, "Starting Day01 Computation");

    var lines = Utils.readLines("src/main/resources/day01_data.txt");
    var sum1 = lines.stream().map(Day01::keepDigits).mapToInt(l -> l.getFirst() * 10 + l.getLast())
        .sum();
    LOGGER.log(INFO, "Sum1 = " + sum1);
    var sum2 = lines.stream().map(Day01::keepAllDigits)
        .mapToInt(l -> l.getFirst() * 10 + l.getLast()).sum();
    LOGGER.log(INFO, "Sum2 = " + sum2);
  }

  private static List<Integer> keepDigits(String s) {
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      if ('1' <= c && c <= '9') {
        res.add(c - '0');
      }
    }
    return res;
  }

  private static List<Integer> keepAllDigits(String s) {
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      if ('1' <= c && c <= '9') {
        res.add(Integer.parseInt("" + c));
      } else {
        var ss = s.substring(i);
        DIGIT_NAMES.keySet().stream().filter(k -> ss.startsWith(k)).map(k -> DIGIT_NAMES.get(k))
            .findAny().ifPresent(res::add);
      }
    }
    return res;
  }

}