package javaPrograms.ReflectionAPI;

public class Test {

	private Test(String str) {

	}

	public Test() {

	}

	Test(int integer) {

	}

	private void show() {
		System.out.println("Test class- show method");
	}

	private void cube(int n) {
		System.out.println("Cube of " + n + " : " + n * n * n);
	}
}