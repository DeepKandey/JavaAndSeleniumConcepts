package seleniumPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxLogsInSelenium {

  public static void main(String[] args) {
    System.setProperty(
        "webdriver.gecko.driver",
        "C:/Users/deepa/Downloads/Browser Drivers/FireFoxDrivers/geckodriver.exe");

    System.setProperty(
        FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
        "./src/test/resources/BrowserLogs/FireFoxlogs.txt");
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().maximize();

    driver.get("https://www.google.com/");
    WebElement googleSearchTxt = driver.findElement(By.name("q"));
    googleSearchTxt.sendKeys("Hello World");
    googleSearchTxt.sendKeys(Keys.ARROW_DOWN);
    googleSearchTxt.sendKeys(Keys.ENTER);
    driver.quit();
  }
}
