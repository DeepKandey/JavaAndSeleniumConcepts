package seleniumPrograms;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TrainLineAssignment {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}

	@Test
	public void verifyTicketFare() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://www.thetrainline.com/");

		driver.findElement(By.id("from.text")).sendKeys("London");
		driver.findElement(By.id("to.text")).sendKeys("Manchester");

		String scriptForDestination = "return document.getElementById(\"to.text\").value;";

		while (!js.executeScript(scriptForDestination).equals("Manchester")) {
			driver.findElement(By.id("to.text")).clear();
			driver.findElement(By.id("to.text")).sendKeys("Manchester");
		}
		driver.findElement(By.id("to.text")).sendKeys(Keys.ENTER);

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@data-test='submit-journey-search-button']")));
		driver.findElement(By.xpath("//button[@data-test='submit-journey-search-button']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("descendant::input[@type='radio'][5]")));
		driver.findElement(By.xpath("descendant::input[@type='radio'][5]")).click();

		driver.findElement(By.linkText("Register")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
		String randomAlphaNumeric = RandomStringUtils.randomAlphanumeric(10);
		String completeEmailId = randomAlphaNumeric + "@gmail.com";
		String[] array = completeEmailId.split("");

		for (String str : array) {
			driver.findElement(By.name("email")).sendKeys(str);
		}
		// driver.findElement(By.name("email")).sendKeys(emailId + "@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("firstName")).sendKeys("xyzkl");
		driver.findElement(By.id("surname")).sendKeys("xyzkl");
		driver.findElement(By.xpath("//button[@data-test='manual-address-entry-button']")).click();

		Select select = new Select(driver.findElement(By.xpath("//select[@data-test='address-country-dropdown']")));
		select.selectByVisibleText("India");

		driver.findElement(By.id("addressLine1")).sendKeys("asafkjhf");
		driver.findElement(By.id("addressLine2")).sendKeys("asafkjhf");
		driver.findElement(By.id("city")).sendKeys("Mumbai");
		driver.findElement(By.id("state")).sendKeys("Maharashtra");
		driver.findElement(By.id("postcode")).sendKeys("411207");
		driver.findElement(By.xpath("//button[@data-test='register-button']")).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@data-test='submit-journey-search-button']")));
		driver.findElement(By.xpath("//button[@data-test='submit-journey-search-button']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("descendant::input[@type='radio'][5]")));
		driver.findElement(By.xpath("descendant::input[@type='radio'][5]")).click();

		/*
		 * String ticketFare = driver .findElement(By.xpath(
		 * "descendant::input[@type='radio'][5]/parent::div/following-sibling::span/span"
		 * )) .getAttribute("innerHTML");
		 */
		String fareOnMatrixPage = null;
		try {
			if (driver
					.findElement(
							By.xpath("descendant::input[@type='radio'][5]/parent::div/following-sibling::span/span"))
					.isDisplayed())
				fareOnMatrixPage = driver
						.findElement(By
								.xpath("descendant::input[@type='radio'][5]/parent::div/following-sibling::span/span"))
						.getAttribute("innerHTML");
		} catch (Exception e) {
			fareOnMatrixPage = driver
					.findElement(By.xpath(
							"descendant::input[@type='radio'][5]/parent::div/following-sibling::div/span[2]/span/span"))
					.getAttribute("innerHTML");
		}
		System.out.println("First Class Ticket Fare: " + fareOnMatrixPage);

		Thread.sleep(2000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-test='cjs-button-quick-buy']")));
		driver.findElement(By.xpath("//button[@data-test='cjs-button-quick-buy']")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@data-test='trip-card-total']")));
		String fareOnCheckout = driver.findElement(By.xpath("//span[@data-test='trip-card-total']/span"))
				.getAttribute("innerHTML");
		System.out.println("FareOnCheckout: " + fareOnCheckout);
		Assert.assertEquals(fareOnCheckout, fareOnMatrixPage, "Fares do not match");
		if (fareOnCheckout.equals(fareOnMatrixPage)) {
			System.out.println("Ticket fares are matching");
		}
	}

	@AfterTest
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}
}
