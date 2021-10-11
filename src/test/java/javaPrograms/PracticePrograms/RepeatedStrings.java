package javaPrograms.PracticePrograms;

import java.io.IOException;
import java.util.Scanner;

public class RepeatedStrings {
  public static void main(String[] args) throws IOException {

    Scanner scanner = new Scanner(System.in);

    String s = scanner.next();

    long n = Long.parseLong(String.valueOf(scanner.nextLong()));

    long result = repeatedString(s, n);
    System.out.println(result);
  }

  /*
   * Complete the 'repeatedString' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   *  1. STRING s
   *  2. LONG_INTEGER n
   */

  public static long repeatedString(String s, long n) {
    // Write your code here

    long countForSubstring = 0;
    long totalCount = 0;

    // Determine how many a's are in a substring
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'a') {
        countForSubstring++;
      }
    }

    // Determine how many complete substrings we will analyze
    long divisor = n / s.length();
    totalCount += divisor * countForSubstring;

    // Determine how many characters we will analyze towards the end of our n range
    long remainder = n % s.length();

    for (int i = 0; i < remainder; i++) {
      if (s.charAt(i) == 'a') {
        totalCount++;
      }
    }
    return totalCount;
  }
}
