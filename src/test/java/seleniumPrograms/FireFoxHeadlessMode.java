package seleniumPrograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class FireFoxHeadlessMode extends TestBase {

	@Test
	public void openBrowserInHeadlessMode() {
		FirefoxBinary binary = new FirefoxBinary();
		binary.addCommandLineOptions("--headless");

		FirefoxOptions options = new FirefoxOptions();
		options.setBinary(binary);

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\deepa\\Downloads\\Drivers\\FireFoxDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(options);
		driver.get(
				"https://confengine.com/selenium-conf-2018/proposal/6220/appium-in-an-enterprise-banking-organisation");
		System.out.println("Title of the page-->" + driver.getTitle());
		driver.quit();
	}
}
