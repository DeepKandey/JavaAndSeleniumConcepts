package seleniumPrograms;

import java.util.Date;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class GetJSErrorsConcept extends TestBase {
	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		LoggingPreferences logPreferences = new LoggingPreferences();
		logPreferences.enable(LogType.BROWSER, Level.ALL);

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, logPreferences);

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\deepa\\Downloads\\Browser Drivers\\Chrome Drivers\\chromedriver.exe");
		driver = new ChromeDriver(chromeOptions);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	public void extractJSLogs() {
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry logEntry : logEntries) {
			System.out.println(
					new Date(logEntry.getTimestamp()) + " " + logEntry.getLevel() + " " + logEntry.getMessage());
		}
	}

	@Test(invocationCount=2)
	public void testMethod() {
		driver.get("https://www.makemytrip.com/");
		extractJSLogs();
	}
}