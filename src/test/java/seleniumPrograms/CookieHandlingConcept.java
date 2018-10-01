package seleniumPrograms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CookieHandlingConcept {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\deepa\\Downloads\\Drivers\\FireFoxDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();

		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\deepa\\Downloads\\chromedriver.exe"); driver = new
		 * ChromeDriver();
		 */

	}

	@Test
	public void getCookie() throws InterruptedException, IOException {
		driver.get("https://www.taggdigital.com/");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//ul[@class='main-navigation']//a[@href='#']"))).build()
				.perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("descendant::a[@data-target='#login_popup'][2]")));
		driver.findElement(By.xpath("descendant::a[@data-target='#login_popup'][2]")).click();

		driver.findElement(By.id("email")).sendKeys("Deepakggsipu@gmail.com");
		driver.findElement(By.id("password")).sendKeys("TAGG123");
		driver.findElement(By.id("loginsubmit")).click();

		// Getting Excel Sheet
		FileInputStream fis = new FileInputStream("C:\\Users\\deepa\\Downloads\\TestDocument.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int index = workbook.getSheetIndex("Cookie");
		XSSFSheet sheet = workbook.getSheetAt(index);

		// Print Cookies
		Set<Cookie> cookiesSet = driver.manage().getCookies();
		System.out.println(cookiesSet);
		for (Cookie cookie : cookiesSet) {
			System.out.println("Name-->" + cookie.getName() + "  Value-->" + cookie.getValue() + "  Domain-->"
					+ cookie.getDomain() + "  Path-->" + cookie.getPath() + "  Expiry-->" + cookie.getExpiry()
					+ "  Is Secure-->" + cookie.isSecure() + "  IsHttp-->" + cookie.isHttpOnly());

			int totalNoRows = sheet.getLastRowNum();
			XSSFRow row = sheet.createRow(totalNoRows + 1);
			row.createCell(0).setCellValue(cookie.getName());
			row.createCell(1).setCellValue(cookie.getValue());
			row.createCell(2).setCellValue(cookie.getDomain());
			row.createCell(3).setCellValue(cookie.getPath());
			row.createCell(4).setCellValue(cookie.getExpiry());
			row.createCell(5).setCellValue(cookie.isSecure());
			row.createCell(6).setCellValue(cookie.isHttpOnly());
			FileOutputStream out = new FileOutputStream("C:\\Users\\deepa\\Downloads\\TestDocument.xlsx");
			workbook.write(out);
		}
		workbook.close();
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
