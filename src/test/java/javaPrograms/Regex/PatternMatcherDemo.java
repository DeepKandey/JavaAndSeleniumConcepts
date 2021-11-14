package javaPrograms.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javaPrograms.Range;

public class PatternMatcherDemo {

  public static void main(String[] args) {
    Pattern p1 = Pattern.compile("(a)\\1+");
    Matcher m1 = p1.matcher("aaaaabbaaabbba");
    while (m1.find()) System.out.println(m1.group());

    Range range = new Range(23, 45);
    Range range2 = new Range(23, 45);
    System.out.println("high: " + range.high() + " low: " + range.low());
    System.out.println(range);
    System.out.println(range.equals(range2));
    System.out.println(range.hashCode());
  }
}
