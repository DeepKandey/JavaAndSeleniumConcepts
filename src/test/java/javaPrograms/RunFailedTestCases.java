package javaPrograms;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.Test;

public class RunFailedTestCases {

	@Test
	public void testNGRunnerForFailedTests() {
		TestNG testNGRunner = new TestNG();
		List<String> arrayList = new ArrayList<String>();
		arrayList.add("C:\\Users\\deepa\\workspace\\JavaAndSeleniumConcepts\\test-output\\testng-failed.xml");
		testNGRunner.setTestSuites(arrayList);
		testNGRunner.run();
	}
}