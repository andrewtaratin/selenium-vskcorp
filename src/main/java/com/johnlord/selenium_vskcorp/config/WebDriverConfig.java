package com.johnlord.selenium_vskcorp.config;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class WebDriverConfig {
    public static ChromeDriver init() {
        String absolutePathToChromeDriver =
                new File("src/main/resources/chromedriver-win64-125.0.6422.141/chromedriver.exe").getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", absolutePathToChromeDriver);

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--enable"); //--enable - open browser OR --headless for silent version
        options.addArguments("--start-maximized");
        options.addArguments("--test-type");
        options.addArguments("--no-sandbox");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");
        options.addArguments("--disable-blink-features=AutomationControlled"); //disable boot driver
        options.addArguments("--disable-extensions-file-access-check");
        options.addArguments("user-data-dir=/home/anon/snap/chromium/common/chromium/Profile 1"); //ACTIVATE PROFILE
        //options.addArguments("--incognito");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications"); //delete "Chrome is being controlled by automated test software"
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); //delete "Chrome is being controlled by automated test software"

        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--remote-debugging-port=9225");

        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize(); //open browser for all monitor
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); //wait until the page opens
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //wait until web-element on page is loading
        return driver;
    }
}
