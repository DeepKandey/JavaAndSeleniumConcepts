package javaPrograms.PracticePrograms;

import org.testng.TestNG;
import seleniumPrograms.MyFluentWait;

public class RunnerClassForJarFile {

  static TestNG testNG;

  public static void main(String[] args) {

    testNG = new TestNG();
    testNG.setTestClasses(new Class[] {MyFluentWait.class});
    testNG.run();
  } // End of method main()
} // End of class RunnerClassForJarFile
