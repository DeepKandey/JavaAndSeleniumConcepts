package javaPrograms.LambdaAndStreamAPI;

interface A {
	void show();
}


// Class to implement show method of interface
/*
 * class Xyz implements A{ public void show() { System.out.println("Hello"); } }
 */

/*
 * Here we are first calling show method using Xyz object, then using
 * anonymous class defining show method. At last using lambda expression,
 * defining and calling show method
 */
public class LambdaDemo {

	public static void main(String[] args) {

		A obj;
		/* obj = new Xyz(); */

		// obj = new A() { public void show() { System.out.println("Hello"); } };

		obj = () -> System.out.println("Hello");
		obj.show();
	}
}