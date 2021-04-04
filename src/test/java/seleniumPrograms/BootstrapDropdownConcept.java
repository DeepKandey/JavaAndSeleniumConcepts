package seleniumPrograms;

import com.qa.base.BrowserNames;
import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BootstrapDropdownConcept extends TestBase {

  @BeforeMethod
  public void setup() {
    initialization(BrowserNames.CHROME);
  }

  // Clicking on web element from bootstrap drop down
  @Test
  public void bootStrapDropdown() throws InterruptedException {
    driver.get(
        "http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
    driver.findElement(By.id("menu1")).click();
    Thread.sleep(5000);
    List<WebElement> element = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li/a"));
    System.out.println(element.size());
    for (WebElement webElement : element) {
      if (webElement.getAttribute("innerHTML").equals("JavaScript")) {
        System.out.println(webElement.getAttribute("innerHTML"));
        webElement.click();
        break;
      }
    }
  }

  // Clicking the web element in bootstrap pop up
  @Test(enabled = false)
  public void bootStrapClick() throws InterruptedException {
    driver.get("https://www.gliffy.com/");
    driver.findElement(By.xpath("//li[@class='hs-menu-item hs-menu-depth-1']/span")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//div[@data-trial='Gliffy Diagram For Jira']")).click();
    Thread.sleep(3000);
  }

  // Getting tool tip text
  @Test(enabled = false)
  public void tooltip() throws InterruptedException {
    driver.get("https://www.seleniumhq.org/");

    Actions action = new Actions(driver);
    action
        .moveToElement(driver.findElement(By.xpath("//a[@title='Get Selenium']")))
        .build()
        .perform();

    Thread.sleep(3000);

    String tooltip =
        driver.findElement(By.xpath("//a[@title='Get Selenium']")).getAttribute("title");
    String text =
        driver.findElement(By.xpath("//a[@title='Get Selenium']")).getAttribute("innerHTML");
    System.out.println("Tooltip text: " + tooltip + System.lineSeparator() + "Link text: " + text);
  }

  @AfterMethod
  public void tearDown() {
    closeDriver();
  }
}
