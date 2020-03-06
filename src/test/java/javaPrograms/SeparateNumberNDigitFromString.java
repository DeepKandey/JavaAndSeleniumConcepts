package javaPrograms;

public class SeparateNumberNDigitFromString {

	public static void main(String[] args) {

		String s = "A123BNG@er12";

		char charc[] = s.toCharArray();
		for (int i = 0; i < charc.length; i++) {
			if (Character.isAlphabetic(charc[i])) {
				System.out.println(charc[i] + " is alphabet? " + Character.isAlphabetic(charc[i]));
			} else if (Character.isDigit(charc[i])) {
				System.out.println(charc[i] + " is digit? " + Character.isDigit(charc[i]));
			} else
				System.out.println(charc[i]);

		}
	} // end of main method
} // End of class PratcicePrograms
