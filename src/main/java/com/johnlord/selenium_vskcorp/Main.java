package com.johnlord.selenium_vskcorp;

import com.johnlord.selenium_vskcorp.config.WebDriverConfig;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final ChromeDriver driver = WebDriverConfig.init();

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        driver.get("https://vskcorp.ru/zb/");

        //Заполняем риски в формах - находим форму и потом посылаем "ключ"
        WebElement element = find("(//input[@type='tel'])[1]");
        element.sendKeys("200000");
        find("(//input[@type='tel'])[2]").sendKeys("200050");
        find("(//input[@type='tel'])[3]").sendKeys("200150");
        scrollPage(); //слегка листаем страницу вниз
        find("(//input[@type='tel'])[4]").sendKeys("200250");

        //Открываем выпадающий список "Выберите деятельность" и выбираем из предложенного и закрываем список чтобы не мешал
        enableClick(find("//a[@id='pv_id_6_header']//span[1]"));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        enableClick(find("(//div[@class='p-radiobutton-box'])[2]"));
        find("//a[@id='pv_id_6_header']//span[1]").click();

        find("(//input[@type='tel'])[5]").sendKeys("199"); //метры
        enableClick(find("(//div[contains(@class,'app-checkbox mr-10')]//div)[2]")); //галка

        scrollPage(); //слегка листаем страницу вниз

        //Действия чтобы нажать кнопку
        find("//span[text()='Рассчитать']").click();
        scrollPage(); //слегка листаем страницу вниз

        //получаем сумму со страницы
        String calcSum = find("//div[contains(@class,'fs-24 c-p')]").getText();
        log.info("Sum of calculate: {}", calcSum);

        //     Thread.sleep(2000); //задержка перед закрытием страницы - ТОЛЬКО ДЛЯ РУЧНОГО ТЕСТИРОВАНИЯ!!!

        //Внимание! Всегда надо закрывать тестовый браузер иначе программа будет работать некорректно
        driver.close(); //закрываем браузер чтобы освободить ресурсы.
    }

    private static WebElement find(String xPath) {
        return driver.findElement(By.xpath(xPath));
    }

    //слегка листаем страницу вниз
    private static void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,150)", "");
    }

    private static void enableClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }
}