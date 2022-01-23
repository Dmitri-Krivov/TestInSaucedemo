package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;

public class FillLogInForm2 extends BaseTest{
    @Test
    public void testFillForm(){
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
    }
}
