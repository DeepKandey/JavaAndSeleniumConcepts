/** @author Deepak Rai */
package javaPrograms.LambdaAndStreamAPI;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/** @author Deepak Rai */
public class FunctionalInterfaceExamples {

  /**
   * {@summary Java 8 features}
   *
   * @param
   * @return
   * @author deepak rai
   */
  public static void main(String[] args) {

    // Supplier functional interface
    Supplier<Double> random = Math::random;
    System.out.println(random.get());

    // Consumer functional interface
    Consumer<String> consumer = s -> System.out.println(s);
    consumer.accept("Consumer Functional Interface");

    // BiConsumer functional interface-- forEach method of Map takes biConsumer
    BiConsumer<String, Integer> biconsumer =
        (s, i) -> {
          System.out.println("My name:: " + s);
          System.out.println("My age:: " + i);
        };
    biconsumer.accept("Deepak Rai", 30);

    // Predicate functional interface
    Predicate<Integer> predicateIsGT2 = n -> n > 2;
    System.out.println(predicateIsGT2.test(5));

    // Function functional interface
    Function<String, Integer> strLen = s -> s.length();
    Function<Integer, Integer> square = i -> i * i;
    Function<Integer, Integer> plus2 = i -> i + 2;

    System.out.println(strLen.andThen(square).apply("Stream")); // a->b
    System.out.println(plus2.compose(square).apply(2)); // b->a

    // Runnable functional interface
    Runnable runnable = () -> System.out.println("Runnable functional interface");
    runnable.run();
  }
}
