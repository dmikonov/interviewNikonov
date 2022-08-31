package tablesTests;

import managerTables.MainPage;
import managerTables.MyDataProvider;
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
    Logger logger = LoggerFactory.getLogger(Test.class);

    @BeforeClass
    public void init() {
        wd = new ChromeDriver();
        WebDriverListener listener = new MyListenerTables();
        wd = new EventFiringDecorator(listener).decorate(wd);
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.navigate().to("http://www.w3schools.com/html/html_tables.asp");
        logger.info("Current URL ---> " + wd.getCurrentUrl());
    }

    @AfterClass
    public void tearDown() {
        wd.quit();
    }

    @BeforeMethod
    public void startLogger(Method m) {
        logger.info("Start method with name ->>" + m.getName());
    }

    @org.testng.annotations.Test
    public void searchVerify() {
        new MainPage(wd)
                .getTableCell()
                .verifyTableCellTextAssert();
    }

    @org.testng.annotations.Test(dataProvider = "dataSearch", dataProviderClass = MyDataProvider.class)
    public void searchDataProvider(int searchColumn, String searchText, int returnColumnText) throws Exception {
        new MainPage(wd)
                .getXpath(searchColumn, searchText, returnColumnText);
    }


}
