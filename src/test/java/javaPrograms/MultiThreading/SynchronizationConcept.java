/**
 * @author Deepak Rai
 */
package javaPrograms.MultiThreading;

class Counter {
	int count;

	synchronized void increment() {
		count++;
	}
}

public class SynchronizationConcept {

	/**
	 * {@summary 2 threads created which calls increment() method 100 times each. So
	 * the method increment() is made synchronized so that when one thread is
	 * incrementing the value of variable count, another thread should interfere. In
	 * this way, we will get correct value of count when both thread finished
	 * running. Else, both thread will be accessing the method same time and
	 * multiple times they will be incrementing count variable at same time, in this
	 * way we will get wrong value of count once the loop is done in both the
	 * threads.}
	 * 
	 * @param
	 * @return
	 * @author deepak rai
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		Counter objCounter = new Counter();

		// First thread
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					objCounter.increment();
				}
			}
		});

		// Second thread
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					objCounter.increment();
				}
			}
		});

		thread1.start();
		thread1.join();

		thread2.start();
		thread2.join();

		System.out.println(objCounter.count);

	}
}