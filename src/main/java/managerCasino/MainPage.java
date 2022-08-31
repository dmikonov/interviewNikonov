package managerCasino;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPage extends BasePage{
@FindBy(xpath = "//div[@class='cgp-layout-buttons-form-popup']")
WebElement rightCornerButton;

    public WebDriver wd;

    public MainPage(WebDriver wd){
        PageFactory.initElements(wd,this);
    }

    public MainPage clickOnCornerScreen(){
        rightCornerButton.click();
        return this;
    }
    public MainPage buttonLanguageIsPresentAssert(){
       Assert.assertFalse(rightCornerButton.isDisplayed());
       return this;
    }
    public MainPage setLanguage(String language){
        String locator = String.format("//*[@lang=' %s ']",language);
        click(By.xpath(locator));
        return this;
    }

}
