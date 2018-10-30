package seleniumPrograms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootstrapDropdownConcept {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	// Clicking on web element from bootstrap drop down
	@Test
	public void bootStrapDropdown() throws InterruptedException {
		driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		driver.findElement(By.id("menu1")).click();
		Thread.sleep(5000);
		List<WebElement> element = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li/a"));
		System.out.println(element.size());
		for (int i = 0; i < element.size(); i++) {
			if (element.get(i).getAttribute("innerHTML").equals("JavaScript")) {
				System.out.println(element.get(i).getAttribute("innerHTML"));
				element.get(i).click();
				break;
			}
		}
	}

	// Clicking the web element in bootstrap pop up
	@Test
	public void bootStrapClick() throws InterruptedException {
		driver.get("https://www.gliffy.com/");
		driver.findElement(By.xpath("//li[@class='hs-menu-item hs-menu-depth-1']/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@data-trial='Gliffy Diagram For Jira']")).click();
		Thread.sleep(3000);
	}

	// Getting tool tip text
	@Test
	public void tooltip() throws InterruptedException {
		driver.get("https://www.seleniumhq.org/");

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@title='Get Selenium']"))).build().perform();

		Thread.sleep(3000);

		String tooltip = driver.findElement(By.xpath("//a[@title='Get Selenium']")).getAttribute("title");
		String text = driver.findElement(By.xpath("//a[@title='Get Selenium']")).getAttribute("innerHTML");
		System.out.println("Tooltip text: " + tooltip + System.lineSeparator() + "Link text: " + text);
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}
}
