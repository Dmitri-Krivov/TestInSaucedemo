package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Urls;

import java.io.ByteArrayInputStream;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setupChromeDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Urls.BASE_URL);
    }

    @AfterMethod
    public void tearDown(){
        Allure.addAttachment("screenshot",new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        driver.quit();
    }
}
