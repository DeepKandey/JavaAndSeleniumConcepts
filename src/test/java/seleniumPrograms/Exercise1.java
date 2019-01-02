package seleniumPrograms;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Exercise1 {

	@Test
	public void findTotalNumberOfCheckBoxes() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\deepa\\Downloads\\Browser Drivers\\Chrome Drivers\\chromedriver_win.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//*[@type='checkbox']"));
		System.out.println("Total number of checkBoxes in the page: " + checkBoxes.size());
		driver.close();
	}

	@Test
	public void checkBoxValidation() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\deepa\\Downloads\\Browser Drivers\\Chrome Drivers\\chromedriver_win.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		WebElement checkBox1 = driver.findElement(By.id("checkBoxOption1"));
		checkBox1.click();
		System.out.println("Is checkBox selected: " + checkBox1.isSelected());
		assertTrue(checkBox1.isSelected());
		checkBox1.click();
		System.out.println("Is checkBox selected: " + checkBox1.isSelected());
		assertFalse(checkBox1.isSelected());
		driver.close();

	}

}
