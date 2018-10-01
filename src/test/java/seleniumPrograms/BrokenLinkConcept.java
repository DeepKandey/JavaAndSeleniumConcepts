package seleniumPrograms;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinkConcept {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepa\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null)
			driver.quit();
	}

  @Test
  public void verifyBrokenLinks() {
	  // driver.get("https://www.thetrainline.com/");
	  driver.get("https://www.makemytrip.com/");
	  
	  //1. Getting total number of links on the WebPage
	  List<WebElement> linksList = driver.findElements(By.tagName("a"));
	  linksList.addAll(driver.findElements(By.tagName("img")));
	  System.out.println("Size of full list of links and images -->" + linksList.size());
	  
	  List<WebElement> activeLinks =new ArrayList<WebElement>();
	  
	  //2. Iterating linksList and excluding the links/images which does not have valid href attribute  
	  for(int j=0;j<linksList.size();j++) {
		  if(linksList.get(j).getAttribute("href")!=null && (!linksList.get(j).getAttribute("href").contains("javascript"))) {
			  activeLinks.add(linksList.get(j));
		  }
	  }
	  System.out.println("Size of active links and images -->" + activeLinks.size());
	  
	  for(int i=0;i<activeLinks.size();i++) {
		  String url = activeLinks.get(i).getAttribute("href");
		  System.out.print(i + ":" ); 
		  verifyLink(url);
		  System.lineSeparator();
	  }
  }
  
  public void verifyLink(String urlLink) {
	  try {
		  URL link= new URL(urlLink);
		  HttpURLConnection httpCon=(HttpURLConnection)link.openConnection();
		  httpCon.connect();
		  if(httpCon.getResponseCode()==200) {
			  System.out.println(urlLink+ " -- " + httpCon.getResponseMessage());
		  }
		  if(httpCon.getResponseCode()==400) {
			  System.out.println(urlLink+ " -- " + httpCon.getResponseMessage());
		  }
	  }
	  catch(Exception e) {
		  System.out.print(urlLink + " ");
		  e.printStackTrace();
	  }
  }
}
