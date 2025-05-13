package frontend.pages;

import frontend.pageLocators.LoginLocators;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver){
        super(driver);
    }
 public void loginProcess(String username, String password){
     elementHelper.fillLocator(LoginLocators.usernameLocators,username);
     LoggerUtility.infoLog("The user fills username fild with: "+ username + "value");


     elementHelper.fillLocator(LoginLocators.paswardLocators,password);
     LoggerUtility.infoLog("The user fills password fild with: "+ password + "value");

     elementHelper.clickLocator(LoginLocators.loginLocators);
     LoggerUtility.infoLog("The user clicks on Login field");
 }
}
