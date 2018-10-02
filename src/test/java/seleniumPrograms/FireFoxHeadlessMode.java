package seleniumPrograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class FireFoxHeadlessMode extends TestBase {

	@Test
	public void openFirefoxInHeadlessMode() {
		FirefoxBinary binary = new FirefoxBinary();
		binary.addCommandLineOptions("--headless");

		FirefoxOptions options = new FirefoxOptions();
		options.setBinary(binary);

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\deepa\\Downloads\\Drivers\\FireFoxDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(options);

		driver.get(
				"http://learn-automation.com/launch-microsoft-edge-browser-using-selenium-webdriver");
		System.out.println("Title of the page-->" + driver.getTitle());
		driver.quit();
	}

	@Test
	public void launchEdgeBrowser() {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\deepa\\Downloads\\Drivers\\EdgeDriver\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get(
				"http://learn-automation.com/launch-microsoft-edge-browser-using-selenium-webdriver");
		System.out.println("Title of the page-->" + driver.getTitle());
		driver.quit();
	}
}
