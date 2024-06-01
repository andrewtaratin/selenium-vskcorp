## Плагин для оптимизации Xpath  
https://chromewebstore.google.com/detail/ruto-xpath-finder/ilcoelkkcokgeeijnopjnolmmighnppp?hl=ru 

---

## Найти элемент в подэлементе
Если вы начинаете выражение XPath с //, поиск начинается с корня документа. Чтобы выполнить поиск относительно
определенного элемента, вы должны добавить перед выражением . вместо:  
element2 = driver.find_element_by_xpath("//div[@title='div2']")  
element2.find_element_by_xpath(".//p[@class='test']").text

https://stackoverflow.com/questions/14049983/selenium-webdriver-finding-an-element-in-a-sub-element

---
## Прокрутка страницы вверх или вниз
WebDriver driver = new FirefoxDriver();  
JavascriptExecutor jse = (JavascriptExecutor)driver;  
jse.executeScript("window.scrollBy(0,250)");  
https://www.browserstack.com/guide/selenium-scroll-tutorial  
https://stackoverflow.com/questions/12293158/page-scroll-up-or-down-in-selenium-webdriver-selenium-2-using-java

---
## Как найти элемент по тексту
WebElement e = driver.findElement(By.xpath("//*[text()='Get started free']"));

WebElement addToFriend = friend.findElement(By.xpath(".//span[text() = ' Подписаться']"));

By.xpath("//*[@id=\"pjax-container\"]/section/div/div/div/div/div/div/div/div/div/div/div/div/div/span[1][contains(@data-hint, 'Репутация:')]"));  
https://www.browserstack.com/guide/find-element-by-text-using-selenium

---
## Найти все ссылки на странице
List<WebElement> elements = driver.findElements(By.xpath("//a[@href]"));  
List<String> href = elements.stream().map(m -> m.getAttribute("href")).collect(Collectors.toList());  
https://stackoverflow.com/questions/34759787/fetch-all-href-link-using-selenium-in-python

---