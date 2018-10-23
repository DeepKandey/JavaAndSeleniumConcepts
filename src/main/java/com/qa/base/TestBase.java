package com.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

	protected static WebDriver driver = null;
	protected static WebDriverWait wait;

	public static void initialization(String browswerName) {
		if (driver == null) {
			if (browswerName == "chrome") {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\deepa\\Downloads\\Drivers\\Chrome Drivers\\chromedriver_win.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				wait = new WebDriverWait(driver, 20);
			} else if (browswerName == "FF") {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\deepa\\Downloads\\Drivers\\FireFoxDrivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				wait = new WebDriverWait(driver, 20);
			} else if (browswerName == "Edge") {
				System.setProperty("webdriver.edge.driver",
						"C:\\Users\\deepa\\Downloads\\Drivers\\EdgeDriver\\MicrosoftWebDriver.exe");
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				wait = new WebDriverWait(driver, 20);
			}
		}
	}

	public static void close() {
		if (driver != null) {
			System.out.println("Quitting the driver");
			driver.quit();
		}
	}
}
