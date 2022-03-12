package javaPrograms.HackerrankProblems;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MissingNumbers {

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    List<Integer> arr =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    List<Integer> brr =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    List<Integer> result = missingNumbers(arr, brr);

    bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")) + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }

  public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {

    HashMap<Integer, Integer> brrMap = new HashMap<>();
    HashMap<Integer, Integer> arrMap = new HashMap<>();
    Set<Integer> missingNumberSet = new TreeSet<>();

    for (Integer integer : brr) {
      brrMap.merge(integer, 1, Integer::sum);
    }

    for (Integer integer : arr) {
      arrMap.merge(integer, 1, Integer::sum);
    }

    for (Integer integer : brr) {
      if (!(brrMap.get(integer).equals(arrMap.get(integer)))) {
        missingNumberSet.add(integer);
      }
    }
    return new ArrayList<>(missingNumberSet);
  }
}
