/**
 * @author Deepak Rai
 */
package javaPrograms.MultiThreading;

import java.time.DayOfWeek;
import java.time.LocalDate;

class A {
	int num;
	boolean valueSet = false;

	protected synchronized void put(int num) {
		while (valueSet) {
			try {
				wait();
			} catch (Exception e) {
			}
		}

		System.out.println("Put: " + num);
		this.num = num;
		valueSet = true;
		notify();
	}

	protected synchronized void get() {
		while (!valueSet) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		System.out.println("Get: " + num);
		valueSet = false;
		notify();
	}
}

class Producer implements Runnable {

	A a;

	public Producer(A a) {
		this.a = a;
		Thread t = new Thread(this, "Producer");
		t.start();
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			a.put(i++);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}
}

class Consumer implements Runnable {

	A a;

	public Consumer(A a) {
		this.a = a;
		Thread t = new Thread(this, "Consumer");
		t.start();
	}

	@Override
	public void run() {

		while (true) {
			a.get();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}
}

/**
 * @author Deepak Rai
 *
 */
public class InterThreadCommunication {

	/**
	 * {@summary One class A for putting and getting of the variable. 2 classes
	 * Producer and Consumer implementing Runnable interface. Both classes acts as 2
	 * threads and call methods put() and get() respectively. In both synchronized
	 * methods, wait() and notify() methods are called so that when one
	 * thread(Producer) is accessing put() method other thread(Consumer) should wait
	 * to get notified that value is set and it can call get() method to fetch the
	 * value. It happens vice versa for put() and get() method call
	 * 
	 * }
	 * 
	 * @param
	 * @return
	 * @author deepak rai
	 */
	public static void main(String[] args) {

		// Prints day of the week. LocalDate in Java8
		LocalDate localDate = LocalDate.of(2015, 8, 01);
		DayOfWeek dayOfWeek = localDate.getDayOfWeek();
		System.out.println(dayOfWeek);

		A objA = new A();
		new Producer(objA);
		new Consumer(objA);

	}
}