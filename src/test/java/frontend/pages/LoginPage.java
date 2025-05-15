package frontend.pages;

import frontend.pageLocators.LoginLocators;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginProcess(String username, String password) {
        elementHelper.fillLocator(LoginLocators.usernameLocators, username);
        LoggerUtility.infoLog("The user fills username field with " + username + " value");

        elementHelper.fillLocator(LoginLocators.paswardLocators, password);
        loggerUtility.LoggerUtility.infoLog("The user fills password field with " + password + " value");

        elementHelper.clickLocator(LoginLocators.loginLocators);
        loggerUtility.LoggerUtility.infoLog("The user clicks on Login field");
    }
}