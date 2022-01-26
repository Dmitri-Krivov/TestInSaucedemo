package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCartPage extends BasePage{
    public YourCartPage(WebDriver driver) {
        super(driver);
    }
//Elements
    @FindBy(css = "[class='cart_quantity_label']")
    private WebElement QTY;

    @FindBy(css = "[id='checkout']")
    private WebElement checkoutButton;



//Method
    public void performCheckout() {
        clickElement(checkoutButton);
    }
    public boolean elementOnThePage(){
        return elementIsDisplayed(QTY);
    }

}
