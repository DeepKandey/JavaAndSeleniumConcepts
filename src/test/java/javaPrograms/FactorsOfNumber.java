/**
 * 
 */
package javaPrograms;

/**
 * @author Deepak Rai
 *
 */
public class FactorsOfNumber {

	/**
	 * {@summary Factors Of a Number}
	 * 
	 * @param
	 * @return
	 * @author deepak
	 */
	public static void main(String[] args) {

		int num = 111;

		System.out.println("Factors of the number: " + num);
		for (int i = 1; i <= num; i++) {
			if (num % i == 0)
				System.out.print(i + " ");
		}
	}
}
