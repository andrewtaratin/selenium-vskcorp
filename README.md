[WebDriverConfig.java](src%2Fmain%2Fjava%2Fcom%2Fjohnlord%2Fselenium_vskcorp%2Fconfig%2FWebDriverConfig.java) - класс с настройками Селениума  
[build.gradle](build.gradle) - здесь добавляются/обновляются библиотеки по проекту (Selenium, Junit, TestNG, Rest Assured и другие)  
[chromedriver-125.0.6422.141](src%2Fmain%2Fresources%2Fchromedriver-125.0.6422.141) - здесь лежит хром драйвер (нужен для запуска браузера)  
[application.properties](src%2Fmain%2Fresources%2Fapplication.properties) - сюда можно записывать какие-то глобальные переменные (примеры будут позже)

See also:
- xpath.md - подсказки по Xpath
- hotkeys.md - горячие клавиши в идее

Что нужно для сборки:  
1) Intellij Community
2) Java 17  
3) перейти в идею и нажать в левом верхнем углу file - new - project from version control  
4) вставить туда ссылку
5) дождаться когда идея всё скачает
6) проверить что граддл настроен правильно file - settings - Build - Build tools - Gradle: проверить что в строчке Gradle Jvm стоит 17 джава
7) скачать свой вебдрайвер под версию своего браузера и вставить его в папку resources
8) прописать в классе WebDriverConfig свой путь до папки с вебдрайвером (пример места где нужно изменить путь - ниже)
   WebDriverConfig {
   public static ChromeDriver init() {
   String absolutePathToChromeDriver =
   new File("src/main/resources/chromedriver-125.0.6422.141/chromedriver").getAbsolutePath();
9) Перейти в класс Main и нажать в зелёный треугольник чтобы запустить программу
