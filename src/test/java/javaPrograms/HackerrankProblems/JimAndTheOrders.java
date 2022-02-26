package javaPrograms.HackerrankProblems;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class JimAndTheOrders {

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<Integer>> orders = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      String[] ordersRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

      List<Integer> ordersRowItems = new ArrayList<>();

      for (int j = 0; j < 2; j++) {
        int ordersItem = Integer.parseInt(ordersRowTempItems[j]);
        ordersRowItems.add(ordersItem);
      }

      orders.add(ordersRowItems);
    }

    List<Integer> result = jimOrders(orders);

    for (int i = 0; i < result.size(); i++) {
      bufferedWriter.write(String.valueOf(result.get(i)));

      if (i != result.size() - 1) {
        bufferedWriter.write(" ");
      }
    }

    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }

  public static List<Integer> jimOrders(List<List<Integer>> orders) {
    HashMap<Integer, Integer> customerServeTimeMap = new HashMap();

    for (int i = 0; i < orders.size(); i++) {
      customerServeTimeMap.put(i + 1, orders.get(i).get(0) + orders.get(i).get(1));
    }

    LinkedHashMap<Integer, Integer> customerServeTimeSortedMap =
        customerServeTimeMap.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    return new ArrayList<>(customerServeTimeSortedMap.keySet());
  }
}
