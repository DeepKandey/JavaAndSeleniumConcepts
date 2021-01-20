package seleniumPrograms;

import com.qa.base.BrowserNames;
import com.qa.base.TestBase;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SikuliConcept extends TestBase {

  @BeforeMethod
  public void setup() {
    initialization(BrowserNames.CHROME);
  }

  @Test
  public void flashObjectsControl() throws FindFailed {
    driver.get("https://www.youtube.com/watch?v=0Gew2XOuum8");

    Screen screen = new Screen();

    Pattern pauseImg =
        new Pattern(System.getProperty("user.dir") + "/src/test/resources/Images/YT_PAUSE.PNG");
    screen.wait(pauseImg, 2000);
    screen.click();
    screen.click();
    screen.click();

    Pattern playImg =
        new Pattern(System.getProperty("user.dir") + "/src/test/resources/Images/YT_PLAY.PNG");
    screen.wait(playImg, 2000);
    screen.click();

    Pattern settingImg =
        new Pattern(System.getProperty("user.dir") + "/src/test/resources/Images/YT_SETTING.PNG");
    screen.wait(settingImg, 2000);
    screen.click();

    Pattern qualityImg =
        new Pattern(System.getProperty("user.dir") + "/src/test/resources/Images/YT_QUALITY.PNG");
    screen.wait(qualityImg, 2000);
    screen.click();

    Pattern Img1080P =
        new Pattern(System.getProperty("user.dir") + "/src/test/resources/Images/YT_1080P.PNG");
    screen.wait(Img1080P, 2000);
    screen.click();
  }

  @AfterTest
  public void tearDown() {
    driver.close();
    driver.quit();
  }
}
