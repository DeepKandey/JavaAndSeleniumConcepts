package javaPrograms.LambdaAndStreamAPI;

import java.util.Arrays;
import java.util.List;

public class DemoForEach {

	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(4, 5, 6, 7, 8);

		// External loop
		System.out.println("Using For loop");
		for (int i = 0; i < values.size(); i++) {
			System.out.print(values.get(i) + " ");
		}

		System.out.println("\n" + "Using enhanced For loop");

		for (int i : values) {
			System.out.print(i + " ");
		}

		// Internal For Each Loop
		System.out.println("\n" + "Using lamda expression");
		values.forEach(i -> System.out.print(i + " "));
	}
}