package seleniumPrograms;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.Test;

public class AutoIT {

  private WebDriver driver;

  @Test(enabled = false)
  public void fluentWaitCheckWithInternetExplorerAndEdge() throws IOException {
    WebDriverManager.iedriver().setup();
    InternetExplorerOptions options = new InternetExplorerOptions();
    options.setCapability(
        InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
    options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);

    driver = new InternetExplorerDriver(options);
    driver.manage().window().maximize();
    Runtime.getRuntime()
        .exec(
            System.getProperty("user.dir")
                + "\\src\\test\\resources\\AutoITScripts\\HandleWindow_IE.exe");
    driver.get("https://www.engprod-charter.net");
  }

  @Test
  public void fluentWaitCheckWithChrome() throws IOException {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();

    Runtime.getRuntime()
        .exec(
            System.getProperty("user.dir")
                + "\\src\\test\\resources\\AutoITScripts\\HandleWindow_Chrome.exe");
    driver.get("https://www.engprod-charter.net");
  }

  @Test(enabled = false)
  public void fluentWaitCheckWithFF() throws IOException {
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
    driver.manage().window().maximize();

    Runtime.getRuntime()
        .exec(
            System.getProperty("user.dir")
                + "\\src\\test\\resources\\AutoITScripts\\HandleWindow_FF.exe");
    driver.get("https://www.engprod-charter.net");
  }
}
