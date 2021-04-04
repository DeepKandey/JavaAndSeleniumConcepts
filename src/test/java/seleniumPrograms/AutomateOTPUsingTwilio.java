package seleniumPrograms;

import com.qa.base.BrowserNames;
import com.qa.base.TestBase;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AutomateOTPUsingTwilio extends TestBase {

  private static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
  private static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

  @Test
  public void HandleOTPMessage() {
    initialization(BrowserNames.CHROME);
    driver.get("https://www.amazon.in/");
    try {
      if (driver.findElement(By.linkText("Start here.")).isDisplayed())
        driver.findElement(By.linkText("Start here.")).click();

    } catch (Exception e) {
      Actions actionObj = new Actions(driver);
      actionObj.moveToElement(driver.findElement(By.id("nav-link-accountList"))).perform();
      driver.findElement(By.linkText("Start here.")).click();
    }
    driver.findElement(By.id("ap_customer_name")).sendKeys("testDeepakAutomationLab");
    driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']")).click();
    driver
        .findElement(By.xpath("//ul[@role='application']//li//a[text()='United States +1']"))
        .click();
    driver.findElement(By.id("ap_phone_number")).sendKeys("");
    driver.findElement(By.id("ap_password")).sendKeys("abc@123");
    driver.findElement(By.id("continue")).click();

    // Using Twilio API to fetch OTP sent.
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    String smsBody = getMessage();
    System.out.println(smsBody);
    String OTPNumber =
        smsBody.replaceAll("[^-?0-9]+", " "); // Fetch only OTP using regular expression
    driver.findElement(By.id("auth-pv-enter-code")).sendKeys(OTPNumber);
    // driver.findElement(By.id("auth-verify-button")).click();

    // closeDriver();
  }

  // Fetch the latest message sent to the given number
  private static String getMessage() {
    return getMessages()
        .filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
        .filter(m -> m.getTo().equals("+1"))
        .map(Message::getBody)
        .findFirst()
        .orElseThrow(IllegalStateException::new);
  }

  // Fetch all the messages details for the given account
  private static Stream<Message> getMessages() {
    ResourceSet<Message> messages = Message.reader(ACCOUNT_SID).read();
    return StreamSupport.stream(messages.spliterator(), false);
  }
}
