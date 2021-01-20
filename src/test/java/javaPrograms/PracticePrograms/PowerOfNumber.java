/** */
package javaPrograms.PracticePrograms;

/** @author Deepak Rai */
public class PowerOfNumber {

  /**
   * {@summary power of a number}
   *
   * @param
   * @return
   * @author deepak
   */
  public static void main(String[] args) {

    int number = 3;
    int power = 3;
    int finalNumber = 1;

    for (int j = power; j < 1; j--) {
      finalNumber = finalNumber * number;
    }
    System.out.println(finalNumber);
  }
}
