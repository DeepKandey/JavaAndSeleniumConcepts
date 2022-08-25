package seleniumPrograms;

import com.qa.base.BrowserNames;
import com.qa.base.TestBase;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinkConcept extends TestBase {

  @BeforeMethod
  public void setup() {
    initialization(BrowserNames.EDGE);
  }

  @AfterMethod
  public void tearDown() {
    closeDriver();
  }

  /**
   * {@summary verifyBrokenLinks}
   *
   * @param
   * @return
   * @author deepak rai
   */
  @Test
  public void verifyBrokenLinks() {

    driver.get("https://www.makemytrip.com/");

    // 1. Getting total number of links on the WebPage
    List<WebElement> linksList = driver.findElements(By.tagName("a"));
    linksList.addAll(driver.findElements(By.tagName("img")));
    System.out.println("Size of full list of links and images -->" + linksList.size());

    // 2. Iterating linksList and excluding the links/images which are not valid
    List<WebElement> activeLinksUsingLambda =
        linksList.stream()
            .filter(
                a ->
                    a.getAttribute("href") != null
                        && !a.getAttribute("href").contains("javascript"))
            .collect(Collectors.toList());

    System.out.println(
        "Size of active links and images using lambda-->" + activeLinksUsingLambda.size());

    // Using Lambda
    activeLinksUsingLambda.forEach(
        a -> {
          verifyLink(a.getAttribute("href"));
          System.lineSeparator();
        });
  }

  /**
   * {@summary verifyLink}
   *
   * @param urlLink
   * @return
   * @author deepak rai
   */
  public void verifyLink(String urlLink) {
    try {

      URL link = new URL(urlLink);
      HttpURLConnection httpCon = (HttpURLConnection) link.openConnection();
      httpCon.connect();

      if (httpCon.getResponseCode() == 200 || httpCon.getResponseCode() == 400) {
        System.out.println(
            urlLink + " -- " + httpCon.getResponseMessage() + " " + httpCon.getResponseCode());
      }
    } catch (Exception e) {
      System.out.print(urlLink + " ");
      e.printStackTrace();
    }
  }
}
