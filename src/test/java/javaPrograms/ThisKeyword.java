package javaPrograms;

public class ThisKeyword {
	int a = 0;

	// 1. For same parameter name and instance variable
	void Display(int a) {
		System.out.println("Value of variable passed--> " + a);
		System.out.println("Value of instance variable--> " + this.a + System.lineSeparator());
	}

	// 2. For calling instance method using this keyword
	void callDisplay() {
		System.out.println("-----Calling instance method using this keyword----");
		this.Display(30);
	}

	ThisKeyword() {
		System.out.println("Default Constructor" + System.lineSeparator());
	}

	// 3. Calling constructor using this keyword
	ThisKeyword(int a) {
		this();
		this.a = a;
		System.out.println("Printing value using parameterized constructor--> " + a + System.lineSeparator());
	}

	void callByReferene(ThisKeyword obj) {
		System.out.println("Call By Reference");
	}

	// 4. Calling method passing object reference using this keyword
	void methodCallWithThisAsParameter() {
		callByReferene(this);
	}

	// 5. Returning this (current instance) from method
	ThisKeyword returnCurrentInstance() {
		System.out.println(System.lineSeparator() + "Returning current instance using this Keyword");
		return this;
	}

	public static void main(String[] args) {
		ThisKeyword thisKeyWord1 = new ThisKeyword();
		System.out.println("**Calling default constructor using this Keyword**");
		ThisKeyword thisKeyWord2 = new ThisKeyword(45);
		thisKeyWord1.Display(12);
		thisKeyWord1.callDisplay();
		thisKeyWord2.methodCallWithThisAsParameter();
		thisKeyWord2.returnCurrentInstance().methodCallWithThisAsParameter();
	}
}
