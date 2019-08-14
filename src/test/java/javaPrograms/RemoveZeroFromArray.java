package javaPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveZeroFromArray {

	public static void main(String[] args) {
		// Array with zero and non-zero numbers
		Integer[] numbers = { 1, 3, 6, 0, 4, 0, 3 };

		List<Integer> list = new ArrayList<Integer>(Arrays.asList(numbers));
		// Removing all zero from the list
		list.removeAll(Arrays.asList(Integer.valueOf(0)));
		// Assigning the list with non-zero numbers into array using toArray() method
		numbers = list.toArray(new Integer[list.size()]);
		// Printing the numbers
		System.out.println(Arrays.toString(numbers));

	}
}
