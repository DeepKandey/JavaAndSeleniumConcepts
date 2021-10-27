/* @author Deepak Rai */
package javaPrograms.PracticePrograms;

import java.util.ArrayList;
import java.util.List;

class Practice {

  public static void main(String[] args) {

    List<Integer> integers = new ArrayList<>();
    integers.add(1);
    integers.add(2);
    integers.add(3);
    integers.add(4);
    integers.add(5);

    List<Integer> integers1 = integers.subList(4, integers.size());
    List<Integer> integers2 = integers.subList(0, 4);
    integers1.addAll(integers2);

    System.out.println(integers1);
  }
}
