package javaPrograms.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Using Comparator interface defining own logic of sorting
public class ComparatorInterfaceExamples {

	public static void main(String[] args) {

		// Using List Interface which extends Collection interface but maintains index
		List<Integer> valuesList = new ArrayList<>();
		valuesList.add(996);
		valuesList.add(237);
		valuesList.add(1, 874);
		valuesList.add(102);

		// Another way to implement compare abstract method using lambda expression
		Comparator<Integer> compObj = (o1, o2) -> o1 % 10 > o2 % 10 ? 1 : -1;

		// Sorting list using Collections class and Comparator Interface
		Collections.sort(valuesList, compObj);

		System.out.println("--------Sorted using Comparator functional interface");
		valuesList.forEach(System.out::println);

		// Sorting list using Collections class and compare abstract method defined
		// using lambda expression
		Collections.sort(valuesList, (o1, o2) -> {
			return o1 % 10 > o2 % 10 ? 1 : -1;
		});
		System.out.println("--------Sorted without using comparator object");
		valuesList.forEach(System.out::println);
	}
}