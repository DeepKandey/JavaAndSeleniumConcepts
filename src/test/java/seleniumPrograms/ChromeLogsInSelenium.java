package seleniumPrograms;

import com.qa.constants.CommonConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Class to generate Chromium logs while Selenium API interacts with the browser
public class ChromeLogsInSelenium {

  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", CommonConstants.DRIVERPATH_CHROME);

    System.setProperty(
        "webdriver.chrome.logfile", "./src/test/resources/BrowserLogs/Chromelogs.txt");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().fullscreen();

    driver.get("https://www.google.com/");
    WebElement googleSearchTxt = driver.findElement(By.name("q"));
    googleSearchTxt.sendKeys("Hello World");
    googleSearchTxt.sendKeys(Keys.ARROW_DOWN);
    googleSearchTxt.sendKeys(Keys.ENTER);
    driver.quit();
  }
}
