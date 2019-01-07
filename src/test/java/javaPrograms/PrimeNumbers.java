package javaPrograms;

import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String[] args) {
		int remainder = 0;
		System.out.println("-------Prime mumbers between 1 and 100------");
		for (int i = 2; i < 100; i++) {
			for (int j = 2; j <= i; j++) {
				remainder = i % j;
				if (remainder == 0 && i != j) {
					break;
				} else if (remainder == 0 && i == j) {
					System.out.println(i);
				}
			}
		}
		Boolean primeNumber_flag = isPrimeNumber();
		if (primeNumber_flag) {
			System.out.println("This is a prime number");
		} else {
			System.out.println("This is not a prime number");
		}
	}

	public static boolean isPrimeNumber() {
		int num;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a Number to check if it is a prime number: ");
		num = scan.nextInt();
		scan.close();

		if (num <= 1) {
			return false;
		}

		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
