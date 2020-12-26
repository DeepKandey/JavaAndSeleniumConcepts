/**
 * @author Deepak Rai
 */
package javaPrograms.PracticePrograms;

public class IPAddressPatternMatch {

	/**
	 * {@summary IP Address Pattern check}
	 * 
	 * @param
	 * @return
	 * @author deepak rai
	 */
	public static void main(String[] args) {

		String IP = "000.10.120.034";

		System.out.println(IP.matches(new MyRegex().pattern));

	}
}

class MyRegex {

	String patternIP = "([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])";

	String pattern = "^" + patternIP + "\\." + patternIP + "\\." + patternIP + "\\." + patternIP + "$";
}