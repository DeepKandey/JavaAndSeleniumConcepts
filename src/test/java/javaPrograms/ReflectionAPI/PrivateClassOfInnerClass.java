/** @author Deepak Rai */
package javaPrograms.ReflectionAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.Permission;

/** @author Deepak Rai */
public class PrivateClassOfInnerClass {

  /**
   * {@summary access private method of private class of Inner class}
   *
   * @param
   * @return
   * @author deepak rai
   */
  public static void main(String[] args) throws Exception {

    DoNotTerminate.forbidExit();

    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int num = Integer.parseInt(br.readLine().trim());

      Object o; // Must be used to hold the reference of the instance of the class
      // Solution.Inner.Private

      // Inner Class
      Class<?> innerClass = PrivateClassOfInnerClass.class.getDeclaredClasses()[0];
      Constructor<?> innerClassConstructor = innerClass.getDeclaredConstructors()[0];
      Object innerClassObject = innerClassConstructor.newInstance();

      // Private class of Inner class
      Class<?> privateClassOfInnerClass = innerClass.getDeclaredClasses()[0];
      Constructor<?> constructorOfprivateClassOfInnerClass =
          privateClassOfInnerClass.getDeclaredConstructors()[0];
      constructorOfprivateClassOfInnerClass.setAccessible(true);
      o = constructorOfprivateClassOfInnerClass.newInstance(innerClassObject);

      // Private method access of Private class of Inner class
      Method method =
          privateClassOfInnerClass.getDeclaredMethod("powerof2", new Class[] {int.class});
      method.setAccessible(true);

      System.out.println(num + " is " + method.invoke(o, num));
      System.out.println(
          "An instance of class: " + o.getClass().getCanonicalName() + " has been created");

    } // end of try
    catch (DoNotTerminate.ExitTrappedException e) {
      System.out.println("Unsuccessful Termination!!");
    }
  } // end of main

  static class Inner {
    private class Private {
      private String powerof2(int num) {
        return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
      }
    }
  } // end of Inner
}

class DoNotTerminate { // This class prevents exit(0)

  public static class ExitTrappedException extends SecurityException {

    private static final long serialVersionUID = 1L;
  }

  public static void forbidExit() {
    final SecurityManager securityManager =
        new SecurityManager() {
          @Override
          public void checkPermission(Permission permission) {
            if (permission.getName().contains("exitVM")) {
              throw new ExitTrappedException();
            }
          }
        };
    System.setSecurityManager(securityManager);
  }
}
