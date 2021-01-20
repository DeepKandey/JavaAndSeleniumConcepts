/** @author Deepak Rai */
package javaPrograms.PracticePrograms;

import java.math.BigInteger;
import java.util.Scanner;

/** @author Deepak Rai */
public class BigIntegerDemo {

  /**
   * {@summary handle input as BigInteger}
   *
   * @param
   * @return
   * @author deepak rai
   */
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    BigInteger a = scan.nextBigInteger();
    BigInteger b = scan.nextBigInteger();

    System.out.println(a.add(b));
    System.out.println(a.multiply(b));

    scan.close();
  }
}
