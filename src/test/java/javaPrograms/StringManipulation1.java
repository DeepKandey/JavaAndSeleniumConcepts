package javaPrograms;

public class StringManipulation1 {

	// Program to make first letter of each word UpperCase in the string
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String original = "my name is deepak";

		String[] splitStringArray = original.split(" ");

		for (int i = 0; i < splitStringArray.length; i++) {
			String splitString = splitStringArray[i];
			for (int j = 0; j < splitString.length(); j++) {
				if (j == 0) {
					String s = splitString.substring(0, 1).toUpperCase() + splitString.substring(1);
					System.out.print(s + " ");
					break;
				}
			}
		}
	}
}