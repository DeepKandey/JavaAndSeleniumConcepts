/**
 * @author Deepak Rai
 */
package javaPrograms;

import java.io.File;
import java.io.IOException;

public class JavaPractice {

	/**
	 * {@summary }
	 * 
	 * @param
	 * @return
	 * @author deepak rai
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
//
//		Runtime.getRuntime().exec("cmd /c start cmd.exe /K" + "cd /Users/deepa/Downloads/BrowserDrivers" + "java -jar "
//				+ CommonConstants.GRID_SERVER_PATH + " standalone");
//
//		String[] amdarray = new String[] { "cmd /c start cmd.exe /K","cd /Users/deepa/Downloads/BrowserDrivers",
//				"java -jar selenium-server-4.0.0-alpha-6.jar standalone" };
//		Runtime.getRuntime().exec(  amdarray);
		
		String path = "/Users/deepa/Downloads/BrowserDrivers";   
		ProcessBuilder b = new ProcessBuilder();
		b.directory(new File(path));
		b.command("cmd", "/k", "start" + " java -jar selenium-server-4.0.0-alpha-6.jar standalone").start(); 
	}
}