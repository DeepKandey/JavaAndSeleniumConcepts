package seleniumPrograms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CricketScoreboard {

	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\deepa\\Downloads\\Browser Drivers\\Chrome Drivers\\chromedriver_win.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void scoreBoard() {
		driver.get(
				"http://www.espncricinfo.com/series/8048/scorecard/1175356/chennai-super-kings-vs-royal-challengers-bangalore-1st-match-indian-premier-league-2019");

		List<WebElement> batsmen_List = driver
				.findElements(By.xpath("//*[@class='scorecard-section batsmen']//*[@class='wrap batsmen']"));

		String xpath1 = "(//*[@class='scorecard-section batsmen']//*[@class='wrap batsmen'])";
		String xpath2 = "//div";
		for (int i = 0; i <= batsmen_List.size(); i++) {
			List<WebElement> batsman_ScoreCard = driver.findElements(By.xpath(xpath1 + "[" + i + "]" + xpath2));

			for (int j = 1; j <= batsman_ScoreCard.size(); j++) {
				String var = driver.findElement(By.xpath("(" + xpath1 + "[" + i + "]" + xpath2 + ")" + "[" + j + "]"))
						.getAttribute("innerText");
				if (j != 2) {
					if (j == 1 && var.length()<=8)
						System.out.print(var + "\t\t"+ "  ");
					else {
						System.out.print(var + "\t\t");
					}
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}