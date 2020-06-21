/**
 * 
 */
package javaPrograms;

/**
 * @author Deepak Rai
 *
 */
public class FindLeapYear {

	/**
	 * {@summary to find leap year}
	 * 
	 * @param
	 * @return
	 * @author deepak
	 */
	public static void main(String[] args) {

		System.out.println(isLeapYear(2026));
	}

	private static boolean isLeapYear(int year) {

		if ((year % 400 == 0 && year % 100 == 0) || year % 4 == 0)
			return true;
		else
			return false;
	}
}