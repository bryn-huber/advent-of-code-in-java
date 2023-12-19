package aoc;

import static aoc.Utils.readInput;
import static java.lang.System.Logger.Level.INFO;

import java.util.HashSet;
import java.util.regex.MatchResult;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day04 {

  private static final System.Logger LOGGER = System.getLogger("Day05.DefaultLogger");
  private static final Pattern integerPattern = Pattern.compile("(?:(?<![a-zA-Z0-9])-)?\\d+");

  public static void main(String[] args) {
    LOGGER.log(INFO, "Starting Day04 Computation");

    var lines = readInput("src/main/resources/day04_data.txt").lines().toList();

    var win = new int[lines.size()];
    for (int i = 0; i < lines.size(); i++) {
      var parts = lines.get(i).split(":")[1].split("[|]");
      win[i] = intersectionOf(setOf(parseInts(parts[0])), setOf(parseInts(parts[1]))).size();
    }

    int ans1 = Arrays.stream(win).filter(i -> i > 0).map(i -> 1 << (i - 1)).sum();
    LOGGER.log(INFO, "Part 1 = " + ans1);

    int[] copies = new int[win.length];
    Arrays.fill(copies, 1);
    for (int i = 0; i < copies.length; i++) {
      for (int j = 1; j <= win[i]; j++) {
        copies[i + j] += copies[i];
      }
    }
    int ans2 = Arrays.stream(copies).sum();
    LOGGER.log(INFO, "Part 2 = " + ans2);

  }

  public static int[] parseInts(String input) {
    return integerPattern.matcher(input).results()
        .map(MatchResult::group)
        .mapToInt(Integer::parseInt)
        .toArray();
  }

  public static IntStream streamOf(int... ints) {
    return IntStream.of(ints);
  }

  public static Set<Integer> setOf(int... ints) {
    return streamOf(ints).boxed().collect(Collectors.toUnmodifiableSet());
  }

  public static <E> Set<E> intersectionOf(Collection<? extends E> a, Collection<? extends E> b) {
    return intersectionOf(List.of(a, b));
  }

  public static <E> Set<E> intersectionOf(Collection<? extends Collection<? extends E>> collections) {
    var result = new HashSet<E>(collections.iterator().next());
    collections.stream()
        .skip(1)
        .map(c -> c instanceof Set ? c : new HashSet<>(c))
        .forEach(result::retainAll);
    return result;
  }
}