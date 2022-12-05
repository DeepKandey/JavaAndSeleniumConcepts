package seleniumPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DownloadDirInChrome {

    @Test
    public void downloadDirInChrome() {

        // Setting new download directory path
        Map<String, Object> chromePrefs = new HashMap<String, Object>();

        // Use File.separator as it will work on any OS
        // chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("download.directory_upgrade", true);
        //	chromePrefs.put("safebrowsing_for_trusted_sources_enabled", false);
        chromePrefs.put("download.extensions_to_open", "application/java-archive");
        chromePrefs.put("download.extensions_to_open", "application/x-java-archive");
        chromePrefs.put("download.extensions_to_open", "application/x-jar");
        chromePrefs.put("safebrowsing.enabled", false);
        chromePrefs.put(
                "download.default_directory",
                System.getProperty("user.dir")
                        + File.separator
                        + "externalFiles"
                        + File.separator
                        + "downloadFiles");
        // chromePrefs.put("automatic_downloads", "https://www.selenium.dev");

        // Adding capabilities to ChromeOptions
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        // chromeOptions.addArguments("--test-type");
        // chromeOptions.addArguments("--disable-extensions"); // to disable browser
        // extension popup
        // chromeOptions.addArguments("--disable-gpu");
        // chromeOptions.addArguments("--disable-software-rasterizer");
        // chromeOptions.addArguments("--browser.download.folderList=2");
        // chromeOptions.addArguments("--browser.helperApps.neverAsk.saveToDisk=application/java-archive");

        chromeOptions.addArguments("--safebrowsing-disable-download-protection");
        // chromeOptions.addArguments("--safebrowsing-manual-download-blacklist");
        chromeOptions.addArguments("safebrowsing-disable-extension-blacklist");

        // Launching browser with desired capabilities
        ChromeDriver driver = new ChromeDriver(chromeOptions);

        // URL loading
        driver.get("https://www.selenium.dev/downloads/");

        // Click on download selenium server jar file
        driver.findElement(By.xpath("//p[normalize-space(text())='Latest stable version']/a")).click();
    }
} // End of class DownloadDirInChrome
