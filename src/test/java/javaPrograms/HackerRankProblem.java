/**
 * @author Deepak Rai
 */
package javaPrograms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HackerRankProblem {

	/**
	 * {@summary }
	 * 
	 * @param
	 * @return
	 * @author deepak rai
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int nubmerOfElementsInList = in.nextInt();

		List<Integer> arrayList = new ArrayList<>();
		
		for (int i = 0; i < nubmerOfElementsInList; i++) {
			arrayList.add(in.nextInt());
		}

		int nubmerOfQueries = in.nextInt();

		for (int i = 0; i < nubmerOfQueries; i++) {

			String modifyCondition = in.next();

			if (modifyCondition.equals("Insert")) {
				int index = in.nextInt();
				int value = in.nextInt();
				arrayList.add(index, value);

			} else if (modifyCondition.equals("Delete")) {

				int index = in.nextInt();
				arrayList.remove(index);

			}
		}
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i) + " ");
		}

	}
}