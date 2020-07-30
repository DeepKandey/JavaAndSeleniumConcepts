/**
 * @author Deepak Rai
 */
package selenium.multiThreading;

public class ThreadRunner {

	/**
	 * {@summary }
	 * 
	 * @param
	 * @return
	 * @author deepak rai
	 */
	public static void main(String[] args) {

		int chromeCount = Integer.parseInt(System.getProperty("chrome"));
		int fireFoxCount = Integer.parseInt(System.getProperty("FF"));

		for (int i = 0, j = 0; i < chromeCount || j < fireFoxCount; i++, j++) {
			new GoogleThread("Chrome Thread", "chrome").start();
			;
			new GoogleThread("FireFox Thread", "FF").start();
			;
		}
	}

	// maven command
	// mvn compile exec:java
	// -Dexec.mainClass="seleniumPrograms.MultiThreading.ThreadRunner"
	// -Dexec.cleanupDaemonThreads=false -Dchrome=2 -DFF=2
}