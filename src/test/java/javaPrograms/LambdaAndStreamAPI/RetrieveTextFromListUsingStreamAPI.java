package javaPrograms.LambdaAndStreamAPI;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class RetrieveTextFromListUsingStreamAPI extends TestBase {

	@BeforeMethod
	public void setUp() {
		initialization("chrome");
	}

	@Test
	public void retriveTextFromWebElementsUsingStreamAPI() throws InterruptedException {
		// Navigating to Google URL
		driver.get("https://www.google.com/");
		// Creating List of string to hold Google Application names
		List<String> allGoogleAppsName = new ArrayList<>();

		// Click on Google Applications link
		driver.findElement(By.xpath("//a[@title='Google apps']")).click();
		// Take list of all Google Applications names link
		List<WebElement> listOfGoogleApps = driver.findElements(By.xpath("//*[@class='gb_t']"));
		Thread.sleep(5000);
		// Add all the link names to allGoogleAppsName list using Stream API
		listOfGoogleApps.stream().forEach(app -> allGoogleAppsName.add(app.getText()));

		// Print out application names
		System.out.println("All product names are: ");
		allGoogleAppsName.forEach(name -> System.out.println(name));
	}

	@AfterMethod
	public void tearDown() {
		close();
	}
}