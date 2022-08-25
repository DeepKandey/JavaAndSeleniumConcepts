package seleniumPrograms;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.qa.base.BrowserNames;
import com.qa.base.TestBase;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BarCodeReader extends TestBase {

  @BeforeTest
  public void setup() {
    initialization(BrowserNames.CHROME);
  }

  @AfterTest
  public void tearDown() {
    closeDriver();
  }

  @Test
  public void readTextInBarCode() throws IOException, NotFoundException {
    driver.get("https://barcode.tec-it.com/en");
    String barCodeLink =
        driver
            .findElement(By.className("barcode"))
            .findElement(By.tagName("img"))
            .getAttribute("src");
    System.out.println("Bar Code Link--> " + barCodeLink);

    URL url = new URL(barCodeLink);
    BufferedImage bufferedImage = ImageIO.read(url);

    LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
    Result result = new MultiFormatReader().decode(bitmap);
    System.out.println("Result Object--> " + result);
    System.out.println("Text in Bar Code--> " + result.getText());
  }
}
