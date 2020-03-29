package seleniumPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class GetColorFontSizeBackGroundColorConcept extends TestBase {

	@BeforeTest
	public void setUp() {
		initialization("FF");
	}

	@Test
	public void getColorFontSizeAndBackgroundColor() {
		driver.get("http://www.google.com");
		WebElement googleLogo = driver.findElement(By.xpath("//img[@alt='Google']"));

		System.out.println("Color of Google Home Page logo: " + googleLogo.getCssValue("color"));

		System.out.println("Font Size of Google Home Page logo: " + googleLogo.getCssValue("font-size"));

		System.out.println("Background Color of Google Home Page logo: " + googleLogo.getCssValue("background-color"));
	}

	@AfterMethod
	public void tearDown() {
		closeDriver();
	}
}
