package seleniumPrograms;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridBasicConcept {

	public static void main(String[] args) throws IOException {

		Process processForHub = Runtime.getRuntime().exec("cmd /c start cmd.exe /K "
				+ "java -jar C:/Users/deepa/Downloads/BrowserDrivers/selenium-server-4.0.0-alpha-6.jar hub");

		Process processForNode_FF = Runtime.getRuntime().exec("cmd /c start cmd.exe /K "
				+ "java -Dwebdriver.gecko.driver=\"/Users/deepa/Downloads/BrowserDrivers/FireFoxDrivers/geckodriver.exe\" -jar C:/Users/deepa/Downloads/BrowserDrivers/selenium-server-4.0.0-alpha-6.jar node");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setPlatform(Platform.WINDOWS);

		// Chrome
//		cap.setBrowserName("chrome");
//		ChromeOptions options = new ChromeOptions();
//		options.merge(cap);

		// firefox
		cap.setBrowserName("firefox");
		FirefoxOptions options = new FirefoxOptions();
		options.merge(cap);

		String hubUrl = "http://localhost:4444/wd/hub";

		WebDriver driver = new RemoteWebDriver(new URL(hubUrl), options);

		driver.manage().window().maximize();
		driver.get("https://www.google.com/");

		System.out.println("WebPage Title: " + driver.getTitle());

		driver.quit();

		processForHub.destroyForcibly();
		processForNode_FF.destroyForcibly();
		
		Runtime.getRuntime().exec("cmd /c exit cmd.exe");
	}
}