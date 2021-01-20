/** @author Deepak Rai */
package javaPrograms.PracticePrograms;

import java.util.ArrayList;
import java.util.List;

/** @author Deepak Rai */
public class UniqueNumbersInString {

  /**
   * {@summary Print unique numbers in String}
   *
   * @param
   * @return
   * @author deepak rai
   */
  public static void main(String[] args) {

    String s = "qq4 q4 q rvw vw5 wv 5gv w12345wg5gw 5gw5 gw";

    char[] ch = s.toCharArray();
    List<Character> listOfUniqueNumbersInString = new ArrayList<>();

    // filter
    for (Character c : ch) {
      if (Character.isDigit(c) && !listOfUniqueNumbersInString.contains(c))
        listOfUniqueNumbersInString.add(c);
    }

    // Print numbers
    listOfUniqueNumbersInString.forEach(a -> System.out.print(a + " "));
  }
}
