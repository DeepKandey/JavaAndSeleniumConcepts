package javaPrograms.ReflectionAPI;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodLevelFunctions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Complete Class Name -->"+ MethodLevelFunctions.class);
		System.out.println("Simple Class Name -->"+ MethodLevelFunctions.class.getSimpleName());
		
		Method[] methodList= MethodLevelFunctions.class.getDeclaredMethods();
		for(Method method:methodList) {
			System.out.println("Name of the method -->" + method.getName());
			System.out.println("Return type of the method -->" + method.getReturnType());
			int modifier=method.getModifiers();
			System.out.println("Modifier used for the method -->" + Modifier.toString(modifier));
		}
	}
}
