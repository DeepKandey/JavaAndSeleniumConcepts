package javaPrograms.PracticePrograms;

import org.apache.commons.lang3.math.NumberUtils;

public class ValueOfAndParseConcept {

	// Convert String to Integer
	public static void main(String[] args) {

		String str1 = "1232355467";
		int val1 = Integer.parseInt(str1); // Using ParseInt method which returns primitive data type
		System.out.println("Primitive interger type representation: " + val1);

		try {
			String str2 = "1232355467345546";
			Long val2;
			if (NumberUtils.isCreatable(str2)) {
				val2 = Long.valueOf(str2); // Using valueOf method which returns object of primitive Type
				System.out.println("Object representation of primitve data type: " + val2);
			} else
				System.out.println("String is not proper number");
		} catch (Exception e) {
			System.out.println("Number is not valid");
		}
	}
}