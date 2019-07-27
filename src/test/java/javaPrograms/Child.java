package javaPrograms;

public class Child extends Parent {

	int a = 100;

	public void m1() {
		System.out.println("Child");
	}

	public static void main(String[] args) {
		Child obj= new Child();
		
		Parent pObj= obj;
		System.out.println(((Child)pObj).a);
		System.out.println(pObj.a);
		pObj.m1();
	}
}
