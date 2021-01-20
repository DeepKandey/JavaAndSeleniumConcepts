/** */
package javaPrograms.PracticePrograms;

import java.io.File;
import java.net.URL;

/** @author Deepak Rai */
public class ClassLoaderExample {

  /**
   * {@summary method to fetch file path using ClassLoader class}
   *
   * @param
   * @return
   * @author deepak
   */
  public static void main(String[] args) {

    ClassLoaderExample cleObj = new ClassLoaderExample();
    // get Absolute File Path
    System.out.println(
        cleObj.getFileFromResources("Credentials/GMAILCredential.json").getAbsolutePath());
    System.out.println(cleObj.getFileFromResources("Images/TitleError.PNG"));

    // Using new line
    System.out.println(
        cleObj.getFileFromResources("Credentials/GMAILCredential.json")
            + "\n"
            + cleObj.getFileFromResources("Images/TitleError.PNG"));
  }

  private File getFileFromResources(String fileName) {
    ClassLoader classLoader = getClass().getClassLoader();
    URL resource = classLoader.getResource(fileName);
    if (resource == null) {
      throw new IllegalArgumentException("file is not found");
    } else {
      return new File(resource.getFile());
    }
  }
}
