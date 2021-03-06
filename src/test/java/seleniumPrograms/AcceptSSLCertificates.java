package seleniumPrograms;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AcceptSSLCertificates {
  WebDriver driver;

  @Test(enabled = false)
  public void handlingSSLInChrome() {
    WebDriverManager.chromedriver().setup();

    ChromeOptions options = new ChromeOptions();
    options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.get("https://www.cacert.org/");
    driver.quit();
  }

  @Test(enabled = false)
  public void handlingSSLInIE() {
    WebDriverManager.iedriver().setup();

    InternetExplorerOptions options = new InternetExplorerOptions();
    options.setCapability(
        InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
    options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);

    driver = new InternetExplorerDriver(options);
    driver.manage().window().maximize();
    driver.get("https://www.cacert.org/");
    driver.navigate().to("javascript:document.getElementById('overridelink').click()");
    new WebDriverWait(driver, 10)
        .until(
            ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("//a[@href='http://www.cacert.org']"))));
    driver.quit();
  }

  @Test(enabled = false)
  public void handlingSSLInEdge() {
    WebDriverManager.edgedriver().setup();

    driver = new EdgeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.cacert.org/");
    driver.navigate().to("javascript:document.getElementById('overridelink').click()");
    new WebDriverWait(driver, 10)
        .until(
            ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("//a[@href='http://www.cacert.org']"))));
    driver.quit();
  }

  @Test
  public void handlingSSLInFF() {
    WebDriverManager.firefoxdriver().setup();

    FirefoxOptions options = new FirefoxOptions();
    options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

    driver = new FirefoxDriver(options);
    driver.manage().window().maximize();
    driver.get("https://www.cacert.org/");

    new WebDriverWait(driver, 10)
        .until(
            ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("//a[@href='http://www.cacert.org']"))));
    driver.quit();
  }
}
