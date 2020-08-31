package seleniumPrograms;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.BrowserNames;
import com.qa.base.TestBase;

public class TrainLineAssignment extends TestBase {

	@BeforeTest
	public void setup() {
		initialization(BrowserNames.CHROME);
	}

	@Test
	public void verifyTicketFare() {
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

		String fareOnMatrixPage = null;
		try {
			if (driver
					.findElement(By
							.xpath("descendant::input[@type='radio'][5]/parent::div/following-sibling::div//span/span"))
					.isDisplayed())
				fareOnMatrixPage = driver
						.findElement(By.xpath(
								"descendant::input[@type='radio'][5]/parent::div/following-sibling::div//span/span"))
						.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-test='cjs-button-quick-buy']")));
		driver.findElement(By.xpath("//button[@data-test='cjs-button-quick-buy']")).click();

		// Select Guest
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='isGuest' and @value='true']")));
		driver.findElement(By.xpath("//input[@name='isGuest' and @value='true']")).click();

		String randomAlphaNumeric = RandomStringUtils.randomAlphanumeric(10);
		String completeEmailId = randomAlphaNumeric + "@gmail.com";
		String[] array = completeEmailId.split("");

		for (String str : array) {
			driver.findElement(By.name("email")).sendKeys(str);
		}

		driver.findElement(By.xpath("//*[text()='Continue as guest']")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@data-test='trip-card-total']")));
		String fareOnCheckout = driver.findElement(By.xpath("//span[@data-test='trip-card-total']/span")).getText();

		System.out.println("First Class Ticket Fare on Matrix Page: " + fareOnMatrixPage + "  Fare On Checkout Page: "
				+ fareOnCheckout);

		// Verify fares
		Assert.assertEquals(fareOnCheckout, fareOnMatrixPage, "Fares do not match");

		if (fareOnCheckout.equals(fareOnMatrixPage)) {
			System.out.println("Ticket fares are matching");
		}
	}

	@AfterTest
	public void tearDown() {
		closeDriver();
	}

} // end of class TrainLineAssignment