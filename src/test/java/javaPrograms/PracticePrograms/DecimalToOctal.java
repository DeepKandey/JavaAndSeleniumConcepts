/**
 * 
 */
package javaPrograms.PracticePrograms;

/**
 * @author Deepak Rai
 *
 */
public class DecimalToOctal {

	/**
		 * {@summary to find Octal number from Decimal}
		 * @param
		 * @return
		 * @author deepak
		 */
	public static void main(String[] args) {
		int[] numberArray = decimalToOctalConverter(50);

		for (int j = i - 1; j >= 0; j--) {
			System.out.print(numberArray[j]);
		}
	}
	static int i = 0;

	private static int[] decimalToOctalConverter(int decimalNumber) {
		
		int[] binaryNumber = new int[100];
		int remainder = 0;

		while (decimalNumber != 0) {
			remainder = decimalNumber % 8;
			decimalNumber = decimalNumber / 8;
			binaryNumber[i] = remainder;
			i++;
		}
		return binaryNumber;
	}
}
