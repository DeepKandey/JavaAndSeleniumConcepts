package javaPrograms.Regex;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegexAsPredicate {

  public static void main(String[] args) {
    // Compile regex as predicate
    Predicate<String> emailFilter = Pattern.compile("^(.+)@example.com$").asPredicate();

    // Input list
    List<String> emails =
        Arrays.asList("alex@example.com", "bob@yahoo.com", "cat@google.com", "david@example.com");

    // Apply predicate filter
    List<String> desiredEmails = emails.stream().filter(emailFilter).collect(Collectors.toList());

    // Now perform desired operation
    desiredEmails.forEach(System.out::println);
  }
}
