/** */
package javaPrograms.PracticePrograms;

/** @author Deepak Rai */
public class OctalToDecimal {

  /**
   * {@summary to find Octal from Decimal}
   *
   * @param
   * @return
   * @author deepak
   */
  public static void main(String[] args) {

    OctalToDecimalConverter(62);
  }

  private static void OctalToDecimalConverter(int num) {

    int decimalNumber = 0;
    int remainder = 0;
    int numberOfDigits = countDigits(num);

    while (num != 0) {
      for (int i = 0; i <= numberOfDigits - 1; i++) {
        remainder = num % 10;
        decimalNumber = (int) (decimalNumber + remainder * Math.pow(8, i));
        num = num / 10;
      }
    }
    System.out.println(decimalNumber);
  }

  private static int countDigits(int num) {
    int numberOfDigits = 0;
    while (num != 0) {
      num = num / 10;
      numberOfDigits++;
    }
    return numberOfDigits;
  }
}
