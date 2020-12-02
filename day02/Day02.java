import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Day02 {

  public static void main(final String[] args) throws IOException {
    List<String> inputList = Files.readAllLines(Paths.get("day02.txt")).stream().collect(Collectors.toList());
    System.out.println(solvePart1(inputList));
    System.out.println(solvePart2(inputList));
  }

  static int solvePart1(final List<String> inputList) {
    AtomicInteger count = new AtomicInteger();
    inputList.forEach(rule -> {
      String[] ruleSplit = rule.split(":");
      char value = ruleSplit[0].split(" ")[1].charAt(0);
      String range = ruleSplit[0].split(" ")[0];
      int upperRange = Integer.parseInt(range.split("-")[1]);
      int lowerRange = Integer.parseInt(range.split("-")[0]);

      String testString = ruleSplit[1].trim();
      long len = testString.chars().filter(ch -> ch == value).count();
      if ((len >= lowerRange) && (len <= upperRange)) {
        count.incrementAndGet();
      }
    });
    return count.get();
  }

  static int solvePart2(final List<String> inputList) {
    AtomicInteger count = new AtomicInteger();
    inputList.forEach(rule -> {
      String[] rules = rule.split(":");
      char value = rules[0].split(" ")[1].charAt(0);
      String range = rules[0].split(" ")[0];
      int upperRange = Integer.parseInt(range.split("-")[1]);
      int lowerRange = Integer.parseInt(range.split("-")[0]);

      String testString = rules[1].trim();

      boolean present = ((testString.charAt(upperRange - 1)) == value) ^ ((testString.charAt(lowerRange - 1)) == value);

      if (present) {
        count.incrementAndGet();
      }
    });
    return count.get();
  }
}
