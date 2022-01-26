package tests.Sanity;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Credentials;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.Urls;
import tests.BaseTest;

public class SanityTest extends BaseTest {

    @Test(testName = "Sanity")
    public void test_01() {
//Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkIn(Credentials.STANDARD_USER, Credentials.CORRECT_PASSWORD);
//ProductsPage
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.elementOnThePage());
        Assert.assertEquals(productsPage.getCurrentUrl(), Urls.BASE_INVENTORY, "Address is incorrect");
        productsPage.addToCart(0);
        productsPage.addToCart(1);
        productsPage.openCart();

    }
}
