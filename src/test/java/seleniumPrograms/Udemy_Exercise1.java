package seleniumPrograms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Udemy_Exercise1 {

	@Test
	public void checkBoxTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qaclickacademy.com/practice.php");

		driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();
		String text = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();

		Select select = new Select(driver.findElement(By.id("dropdown-class-example")));
		List<WebElement> dropDownOptions = select.getOptions();

		for (int i = 0; i < dropDownOptions.size(); i++) {
			if (dropDownOptions.get(i).getText().equals(text)) {
				dropDownOptions.get(i).click();
				break;
			}
		}

		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();

		String alertText = driver.switchTo().alert().getText();
		Assert.assertTrue(alertText.contains(text));
		driver.switchTo().alert().accept();

		driver.findElement(By.id("autocomplete")).sendKeys("Unit");
		while (!(driver.findElement(By.id("autocomplete")).getAttribute("value").equals("United Kingdom"))) {
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(500);
		}
		driver.quit();
	}
}
