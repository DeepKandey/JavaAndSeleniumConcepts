package seleniumPrograms;

import com.qa.base.BrowserNames;
import com.qa.base.TestBase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CookieHandlingConcept2 extends TestBase {

  @BeforeMethod
  public void setUp() {
    initialization(BrowserNames.CHROME);
  }

  @AfterMethod
  public void tearDown() {
    // close();
  }

  @Test
  public void storeAndLoadCookieInBrowser() throws IOException {
    driver.get("https://www.facebook.com/");

    driver.findElement(new ByIdOrName("email")).sendKeys("deepak.rai21@yahoo.com");
    driver.findElement(new ByAll(By.id("pass"), By.id("pass"))).sendKeys("xxxxxx");
    driver
        .findElement(
            new ByChained(
                By.cssSelector("div[class='menu_login_container rfloat _ohf']"),
                By.id("login_form"),
                By.id("loginbutton")))
        .click();

    storeCookie();
    driver.close();

    driver = new ChromeDriver();
    driver.get("https://www.facebook.com/");
    loadCookie();
    driver.navigate().refresh();
  }

  private void storeCookie() {
    File file = new File("Cookies.data");
    try {
      file.delete();
      file.createNewFile();
      FileWriter fileWriter = new FileWriter(file);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

      for (Cookie ck : driver.manage().getCookies()) {
        bufferedWriter.write(
            (ck.getName()
                + ";"
                + ck.getValue()
                + ";"
                + ck.getDomain()
                + ";"
                + ck.getPath()
                + ";"
                + ck.getExpiry()
                + ";"
                + ck.isSecure()));
        bufferedWriter.newLine();
      }
      bufferedWriter.close();
      fileWriter.close();

    } catch (Exception e) {
    }
  }

  private void loadCookie() throws IOException {
    File file = new File("Cookies.data");
    FileReader fileReader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    String strLine;

    while ((strLine = bufferedReader.readLine()) != null) {
      StringTokenizer token = new StringTokenizer(strLine, ";");
      while (token.hasMoreTokens()) {
        String name = token.nextToken();
        String value = token.nextToken();
        String domain = token.nextToken();
        String path = token.nextToken();
        Date expiry = null;
        if ((token.nextToken()).equals("null")) {
          expiry = new Date();
        }
        boolean isSecure = Boolean.parseBoolean(token.nextToken());
        Cookie cookie = new Cookie(name, value, domain, path, expiry, isSecure);
        System.out.println(cookie);
        driver.manage().addCookie(cookie);
      }
    }
    bufferedReader.close();
    fileReader.close();
  }
}
