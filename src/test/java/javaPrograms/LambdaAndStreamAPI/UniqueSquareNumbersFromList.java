package javaPrograms.LambdaAndStreamAPI;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class UniqueSquareNumbersFromList {

	public static void main(String[] args) {

		// Array List of Integers
		List<Integer> al = Arrays.asList(1, 1, 4, 9, 10);
		System.out.println(al);

		// Used Lambda expression to print square of unique numbers using HashSet
		new HashSet<>(al).forEach(n -> System.out.println(n + "\t" + (int) Math.pow(n, 2)));
		new HashSet<>(al).stream().map(n-> (int) Math.pow(n, 2)).forEach(UniqueSquareNumbersFromList::printMethod);
	}
	
	public static void printMethod(int i) {
		System.out.print(i + " ");
	}
}