package tests.Sanity;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import tests.BaseTest;

public class SanityTest extends BaseTest {

    @Severity(SeverityLevel.MINOR)
    @Description("Verify login with different Credentials")
    @Epic("E01")
    @Feature("Feature2: Login")
    @Story("Story:PRO-45262")
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

//YourCartPage
        YourCartPage yourCartPage = new YourCartPage(driver);
        Assert.assertTrue(yourCartPage.elementOnThePage());
        Assert.assertEquals(yourCartPage.getCurrentUrl(), Urls.BASE_YOURCARTPAGE, "Address is incorrect");
        yourCartPage.performCheckout();

//CheckOutYourInformationPage
        CheckOutYourInformationPage checkOutYourInformationPage = new CheckOutYourInformationPage(driver);
        Assert.assertTrue(checkOutYourInformationPage.elementOnThePage());
        Assert.assertEquals(checkOutYourInformationPage.getCurrentUrl(), Urls.BASE_CHECKOUTSTEPONE, "Address is incorrect");
        checkOutYourInformationPage.fillCheckoutForm("Qwerty", "Qwerty", "220000");

//      CheckoutOverviewPage
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        Assert.assertTrue(checkoutOverviewPage.elementOnThePage());
        Assert.assertEquals(checkoutOverviewPage.getCurrentUrl(), Urls.BASE_CHECKOUTSTEPTWO, "Address is incorrect");
        checkoutOverviewPage.finishCheckout();

//checkoutCompletePage
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        Assert.assertTrue(checkoutCompletePage.elementOnThePage());
        Assert.assertEquals(checkoutCompletePage.getCurrentUrl(), Urls.BASE_CHECKOUTCOMPLETE, "Address is incorrect");
        checkoutCompletePage.goBackToProductsPage();
    }
}
