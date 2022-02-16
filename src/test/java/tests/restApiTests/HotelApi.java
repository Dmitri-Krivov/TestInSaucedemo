package tests.restApiTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class HotelApi {
    @Test (testName = "First GET Method")
    public void  test_01(){
        given()
                .log()
                .all()
                .when()
                .get("https://fakestoreapi.com/products")
                .then()
                .statusCode(200);
    }
    @Test (testName = "Show log if validation failed")
    public void  test_02(){
        given()
                .log()
                .ifValidationFails()
                .when()
                .get("https://fakestoreapi.com/products")
                .then()
                .statusCode(201);
    }
    @Test (testName = "java styled test writing")
    public void  test_03(){
      RequestSpecification HTTPRequest = RestAssured.given();
        Response response = HTTPRequest.get("https://fakestoreapi.com/products");
        Assert.assertEquals(response.getStatusCode(), 202, "Status code "+ response.statusCode()+" was received");
    }
    @Test (testName = "selenium+rest assured")
    public void  test_04() throws InterruptedException {
        RequestSpecification HTTPRequest = RestAssured.given();
        Response response = HTTPRequest.get("https://fakestoreapi.com/products");
        if(response.getStatusCode() == 200){
            WebDriverManager.chromedriver().setup();

            WebDriver driver  = new ChromeDriver();
            driver.get("https://fakestoreapi.com/products");
            driver.manage().window().maximize();
            Thread.sleep(5000);
            driver.quit();
        }else{
            System.out.println("Status code "+response.getStatusCode()+" is incorrect");
        }
    }
}
