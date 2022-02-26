package javaPrograms.HackerrankProblems;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class IceCreamParlour {

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t)
        .forEach(
            tItr -> {
              try {
                int m = Integer.parseInt(bufferedReader.readLine().trim());

                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr =
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> result = iceCreamParlor(m, arr);

                bufferedWriter.write(
                    result.stream().map(Object::toString).collect(joining(" ")) + "\n");
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }

  public static List<Integer> iceCreamParlor(int m, List<Integer> arr) {
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < arr.size(); i++) {

      int secondFlavourCost = m - arr.get(i);

      for (int j = i + 1; j < arr.size(); j++) {

        if (arr.get(j) == secondFlavourCost) {
          list.add(i + 1);
          list.add(j + 1);
          return list;
        }
      }
    }

    return list;
  }
}
