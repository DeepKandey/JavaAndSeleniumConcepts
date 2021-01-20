package seleniumPrograms;

import com.qa.base.BrowserNames;
import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CharSequenceSendKeysConcept extends TestBase {

  @BeforeMethod
  public void setUp() {
    initialization(BrowserNames.CHROME);
  }

  @AfterMethod
  public void tearDown() {
    closeDriver();
  }

  @Test
  public void charSequenceUsingSendKeys() throws InterruptedException {
    driver.get(
        "https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
    WebElement emailTxt = driver.findElement(By.id("identifierId"));

    String name = "Deepak";

    String space = " ";

    StringBuilder userInfo = new StringBuilder();
    userInfo.append("is an automation ").append("enginer");

    StringBuffer userDetails = new StringBuffer();
    userDetails.append("He loves learning").append(space).append("new technologies");
    // Using different charSequence in sendKeys method
    emailTxt.sendKeys(name, space, userInfo, userDetails, Keys.TAB);

    Thread.sleep(5000);
  }
}
