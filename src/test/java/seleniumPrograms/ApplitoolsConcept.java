package seleniumPrograms;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.applitools.eyes.selenium.Eyes;
import com.qa.base.TestBase;

public class ApplitoolsConcept extends TestBase {

	@BeforeMethod
	public void setUp() {
		initialization("chrome");
	}

	@AfterMethod
	public void tearDown() {
		close();
	}

	@Test
	public void visualTesting() {
		Eyes eyes = new Eyes();
		eyes.setApiKey("lyV1luwQQdZpjJ5AxPpl4p59YFWyuGHLtfNqXFAAGOM110");
		eyes.open(driver, "Applitools", "Hello World");

		driver.get("https://applitools.com/helloworld?diff2");
		eyes.checkWindow("Home Page"); // checkpoint
		
		eyes.close();
	}
}
