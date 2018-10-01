package seleniumPrograms;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DownloadFileConcept {

	WebDriver driver;
	File folder;

	@BeforeMethod
	public void setUp() {
		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();

		// chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepa\\Downloads\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		Map<String, Object> pref = new HashMap<String, Object>();
		pref.put("profile.default_content_settings.popups", 0);
		pref.put("download.default_directory", folder.getAbsolutePath());

		options.setExperimentalOption("prefs", pref);

		driver = new ChromeDriver(options);
	}

	@Test
	public void downloadFilesTest() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/download");
		driver.findElement(By.linkText("some-file.txt")).click();

		Thread.sleep(2000);

		File[] listOfFiles = folder.listFiles();
		// make sure directory is not empty
		Assert.assertTrue(listOfFiles.length > 0);

		for (File file : folder.listFiles()) {
			Assert.assertTrue(file.length() > 0);
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		for (File file : folder.listFiles()) {
			file.delete();
		}
		folder.delete();
	}
}
