package test.LoginTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Credentials;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.Urls;
import test.BaseTest;

public class SuccessfulLoginTests extends BaseTest {
    @Test(testName = "Login with standard user")
    public void test_01() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkIn(Credentials.STANDARD_USER, Credentials.CORRECT_PASSWORD);
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.elementOnThePage());
        Assert.assertEquals(productsPage.getCurrentUrl(), Urls.BASE_INVENTORY, "Address is incorrect");
    }

    @Test(testName = "Login with problem_user")
    public void test_02() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkIn(Credentials.PROBLEM_USER, Credentials.CORRECT_PASSWORD);
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.elementOnThePage());
        Assert.assertEquals(productsPage.getCurrentUrl(), Urls.BASE_INVENTORY, "Address is incorrect");
    }

    @Test(testName = "Login with performance glitch user")
    public void test_03() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkIn(Credentials.GLITCH_USER, Credentials.CORRECT_PASSWORD);
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.elementOnThePage());
        Assert.assertEquals(productsPage.getCurrentUrl(), Urls.BASE_INVENTORY, "Address is incorrect");
    }
}
