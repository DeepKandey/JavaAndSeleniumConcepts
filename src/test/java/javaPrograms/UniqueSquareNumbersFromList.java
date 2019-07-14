package javaPrograms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class UniqueSquareNumbersFromList {

	public static void main(String[] args) {

		List<Integer> al = Arrays.asList(1, 1, 4, 9, 10);
		System.out.println(al);

		new HashSet<>(al).forEach(n -> System.out.println(n + "\t" + (int) Math.pow(n, 2)));
	}
}