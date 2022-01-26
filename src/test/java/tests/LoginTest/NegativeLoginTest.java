package tests.LoginTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Credentials;
import pageObjects.LoginPage;
import tests.BaseTest;

public class NegativeLoginTest  extends BaseTest {
    @Test(testName = "Login with locked user")
    public void test_01() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkIn(Credentials.LOCKED_USER, Credentials.CORRECT_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.", "Address is incorrect");
    }
    @Test(testName = "Login with empty user")
    public void test_02() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkIn("", Credentials.CORRECT_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required", "Address is incorrect");
    }
    @Test(testName = "Login with empty password")
    public void test_03() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkIn(Credentials.LOCKED_USER, "");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required", "Address is incorrect");
    }

}
