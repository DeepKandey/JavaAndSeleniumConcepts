package javaPrograms;

public class FactorialNumber {

	private int factorial(int num) {
		if (num == 0) {
			return 1;
		} else {
			return num * (factorial(num - 1));
		}
	}

	public static void main(String[] args) {
	
		FactorialNumber obj = new FactorialNumber();
		System.out.println("Factorial of 0:--> " + obj.factorial(0));
		System.out.println("Factorial of 1:--> " + obj.factorial(1));
		System.out.println("Factorial of 6:--> " + obj.factorial(6));
		System.out.println("Factorial of 10:--> " + obj.factorial(10));
	}
}