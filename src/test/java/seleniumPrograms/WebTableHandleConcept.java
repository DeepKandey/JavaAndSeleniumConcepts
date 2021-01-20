package seleniumPrograms;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTableHandleConcept {
  WebDriver driver;
  EventFiringWebDriver eventDriver;
  EventHandler eventHandler;

  @BeforeMethod
  public void setUp() {
    System.setProperty(
        "webdriver.chrome.driver",
        "C:/Users/deepa/Downloads/Browser Drivers/Chrome Drivers/chromedriver.exe");
    driver = new ChromeDriver();
    eventDriver = new EventFiringWebDriver(driver);
    eventHandler = new EventHandler();
    eventDriver.register(eventHandler);
    driver = eventDriver;
    driver.manage().window().maximize();
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
    eventDriver.unregister(eventHandler);
  }

  @Test
  public void webTableHandle() {
    driver.get("https://www.w3schools.com/html/html_tables.asp");

    List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));

    // Dynamic Web table handle
    String beforeXpath = "//table[@id='customers']/tbody/tr[";
    String afterXpath = "]/td[1]";

    for (int i = 2; i <= rows.size(); i++) {
      String actualXpath = beforeXpath + i + afterXpath;
      WebElement element = driver.findElement(By.xpath(actualXpath));
      System.out.println(element.getText());

      if (element.getText().equals("Ernst Handel")) {
        String siblingXpath = actualXpath + "/following-sibling::td"; // Sibling Concept used
        WebElement siblingElement = driver.findElement(By.xpath(siblingXpath));
        System.out.println("**********************");
        System.out.println("Sibling Element: " + siblingElement.getText());
        System.out.println("**********************");
      }
    }
  }
}
