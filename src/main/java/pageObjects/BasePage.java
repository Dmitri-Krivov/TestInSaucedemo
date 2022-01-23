package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    //    Elements
    protected WebDriver driver;
    protected WebDriverWait wait;

    //    Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 30);
    }

    //    Methods
    public void fillText(WebElement element, String text) {
        waitUntilElementIsVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public void clickElement(WebElement element) {
        waitUntilElementVisibleAndClicable(element);
        element.click();
    }

    public void waitUntilElementVisibleAndClicable(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public String getElementText(WebElement element) {
        waitUntilElementIsVisible(element);
        return element.getText();
    }

    public void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean elementIsDisplayed(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void tearDown() {
        driver.quit();
    }
}
