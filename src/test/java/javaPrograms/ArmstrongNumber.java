package javaPrograms;

import java.util.Scanner;

public class ArmstrongNumber {
	private static Scanner sc;

	public static void main(String[] args) {
		
		int Number = 0;
		sc = new Scanner(System.in);
		System.out.println("Please enter any number: ");
		Number = sc.nextInt();

		int numberOfDigits = numberOfDigits(Number);
		int sumofDigitsRaisedToPowerOfNumberOfDigits = getSumofDigitsRaisedToPowerOfNumberOfDigits(Number,
				numberOfDigits);
		System.out.println("Sum of Digits in the Number raised to power of number of digits-->"
				+ sumofDigitsRaisedToPowerOfNumberOfDigits);

		if (Number == sumofDigitsRaisedToPowerOfNumberOfDigits) {
			System.out.println("The given number " + Number + " is an Armstrong number");
		} else {
			System.out.println("The given number " + Number + " is not an Armstrong number");
		}

	}

	public static int numberOfDigits(int number) {
		int Count = 0;
		while (number > 0) {
			number = number / 10;
			Count = Count + 1;
		}
		return Count;
	}

	public static int getSumofDigitsRaisedToPowerOfNumberOfDigits(int number, int count) {
		int sum = 0;
		int temp = 0;
		while (number > 0) {
			temp = number % 10;
			number = number / 10;
			sum = sum + (int) Math.pow(temp, count);
		}
		return sum;
	}
}
