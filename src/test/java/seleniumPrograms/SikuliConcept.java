package seleniumPrograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SikuliConcept {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepa\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}

	@Test
	public void flashObjectsControl() throws FindFailed {
		driver.get("https://www.youtube.com/watch?v=0Gew2XOuum8");

		Screen screen = new Screen();

		Pattern pauseImg = new Pattern(System.getProperty("user.dir") + "/YT_PAUSE.PNG");
		screen.wait(pauseImg, 2000);
		screen.click();
		screen.click();
		screen.click();

		Pattern playImg = new Pattern(System.getProperty("user.dir") + "/YT_PLAY.PNG");
		screen.wait(playImg, 2000);
		screen.click();

		Pattern settingImg = new Pattern(System.getProperty("user.dir") + "/YT_SETTING.PNG");
		screen.wait(settingImg, 2000);
		screen.click();

		Pattern qualityImg = new Pattern(System.getProperty("user.dir") + "/YT_QUALITY.PNG");
		screen.wait(qualityImg, 2000);
		screen.click();

		Pattern Img1080P = new Pattern(System.getProperty("user.dir") + "/YT_1080P.PNG");
		screen.wait(Img1080P, 2000);
		screen.click();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
