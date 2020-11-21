/**
 * @author Deepak Rai
 */
package javaPrograms;

import java.math.BigInteger;
import java.util.Scanner;

public class Practice {

	private Practice() {

	}

	public static void main(String[] args) {

		boolean result;

		final Scanner scanner = new Scanner(System.in);
		String n = scanner.nextLine();

		BigInteger a = new BigInteger(n);
		result = a.isProbablePrime(1);
		scanner.close();

		if (result)
			System.out.println("prime");
		else
			System.out.println("not prime");
	}

}