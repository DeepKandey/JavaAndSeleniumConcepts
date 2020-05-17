package javaPrograms;

interface Phone {

	void call();

	default void message() {
		System.out.println("Message defined default in Phone Interface");
	}

	static void photo() {
		System.out.println("Photo defined static in Interface");
	}
}

interface Tablet {
	default void message() {
		System.out.println("Tablet message");
	}
	
}

class Android implements Phone {

	public void call() {
		System.out.println("Calling from Android Class");
	}
}

public class InterfaceExample implements Phone, Tablet {

	public static void main(String[] args) {
		Phone p = new Android();
		Phone p1 = new InterfaceExample();
		InterfaceExample demoObj = new InterfaceExample();
		demoObj.message(); // Message defined is common to both interface
		p.call();
		p1.call();
		p.message();
		Phone.photo();
		demoObj.equals(p1);
	}

	@Override
	public void call() {
		System.out.println("Call defined inside DemoInterface");

	}

	@Override
	public void message() {
		// TODO Auto-generated method stub
		System.out.println("Demo Message");
	}
}