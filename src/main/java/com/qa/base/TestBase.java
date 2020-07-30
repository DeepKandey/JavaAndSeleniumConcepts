package com.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	protected static WebDriver driver = null;
	protected static WebDriverWait wait;

	public static void initialization(BrowserNames browserName) {
		if (driver == null) {
			if (browserName == BrowserNames.CHROME) {
				System.setProperty("webdriver.chrome.driver",
						"C:/Users/deepa/Downloads/Browser Drivers/Chrome Drivers/chromedriver.exe");
				System.setProperty("webdriver.chrome.silentOutput", "true"); // To suppress the Chrome logs
				driver = new ChromeDriver();

			} else if (browserName == BrowserNames.FF) {
				System.setProperty("webdriver.gecko.driver",
						"C:/Users/deepa/Downloads/Browser Drivers/FireFoxDrivers/geckodriver.exe");

				System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null"); // To suppress FF logs on
				driver = new FirefoxDriver();

			} else if (browserName == BrowserNames.EDGE) {
				System.setProperty("webdriver.edge.driver",
						"C:/Users/deepa/Downloads/Browser Drivers/EdgeDriver/msedgedriver.exe");
				driver = new EdgeDriver();

			} else if (browserName == BrowserNames.IE) {
				WebDriverManager.iedriver().setup();

				InternetExplorerOptions options = new InternetExplorerOptions();
				options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				options.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
				options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);

				driver = new InternetExplorerDriver(options);
			} else 
				System.out.println("Print provide valid browser names");
		}

		if (driver != null) {
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, 20);
			System.out.println("Launching " + browserName + " browser");
		}
	} // End of method initialization()

	public static void closeDriver() {

		if (driver != null) {
			System.out.println("Quitting the driver");
			driver.quit();

		}
	} // End of method close()
} // End of class TestBase