package javaPrograms;

import java.util.Scanner;

public class FibonacciSeries {

	private static Scanner scan;

	public static void main(String[] args) {
		System.out.println("How many numbers you want in Fibonacci:-");
		scan = new Scanner(System.in);
		int fibonacciSeriesNumber = scan.nextInt();

		printFibonacci(fibonacciSeriesNumber);
	}

	public static void printFibonacci(int number) {
		int previousNumber = 0, nextNumber = 1, sum;
		int fibNumberAtNthPosition = 0;

		System.out.println("Fibonacci Series of " + number + " numbers:");

		for (int i = 0; i < number; i++) {
			System.out.println(previousNumber + " ");
			fibNumberAtNthPosition = previousNumber;
			sum = previousNumber + nextNumber;
			previousNumber = nextNumber;
			nextNumber = sum;
		}
		System.out.println("Fibonacci number at position " + number + " is: " + fibNumberAtNthPosition);
	}
}
