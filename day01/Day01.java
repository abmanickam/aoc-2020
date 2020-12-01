
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day01 {

  public static void main(final String[] args) throws IOException {
    List<Integer> inputList =
        Files.readAllLines(Paths.get("input.txt")).stream().map(Integer::parseInt).collect(Collectors.toList());
    System.out.println(solvePart1(inputList));
    System.out.println(solvePart2(inputList));
  }

  static int solvePart1(final List<Integer> inputList) {
    int i;
    for (i = 0; i < inputList.size(); i++) {
      int x = inputList.get(i);
      int y = 2020 - x;
      if (inputList.contains(y) && (x != y)) {
		System.out.println(x);
		System.out.println(y);
        return x * y;
      }
    }
    return -1;
  }

  static int solvePart2(final List<Integer> inputList) {
    int i, j;
    for (i = 0; i < inputList.size(); i++) {
      int x = inputList.get(i);
      for (j = i+1; j < inputList.size(); j++) {
        int y = inputList.get(j);

        if (((x + y) >= 2020) || (x == y)) {
          continue;
        }

        int z = 2020 - x - y;
        if (inputList.contains(z) && (z != x) && (z != y)) {
		  System.out.println(x);
		  System.out.println(y);
		  System.out.println(z);
          return x * y * z;
        }
      }
    }
    return -1;
  }
}