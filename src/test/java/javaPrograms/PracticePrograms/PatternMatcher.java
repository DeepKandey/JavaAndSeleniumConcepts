/**
 * @author Deepak Rai
 */
package javaPrograms.PracticePrograms;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author Deepak Rai
 *
 */
public class PatternMatcher {

	/**
	 * {@summary Pattern class example }
	 * 
	 * @param
	 * @return
	 * @author deepak rai
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());

		while (testCases > 0) {
			String pattern = in.nextLine();
			try {
				Pattern.compile(pattern);
				System.out.println("Valid");
			} catch (PatternSyntaxException exception) {
				System.out.println("Invalid");
			}
			testCases--;
		}
		in.close();
	}
}
