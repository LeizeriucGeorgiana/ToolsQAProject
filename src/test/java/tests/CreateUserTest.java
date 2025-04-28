package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
public class CreateUserTest {
    @Test
        public void testMethod(){
            //reează o instanță de tip RequestSpecification, adică o "schiță" pentru cererea HTTP pe care urmează să o trimiți (GET, POST etc.).
            RequestSpecification requestSpecification = RestAssured.given();

            //configurare baseuri
            requestSpecification.baseUri("https://demoqa.com");

            //setam contentul
            requestSpecification.contentType(ContentType.JSON);

            //Crearea unui username și parola + adaugare la sfarsitul  user-lui , timpulcurrent in ms
            String userName = "GeorgianaTest" + System.currentTimeMillis();
            String password = "Tele@91Aremere22!";

            //Crearea body-ului cererii API
            Map<String, String> requestBody = new HashMap<>();
            requestBody.put("userName", userName);
            requestBody.put("password", password);

            requestSpecification.body(requestBody);

            //Trimiterea cererii POST:
            Response response = requestSpecification.post("/Account/v1/User");

            //Afișează linia de status a răspunsului HTTP (ex. "HTTP/1.1 200 OK").
            System.out.println(response.statusLine());
            //Afișează body-ul răspunsului într-un format ușor de citit.
            response.getBody().prettyPrint();

            //Inițializarea WebDriver-ului pentru Selenium
            WebDriver driver = new ChromeDriver();
            driver.get("https://demoqa.com/login");
            driver.manage().window().maximize();

            WebElement userNameElement = driver.findElement(By.id("userName"));
            userNameElement.sendKeys(userName);
            WebElement passwordElement = driver.findElement(By.id("password"));
            passwordElement.sendKeys(password);
            WebElement logginButtonElement = driver.findElement(By.id("login"));
            logginButtonElement.click();

        }

    }
