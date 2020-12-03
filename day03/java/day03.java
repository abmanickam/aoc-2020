
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day03 {

  public static void main(final String[] args) throws IOException {
    List<String> inputList = Files.readAllLines(Paths.get("day03.txt")).stream().collect(Collectors.toList());
    System.out.println(solvePart1(inputList));
    System.out.println(solvePart2(inputList));
  }

  static int solvePart1(final List<String> inputList) {
    int count = 0;
    int j = 0;
    for (int i = 1; i < inputList.size(); i++) {
      String currLine = inputList.get(i);
      j = (j + 3) % currLine.length();
      if (currLine.charAt(j) == '#') {
        count++;
      }
    }
    return count;
  }

  static long solvePart2(final List<String> inputList) {
    int count = 0;
    List<Integer> rowIncrement = Arrays.asList(1, 3, 5, 7, 1);
    List<Integer> colIncrement = Arrays.asList(1, 1, 1, 1, 2);
    long ans = 1;
    for (int q = 0; q < rowIncrement.size(); q++) {
      int j = 0;
      for (int i = colIncrement.get(q); i < inputList.size(); i = i + colIncrement.get(q)) {
        String currLine = inputList.get(i);
        j = (j + rowIncrement.get(q)) % currLine.length();
        if (currLine.charAt(j) == '#') {
          count++;
        }
      }
      ans = ans * count;
      count = 0;
    }
    return ans;
  }
}
