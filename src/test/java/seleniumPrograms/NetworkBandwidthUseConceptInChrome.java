package seleniumPrograms;

import com.google.common.collect.ImmutableMap;
import com.qa.base.BrowserNames;
import com.qa.base.TestBase;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NetworkBandwidthUseConceptInChrome extends TestBase {

  // data provider for the connection's download and upload throughput
  @DataProvider(name = "networkBandwidths")
  public Object[][] networkConditions() {
    return new Object[][] {
      {5000, 5000},
      {10000, 7000},
      {15000, 9000},
      {20000, 10000},
      {23000, 11000},
      {30000, 15000},
      {40000, 20000},
      {50000, 20000},
      {75000, 20000},
      {100000, 20000},
      {0, 0}
    };
  }

  @Test(dataProvider = "networkBandwidths")
  public void test(int downloadThroughput, int uploadThroughput) throws IOException {
    // Launch browser
    initialization(BrowserNames.CHROME);

    if (downloadThroughput > 0 && uploadThroughput > 0) {
      CommandExecutor executor = ((RemoteWebDriver) driver).getCommandExecutor();

      Map<String, Comparable> map = new HashMap<String, Comparable>();
      map.put("offline", false);
      map.put("latency", 5);
      map.put("download_throughput", downloadThroughput);
      map.put("upload_throughput", uploadThroughput);

      executor.execute(
          new Command(
              ((RemoteWebDriver) driver).getSessionId(),
              "setNetworkConditions",
              ImmutableMap.of("network_conditions", ImmutableMap.copyOf(map))));

      driver.get("http://google.com");

      driver.close();
    }
    driver.quit();
  }
}
