package seleniumPrograms;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class MyFluentWait extends TestBase {

	@BeforeMethod
	public void setUp() {
		initialization("IE");
	}

	@AfterMethod
	public void tearDown() {
		close();
	}

	@Test
	public void fluentWaitCheck() {
		driver.get("https://www.makemytrip.com/");

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);

		WebElement hotelsLink = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id("header_tab_hotels"));
			}
		});
		System.out.println("Hotels Link is displayed-->" + hotelsLink.getText());

		String backGroundColorSearchBtn = driver.findElement(By.id("searchBtn")).getCssValue("background-color");
		String textColorSearchBtn = driver.findElement(By.id("searchBtn")).getCssValue("color");
		System.out.println("Background Color of search button-->" + backGroundColorSearchBtn);
		System.out.println("Text Color of search button-->" + textColorSearchBtn);
		System.out.println(
				"Background Color of search button in Hex-->" + Color.fromString(backGroundColorSearchBtn).asHex());
		System.out.println("Text Color of search button in Hex-->" + Color.fromString(textColorSearchBtn).asHex());
	}
}
