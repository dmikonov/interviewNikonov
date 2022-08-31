package managerCasino;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    public WebDriver wd;
    public void click(By locator){
        wd.findElement(locator);
    }
}
