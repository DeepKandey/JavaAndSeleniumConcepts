package seleniumPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleAuthenticationPopUp {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\deepa\\Downloads\\Drivers\\Chrome Drivers\\chromedriver_win.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void authenticationHandle() {
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		String message = driver.findElement(By.cssSelector("p")).getText();
		Assert.assertEquals(message, "Congratulations! You must have the proper credentials.", "Message not expected");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
