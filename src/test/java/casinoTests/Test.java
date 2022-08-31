package casinoTests;

import managerCasino.MainPage;
import managerTables.MyListenerTables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.Duration;

public class Test {
    WebDriver wd;
    Logger logger = LoggerFactory.getLogger(tablesTests.Test.class);

    @BeforeClass
    public void init() {
        wd = new ChromeDriver();
        WebDriverListener listener = new MyListenerTables();
        wd = new EventFiringDecorator(listener).decorate(wd);
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.navigate().to("https://www.777.com");
        logger.info("Current URL ---> " + wd.getCurrentUrl());
    }

    @BeforeMethod
    public void startLogger(Method m) {
        logger.info("Start method with name ->>" + m.getName());
    }

    @org.testng.annotations.Test
    public void checkLanguage() {
        new MainPage(wd)
                .clickOnCornerScreen()
                .setLanguage("he")
                .buttonLanguageIsPresentAssert();
    }

    @AfterClass
    public void tearDown() {
        wd.quit();
    }
}
