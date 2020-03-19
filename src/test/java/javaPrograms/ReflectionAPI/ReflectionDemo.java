package javaPrograms.ReflectionAPI;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

class ABC {

}

public class ReflectionDemo {

	public static void main(String[] args) throws Exception {

		// Instantiating any class(Creating Object) using 'Class'class and calling
		// method
		/*
		 * Class<? extends Object> c = Class.forName("javaPrograms.ReflectionAPI.Test");
		 * Test test = (Test) c.getDeclaredConstructor().newInstance(); test.show();
		 */

		// Using Reflection API, print Constructors
		Class<?> classObj = Class.forName("javaPrograms.ReflectionAPI.Test");
		System.out.println("Private Parameterized Constructor: " + classObj.getDeclaredConstructor(String.class).toString());
		System.out.println("Public Constructor: " + classObj.getConstructor().toString());
		System.out.println("All Constructors(Pubic,Private,Default,protected): " + Arrays.toString(classObj.getDeclaredConstructors()));

		// Get private constructor using getDeclaredConstructor. set it accessible and
		// then create the instance.
		Constructor<?> constructor = classObj.getDeclaredConstructor(String.class);
		constructor.setAccessible(true);
		Test test = (Test) constructor.newInstance(new String());

		// Calling private non-parameterized method
		Method method = classObj.getDeclaredMethod("show", null);
		method.setAccessible(true);
		method.invoke(test, null);

		// Calling parameterized private method
		Method methodObj = classObj.getDeclaredMethod("cube", new Class[] { int.class });
		methodObj.setAccessible(true);
		methodObj.invoke(test, 4);

		// To determine whether given class is a class or interface
		Class<?> classObj2 = Class.forName("javaPrograms.ReflectionAPI.ABC");
		System.out.println(classObj2.isInterface());

		// To determine the super class of the given class
		System.out.println(classObj2.getSuperclass());
	}
} // End of class ReflectionDemo