package seleniumPrograms;

import com.qa.constants.CommonConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelBrowserHandlingUsingTestNG {

  WebDriver driver;

  @BeforeMethod
  @Parameters("browser")
  public void setUp(String browserName) {

    if (browserName.equalsIgnoreCase("chrome")) {

      System.setProperty("webdriver.chrome.driver", CommonConstants.DRIVERPATH_CHROME);
      driver = new ChromeDriver();
      System.out.println("Launching " + browserName + " browser");
      driver.manage().window().maximize();

    } else if (browserName.equalsIgnoreCase("firefox")) {

      System.setProperty("webdriver.gecko.driver", CommonConstants.DRIVERPATH_FIREFOX);
      driver = new FirefoxDriver();
      System.out.println("Launching " + browserName + " browser");

    } else if (browserName.equalsIgnoreCase("Edge")) {

      System.setProperty("webdriver.edge.driver", CommonConstants.DRIVERPATH_EDGE);
      driver = new EdgeDriver();
      System.out.println("Launching " + browserName + " browser");
    }
  }

  @Test
  public void openAndCloseBrowser() {
    driver.get("https://www.youtube.com/watch?v=K8j4yC98EtA");
    System.out.println("Test Case Exceuted. Navigated to " + driver.getTitle());
  }

  @AfterMethod
  @Parameters("browser")
  public void end(String browserName) {
    System.out.println("Closing " + browserName + " browser");
    driver.quit();
  }
} // End of class ParallelBrowserHandlingUsingTesttNG
