package seleniumPrograms;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class GridBasicConcept {

  private static final String HUB = " hub";
  private static final String NODE = " node";
  private static final String HUB_URL = "http://localhost:4444/";
  private static final String URL_TO_NAVIGATE = "https://www.google.com/";
  private static final String PATH = "/Users/deepa/Downloads/BrowserDrivers";

  public static void closeGridServer() throws IOException {

    Process process = Runtime.getRuntime().exec("cmd /c netstat -ano | findstr :4444");

    BufferedReader lineReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    List<String> list =
        lineReader
            .lines()
            .map(str -> str.substring(str.indexOf("LISTENING") + ("LISTENING").length()).trim())
            .distinct()
            .collect(Collectors.toList());

    if (!list.isEmpty()) {

      for (int i = 0; i < list.size(); i++) {
        Process process1 = Runtime.getRuntime().exec("cmd /c taskkill /pid " + list.get(i) + " /f");
        BufferedReader lineReader1 =
            new BufferedReader(new InputStreamReader(process1.getInputStream()));
        lineReader1.lines().forEach(System.out::println);
      }
    }
  }

  @BeforeClass
  public void startGridServer() throws IOException {

    closeGridServer();

    ProcessBuilder b = new ProcessBuilder();
    b.directory(new File(PATH));
    b.command("cmd", "/k", "start" + " java -jar selenium-server-4.0.0-alpha-6.jar standalone")
        .start();
  }

  @Test()
  public static void gridOnFirefoxTest() throws IOException {

    //		closeGridServer();
    //		Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + "java -jar " +
    // CommonConstants.GRID_SERVER_PATH + HUB);
    //
    //		Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + "java -Dwebdriver.gecko.driver="
    //				+ CommonConstants.DRIVERPATH_FIREFOX + " -jar " + CommonConstants.GRID_SERVER_PATH +
    // NODE);

    DesiredCapabilities cap = new DesiredCapabilities();
    cap.setPlatform(Platform.WINDOWS);

    cap.setBrowserName(String.valueOf(Browser.FIREFOX));
    FirefoxOptions options = new FirefoxOptions();
    options.merge(cap);

    WebDriver driver = new RemoteWebDriver(new URL(HUB_URL), options);
    driver.manage().window().maximize();

    driver.get(URL_TO_NAVIGATE);
    System.out.println("WebPage Title: " + driver.getTitle());
    driver.quit();
  }

  @Test()
  public static void gridOnChromeTest() throws IOException {

    //		closeGridServer();
    //		Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + "java -jar " +
    // CommonConstants.GRID_SERVER_PATH + HUB);
    //
    //		Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + "java -Dwebdriver.chrome.driver="
    //				+ CommonConstants.DRIVERPATH_CHROME + " -jar " + CommonConstants.GRID_SERVER_PATH + NODE);

    DesiredCapabilities cap = new DesiredCapabilities();
    cap.setPlatform(Platform.WINDOWS);

    cap.setBrowserName(String.valueOf(Browser.CHROME));
    ChromeOptions options = new ChromeOptions();
    options.merge(cap);

    WebDriver driver = new RemoteWebDriver(new URL(HUB_URL), options);
    driver.manage().window().maximize();

    driver.get(URL_TO_NAVIGATE);
    System.out.println("WebPage Title: " + driver.getTitle());
    driver.quit();
  }

  @Test()
  public static void gridOnEdgeTest() throws IOException {

    //		closeGridServer();
    //		Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + "java -jar " +
    // CommonConstants.GRID_SERVER_PATH + HUB);
    //
    //		Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + "java -Dwebdriver.edge.driver="
    //				+ CommonConstants.DRIVERPATH_EDGE + " -jar " + CommonConstants.GRID_SERVER_PATH + NODE);

    DesiredCapabilities cap = new DesiredCapabilities();
    cap.setPlatform(Platform.WINDOWS);

    cap.setBrowserName(String.valueOf(Browser.EDGE));
    EdgeOptions options = new EdgeOptions();
    options.merge(cap);

    WebDriver driver = new RemoteWebDriver(new URL(HUB_URL), options);
    driver.manage().window().maximize();

    driver.get(URL_TO_NAVIGATE);
    System.out.println("WebPage Title: " + driver.getTitle());
    driver.quit();
  }
}
