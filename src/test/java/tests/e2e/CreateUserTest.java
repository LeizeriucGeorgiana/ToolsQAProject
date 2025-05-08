package tests.e2e;
import loggerUtility.LoggerUtility;
import modelObject.request.RequestCreateUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import services.AccountService;
import shareData.SharedData;

import static io.restassured.RestAssured.requestSpecification;

public class CreateUserTest extends SharedData {
    @Test
        public void testMethod(){

            //Crearea unui username și parola + adaugare la sfarsitul  user-lui , timpulcurrent in ms
            RequestCreateUser requestBody=new RequestCreateUser("src/main/resources/testData/createUserData.json");
            AccountService accountService= new AccountService();
            accountService.createAccount(requestBody);

            //Inițializarea WebDriver-ului pentru Selenium
            WebDriver driver = new ChromeDriver();
            driver.get("https://demoqa.com/login");
            driver.manage().window().maximize();

            WebElement userNameElement = driver.findElement(By.id("userName"));
            userNameElement.sendKeys(requestBody.getUserName());
            LoggerUtility.infoLog("The user fills username fild with: "+ requestBody.getUserName() + "value");

            WebElement passwordElement = driver.findElement(By.id("password"));
            passwordElement.sendKeys(requestBody.getPassword());
            LoggerUtility.infoLog("The user fills password fild with: "+ requestBody.getPassword() + "value");

            WebElement logginButtonElement = driver.findElement(By.id("login"));
            logginButtonElement.click();
            LoggerUtility.infoLog("The user clicks on Login field");
        }

    }
