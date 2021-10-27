package seleniumPrograms;

import com.qa.base.BrowserNames;
import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScrollingConcept extends TestBase {

  @BeforeMethod
  public void setUp() {
    initialization(BrowserNames.CHROME);
  }

  @Test
  public void scrolling() throws InterruptedException {
    driver.get("https://www.makemytrip.com/");
    JavascriptExecutor js = (JavascriptExecutor) (driver);

    Thread.sleep(6000);
    WebElement element =
        driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"));
    driver.switchTo().frame(element);
    driver.findElement(By.xpath("//a[@class='close']")).click();

    // Scroll Page down to 550px
    js.executeScript("window.scrollBy(0,550)", "");
    // js.executeScript("scroll(0,250)")
    Thread.sleep(5000);

    // Scroll Page Up by 250px
    js.executeScript("window.scrollBy(0,-250)", "");
    Thread.sleep(2000);

    WebElement followUsTxt =
        driver.findElement(By.xpath("//div[@class='cfooter_small']//section[1]/h5"));

    // Scroll Page to view an element
    js.executeScript("arguments[0].scrollIntoView(true);", followUsTxt);
    System.out.println(followUsTxt.getAttribute("innerHTML"));
    Thread.sleep(2000);
  }

  @AfterMethod
  public void tearDown() {
    closeDriver();
  }
}
