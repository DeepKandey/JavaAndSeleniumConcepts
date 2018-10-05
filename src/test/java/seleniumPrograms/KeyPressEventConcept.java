package seleniumPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressEventConcept {

	@Test
	public void keyEventTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepa\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/key_presses");

		Actions action = new Actions(driver);
		// *Using send keys
		// action.sendKeys(Keys.SPACE).build().perform();

		/*
		 * Using keyDown method - takes modifier keys as parameter(SHIFT, ALT and
		 * CONTROL Keys that modifies the purpose of other keys It is used to simulate
		 * the action of pressing a modifier key, without releasing. The expected values
		 * for the keyDown() method are - Keys.SHIFT, Keys.ALT and Keys.CONTROL only,
		 * passing key other than these results in IllegalArgumentException.
		 */
		action.keyDown(Keys.ALT).build().perform();

		String text = driver.findElement(By.id("result")).getText();
		System.out.println(text);
		// Assert.assertEquals(text,"You entered: SPACE");
		Assert.assertEquals(text, "You entered: ALT");
	}
}
