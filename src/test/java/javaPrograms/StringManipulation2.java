package javaPrograms;

import org.apache.commons.lang3.math.NumberUtils;

public class StringManipulation2 {

	// Convert String to Integer
	public static void main(String[] args) {
		String str1 = "1232355467";
		int val1 = Integer.parseInt(str1); // Using ParseInt method which returns Integer of primitive type
		System.out.println(val1);

		try {
			String str2 = "1232355467345546$";
			Integer val2;
			if (NumberUtils.isCreatable(str2)) {
				val2 = Integer.valueOf(str2); // Using valueOf method which returns Integer object
				System.out.println(val2.toString());
			} else
				System.out.println("String is not proper number");
		} catch (Exception e) {
			System.out.println("Number is not valid");
		}
	}
}