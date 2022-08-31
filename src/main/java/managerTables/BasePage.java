package managerTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver wd;
    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;

    }
    public BasePage(WebDriver wd){
        this.wd = wd;
        PageFactory.initElements(wd,this);
    }
    public void pause(int time)    {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
