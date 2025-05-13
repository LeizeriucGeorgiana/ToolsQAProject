package tests.e2e;
import frontend.pages.LoginPage;
import modelObject.ModelPath;
import modelObject.backend.request.RequestCreateUser;
import org.testng.annotations.Test;
import backend.services.AccountService;
import shareData.Hooks;
import suites.AtfSuite;

public class CreateUserTest extends Hooks {
    @Test(groups = AtfSuite.E2E_SUITE)
        public void testMethod(){

            //Crearea unui username și parola + adaugare la sfarsitul  user-lui , timpulcurrent in ms
            RequestCreateUser requestBody=new RequestCreateUser(ModelPath.REQUEST_CREATE_GET_USER_PATH);
            AccountService accountService= new AccountService();
            accountService.createAccount(requestBody);

           LoginPage loginPage = new LoginPage(driverService.getDriver());
            loginPage.loginProcess(requestBody.getUserName(),requestBody.getPassword());
        }

    }
