package managerTables;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class MainPage {
    public WebDriver wd;
    Logger logger = LoggerFactory.getLogger(MainPage.class);

    public MainPage(WebDriver wd) {
        PageFactory.initElements(wd, this);
        this.wd = wd;
    }

    @FindBy(xpath = "//*[@id='customers']")
    WebElement tabl;

    public MainPage getTableCell() {
        scrollPageDown();
        getTableCellText(tabl, 2, "Alfreds Futterkiste", 2);
        return this;
    }
    public MainPage verifyTableCellTextAssert(){
        Assert.assertTrue(verifyTableCellText(tabl, 2, "Alfreds Futterkiste", 2,"Germany"));
        return this;
    }
    public String getTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText) {
        String beforeCompanyXpath = "//*[@id='customers']/tbody/tr[";
        String afterCompanyXpath = "]/td[1]";
        String actualXpath = beforeCompanyXpath + searchColumn + afterCompanyXpath;
        WebElement elementCompany = wd.findElement(By.xpath(actualXpath));
        String afterXpathCountry = "]/td[3]";
        String actualPathCountry = beforeCompanyXpath + returnColumnText + afterXpathCountry;
        WebElement elementCountry = wd.findElement(By.xpath(actualPathCountry));
        System.out.println("The country name : " + elementCountry.getText());
        if (elementCompany.getText().equals(searchText))
            System.out.println("The company name : " + elementCompany.getText());
        return elementCountry.getText();
    }


    public boolean verifyTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText) {
        String beforeCompanyXpath =  "//*[@id='customers']/tbody/tr[";
        String afterCompanyXpath = "]/td[1]";
        String actualXpath = beforeCompanyXpath + searchColumn + afterCompanyXpath;
        WebElement elementCompany = wd.findElement(By.xpath(actualXpath));
        String afterXpathCountry = "]/td[3]";
        String actualPathCountry = beforeCompanyXpath + returnColumnText + afterXpathCountry;
        WebElement elementCountry = wd.findElement(By.xpath(actualPathCountry));
        if (elementCompany.getText().equals(searchText))
            System.out.println("The company name : " + elementCompany.getText());
        elementCompany.getText();
        return elementCountry.getText().equals(expectedText);
    }

    public String getXpath(int searchColumn, String searchText, int returnColumnText) throws Exception {
        String beforeCompanyXpath = "//*[@id='customers']/tbody/tr[";
        String afterCompanyXpath = "]/td[1]";
        String actualXpath = beforeCompanyXpath + searchColumn + afterCompanyXpath;
        WebElement elementCompany = wd.findElement(By.xpath(actualXpath));
        String afterXpathCountry = "]/td[3]";
        String actualPathCountry = beforeCompanyXpath + returnColumnText + afterXpathCountry;
        WebElement elementCountry = wd.findElement(By.xpath(actualPathCountry));
        System.out.println("The country name : " + elementCountry.getText());
        if (elementCompany.getText().equals(searchText))
            System.out.println("The company name : " + elementCompany.getText());
        return elementCountry.getText();
    }

    public void scrollPageDown() {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("arguments[0].scrollIntoView();", tabl);

    }


}
