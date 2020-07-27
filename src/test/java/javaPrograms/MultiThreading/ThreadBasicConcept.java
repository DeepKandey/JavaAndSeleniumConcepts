/**
 * @author Deepak Rai
 */
package javaPrograms.MultiThreading;

class Hi extends Thread {

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Hi");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}
}

class Hello extends Thread {

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Hello");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}
}

public class ThreadBasicConcept {

	/**
	 * {@summary Two threads are started by creating instances of Class 'Hi' and
	 * Class 'Hello' and both extend Thread Class. Thread class implements Runnable
	 * interface which has abstract method run(). These two classes define run()
	 * method by which thread understands what it as do upon calling method start()}
	 * 
	 * @param
	 * @return
	 * @author deepak rai
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		// thread instances
		Thread objHi = new Hi();
		Thread objHello = new Hello();

		// threads started
		objHi.start();
		Thread.sleep(10);
		objHello.start();

	}
}