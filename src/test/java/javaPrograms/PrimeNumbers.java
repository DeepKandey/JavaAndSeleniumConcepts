package javaPrograms;

import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String[] args) {
		Boolean primeNumber_flag = isPrimeNumber();

		if (primeNumber_flag) {
			System.out.println("This is a prime number");
		} else {
			System.out.println("This is not a prime number");
		}

		getPrimeNumbers(100);
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

	public static void getPrimeNumbers(int num) {

		System.out.println("****--Prime numbers upto " + num + "--****");
		for (int i = 2; i <= num; i++) {
			for (int j = 2; j <= i; j++) {
				if (i % j == 0 && i != j) {
					break;
				} else if (i % j == 0 && i == j) {
					System.out.print(i + " ");
				}
			}
		}
	}
}
