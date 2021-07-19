package javaPrograms.LambdaAndStreamAPI;

import java.io.IOException;
import java.util.stream.IntStream;

public class SumOfRangeOfIntegers {
  public static void main(String[] args) throws IOException {
    int reduce =
        IntStream.range(69, 100)
            .filter(i -> String.valueOf(i).contains("9"))
            .peek(System.out::println)
            .reduce(0, Integer::sum);
    System.out.println(reduce);
  }
}
