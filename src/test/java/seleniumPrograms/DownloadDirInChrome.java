package seleniumPrograms;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class DownloadDirInChrome {

	@Test
	public void downloadDirInChrome() throws IOException {

		// Setting chrome driver path
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\deepa\\Downloads\\Drivers\\Chrome Drivers\\chromedriver_win.exe");

		// Setting new download directory path
		Map<String, Object> prefs = new HashMap<String, Object>();

		// Use File.separator as it will work on any OS
		prefs.put("download.default_directory",
				System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");
		prefs.put("safebrowsing.enabled", "false");
		prefs.put("profile.default_content_settings.popups", 0);

		// Adding cpabilities to ChromeOptions
		ChromeOptions options = new ChromeOptions();
		/*
		 * options.addArguments("--safebrowsing-disable-download-protection");
		 * options.addArguments("--safebrowsing-manual-download-blacklist");
		 * options.addArguments("--safebrowsing-disable-extension-blacklist ");
		 */
		options.setExperimentalOption("prefs", prefs);

		// Launching browser with desired capabilities
		ChromeDriver driver = new ChromeDriver(options);

		// URL loading
		driver.get("https://www.seleniumhq.org/download/");

		// Click on download selenium server jar file
		driver.findElement(By.xpath("//p[text()='Download version ']/a")).click();

	}
}
