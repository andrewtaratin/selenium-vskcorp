package com.johnlord.selenium_vskcorp;

import com.johnlord.selenium_vskcorp.config.WebDriverConfig;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileNotFoundException;

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
        find("(//div[@class='p-accordion-header']//a)[2]").click();
        find("//label[@for='option-административные здания, офисы, помещения, кабинеты']").click();
        find("(//div[@class='p-accordion-header p-highlight']//a)[3]").click();

        find("(//input[@type='tel'])[5]").sendKeys("199"); //метры
        find("(//div[contains(@class,'app-checkbox mr-10')]//div)[2]").click(); //галочка

        scrollPage(); //слегка листаем страницу вниз

        //Действия чтобы нажать кнопку
        WebElement calculateButton = find("//button[@type='submit']//span");
        calculateButton.click();
        scrollPage(); //слегка листаем страницу вниз

        Thread.sleep(2000); //задержка перед закрытием страницы - ТОЛЬКО ДЛЯ РУЧНОГО ТЕСТИРОВАНИЯ!!!

        String calcSum = find("//div[contains(@class,'fs-24 c-p')]").getText();
        log.info("Sum of calculate: {}", calcSum);


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
}
