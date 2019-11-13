package javaPrograms.Collections;

import java.util.ArrayList;

// T is of any type extending Number class
class Container<T extends Number> {
	T value;

	// To print class type of object
	public void show() {
		System.out.println(value.getClass().getName());
	}

	// ? can be of any type that extends T which internally extends Number
	public void demo(ArrayList<? extends T> obj) {

	}

	// ? can be of any type that is super class of T which internally extends Number
	public void demo1(ArrayList<? super T> obj) {

	}
}

public class GenericsDemo {

	public static void main(String[] args) {
		Container<Number> obj = new Container<>();
		obj.value = 9;
		obj.show();
		obj.demo(new ArrayList<Double>()); // Double extends Number
		obj.demo1(new ArrayList<Object>()); // Object is super class of Number

	}
}
