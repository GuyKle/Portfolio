package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ResultsPage {
//    private static String PAGE_URL="http://www.lieferando.de";
    private WebDriver browser;

    public ResultsPage(WebDriver browser){
        this.browser=browser;
//        browser.get(PAGE_URL+);
        //Initialise Elements
        PageFactory.initElements(browser, this);
    }

    //page objects
    @FindBy(id="dropdown-location")
    WebElement PO_locationDropDown;

    //getters and setters

    //returns a list of suggestions based on the search text
    public String getLocation (){
        try {
            WebDriverWait wait = new WebDriverWait(browser, 10);
            wait.until(ExpectedConditions.visibilityOfAllElements(PO_locationDropDown));
        }
        catch (NoSuchElementException e)
        {
            System.out.println("location dropdown did not appear within 10 seconds");
        }
        return PO_locationDropDown.getText();
    }


    public String getPageTitle() {
        return browser.getTitle();
    }
}
