/**
 * @author Deepak Rai
 */
package javaPrograms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindWeekDayAFromTheGivenDay {

	/**
	 * {@summary }
	 * 
	 * @param
	 * @return
	 * @author deepak rai
	 */

	public static void main(String args[]) {

		String S = "Wed";
		int k = 7;

		System.out.println(findWeekDay(S, k));
	}

	public static String findWeekDay(String s, int k) {

		List<String> days = Stream.of("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun").collect(Collectors.toList());

		int index = days.indexOf(s);
		return days.get((index + k) % 7);
	}
}