package javaPrograms;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class SingletonClass {

	private static SingletonClass signleton_instance = null;
	public String str;

	private SingletonClass() {
		str = "Hey I am using Singleton class pattern";
	}

	public static SingletonClass getInstance() {
		if (signleton_instance == null) {
			signleton_instance = new SingletonClass();
		}
		return signleton_instance;
	}

	public static void main(String[] args) throws FileNotFoundException {
		SingletonClass x = SingletonClass.getInstance();
		SingletonClass y = SingletonClass.getInstance();
		SingletonClass z = SingletonClass.getInstance();

		System.out.println(
				"Checking string for all the instance of Singleton class after changing string to upper for one instance:--> ");
		x.str = (x.str).toUpperCase();

		System.out.println("Hashcode for X: " + x.hashCode() + " " + x.str);
		System.out.println("Hashcode for Y: " + y.hashCode() + " " + y.str);
		System.out.println("Hashcode for Z: " + z.hashCode() + " " + z.str);

		System.out.println(
				"\nChecking string for all the instance of Singleton class after changing string to lower for one instance:--> ");
		z.str = (z.str).toLowerCase();

		System.out.println("Hashcode for X: " + x.hashCode() + " " + x.str);
		System.out.println("Hashcode for Y: " + y.hashCode() + " " + y.str);
		System.out.println("Hashcode for Z: " + z.hashCode() + " " + z.str);
		
		PrintStream out = new PrintStream(new FileOutputStream("C:/Users/deepa/Desktop/s.txt"));
		System.setOut(out);
		System.out.println("Hashcode for Z: " + z.hashCode() + " " + z.str);
	}
} // End of class Singleton