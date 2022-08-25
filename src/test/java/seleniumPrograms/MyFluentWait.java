package seleniumPrograms;

import com.qa.base.BrowserNames;
import com.qa.base.TestBase;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyFluentWait extends TestBase {

  @BeforeMethod
  public void setUp() {
    initialization(BrowserNames.CHROME);
  }

  @AfterMethod
  public void tearDown() {
    closeDriver();
  }

  @Test
  public void fluentWaitCheck() {
    driver.get("https://www.makemytrip.com/");

    Wait<WebDriver> wait =
        new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofMillis(500))
            .ignoring(NoSuchElementException.class);

    /*
     * WebElement hotelsLink = wait.until(new Function<WebDriver, WebElement>() {
     * public WebElement apply(WebDriver driver) { return
     * driver.findElement(By.id("header_tab_hotels")); } });
     */

    // Lambda expression used for Fluent wait
    WebElement hotelsLink = wait.until(driver -> driver.findElement(By.linkText("Hotels")));

    System.out.println("Hotels Link is displayed-->" + hotelsLink.getText());

    String backGroundColorSearchBtn =
        driver
            .findElement(By.xpath("//a[@class='primaryBtn font24 latoBlack widgetSearchBtn ']"))
            .getCssValue("background-color");
    String textColorSearchBtn =
        driver
            .findElement(By.xpath("//a[@class='primaryBtn font24 latoBlack widgetSearchBtn ']"))
            .getCssValue("color");
    System.out.println("Background Color of search button-->" + backGroundColorSearchBtn);
    System.out.println("Text Color of search button-->" + textColorSearchBtn);
    System.out.println(
        "Background Color of search button in Hex-->"
            + Color.fromString(backGroundColorSearchBtn).asHex());
    System.out.println(
        "Text Color of search button in Hex-->" + Color.fromString(textColorSearchBtn).asHex());
  } // End of method fluentWaitCheck()
} // End of class MyFluentWait
