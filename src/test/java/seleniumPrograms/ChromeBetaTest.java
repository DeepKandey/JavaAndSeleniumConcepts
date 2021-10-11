package seleniumPrograms;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ChromeBetaTest {

  WebDriver driver;

  @Test
  public void handlingWindowSwitchInChrome() {
    // 92 version
    //    System.setProperty(
    //        "webdriver.chrome.driver",
    //        "C:\\Users\\deepa\\Downloads\\chromedriver_win32\\chromedriver.exe");

    // 91 version
    System.setProperty(
        "webdriver.chrome.driver", "C:\\Users\\deepa\\Downloads\\BrowserDrivers\\chromedriver.exe");

    ChromeOptions options = new ChromeOptions();
    options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe"); // Chrome beta
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.get("https://www.cacert.org/");
    ((JavascriptExecutor) driver).executeScript("window.open('https://usefulangle.com','_blank')");
    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
  }
}
