package javaPrograms.LambdaAndStreamAPI;

import static java.util.stream.Collectors.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingByCollectorExamples {

  // Simply put, groupingBy() provides similar functionality to SQL’s GROUP BY clause, just for Java
  // Stream API.
  public static void main(String[] args) {

    List<String> strings = List.of("a", "bb", "cc", "", "cc", "ddd", "dab");

    // Group Strings by their lengths
    Map<Integer, List<String>> resultMap = strings.stream().collect(groupingBy(String::length));
    System.out.println("Map(Group by length): " + resultMap);

    // Grouping into a custom Map implementation
    TreeMap<Integer, List<String>> resultTreeMap =
        strings.stream().collect(groupingBy(String::length, TreeMap::new, toList()));
    System.out.println("TreeMap(Custom Map Implementation): " + resultTreeMap);

    // Providing a Custom Downstream Collection
    Map<Integer, TreeSet<String>> resultCustomDownstream =
        strings.stream().collect(groupingBy(String::length, toCollection(TreeSet::new)));
    System.out.println("TreeSet(Custom Downstream Collection): " + resultCustomDownstream);

    // Grouping and Counting Items in Groups
    Map<Integer, Long> resultCountInGroups =
        strings.stream().collect(groupingBy(String::length, counting()));
    System.out.println("Map(Counting Items in groups): " + resultCountInGroups);

    // Grouping and Combining Items as Strings
    Map<Integer, String> resultCombineItemsAsStrings =
        strings.stream().collect(groupingBy(String::length, joining(",", "[", "]")));
    System.out.println("Map(Group and Combine Items as String): " + resultCombineItemsAsStrings);

    // Grouping and Filtering Items
    Map<Integer, List<String>> resultFilterItems =
        strings.stream()
            .collect(groupingBy(String::length, filtering(s -> !s.contains("c"), toList())));
    System.out.println("Map(Group and Filter Items): " + resultFilterItems);

    // Grouping and Calculating an Average per Group
    Map<Integer, Double> resultAveragePerGroup =
        strings.stream().collect(groupingBy(String::length, averagingInt(String::hashCode)));
    System.out.println("Map(average per group: " + resultAveragePerGroup);

    // Grouping and Calculating a Sum per Group
    Map<Integer, Integer> resultSumPerGroup =
        strings.stream().collect(groupingBy(String::length, summingInt(String::hashCode)));
    System.out.println("Map(Sum per Group) " + resultSumPerGroup);

    // Grouping and Calculating a Statistical Summary per Group
    Map<Integer, IntSummaryStatistics> resultStatisticalSummary =
        strings.stream().collect(groupingBy(String::length, summarizingInt(String::hashCode)));
    System.out.println("Map(Statistical Summary per group): " + resultStatisticalSummary);

    // Grouping and Reducing Items
    Map<Integer, List<Character>> resultGroupAndReduceItems =
        strings.stream()
            .map(toStringListOfCharacters())
            .collect(
                groupingBy(
                    List::size,
                    reducing(
                        List.of(),
                        (l1, l2) -> Stream.concat(l1.stream(), l2.stream()).collect(toList()))));
    System.out.println("Map(Group and Reduce Items: )" + resultGroupAndReduceItems);

    // Grouping and Calculating Max/Min Item
    Map<Integer, Optional<String>> resultGroupAndCalculateMax =
        strings.stream()
            .collect(
                groupingBy(
                    String::length, Collectors.maxBy(Comparator.comparing(String::toUpperCase))));
    System.out.println("Map(Group and Calculate Max): " + resultGroupAndCalculateMax);

    // Composing Downstream Collectors
    Map<Integer, TreeSet<String>> resultDownstreamCollector1 =
        strings.stream()
            .collect(
                groupingBy(
                    String::length,
                    mapping(
                        String::toUpperCase,
                        filtering(s -> s.length() > 1, toCollection(TreeSet::new)))));
    System.out.println(
        "Map(Compose Downstream Collector into TreeSet): " + resultDownstreamCollector1);

    Map<Integer, String> resultDownstreamCollector2 =
        strings.stream()
            .collect(
                groupingBy(
                    String::length,
                    mapping(
                        toStringListOfStrings(),
                        flatMapping(
                            s -> s.stream().distinct(),
                            filtering(
                                s -> s.length() > 0,
                                mapping(String::toUpperCase, reducing("", (s, s2) -> s + s2)))))));

    System.out.println(
        "Map(Compose Downstream Collector and concat): " + resultDownstreamCollector2);
  }

  private static Function<String, List<Character>> toStringListOfCharacters() {
    return s -> s.chars().mapToObj(c -> (char) c).collect(toList());
  }

  private static Function<String, List<String>> toStringListOfStrings() {
    return s -> s.chars().mapToObj(c -> (char) c).map(Object::toString).collect(toList());
  }
}
