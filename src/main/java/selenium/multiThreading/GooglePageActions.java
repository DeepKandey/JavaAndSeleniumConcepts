/** @author Deepak Rai */
package selenium.multiThreading;

/** @author Deepak Rai */
class GooglePageActions extends BasePage {

  public GooglePageActions(String browserName) {
    setUp(browserName);
  }

  protected void navigateGoogle() {
    driver.get("https://www.google.com");
  }

  protected void tearDown() {
    driver.quit();
  }
}
