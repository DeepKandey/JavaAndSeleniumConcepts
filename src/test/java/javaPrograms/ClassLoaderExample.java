/**
 * 
 */
package javaPrograms;

import java.io.File;
import java.net.URL;

/**
 * @author Deepak Rai
 *
 */
public class ClassLoaderExample {

	/**
	 * {@summary }
	 * 
	 * @param
	 * @return
	 * @author deepak
	 */
	public static void main(String[] args) {

		ClassLoaderExample cleObj = new ClassLoaderExample();
		// get Absolute File Path
		System.out.println(cleObj.getFileFroResources("Credentials/GMAILcredential.json").getAbsolutePath());
		System.out.println(cleObj.getFileFroResources("Images/TitleError.PNG"));

		// Using new line
		System.out.println(cleObj.getFileFroResources("Credentials/GMAILcredential.json") + "\n"
				+ cleObj.getFileFroResources("Images/TitleError.PNG"));
	}

	private File getFileFroResources(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		URL resource = classLoader.getResource(fileName);
		if (resource == null) {
			throw new IllegalArgumentException("file is not found");
		} else {
			return new File(resource.getFile());
		}
	}

}