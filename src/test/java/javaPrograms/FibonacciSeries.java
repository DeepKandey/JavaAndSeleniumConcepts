package javaPrograms;

import java.util.Scanner;

public class FibonacciSeries {

	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		System.out.println("Please enter any number for Fibonacci Series:-");
		int fibonacciSeriesNumber = scan.nextInt();

		printFibonacciUsingArray(fibonacciSeriesNumber);
		printFibonacciAtGivenPosition(fibonacciSeriesNumber);
	}

	public static void printFibonacciUsingArray(int number) {
		int[] fibonacciAraay = new int[number];

		if (number == 0) {
			System.out.println("Entered number should be greater than zero");
		} else if (number == 1) {
			fibonacciAraay[0] = 0;
		} else if (number > 1) {
			fibonacciAraay[0] = 0;
			fibonacciAraay[1] = 1;
			for (int i = 2; i < number; i++) {
				fibonacciAraay[i] = fibonacciAraay[i - 1] + fibonacciAraay[i - 2];
			}
		}

		if (number > 0) {
			System.out.println("---Fibonacci Series---");
			for (int j = 0; j < number; j++) {
				System.out.println(fibonacciAraay[j]);
			}
		}

	}

	public static void printFibonacciAtGivenPosition(int number) {
		int a = 0, b = 1, c;

		for (int i = 2; i < number; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		if (number > 0)
			System.out.println("Fibonacci number at position " + number + " is: " + b);
	}
}
