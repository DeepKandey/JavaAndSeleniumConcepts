package seleniumPrograms;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MakeMyTrip {
	WebDriver driver;
	EventFiringWebDriver eventDriver;
	EventHandler eventHandler;
	final static Logger log = Logger.getLogger(MakeMyTrip.class);
	
	@BeforeMethod
	public void setup() {
		ChromeOptions option = new ChromeOptions();
	    // option.addArguments("--disable-notifications"); --disable browser notifications
	    option.addArguments("--disable-infobars"); //--disable info bar-that chrome is controlled by automated test s/w  
	        
	    //To accept notifications
        Map<String, Object> prefs=new HashMap<String,Object>();
        prefs.put("profile.default_content_setting_values.notifications", 1);
        //1-Allow, 2-Block, 0-default
        option.setExperimentalOption("prefs",prefs); 
        
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepa\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver(option);
		eventDriver = new EventFiringWebDriver(driver);
		eventHandler = new EventHandler();
		eventDriver.register(eventHandler);
		driver = eventDriver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() {
		if(driver!=null)
			driver.quit();
		eventDriver.unregister(eventHandler);
	}
	
    @Test
	public void flightSearch() throws InterruptedException {
		driver.get("https://www.makemytrip.com");
		
		//Entering Departure Location
		driver.findElement(By.id("hp-widget__sfrom")).click();
		String scriptForDeparture = "return document.getElementById(\"hp-widget__sfrom\").value;";
		JavascriptExecutor js =(JavascriptExecutor)driver;
	    Object departureLocation =js.executeScript(scriptForDeparture);
	    log.info("Default Departure Location: "+departureLocation);
	    
		driver.findElement(By.id("hp-widget__sfrom")).sendKeys("Mumbai");
		while(!js.executeScript(scriptForDeparture).equals("Mumbai")) {
			driver.findElement(By.id("hp-widget__sfrom")).clear();
			driver.findElement(By.id("hp-widget__sfrom")).sendKeys("Mumbai");
		}
		Thread.sleep(1000);
		driver.findElement(By.id("hp-widget__sfrom")).sendKeys(Keys.ENTER);
			
		//Entering Destination Location
		driver.findElement(By.id("hp-widget__sTo")).click();
		String scriptForDestination = "return document.getElementById(\"hp-widget__sTo\").value;";
		
	    driver.findElement(By.id("hp-widget__sTo")).sendKeys("Patna");
	    while(!js.executeScript(scriptForDestination).equals("Patna")) {
			driver.findElement(By.id("hp-widget__sTo")).clear();
			driver.findElement(By.id("hp-widget__sTo")).sendKeys("Patna");
		}
	    Thread.sleep(1000);
	    driver.findElement(By.id("hp-widget__sTo")).sendKeys(Keys.TAB);
	    
	    log.info("Entered Departure Location: "+ js.executeScript(scriptForDeparture));
	    log.info("Entered Destination Location: "+ js.executeScript(scriptForDestination));
		
		//Selecting Departure date
		driver.findElement(By.id("hp-widget__depart")).click();
		
		while(!driver.findElement(By.xpath("descendant::div[@class ='ui-datepicker-title'][1]/span[@class='ui-datepicker-month']")).getText().contains("OCTOBER")) {
			driver.findElement(By.xpath("descendant::a[@data-handler='next'][1]//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
		int daysInDepartureMonth=driver.findElements(By.xpath("descendant::table[@class='ui-datepicker-calendar'][1]//td[@data-handler='selectDay']")).size();
		
		for(int i=0;i<daysInDepartureMonth;) {
			if(driver.findElements(By.xpath("descendant::table[@class='ui-datepicker-calendar'][1]//td[@data-handler='selectDay']")).get(i).getText().equals("11")) {
				log.info("Departure Date Selected : " + driver.findElement(By.xpath("descendant::div[@class ='ui-datepicker-title'][1]/span[@class='ui-datepicker-month']")).getText() + " " + driver.findElements(By.xpath("descendant::table[@class='ui-datepicker-calendar'][1]//td[@data-handler='selectDay']")).get(i).getText());
				driver.findElements(By.xpath("descendant::table[@class='ui-datepicker-calendar'][1]//td[@data-handler='selectDay']")).get(i).click();	
				break;
			}
			i++;
		}
		
		//Selecting Return date
		driver.findElement(By.id("hp-widget__return")).click();
				
		while(!driver.findElement(By.xpath("descendant::div[@class ='ui-datepicker-title'][3]/span[@class='ui-datepicker-month']")).getText().contains("OCTOBER")) {
			driver.findElement(By.xpath("descendant::a[@data-handler='next'][2]//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
				
		int daysInReturnMonth=driver.findElements(By.xpath("descendant::table[@class='ui-datepicker-calendar'][3]//td[@data-handler='selectDay']")).size();
				
		for(int i=0;i<daysInReturnMonth;) {
		    if(driver.findElements(By.xpath("descendant::table[@class='ui-datepicker-calendar'][3]//td[@data-handler='selectDay']")).get(i).getText().equals("15")) {
		    	log.info("Return Date Selected : " + driver.findElement(By.xpath("descendant::div[@class ='ui-datepicker-title'][3]/span[@class='ui-datepicker-month']")).getText() + " " + driver.findElements(By.xpath("descendant::table[@class='ui-datepicker-calendar'][3]//td[@data-handler='selectDay']")).get(i).getText());
		    	driver.findElements(By.xpath("descendant::table[@class='ui-datepicker-calendar'][3]//td[@data-handler='selectDay']")).get(i).click();		    	
		    	break;
		    }
		    i++;
		}
		
		driver.findElement(By.id("searchBtn")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='pull-right modify_search_toggle ng-scope']/span[2]")));
		
		//Verifying title
		String title =driver.getTitle();
		Assert.assertEquals(title, "Flight Split Listing View", "Title mismatch");
    }
}
