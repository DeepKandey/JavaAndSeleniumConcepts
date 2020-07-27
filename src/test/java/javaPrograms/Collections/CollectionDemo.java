package javaPrograms.Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Have used Collection, List Interface and Collections, ArrayList class
public class CollectionDemo {

	public static void main(String[] args) {

		// Using collection Interface
		Collection<Integer> values = new ArrayList<>();
		values.add(99);
		values.add(90);

		System.out.println("-------Using Collection------");
		Iterator<Integer> iterator = values.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		// Using List Interface which extends Collection interface but maintains index
		List<Integer> valuesList = new ArrayList<>();
		valuesList.add(99);
		valuesList.add(90);
		valuesList.add(1, 87);
		
		System.out.println("--------Using lamda expression");
		valuesList.forEach(System.out::println);
		
		Collections.sort(valuesList);  // Sorting list using Collections class

		System.out.println("-------Using List after sorting using Collections class------");
		Iterator<Integer> iteratorList = valuesList.iterator();
		while (iteratorList.hasNext()) {
			System.out.println(iteratorList.next());
		}
	}
}
