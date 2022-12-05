package seleniumPrograms;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.qa.constants.CommonConstants;
import java.io.FileOutputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GenerateScreenshotPDF {
  WebDriver driver;

  @BeforeTest
  public void setup() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  @Test
  public void screenshotInPDF() throws Exception {

    driver.get("https://www.google.com");
    // Capture Screenshot and store it in byte[] array format
    byte[] input = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    Document document = new Document();
    String output = System.getProperty("user.dir") + "\\Image" + ".pdf";
    FileOutputStream fos = new FileOutputStream(output);

    // Instantiate the PDF writer
    PdfWriter writer = PdfWriter.getInstance(document, fos);

    // Open the PDF for Writing
    writer.open();
    document.open();

    // Process content into image
    Image img = Image.getInstance(input);

    // set the size of the image
    img.scaleToFit(PageSize.A4.getWidth() / 2, PageSize.A4.getHeight() / 2);

    // Add the captured image to PDF
    document.add(img);
    document.add(new Paragraph(""));

    // close the files and write to the local system
    document.close();
    writer.close();
  }

  @AfterTest
  public void tearDown() {
    driver.quit();
  }
}
