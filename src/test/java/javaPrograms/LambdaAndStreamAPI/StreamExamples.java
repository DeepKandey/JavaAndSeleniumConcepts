/** @author Deepak Rai */
package javaPrograms.LambdaAndStreamAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class StreamExamples {

  /**
   * {@summary Stream Examples}
   *
   * @param
   * @return
   * @author deepak rai
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {

    List<Integer> a = new ArrayList<>();
    a.add(1);
    a.add(2);
    a.add(3);
    a.add(3);

    // count
    System.out.println(a.stream().count());

    // findFirst
    System.out.println(a.stream().filter(s -> s > 3).findFirst());

    // Optional
    Optional<Integer> op = a.stream().filter(s -> s > 2).findFirst();

    if (op.isPresent()) {
      System.out.println(op.get());
    }

    // min
    System.out.println(a.stream().min(Comparator.reverseOrder()).get());

    // max
    System.out.println(a.stream().max(Comparator.reverseOrder()).get());

    // anyMatch
    System.out.println(a.stream().filter(s -> s > 2).anyMatch(s -> s > 1));

    // nonMatch
    System.out.println(a.stream().filter(s -> s > 2).noneMatch(s -> s > 1));

    // collect
    Set<Integer> newSet = a.stream().filter(s -> s > 1).collect(Collectors.toSet());
    System.out.println("new Set: " + newSet);

    List<Integer> b = new ArrayList<>();
    b.add(4);
    b.add(5);
    b.add(6);

    // reduce
    Optional<Integer> reduce = b.stream().reduce((x, y) -> x + y);
    System.out.println("Sum of integers: " + reduce.get());

    // mapToInt
    int sum = b.stream().mapToInt(x -> x).sum();
    System.out.println(sum);

    List<Integer> c = new ArrayList<>();
    c.add(7);
    c.add(8);
    c.add(9);

    List<List<Integer>> list = new ArrayList<>();
    list.add(a);
    list.add(b);
    list.add(c);

    System.out.println("----------------");
    // flatMap
    list.stream().flatMap(l -> l.stream()).forEach(l -> System.out.println(l));

    String ball = "Ball";
    String delta = "Delta";
    String apple = "Apple";
    // natural order
    System.out.println(Stream.of(ball, delta, apple).min(Comparator.naturalOrder()));

    Student a1 = new Student("Adam", 80, 150);
    Student b1 = new Student("Bob", 96, 123);
    Student c1 = new Student("Carl", 75, 135);

    // comparing
    Optional<Student> opStudent =
        Stream.of(a1, b1, c1).min(Comparator.comparing(s -> s.getScore()));
    System.out.println(opStudent.get());

    // takeWhile (Java 9)
    Stream<Integer> takeWhileStream = Stream.of(4, 2, 1, 5, 7, 1, 3, 9);
    System.out.println(
        "Take-while till it is lesser than 5: "
            + takeWhileStream.takeWhile(i -> i < 5).collect(Collectors.toList()));

    // dropWhile (Java 9)
    Stream<Integer> dropWhileStream = Stream.of(4, 2, 1, 5, 7, 1, 3, 9);
    System.out.println(
        "Drop-while till it is greater than or equal to 5: "
            + dropWhileStream.dropWhile(i -> i < 5).collect(Collectors.toList()));

    // of(), (Java 9)
    Map<String, Integer> map = Map.of("a", 10, "b", 15, "c", 21);
    System.out.println("Map: " + map);

    // stream of entrySet()
    map.entrySet().stream().forEach(System.out::println);

    // stream of keySet()
    map.keySet().stream().forEach(s -> System.out.print(s + " "));
    System.out.println();

    // stream of values()
    map.values().stream().forEach(s -> System.out.print(s + " "));
    System.out.println();

    var listOfNumber = List.of(1, 2, 3, 4, 5);
    // toUnmodifiableList() Java 10
    var newList =
        listOfNumber.stream().filter(i -> i % 2 == 0).collect(Collectors.toUnmodifiableList());

    String s = " ";
    System.out.println("isEmpty: " + s.isEmpty());
    System.out.println("isBlank: " + s.isBlank()); // isBlank() Java 11

    String str = "hi\nhello\nhow are you?";
    str.lines().forEach(System.out::println); // lines() Java 11

    String repeat = "5";
    System.out.println(repeat.repeat(5)); // repeat() Java 11

    Path path = Paths.get("");
    Files.writeString(path, "Java is cool");
    System.out.println(Files.readString(path));
  }
}

@Getter
@Setter
@AllArgsConstructor
@ToString
class Student {

  private String name;
  private int score;
  private int height;
}
