package javaPrograms.LambdaAndStreamAPI;

import java.util.Arrays;
import java.util.List;

public class ForEachMethodExamples {

  public static void main(String[] args) {

    List<Integer> values = Arrays.asList(4, 5, 6, 10, 25);

    // External loop
    System.out.println("Print numbers using For loop");
    for (int i = 0; i < values.size(); i++) {
      System.out.print(values.get(i) + " ");
    }

    System.out.println("\n" + "Print numbers using enhanced For loop");
    for (int i : values) {
      System.out.print(i + " ");
    }

    // Internal For Each Loop
    System.out.println("\n" + "Print numbers using lamda expression");
    values.forEach(i -> System.out.print(i + " "));

    // Method Reference using ForEach
    System.out.println("\n" + "Print numbers passing Method Reference of println() method");
    values.forEach(System.out::println);

    // Print double the number using Method Reference
    System.out.println("\n" + "Print double the number passing Method Reference in forEach() ");
    values.forEach(ForEachMethodExamples::doubleIt);

    // Print double the number using map method in Stream API
    // the map() is used to transform one object into other by applying a function.
    System.out.println("\n\n" + "Print double the number using map() method in Stream API");
    values.stream().map(number -> number * 2).forEach(ForEachMethodExamples::printMethod);

    // Print the sum of the number which are divisible by 5
    System.out.println(
        "\nSum of the numbers which are divisible by 5 using filter() and reduce method: \n"
            + values.stream().filter(i -> i % 5 == 0).reduce(0, (c, e) -> c + e));

    // Print first number in the list divisible by 5
    System.out.println(
        "First number in the list which is divisible by 5 and double it using filter(),findFirst() and orElse() "
            + values.stream().filter(i -> i % 5 == 0).map(i -> i * 2).findFirst().orElse(0));

    // Print the sum of all the double of the number using Map method in Stream API
    System.out.println(
        "Print sum of all the double of the numbers using map() and reduce() methods in Stream API");
    System.out.println(values.stream().map(i -> i * 2).reduce(0, (c, e) -> c + e));

    /*
     * little explanation of what the above one line of code(stream, map, reduce) is
     * doing
     */
    // Creating instance of Function interface using anonymous class by defining
    // apply method of the interface
    //		Function<Integer, Integer> f = new Function<Integer, Integer>() {
    //			public Integer apply(Integer i) {
    //				return i * 2;
    //			}
    //		};

    //		BinaryOperator<Integer> b = new BinaryOperator<Integer>() {
    //			public Integer apply(Integer i, Integer j) {
    //				return i + j;
    //			}
    //		};

    // Creating instance of Stream class using values
    //		Stream<Integer> s = values.stream();
    // Creating another stream using map, passing function f which takes number and
    // return number * 2
    // Stream<Integer> s1 = s.map(f);

    // Above code is replaced by below by replacing f with the anonymous class
    // implementation
    //		Stream<Integer> s1 = s.map(new Function<Integer, Integer>() {
    //			public Integer apply(Integer i) {
    //				return i * 2;
    //			}
    //		});

    // Above code is reduced to below line by removing boiler plate and using lambda
    // expression
    // Stream<Integer> s1 = s.map(i -> i * 2);

    // Integer result = (Integer) s1.reduce(0,b);

    // Above code is replaced by below by replacing b with the anonymous class
    // implementation
    //		Integer result = (Integer) s1.reduce(0, new BinaryOperator<Integer>() {
    //			public Integer apply(Integer i, Integer j) {
    //				return i + j;
    //			}
    //		});
    // Above code is reduced to below line by removing boiler plate and using lambda
    // expression
    // Integer result = (Integer) s1.reduce(0, (c, v) -> c + v);

    // Above code is reduced by replacing s1 with its value
    // Integer result = s.map(i -> i * 2).reduce(0, (c, v) -> c + v);
    // Above code is further reduced
    // Integer result = values.stream().map(i -> i * 2).reduce(0, (c, v) -> c + v);
    // Above code is further reduced

    //		System.out.println("Sum of all the double of the numbers in the list: "
    //				+ values.stream().map(i -> i * 2).reduce(0, (c, v) -> Integer.sum(c, v)));
    //
    System.out.println(
        "Sum of all the double of the numbers in the list: "
            + values.stream().map(i -> i * 2).reduce(0, Integer::sum));
  }

  public static void doubleIt(int i) {
    System.out.print(i * 2 + " ");
  }

  public static void printMethod(int i) {
    System.out.print(i + " ");
  }
}
