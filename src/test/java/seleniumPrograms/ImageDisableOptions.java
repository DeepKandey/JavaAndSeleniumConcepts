package seleniumPrograms;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class ImageDisableOptions {

	public static void main(String[] args) {

		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\deepa\\Downloads\\Browser Drivers\\Chrome Drivers\\chromedriver_win.exe"
		 * );
		 * 
		 * ChromeOptions options = new ChromeOptions(); disableImageChrome(options);
		 * 
		 * WebDriver driver = new ChromeDriver(options);
		 */

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\deepa\\Downloads\\Browser Drivers\\FireFoxDrivers\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		disableImageFireFox(options);
		WebDriver driver = new FirefoxDriver(options);

		driver.get("https://www.amazon.in");
		System.out.println(driver.getTitle());
	}

	private static void disableImageChrome(ChromeOptions options) {
		HashMap<String, Object> images = new HashMap<String, Object>();
		images.put("images", 2);
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values", images);

		options.setExperimentalOption("prefs", prefs);
	}

	private static void disableImageFireFox(FirefoxOptions options) {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("permissions.default.image", 2);
		options.setProfile(profile);
		options.setCapability(FirefoxDriver.PROFILE, profile);
	}

}
