package com.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	protected static WebDriver driver = null;
	protected static WebDriverWait wait;

	// Initializing browser
	public static void initialization(String browserName) {
		if (driver == null) {

			if (browserName.equalsIgnoreCase("chrome")) {
				// WebDriverManager.chromedriver().setup();
				System.setProperty("webdriver.chrome.driver",
						"C:/Users/deepa/Downloads/Browser Drivers/Chrome Drivers/chromedriver.exe");
				System.setProperty("webdriver.chrome.silentOutput", "true"); // To suppress the Chrome logs on console
																				// before launch

				driver = new ChromeDriver();
				driver.manage().window().fullscreen();
				wait = new WebDriverWait(driver, 20);
			} else if (browserName.equalsIgnoreCase("FF")) {
				// WebDriverManager.firefoxdriver().setup();
				System.setProperty("webdriver.gecko.driver",
						"C:/Users/deepa/Downloads/Browser Drivers/FireFoxDrivers/geckodriver.exe");
				System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null"); // To suppress FF logs on
																							// console
				driver = new FirefoxDriver();
				wait = new WebDriverWait(driver, 20);
			} else if (browserName.equalsIgnoreCase("Edge")) {
				EdgeDriverService service = EdgeDriverService.createDefaultService();

				driver = new EdgeDriver(service);
				wait = new WebDriverWait(driver, 20);
			} else if (browserName.equalsIgnoreCase("IE")) {
				WebDriverManager.iedriver().setup();

				InternetExplorerOptions options = new InternetExplorerOptions();
				options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				options.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
				options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);

				// options.merge(caps);
				driver = new InternetExplorerDriver(options);
				driver.manage().window().maximize();
				wait = new WebDriverWait(driver, 20);
			}
		}
		
		driver.manage().window().maximize();
		System.out.println("Initialising " + browserName + " browser");
		
	} // End of method initialization()

	// Closing browser
	public static void close() {
		if (driver != null) {
			System.out.println("Quitting the driver");
			driver.quit();
		}
	} // End of method close()
} // End of class TestBase