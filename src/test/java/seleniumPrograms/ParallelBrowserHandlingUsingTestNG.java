package seleniumPrograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelBrowserHandlingUsingTestNG {

	WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Launching " + browserName + " browser");
			driver.manage().window().maximize();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Launching " + browserName + " browser");
		} else if (browserName.equalsIgnoreCase("Edge")) {
			EdgeDriverService service = EdgeDriverService.createDefaultService();
			driver = new EdgeDriver(service);
			System.out.println("Launching " + browserName + " browser");
		}
	}

	@Test
	public void openAndCloseBrowser() {
		driver.get("https://www.youtube.com/watch?v=K8j4yC98EtA");
		System.out.println("Test Case Exceuted");
	}

	@AfterMethod
	@Parameters("browser")
	public void end(String browserName) {
		System.out.println("Closing " + browserName + " browser");
		driver.quit();
	}
}
