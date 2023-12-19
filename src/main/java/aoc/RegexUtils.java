package aoc;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

  private RegexUtils() {
  }

  public static Matcher matcher(String regex, CharSequence input) {
    return Pattern.compile(regex).matcher(input);
  }

  public static List<MatchResult> findAllMatches(String regex, CharSequence input) {
    return matcher(regex, input).results().toList();
  }

}
