/**
 * @author Deepak Rai
 */
package javaPrograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

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

		Process process = Runtime.getRuntime().exec("cmd /c netstat -ano | findstr :4444");

		BufferedReader lineReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		List<String> list= lineReader.lines().map(str-> str.substring(str.indexOf("LISTENING")+ ("LISTENING").length()).trim()).distinct().collect(Collectors.toList());
		
	    lineReader.lines().map(str-> str.substring(str.indexOf("LISTENING"))).forEach(System.out::println);;
		
	    System.out.println(list.get(0));
	
		
//		if(!list.isEmpty()) {
//			Process process1 = Runtime.getRuntime().exec("cmd /c taskkill /pid "+ list.get(0) + " /f");
//			BufferedReader lineReader1 = new BufferedReader(new InputStreamReader(process1.getInputStream()));
//			lineReader1.lines().forEach(System.out::println);
//
//		}


	}
}