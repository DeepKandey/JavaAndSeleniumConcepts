package seleniumPrograms;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JqueryGrowlConcept {
	static WebDriver driver;
	static JavascriptExecutor js;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\deepa\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		js = (JavascriptExecutor) driver;
	}

	@AfterMethod
	public void tearDown() {
	    driver.quit();
	}
	
	@Test
	public void growlTest() throws InterruptedException, IOException {
		driver.get("http://freecrm.com/");
		String title =driver.getTitle();
		System.out.println(title);
		getRunTimeInfo("info", title);
		
		if(title.equals("Free CRM software in the cloud powers sales and customer serviceooo")) {
			getRunTimeInfo("info", "title is correct. YAY! YAY! ");
			Assert.assertTrue(true);
		}else {
			getRunTimeInfo("error", "title is not correct. BUG! BUG! ");
			takeScreenshot("TitleError");
			Assert.assertTrue(false);	
		}
	}		
	
	public static void getRunTimeInfo(String messageType,String message) throws InterruptedException {
		// Check for jQuery on the page, add it if need be
	    js.executeScript("if (!window.jQuery) {"
					+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
					+ "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
					+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
		Thread.sleep(2000);

		// Use jQuery to add jquery-growl to the page
		js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");
		
		// Use jQuery to add jquery-growl styles to the page
		js.executeScript("$('head').append('<link rel=\"stylesheet\" "
					+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
		Thread.sleep(2000);
		
		if(messageType.equals("error")) {
			js.executeScript("$.growl.error({ title: 'ERROR', message: '"+ message + "' });");
		}else if(messageType.equals("info")) {
			js.executeScript("$.growl.notice({ title: 'Notice', message: '" + message + "' });");
		}else if(messageType.equals("warning")) {
			js.executeScript("$.growl.warning({ title: 'Warning!', message: '" + message + "' });");
	   }
	}
    
		/*// jquery-growl w/ no frills
		js.executeScript("$.growl({ title: 'GET', message: '/' });");

	 // jquery-growl w/ colorized output
		js.executeScript("$.growl.error({ title: 'ERROR', message: 'Some exception is coming' });");
		js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
		js.executeScript("$.gro;wl.warning({ title: 'Warning!', message: 'your warning message goes here' });");*/
	
	public static void takeScreenshot(String fileName) throws IOException {
		//take Screenshot and store it in file format
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//now copy the file to the desired location using copyFile method
		FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "\\" + fileName + ".png"));
	}
}
