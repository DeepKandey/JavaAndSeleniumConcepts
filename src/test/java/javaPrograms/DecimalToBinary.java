/**
 * 
 */
package javaPrograms;

/**
 * @author Deepak Rai
 *
 */
public class DecimalToBinary {

	/**
	 * {@summary convert decimal to binary}
	 * 
	 * @param
	 * @return
	 * @author deepak
	 */
	public static void main(String[] args) {

		int[] numberArray = decimalToBinaryConverter(50);

		for (int j = i - 1; j >= 0; j--) {
			System.out.print(numberArray[j]);
		}
	}

	static int i = 0;

	private static int[] decimalToBinaryConverter(int decimalNumber) {
		
		int[] binaryNumber = new int[100];
		int remainder = 0;

		while (decimalNumber != 0) {
			remainder = decimalNumber % 2;
			decimalNumber = decimalNumber / 2;
			binaryNumber[i] = remainder;
			i++;
		}
		return binaryNumber;
	}
}
