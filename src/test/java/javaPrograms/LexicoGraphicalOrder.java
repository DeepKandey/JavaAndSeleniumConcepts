/**
 * @author Deepak Rai
 */
package javaPrograms;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Deepak Rai
 *
 */
public class LexicoGraphicalOrder {

	/**
	 * {@summary }
	 * 
	 * @param
	 * @return
	 * @author deepak rai
	 */
	public static void main(String[] args) {

		System.out.println('A' > 'a');
		System.out.println((int) 'A' + " " + (int) 'a');

		System.out.println(getSmallestAndLargest("dezpeakak", 3));
	}

	public static String getSmallestAndLargest(String s, int k) {
		String smallest = "";
		String largest = "";

		// Complete the function
		// 'smallest' must be the lexicographically smallest substring of length 'k'
		// 'largest' must be the lexicographically largest substring of length 'k'

		ArrayList<String> stringAsArrayList = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {

			if (i <= s.length() - k) {
				stringAsArrayList.add(s.substring(i, (i + k)));
			} else
				break;
		}

		// ArrayList with given integer
		System.out.println(stringAsArrayList);
		// Sort arrayList lexicographically
		Collections.sort(stringAsArrayList);
		// Print lexicographical arrayList
		System.out.println("String in lexicographic order: " + stringAsArrayList);

		smallest = stringAsArrayList.get(0);
		largest = stringAsArrayList.get(stringAsArrayList.size() - 1);

		return smallest + "\n" + largest;
	}
}