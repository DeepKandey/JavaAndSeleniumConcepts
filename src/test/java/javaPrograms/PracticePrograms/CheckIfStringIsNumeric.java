package javaPrograms.PracticePrograms;

public class CheckIfStringIsNumeric {

	// Check for null and empty string
	protected static boolean isEmpty(CharSequence cs) {
		return cs == null || cs.length() == 0;
	}

	// Check for numeric string
	protected static boolean isNumeric(CharSequence cs) {
		if (isEmpty(cs)) {
			return false;
		}

		int len = cs.length();
		for (int i = 0; i < len; i++) {
			if (!Character.isDigit(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isNumeric(null));
		System.out.println(isNumeric(""));
		System.out.println(isNumeric("123"));
		System.out.println(isNumeric("   "));
		System.out.println(isNumeric("ABS"));
		System.out.println(isNumeric("12.3"));
		System.out.println(isNumeric("0123"));
		System.out.println(isNumeric("١٢٣"));

	}
}// End of class CheckIfStringIsNumeric