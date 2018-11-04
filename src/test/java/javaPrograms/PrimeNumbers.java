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
		isPrimeNumber();
	}

	public static void isPrimeNumber() {
		int num, i, count = 0;

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a Number to check if it is a prime number: ");
		num = scan.nextInt();
		scan.close();

		for (i = 2; i < num; i++) {
			if (num % i == 0) {
				count++;
				break;
			}
		}
		if (count == 0) {
			System.out.print("This is a Prime Number");
		} else {
			System.out.print("This is not a Prime Number");
		}
	}
}
