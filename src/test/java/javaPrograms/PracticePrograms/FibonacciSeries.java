package javaPrograms.PracticePrograms;

import java.util.Scanner;

public class FibonacciSeries {

	private static Scanner scan;

	public static void main(String[] args) {

		System.out.println("How many numbers you want in Fibonacci:-");
		scan = new Scanner(System.in);
		long fibonacciSeriesNumber = scan.nextLong();

		long preTime = System.currentTimeMillis();
		System.out.println("Current time in millis before procesing: " + preTime);
		printFibonacci(fibonacciSeriesNumber);
		long postTime = System.currentTimeMillis();
		System.out.println("Current time in millis after procesing: " + postTime);
		System.out.println("Time taken to compute in milliseconds->" + (postTime - preTime));
	}

	private static void printFibonacci(long number) {
		int previousNumber = 0, nextNumber = 1, sum;
		int fibNumberAtNthPosition = 0;

		System.out.println("Fibonacci Series of " + number + " numbers:");

		for (int i = 0; i < number; i++) {
			System.out.print(previousNumber + " ");
			fibNumberAtNthPosition = previousNumber;
			sum = previousNumber + nextNumber;
			previousNumber = nextNumber;
			nextNumber = sum;
		}
		System.out.println();
		System.out.println("Fibonacci number at position " + number + " is: " + fibNumberAtNthPosition);
	}
}
