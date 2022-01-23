package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.Urls;

public class FillLogInForm {
    public static void main(String[] args) {
//        Create WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Urls.BASE_URL);

//        LoginPage
         LoginPage loginPage = new LoginPage(driver);
         loginPage.sleep(1000);
         loginPage.clickNext();
         Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username is required", "Error message is incorrect");
         loginPage.checkIn("standard_user", "secret_sauce");
         loginPage.sleep(1000);

//       ProductsPage
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.elementOnThePage());
        Assert.assertEquals(productsPage.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Address is incorrect");
        productsPage.sleep(1000);
        productsPage.tearDown();
    }
}
