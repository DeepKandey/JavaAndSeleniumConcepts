package javaPrograms;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Deepak", "Pankaj", "Harsh");

		names.forEach(System.out::println); // // Method reference feature in Java 8

	}
}