package seleniumPrograms;

import com.qa.constants.CommonConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsConcept {

  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", CommonConstants.DRIVERPATH_CHROME);

    WebDriverManager.chromedriver().setup();

    ChromeOptions option = new ChromeOptions();
    // option.addArguments("--disable-notifications"); --disable browser
    // notifications
    option.addArguments(
        "--disable-infobars"); // --disable info bar-that chrome is controlled by automated test s/w

    // To accept notifications
    Map<String, Object> prefs = new HashMap<String, Object>();
    prefs.put("profile.default_content_setting_values.notifications", 1);
    // 1-Allow, 2-Block, 0-default
    option.setExperimentalOption("prefs", prefs);

    WebDriver driver = new ChromeDriver(option);
    driver.get("https://www.makemytrip.com/");
  }
}
