package aoc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Utils {

  public static List<String> readLines(String file) {
    try (BufferedReader br = new BufferedReader(
        new FileReader(new File(file).getAbsoluteFile(), StandardCharsets.UTF_8))) {
      return br.lines().toList();
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

}
