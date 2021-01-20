package seleniumPrograms;

import com.qa.constants.CommonConstants;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Set;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CookieHandlingConcept {
  WebDriver driver;
  WebDriverWait wait;

  @BeforeMethod
  public void setup() {

    System.setProperty("webdriver.gecko.driver", CommonConstants.DRIVERPATH_FIREFOX);
    driver = new FirefoxDriver();
    wait = new WebDriverWait(driver, 20);
    driver.manage().window().maximize();
  }

  @Test(enabled = false)
  public void getCookie() throws InterruptedException, IOException {
    driver.get("https://www.taggdigital.com/");
    Actions action = new Actions(driver);
    action
        .moveToElement(driver.findElement(By.xpath("//ul[@class='main-navigation']//a[@href='#']")))
        .build()
        .perform();
    Thread.sleep(1000);
    wait.until(
        ExpectedConditions.elementToBeClickable(
            By.xpath("descendant::a[@data-target='#login_popup'][2]")));
    driver.findElement(By.xpath("descendant::a[@data-target='#login_popup'][2]")).click();

    driver.findElement(By.id("email")).sendKeys("");
    driver.findElement(By.id("password")).sendKeys("");
    driver.findElement(By.id("loginsubmit")).click();

    // Getting Excel Sheet
    FileInputStream fis = new FileInputStream(CommonConstants.TESTDOCUMENT_FILEPATH);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
    int index = workbook.getSheetIndex("Cookie");
    XSSFSheet sheet = workbook.getSheetAt(index);

    // Print Cookies
    Set<Cookie> cookiesSet = driver.manage().getCookies();
    System.out.println(cookiesSet);
    for (Cookie cookie : cookiesSet) {
      System.out.println(
          "Name-->"
              + cookie.getName()
              + "  Value-->"
              + cookie.getValue()
              + "  Domain-->"
              + cookie.getDomain()
              + "  Path-->"
              + cookie.getPath()
              + "  Expiry-->"
              + cookie.getExpiry()
              + "  Is Secure-->"
              + cookie.isSecure()
              + "  IsHttp-->"
              + cookie.isHttpOnly());

      int totalNoRows = sheet.getLastRowNum();
      XSSFRow row = sheet.createRow(totalNoRows + 1);
      row.createCell(0).setCellValue(cookie.getName());
      row.createCell(1).setCellValue(cookie.getValue());
      row.createCell(2).setCellValue(cookie.getDomain());
      row.createCell(3).setCellValue(cookie.getPath());
      row.createCell(4).setCellValue(cookie.getExpiry());
      row.createCell(5).setCellValue(cookie.isSecure());
      row.createCell(6).setCellValue(cookie.isHttpOnly());
      FileOutputStream out = new FileOutputStream(CommonConstants.TESTDOCUMENT_FILEPATH);
      workbook.write(out);
    }
    workbook.close();
  }

  @Test
  public void setCookie() throws IOException {
    FileInputStream fis = new FileInputStream(CommonConstants.TESTDOCUMENT_FILEPATH);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
    int index = workbook.getSheetIndex("Cookie");
    XSSFSheet sheet = workbook.getSheetAt(index);

    // Retrieving cookie data from excel
    String cookieName = sheet.getRow(1).getCell(0).toString();
    String cookieValue = sheet.getRow(1).getCell(1).toString();
    String cookieDomain = sheet.getRow(1).getCell(2).toString();
    String cookiePath = sheet.getRow(1).getCell(3).toString();

    XSSFCell cookieExpiryCell = sheet.getRow(1).getCell(4);
    Date cookieExpiry = cookieExpiryCell.getDateCellValue();

    XSSFCell cookieIsSecureCell = sheet.getRow(1).getCell(5);
    Boolean cookieIsSecure = cookieIsSecureCell.getBooleanCellValue();

    XSSFCell cookieisHttpCell = sheet.getRow(1).getCell(6);
    boolean cookieisHttp = cookieisHttpCell.getBooleanCellValue();

    workbook.close();

    Cookie cookie =
        new Cookie(
            cookieName,
            cookieValue,
            cookieDomain,
            cookiePath,
            cookieExpiry,
            cookieIsSecure,
            cookieisHttp);
    driver.get("https://www.taggdigital.com");
    driver.manage().addCookie(cookie);
    driver.get("https://www.taggdigital.com");
  }

  @AfterMethod
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }
}
