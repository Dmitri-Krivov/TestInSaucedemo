package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage{
//    Elements
    @FindBy (css = "[class = 'title']")
    WebElement title;

//    Constructor
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

//    Methods
    public boolean elementOnThePage(){
    return elementIsDisplayed(title);
    }
}
