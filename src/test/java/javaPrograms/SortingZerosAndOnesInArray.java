package javaPrograms;

public class SortingZerosAndOnesInArray {

	public static void main(String[] args) {

		int[] Array1 = new int[] { 0, 1, 0, 0, 1, 1, 1, 0 };
		int n = Array1.length;

		segregate0and1(Array1, n);
		printArray(Array1);

	}

	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");
	}

	static void segregate0and1(int[] arr, int n) {
		int count = 0; // counts the no of zeros in array

		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				count++;
			}
		}

		// loop fills the array with 0 until count
		for (int i = 0; i < count; i++) {
			arr[i] = 0;
		}

		// loop fills remaining array space with 1
		for (int i = count; i < n; i++) {
			arr[i] = 1;
		}
	}
}
