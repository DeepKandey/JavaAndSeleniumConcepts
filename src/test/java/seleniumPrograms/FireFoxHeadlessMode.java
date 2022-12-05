package seleniumPrograms;

import com.qa.base.TestBase;
import com.qa.constants.CommonConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class FireFoxHeadlessMode extends TestBase {

  @Test
  public void openFirefoxInHeadlessMode() {
    FirefoxBinary binary = new FirefoxBinary();
    binary.addCommandLineOptions("--headless");

    FirefoxOptions options = new FirefoxOptions();
    options.setBinary(binary);

    WebDriver driver = new FirefoxDriver(options);

    driver.get(
        "http://learn-automation.com/launch-microsoft-edge-browser-using-selenium-webdriver");
    System.out.println("Title of the page-->" + driver.getTitle());
    driver.quit();
  }

  @Test
  public void launchEdgeBrowser() {
    WebDriver driver = new EdgeDriver();
    driver.get(
        "http://learn-automation.com/launch-microsoft-edge-browser-using-selenium-webdriver");
    System.out.println("Title of the page-->" + driver.getTitle());
    driver.quit();
  }
}
