/** @author Deepak Rai */
package com.qa.constants;

public class CommonConstants {

  private CommonConstants() {}

  public static final String DRIVERPATH_CHROME =
      "C:/Users/deepa/Downloads/BrowserDrivers/chromedriver.exe";

  public static final String DRIVERPATH_FIREFOX =
      "C:/Users/deepa/Downloads/BrowserDrivers/geckodriver.exe";

  public static final String DRIVERPATH_EDGE =
      "C:/Users/deepa/Downloads/BrowserDrivers/msedgedriver.exe";

  public static final String GRID_SERVER_PATH =
      "C:/Users/deepa/Downloads/BrowserDrivers/selenium-server-4.0.0-alpha-6.jar";

  public static String TESTDOCUMENT_FILEPATH =
      System.getProperty("user.dir") + "/src/test/resources/ExcelFiles/TestDocument.xlsx";

  public static String TESTNGSUITE_FILEPATH =
      System.getProperty("user.dir") + "/src/test/resources/ExcelFiles/testng-suite.xml";
} // End of class CommonConstants
