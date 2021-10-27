package seleniumPrograms;

import com.qa.constants.CommonConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoIbiboAssignment {

  WebDriver driver;
  WebDriverWait wait;

  @BeforeMethod
  public void setup() {

    /*
     * System.setProperty("webdriver.gecko.driver",
     * "C:\\Users\\deepa\\Downloads\\Drivers\\FireFoxDrivers\\geckodriver.exe");
     * driver = new FirefoxDriver();
     */

    System.setProperty("webdriver.chrome.driver", CommonConstants.DRIVERPATH_CHROME);
    driver = new ChromeDriver();

    wait = new WebDriverWait(driver, 20);
    driver.manage().window().maximize();
  }

  @AfterMethod
  public void tearDown() {
    if (driver != null) driver.quit();
  }

  @Test
  public void flightBookingTest() throws InterruptedException {

    driver.get("https://www.goibibo.com/");
    JavascriptExecutor js = ((JavascriptExecutor) driver);

    driver.findElement(By.id("gi_roundtrip_label")).click();
    driver.findElement(By.id("gosuggest_inputSrc")).sendKeys("Bangalore");
    Thread.sleep(1000);
    driver.findElement(By.id("gosuggest_inputSrc")).sendKeys(Keys.DOWN, Keys.RETURN);

    driver.findElement(By.id("gosuggest_inputDest")).sendKeys("Mumbai");
    Thread.sleep(1000);
    driver.findElement(By.id("gosuggest_inputDest")).sendKeys(Keys.DOWN, Keys.RETURN);

    driver
        .findElement(
            By.xpath("descendant::input[@class='form-control inputTxtLarge widgetCalenderTxt'][1]"))
        .click();

    try {
      driver
          .findElement(
              By.xpath(
                  "//div[@class='DayPicker-Week']//*[@class='DayPicker-Day DayPicker-Day--today DayPicker-Day--selected']/following-sibling::div"))
          .click();
    } catch (Exception e) {
      driver
          .findElement(
              By.xpath(
                  "descendant::div[@class='DayPicker-Body'][1]/div/div[@class='DayPicker-Day DayPicker-Day--today DayPicker-Day--selected']/parent::div/following-sibling::div[1]/div[1]"))
          .click();
    }

    driver
        .findElement(
            By.xpath(
                "//div[@class='DayPicker-Week']//*[@class='DayPicker-Day DayPicker-Day--selected']"))
        .click();

    driver.findElement(By.id("gi_search_btn")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='button']")));

    try {
      WebElement element =
          driver.findElement(By.xpath("//iframe[contains(@name,'notification-frame-~')]"));
      driver.switchTo().frame(element);
      driver.findElement(By.xpath("//div[@class='close tablecell']")).click();
      driver.switchTo().defaultContent();
    } catch (Exception e) {
    }

    List<WebElement> listOfDepartureTime =
        driver.findElements(
            By.xpath(
                "//div[@id='onwFltContainer']//div[@class='card-block fl width100 padT20 padB15']//div[@class='col-md-3 col-sm-4 col-xs-4']/span[1]"));

    ArrayList<String> timeList = new ArrayList<String>();

    for (int i = 0; i < listOfDepartureTime.size(); i++) {
      timeList.add(listOfDepartureTime.get(i).getAttribute("innerHTML"));
    }

    Collections.sort(timeList);
    System.out.println("For Departure-->" + timeList);

    String beforePath =
        "(//div[@id='onwFltContainer']//div[@class='card-block fl width100 padT20 padB15']//div[@class='col-md-3 col-sm-4 col-xs-4']/span[1])[";
    String afterPath =
        "]/parent::div/parent::div/parent::div/following-sibling::div//div/label/div";

    for (int i = 0; i < listOfDepartureTime.size(); i++) {
      if (listOfDepartureTime.get(i).getAttribute("innerHTML").equals(timeList.get(0))) {

        wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath(beforePath + (i + 1) + afterPath)));
        driver.findElement(By.xpath(beforePath + (i + 1) + afterPath)).click();
        break;
      }
    }

    List<WebElement> listOfReturnTime =
        driver.findElements(
            By.xpath(
                "//div[@id='retFltContainer']//div[@class='card-block fl width100 padT20 padB15']//div[@class='col-md-3 col-sm-4 col-xs-4']/span[1]"));

    ArrayList<String> ReturnTimeList = new ArrayList<String>();

    for (int i = 0; i < listOfReturnTime.size(); i++) {
      ReturnTimeList.add(listOfReturnTime.get(i).getAttribute("innerHTML"));
    }

    Collections.sort(ReturnTimeList);
    System.out.println("While returning, time slots-->" + ReturnTimeList);

    String beforePath1 =
        "(//div[@id='retFltContainer']//div[@class='card-block fl width100 padT20 padB15']//div[@class='col-md-3 col-sm-4 col-xs-4']/span[1])[";
    String afterPath1 =
        "]/parent::div/parent::div/parent::div/following-sibling::div//div/label/div";
    for (int i = 0; i < listOfReturnTime.size(); i++) {
      if (listOfReturnTime.get(i).getAttribute("innerHTML").equals(ReturnTimeList.get(0))) {
        try {
          WebElement close =
              driver.findElement(
                  By.xpath(
                      "//*[@class='fl posAbs icon-close1 ico17 curPoint fb whiteBg closePers black']"));
          if (close.isDisplayed()) {
            close.click();
          }
        } catch (Exception e) {
          js.executeScript("arguments[0].scrollIntoView(true)", listOfReturnTime.get(i));
          js.executeScript("window.scrollBy(0, -370)");
          driver.findElement(By.xpath(beforePath1 + (i + 1) + afterPath1)).click();
        }
        js.executeScript("arguments[0].scrollIntoView(true)", listOfReturnTime.get(i));
        js.executeScript("window.scrollBy(0, -370)");
        driver.findElement(By.xpath(beforePath1 + (i + 1) + afterPath1)).click();
        break;
      }
    }

    driver.findElement(By.xpath("//input[@type='button']")).click();
    wait.until(
        ExpectedConditions.visibilityOf(
            driver.findElement(
                By.xpath("//div[@class='blueBgLt fl padTB10 width100 ']/span[1]/span"))));

    String totalAmountTxt =
        driver
            .findElement(By.xpath("//div[@class='blueBgLt fl padTB10 width100 ']/span[1]/span"))
            .getAttribute("innerHTML");

    String proceedToPaymentTxt =
        driver
            .findElement(By.xpath("//button[@class='button orange col-md-3 fr large']"))
            .getAttribute("innerHTML");

    Assert.assertEquals(totalAmountTxt, "Total Amount");
    Assert.assertEquals(proceedToPaymentTxt, "Proceed to Payment");
  }
}
