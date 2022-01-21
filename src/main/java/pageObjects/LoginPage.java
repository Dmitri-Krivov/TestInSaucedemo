package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.ws.WebEndpoint;

public class LoginPage extends BasePage{
//    Elements
    By userName = By.cssSelector("[id = 'user-name']");
//    By password = By.cssSelector("[id = 'password']");
//    By errorMessage = By.cssSelector("[class = 'error-message-container']");
//    By loginButton = By.cssSelector("[class = 'user-name']");

//    You could do it in another way
    @FindBy (css = "[id = 'password']")
    WebElement password;
    @FindBy (css = "[class = 'error-message-container error']")
    WebElement errorMessage;
    @FindBy (css = "[id= 'login-button']")
    WebElement loginButton;
//    @FindBy (css = "[id = 'user-name']")
//    WebEndpoint userName

    public LoginPage(WebDriver driver) {
        super(driver);
    }

//    Methods
    public void checkIn(String userName, String password){
        fillUserName(userName);
        fillPasswordField(password);
    }

    public void fillUserName(String userData){
        fillText(driver.findElement(userName), userData);
    }

    public void fillPasswordField(String passData){
        fillText(password, passData);
    }

    public String getErrorMessage(){
        return getElementText(errorMessage);
    }
    public void clickNext(){
        clickElement(loginButton);
    }
}
