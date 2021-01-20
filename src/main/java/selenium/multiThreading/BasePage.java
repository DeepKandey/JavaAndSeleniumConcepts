/** @author Deepak Rai */
package selenium.multiThreading;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {

  protected WebDriver driver;

  protected WebDriver setUp(String browserName) {
    if (driver == null) {
      if (browserName == "chrome") {
        System.setProperty(
            "webdriver.chrome.driver",
            "C:/Users/deepa/Downloads/Browser Drivers/Chrome Drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true"); // To suppress the Chrome logs
        driver = new ChromeDriver();

      } else if (browserName == "FF") {
        System.setProperty(
            "webdriver.gecko.driver",
            "C:/Users/deepa/Downloads/Browser Drivers/FireFoxDrivers/geckodriver.exe");

        System.setProperty(
            FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null"); // To suppress FF logs on
        driver = new FirefoxDriver();
      }
    }
    return driver;
  }
}
