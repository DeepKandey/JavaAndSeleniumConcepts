package seleniumPrograms;

import com.applitools.eyes.selenium.Eyes;
import com.qa.base.BrowserNames;
import com.qa.base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApplitoolsConcept extends TestBase {

  Eyes eyes;

  @BeforeMethod
  public void setUp() {
    initialization(BrowserNames.CHROME);
  }

  @AfterMethod
  public void tearDown() {
    closeDriver();
    // If the test was aborted before eyes.close was called, ends the test as
    // aborted.
    eyes.abortIfNotClosed();
  }

  @Test
  public void visualTesting() {
    // Initialize the eyes SDK and set your private API key.
    eyes = new Eyes();
    eyes.setApiKey("lyV1luwQQdZpjJ5AxPpl4p59YFWyuGHLtfNqXFAAGOM110");

    // Start the test by setting AUT's name, window or the page name that's being
    // tested, viewport width and height
    driver = eyes.open(driver, "Applitools", "Hello World");

    driver.get("https://applitools.com/helloworld?diff2");
    eyes.checkWindow("Home Page"); // checkpoint

    eyes.close();
  }
}
