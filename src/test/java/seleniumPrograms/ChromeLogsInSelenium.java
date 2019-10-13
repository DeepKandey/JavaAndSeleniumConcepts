package seleniumPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


// Class to generate Chrome logs while Selenium API interacts with the browser
public class ChromeLogsInSelenium {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/deepa/Downloads/Browser Drivers/Chrome Drivers/chromedriver.exe");

		System.setProperty("webdriver.chrome.logfile", "./Chromelog.txt");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();

		driver.get("https://www.google.com/");
		WebElement googleSearchTxt=driver.findElement(By.name("q"));
		googleSearchTxt.sendKeys("Hello World");
		googleSearchTxt.sendKeys(Keys.ARROW_DOWN);
		googleSearchTxt.sendKeys(Keys.ENTER);
		driver.quit();

	}
}
