package javaPrograms.ThreadLocal;

public class TestThreadLocal {

	public static void main(String[] args) {
		ThreadLocalDemo demo = new ThreadLocalDemo(); // Initialize ThreadLocalDemo class
		Thread thread1 = new Thread(demo, "Thread-1"); // Create instances of Thread passing ThreadlocalDemo objects
		Thread thread2 = new Thread(demo, "Thread-2");

		// Initiate threads
		thread1.start();
		thread2.start();
	}
}