package tests.e2e;

import frontend.pages.LoginPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import modelObject.ModelPath;
import modelObject.backend.request.RequestCreateUser;

import org.testng.annotations.Test;
import backend.services.AccountService;
import sharedData.Hooks;
import suites.AtfSuite;

@Feature("FE-456")
@Story("ST-323")
public class CreateUserTest extends Hooks {

    @Test(groups = AtfSuite.E2E_SUITE,
            description = "TC-GHI: Acesta este testul Alinei")
    public void testMethod() {
        RequestCreateUser requestBody = new RequestCreateUser(ModelPath.REQUEST_CREATE_USER_PATH);
        AccountService accountService = new AccountService();
        accountService.createAccount(requestBody);

        LoginPage loginPage = new LoginPage(driverService.getDriver());
        loginPage.loginProcess(requestBody.getUserName(), requestBody.getPassword());
    }
}