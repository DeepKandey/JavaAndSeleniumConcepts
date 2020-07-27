/**
 * @author Deepak Rai
 */
package javaPrograms.MultiThreading;

public class RunnableConcept {

	/**
	 * {@summary Runnable is a functional interface which Thread class implements.
	 * To create instances of Thread, we have used its overloaded constructor where
	 * it accepts Runnable interface reference. There we have passed 'run' abstract
	 * method implementation using lambda expression.}
	 * 
	 * @param args array
	 * @return
	 * @author deepak rai
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		// First thread
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Hi, Thread Priority: " + Thread.currentThread().getPriority() + " Thread Name: "
						+ Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
			}
		});

		// Second thread
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Hello, Thread Priority: " + Thread.currentThread().getPriority() + " Thread Name: "
						+ Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
			}
		});

		// get and set ThreadName
//		t1.setName("Hi Thread");
//		t2.setName("Hello Thread");
//		System.out.println(t1.getName());
//		System.out.println(t2.getName());

		t1.setPriority(Thread.MIN_PRIORITY);
		t1.setPriority(Thread.MAX_PRIORITY);

		// Start 1st thread
		t1.start();
		Thread.sleep(10);
		// Start 2nd thread
		t2.start();

		// Waits for this thread to die.
		t1.join();
		t2.join();

		System.out.println("Is first thread t1 alive?: " + t1.isAlive());
		System.out.println("Bye");
	}
}