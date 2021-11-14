package seleniumPrograms;

import io.appium.java_client.AppiumDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserStackAndroid {
  public static String userName = "<username>";
  public static String accessKey = "<accessKey>";

  public static void main(String args[]) throws MalformedURLException, InterruptedException {

    DesiredCapabilities caps = new DesiredCapabilities();
    HashMap<String, Object> browserstackOptions = new HashMap<>();

    // Set your access credentials
    browserstackOptions.put("userName", "xyz");
    browserstackOptions.put("accessKey", "xyz");

    // Set URL of the application under test
    //  caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
    caps.setCapability("browserName", "Chrome");
    caps.setCapability("browserVersion", "latest-beta");

    // Set other BrowserStack capabilities
    browserstackOptions.put("osVersion", "9.0");
    browserstackOptions.put("deviceName", "Google Pixel 3");
    browserstackOptions.put("projectName", "First Java Project");
    browserstackOptions.put("buildName", "Java Android");
    browserstackOptions.put("sessionName", "first_test");

    caps.setCapability("bstack:options", browserstackOptions);

    // Initialise the remote Webdriver using BrowserStack remote URL
    // and desired capabilities defined above
    AppiumDriver driver = new AppiumDriver<>(new URL("http://hub.browserstack.com/wd/hub"), caps);
    driver.get("https://www.google.com");
    ((JavascriptExecutor) driver).executeScript("window.open()");
    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
    driver.get("http://google.com");
    driver.quit();
  }
}
