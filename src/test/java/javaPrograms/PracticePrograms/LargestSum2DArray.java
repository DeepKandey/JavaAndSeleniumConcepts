package javaPrograms.PracticePrograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LargestSum2DArray {

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    List<List<Integer>> arr = new ArrayList<>();

    for (int i = 0; i < 6; i++) {
      String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

      List<Integer> arrRowItems = new ArrayList<>();

      for (int j = 0; j < 6; j++) {
        int arrItem = Integer.parseInt(arrRowTempItems[j]);
        arrRowItems.add(arrItem);
      }

      arr.add(arrRowItems);
    }

    bufferedReader.close();

    System.out.println(findLargestSumAmongHourglasses(arr));
  }

  private static int findLargestSumAmongHourglasses(List<List<Integer>> arrayList) {

    int max = Integer.MIN_VALUE;

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {

        int top =
            arrayList.get(i).get(j) + arrayList.get(i).get(j + 1) + arrayList.get(i).get(j + 2);
        int middle = arrayList.get(i + 1).get(j + 1);
        int bottom =
            arrayList.get(i + 2).get(j)
                + arrayList.get(i + 2).get(j + 1)
                + arrayList.get(i + 2).get(j + 2);

        if (top + middle + bottom > max) {
          max = top + middle + bottom;
        }
      }
    }
    return max;
  }
}
