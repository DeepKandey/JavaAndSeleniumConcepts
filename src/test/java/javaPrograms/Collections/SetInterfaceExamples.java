package javaPrograms.Collections;

import java.util.*;

public class SetInterfaceExamples {

  public static void main(String[] args) {

    // Set does not keep duplicate data but unique

    // HashSet - does not keep data sorted but uses hashing concept
    Set<Integer> hashSetObj = new HashSet<>();
    hashSetObj.add(12);
    hashSetObj.add(94);
    hashSetObj.add(67);
    hashSetObj.add(12);

    System.out.println("----Using HashSet----");
    for (int i : hashSetObj) {
      System.out.println(i);
    }

    // Tree Set- which keeps data sorted
    Set<Integer> treeSetObj = new TreeSet<>();
    treeSetObj.add(12);
    treeSetObj.add(94);
    treeSetObj.add(67);
    treeSetObj.add(12);

    System.out.println("----Using TreeSet----");
    for (int i : treeSetObj) {
      System.out.println(i);
    }

    // LinkedHashSet - remove duplicates and maintain order
    ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 7, 2, 5, 6, 7));
    LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(numbers);
    System.out.println("Removing duplicates using LinkedHashSet: " + linkedHashSet);

    // EnumSet - The EnumSet is one of the specialized implementation of the Set interface for use
    // with the enumeration type.
    // Enumerations serve the purpose of representing a group of named constants in a programming
    // language.
    // In Java (from 1.5), enums are represented using enum data type.
    // The main objective of enum is to define our own data types(Enumerated Data Types).

    enum Lang {
      JAVA,
      JAVASCRIPT,
      PHP,
      PYTHON,
      CSHARP
    }
    enum TechLang {
      RUBY
    }

    EnumSet<Lang> langEnumSet = EnumSet.allOf(Lang.class);
    System.out.println("EnumSet:" + langEnumSet);

    for (Lang lang : langEnumSet) System.out.print(lang + " ");

    EnumSet<Lang> emptyEnumSet = EnumSet.noneOf(Lang.class);
    System.out.println("\nEmpty EnumSet:" + emptyEnumSet);

    langEnumSet.remove(Lang.PHP);
    System.out.println("EnumSet after removing Python:" + langEnumSet);
  }
}
