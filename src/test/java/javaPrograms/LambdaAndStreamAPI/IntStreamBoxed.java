package javaPrograms.LambdaAndStreamAPI;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamBoxed {

  // IntStream boxed() returns a Stream consisting of the elements of this stream, each boxed to an
  // Integer.

  public static void main(String[] args) {

    IntStream intStream = IntStream.range(3, 8);
    intStream.boxed().forEach(System.out::print);
    System.out.println("\n*******");

    IntStream intStream1 = IntStream.range(3, 8);
    Stream<Integer> boxed1 = intStream1.boxed();
    Stream.concat(boxed1, Stream.of("Ramesh", "Mansoor")).forEach(System.out::println);
  }
}
