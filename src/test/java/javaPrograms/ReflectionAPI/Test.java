package javaPrograms.ReflectionAPI;

@SuppressWarnings("unused")
public class Test {

	private Test(String str) {

	}

	public Test() {

	}

	Test(int integer) {

	}

	private void show() {
		System.out.println("Test class- Private show method");
	}

	private void cube(int n) {
		System.out.println("Cube of " + n + " : " + n * n * n);
	}

	public void printPublic() {
		System.out.println("Test class- Public Print method");
	}

	protected void printProtected() {
		System.out.println("Test class- Protected Print method");
	}

	void printDefault(int n) {
		System.out.println("Test class- Default Print method");
	}

	private String message = "Hello";
}