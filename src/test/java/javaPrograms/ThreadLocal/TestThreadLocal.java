package javaPrograms.ThreadLocal;

public class TestThreadLocal {

	public static void main(String[] args) {
		ThreadLocalDemo1 demo = new ThreadLocalDemo1();
		Thread thread1 = new Thread(demo, "Thread-1");
		Thread thread2 = new Thread(demo, "Thread-2");

		thread1.start();
		thread2.start();
	}
}