package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends CommonsElements{

    //    Elements
    @FindBy (css = "[class = 'title']")
    private WebElement title;

    @FindBy(css = "[class='inventory_item_name']")
    private List<WebElement> productsTitles;

    @FindBy(css = "[class='btn btn_primary btn_small btn_inventory']")
    private List<WebElement> buttonAddToCart;

    @FindBy(css = "[class='shopping_cart_link']")
    private WebElement shoppingCartButton;

    @FindBy(css = "[class='social_twitter']")
    private WebElement twitterButton;

    @FindBy(css = "[class='social_facebook']")
    private WebElement facebookButton;

    @FindBy(css = "[class='social_linkedin']")
    private WebElement linkedinButton;

    @FindBy(css = "[class='shopping_cart_badge']")
    WebElement cartItemsCounter;

    @FindBy(css = "[id='react-burger-menu-btn']")
    WebElement sandwichButton;

    @FindBy(css = "[id='inventory_sidebar_link']")
    WebElement allItemsSidebarOption;

    @FindBy(css = "[id='about_sidebar_link']")
    WebElement aboutSidebarOption;

    @FindBy(css = "[id='logout_sidebar_link']")
    WebElement logoutSidebarOption;

    @FindBy(css = "[id='reset_sidebar_link']")
    WebElement resetSidebarOption;

    //Methods
    public void openCart() {
        clickElement(shoppingCartButton);
    }

    public void addToCart(Integer num) {
        clickElement(buttonAddToCart.get(num));
    }



    public void clickLinkedin() {
        clickElement(linkedinButton);
    }

    public void clickFacebook() {
        clickElement(facebookButton);
    }

    public void clickTwitter() {
        clickElement(twitterButton);
    }



//    Constructor
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

//    Methods
    public boolean elementOnThePage(){
    return elementIsDisplayed(title);
    }
}
