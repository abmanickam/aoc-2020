
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day05 {

  public static void main(final String[] args) throws IOException {
    List<String> inputList = Files.readAllLines(Paths.get("day05.txt")).stream().collect(Collectors.toList());
    System.out.println(solvePart1(inputList));
    System.out.println(solvePart2(inputList));
  }

  static int solvePart1(final List<String> inputList) {
    List<Integer> list = new ArrayList<>();
    inputList.forEach(string -> {
      String row = string.substring(0, 7);
      row = row.replace("F", "0");
      row = row.replace("B", "1");

      String col = string.substring(7);
      col = col.replace("R", "1");
      col = col.replace("L", "0");
      list.add((Integer.parseInt(row, 2) * 8) + Integer.parseInt(col, 2));
    });
    return Collections.max(list);
  }

  static long solvePart2(final List<String> inputList) {
    List<Integer> list = new ArrayList<>();
    inputList.forEach(string -> {
      String row = string.substring(0, 7);
      row = row.replace("F", "0");
      row = row.replace("B", "1");

      String col = string.substring(7);
      col = col.replace("R", "1");
      col = col.replace("L", "0");
      list.add((Integer.parseInt(row, 2) * 8) + Integer.parseInt(col, 2));
    });

    int start = list.get(0) - 1;
    int end = list.get(list.size() - 1);
    return ((end * (end + 1)) / 2) - ((start * (start + 1)) / 2) - list.stream().mapToInt(Integer::intValue).sum();
  }
}
