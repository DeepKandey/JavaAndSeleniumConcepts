package javaPrograms.ReflectionAPI;

import java.lang.reflect.InvocationTargetException;

public class Demo {

	public static <T> T getInstance(Class<T> TPage) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		return TPage.getDeclaredConstructor().newInstance();
	}

	public static void main(String[] args) throws ClassNotFoundException {
		String className = Class.forName("javaPrograms.ReflectionAPI.Test").getCanonicalName();
		System.out.println(className);
	}
}