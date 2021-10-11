/* @author Deepak Rai */
package javaPrograms.PracticePrograms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Practice {

  public static void main(String[] args) {

    List<String> magazineList = List.of("attack", "at", "dawn");
    List<String> noteList = List.of("Attack", "at", "dawn");

    Result.checkMagazine(magazineList, noteList);
  }
}

class Result {
  /*
   * Complete the 'checkMagazine' function below.
   *
   * The function accepts following parameters:
   *  1. STRING_ARRAY magazine
   *  2. STRING_ARRAY note
   */

  public static void checkMagazine(List<String> magazine, List<String> note) {
    // Write your code here

    HashMap<String, Integer> magazineMap = new HashMap<>();
    for (String i : magazine) {
      if (!magazineMap.containsKey(i)) {
        magazineMap.put(i, 1);
      } else {
        magazineMap.put(i, (magazineMap.get(i) + 1));
      }
    }

    HashMap<String, Integer> noteMap = new HashMap<>();
    for (String i : note) {
      if (!noteMap.containsKey(i)) {
        noteMap.put(i, 1);
      } else {
        noteMap.put(i, (noteMap.get(i) + 1));
      }
    }

    boolean canReplicate  = true;

    for (Map.Entry<String, Integer> noteEntry : noteMap.entrySet()) {
      String key = noteEntry.getKey();
      Integer value = noteEntry.getValue();

        if(!magazineMap.containsKey(key) || (magazineMap.get(key) < noteMap.get(key)) ) {
        canReplicate  = false;
        break;
      }
    }

    if (canReplicate ) {
      System.out.println("Yes");
    } else System.out.println("No");
  }
}
