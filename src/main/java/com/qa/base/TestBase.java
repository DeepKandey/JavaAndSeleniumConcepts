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

	public static void initialization(String browswerName) {
		if (driver == null) {
			if (browswerName == "chrome") {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().fullscreen();
				wait = new WebDriverWait(driver, 20);
			} else if (browswerName == "FF") {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				wait = new WebDriverWait(driver, 20);
			} else if (browswerName == "Edge") {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				wait = new WebDriverWait(driver, 20);
			} else if (browswerName == "IE") {
				WebDriverManager.iedriver().setup();

				/*
				 * DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
				 * caps.setCapability(InternetExplorerDriver.
				 * INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				 * caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				 */
				InternetExplorerOptions options = new InternetExplorerOptions();
				// options.introduceFlakinessByIgnoringSecurityDomains();
				// options.ignoreZoomSettings();
				options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);

				// options.merge(caps);
				driver = new InternetExplorerDriver(options);
				driver.manage().window().maximize();
				wait = new WebDriverWait(driver, 20);
			}
		}
		driver.manage().window().maximize();
		System.out.println("Initialising browser");
	}

	public static void close() {
		if (driver != null) {
			System.out.println("Quitting the driver");
			driver.quit();
		}
	}
}
