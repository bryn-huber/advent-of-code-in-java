package aoc;

import static aoc.Utils.readInput;
import static java.lang.System.Logger.Level.INFO;

import java.util.Arrays;

public class Day05 {

  private static final System.Logger LOGGER = System.getLogger("Day05.DefaultLogger");

  public static void main(String[] args) {
    LOGGER.log(INFO, "Starting Day05 Computation");

    var lines = readInput("src/main/resources/day05_data.txt");


    var seeds = Arrays.stream(lines.split("\n")).toList().get(0);

    LOGGER.log(INFO, Arrays.stream(seeds.split(" ")).toList().getFirst());

  }
}