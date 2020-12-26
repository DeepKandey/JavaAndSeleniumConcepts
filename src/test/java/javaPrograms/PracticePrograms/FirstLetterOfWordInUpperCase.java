package javaPrograms.PracticePrograms;

public class FirstLetterOfWordInUpperCase {

	// Program to make first letter of each word UpperCase in the string
	public static void main(String[] args) {

		String original = "my name is deepak";

		String[] splitStringArray = original.split(" ");

		for (int i = 0; i < splitStringArray.length; i++) {
			
			String splitString = splitStringArray[i];
			String s = splitString.substring(0, 1).toUpperCase() + splitString.substring(1);
			System.out.print(s + " ");
		}
	}
}