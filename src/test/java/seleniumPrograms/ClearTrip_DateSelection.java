package seleniumPrograms;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ClearTrip_DateSelection {

  @Test
  public void clearTripAssignment_Udemy() {
    System.setProperty(
        "webdriver.chrome.driver",
        "C:\\Users\\deepa\\Downloads\\Browser Drivers\\Chrome Drivers\\chromedriver_win.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.cleartrip.com");

    Select adults = new Select(driver.findElement(By.id("Adults")));
    adults.selectByValue("3");

    Select children = new Select(driver.findElement(By.id("Childrens")));
    children.selectByValue("2");

    Select infants = new Select(driver.findElement(By.id("Infants")));
    infants.selectByValue("1");

    driver.findElement(By.xpath("(//*[@class='icon ir datePicker'])[1]")).click();

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
    String currentDate = dateFormat.format(new Date());
    String[] dateArray = currentDate.split(" ");

    String todayDate = null;
    System.out.println("Current date of the month: " + dateArray[0]);

    if (dateArray[0].charAt(0) == '0') {
      todayDate = dateArray[0].substring(1, 2);
    } else {
      todayDate = dateArray[0];
    }

    System.out.println("Current Month: " + dateArray[1]);

    if (dateArray[1].equals(
        driver.findElement(By.xpath("(//*[@class='ui-datepicker-month'])[1]")).getText())) {

      List<WebElement> dateList =
          driver.findElements(
              By.xpath(
                  "(//*[@class='ui-datepicker-month'])[1]/parent::div/parent::div/following-sibling::table/tbody//tr//td//a"));

      for (int i = 0; i < dateList.size(); i++) {
        if (dateList.get(i).getText().equals(todayDate)) {
          dateList.get(i).click();
          break;
        }
      }
    } else {
      List<WebElement> dateList =
          driver.findElements(
              By.xpath(
                  "(//*[@class='ui-datepicker-month'])[2]/parent::div/parent::div/following-sibling::table/tbody//tr//td//a"));

      for (int i = 0; i < dateList.size(); i++) {
        if (dateList.get(i).getText().equals(todayDate)) {
          dateList.get(i).click();
          break;
        }
      }
    }

    driver.findElement(By.id("MoreOptionsLink")).click();
    driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Indigo");
    driver.findElement(By.id("AirlineAutocomplete")).sendKeys(Keys.ENTER);
    // driver.quit();
  }
}
