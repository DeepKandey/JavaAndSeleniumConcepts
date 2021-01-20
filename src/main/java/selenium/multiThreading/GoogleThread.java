/** @author Deepak Rai */
package selenium.multiThreading;

/** @author Deepak Rai */
public class GoogleThread extends Thread {

  GooglePageActions obj;

  public GoogleThread(String threadName, String browserName) {
    super(threadName);
    obj = new GooglePageActions(browserName);
  }

  public void run() {

    System.out.println("Thread started " + Thread.currentThread().getName());
    try {
      obj.navigateGoogle();
      Thread.sleep(5000);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      obj.tearDown();
    }
    System.out.println("Thread ended " + Thread.currentThread().getName());
  }
}
