package tests.FunctionalTests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Credentials;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.Urls;
import tests.BaseTest;

public class CheckIconNumberTest extends BaseTest {
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify icon appears correct number of added product")
    @Epic("Functional Test")
    @Feature("Feature: Icon")
    @Story("Story:PRO-45262")
    @Test(testName = "Check Icon Number Test")
    public void test_01() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkIn(Credentials.STANDARD_USER, Credentials.CORRECT_PASSWORD);

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.elementOnThePage());
        Assert.assertEquals(productsPage.getCurrentUrl(), Urls.BASE_INVENTORY, "Address is incorrect");
//        productsPage.addToCartByProductName("Sauce Labs Backpack");
//        productsPage.addToCartByProductName("Sauce Labs Bike Light");
//        productsPage.sleep(3000);
//        System.out.println("");
        Assert.assertEquals(productsPage.getProductsCount(), 0);

        String products [] = {"Sauce Labs Backpack", "Sauce Labs Bike Light"};

        for (int i = 0; i < products.length; i++) {
            productsPage.addToCartByProductName(products[i]);
        }
//        getProductsCount
        Assert.assertEquals(productsPage.getProductsCount(), products.length);
    }

}
