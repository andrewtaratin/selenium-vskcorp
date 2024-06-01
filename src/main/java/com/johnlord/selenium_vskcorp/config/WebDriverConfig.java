package com.johnlord.selenium_vskcorp.config;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class WebDriverConfig {
    public static ChromeDriver init() {
        String absolutePathToChromeDriver =
                new File("src/main/resources/chromedriver-125.0.6422.141/chromedriver").getAbsolutePath();

        System.setProperty("webdriver.chrome.driver",absolutePathToChromeDriver);

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--enable"); //--enable - open browser OR --hidden for silent version
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
        return driver;
    }
}
