package javaPrograms.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Using Comparator interface defining own logic of sorting
public class CollectionUsingComparator {

	public static void main(String[] args) {

		// Using List Interface which extends Collection interface but maintains index
		List<Integer> valuesList = new ArrayList<>();
		valuesList.add(996);
		valuesList.add(237);
		valuesList.add(1, 874);
		valuesList.add(102);

		/*
		 * Comparator<Integer> compObj = new Comparator<>() {
		 * 
		 * @Override public int compare(Integer o1, Integer o2) {
		 * 
		 * // Defining logic of sorting by last digit of the number if (o1 % 10 > o2 %
		 * 10) return 1; return -1; } };
		 */

		// Another way to implement compare abstract method using lamda expression
		Comparator<Integer> compObj = (o1, o2) -> {
			// Defining logic of sorting by last digit of the number
			/*
			 * if (o1 % 10 > o2 % 10) return 1; return -1;
			 */

			return o1 % 10 > o2 % 10 ? 1 : -1;
		};

		// Sorting list using Collections class and Comparator Interface
		Collections.sort(valuesList, compObj); 

		System.out.println("--------Using lambda expression with comparator object");
		valuesList.forEach(System.out::println);
		
		// Sorting list using Collections class and compare abstract method defined using lambda expression
		Collections.sort(valuesList,  (o1, o2) -> {
			return o1 % 10 > o2 % 10 ? 1 : -1;
		}); 
		System.out.println("--------Using lambda expression without comparator object");
		valuesList.forEach(System.out::println);
	}
}