package javaPrograms.PracticePrograms;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MaximumUniqueNumbersDeque {

  public static void main(String[] args) {
    //
    Scanner in = new Scanner(System.in);
    Deque deque = new ArrayDeque<>();
    int n = in.nextInt();
    int m = in.nextInt();
    long max = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      int num = in.nextInt();
      deque.add(num);
    }

    while (deque.toArray().length >= m) {
      long numberOfUniqueIntegers = deque.stream().toList().stream().limit(m).distinct().count();
      if (numberOfUniqueIntegers > max) {
        max = deque.stream().toList().stream().limit(3).distinct().count();
      }
      deque.remove();
    }

    System.out.println(max);
  }
}
