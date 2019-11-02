package javaPrograms.ReflectionAPI;

import java.lang.reflect.Method;

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

		// Using Reflection API , instantiating Class and calling private method
		Class<?> classObj = Class.forName("javaPrograms.ReflectionAPI.Test");
		Test test = (Test) classObj.getDeclaredConstructor().newInstance();

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
}
