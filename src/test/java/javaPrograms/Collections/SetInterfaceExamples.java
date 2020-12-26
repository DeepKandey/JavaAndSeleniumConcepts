package javaPrograms.Collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetInterfaceExamples {

	public static void main(String[] args) {

		// Set does not keep duplicate data but unique

		// HashSet - does not keep data sorted but uses hashing concept
		Set<Integer> hashSetObj = new HashSet<>();
		hashSetObj.add(12);
		hashSetObj.add(94);
		hashSetObj.add(67);
		hashSetObj.add(12);

		System.out.println("----Using HashSet----");
		for (int i : hashSetObj) {
			System.out.println(i);
		}

		// Tree Set- which keeps data sorted
		Set<Integer> treeSetObj = new TreeSet<>();
		treeSetObj.add(12);
		treeSetObj.add(94);
		treeSetObj.add(67);
		treeSetObj.add(12);

		System.out.println("----Using TreeSet----");
		for (int i : treeSetObj) {
			System.out.println(i);
		}
	}
}