package com.qa.base;

import com.qa.constants.CommonConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

    protected static WebDriver driver = null;
    protected static WebDriverWait wait;

    public static void initialization(BrowserNames browserName) {

        if (driver == null) {
            if (browserName == BrowserNames.CHROME) {
                System.setProperty("webdriver.chrome.silentOutput", "true"); // To suppress browser logs
                driver = new ChromeDriver();

            } else if (browserName == BrowserNames.FF) {
                System.setProperty(
                        FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null"); // To suppress FF logs on
                driver = new FirefoxDriver();

            } else if (browserName == BrowserNames.EDGE) {
                driver = new EdgeDriver();

            } else if (browserName == BrowserNames.IE) {
                WebDriverManager.iedriver().setup();

                InternetExplorerOptions options = new InternetExplorerOptions();
                options.setCapability(
                        InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                options.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
                options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
                driver = new InternetExplorerDriver(options);

            } else System.out.println("Print provide valid browser names");
        }

        if (driver != null) {

            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, 20);
            System.out.println("Launching " + browserName + " browser");
        }
    } // End of method initialization()

    public static void closeDriver() {

        if (driver != null) {
            System.out.println("Driver quit");
            driver.quit();
        }
    } // End of method close()
} // End of class TestBase
