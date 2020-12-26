package javaPrograms.PracticePrograms;

public class SeparateNumberNDigitFromString {

	public static void main(String[] args) {

		String string = "A123BNG@er12";
		StringBuffer alphabet = new StringBuffer();
		StringBuffer numeric = new StringBuffer();
		StringBuffer specialChar = new StringBuffer();

		char charc[] = string.toCharArray();
		for (int i = 0; i < charc.length; i++) {
			if (Character.isAlphabetic(charc[i])) {
				// System.out.println(charc[i] + " is alphabet? " +
				// Character.isAlphabetic(charc[i]));
				alphabet.append(charc[i]);
			} else if (Character.isDigit(charc[i])) {
				// System.out.println(charc[i] + " is digit? " + Character.isDigit(charc[i]));
				numeric.append(charc[i]);
			} else
				// System.out.println(charc[i]);
				specialChar.append(charc[i]);

		}
		System.out.println("Original String: " + string);
		System.out.println("Alphabets: " + alphabet);
		System.out.println("Numbers: " + numeric);
		System.out.println("SpecialCharacters: " + specialChar);
	} // End of main method
} // End of class PratcicePrograms