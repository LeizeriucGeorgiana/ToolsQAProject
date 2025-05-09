package tests.be;
import modelObject.request.RequestCreateUser;
import modelObject.response.ResponseCreateUser;
import modelObject.response.ResponseToken;
import org.testng.annotations.Test;
import services.AccountService;
import shareData.SharedData;

public class CreateUserBETest extends SharedData {

    @Test
    public void testMethod() {
        AccountService accountService= new AccountService();

        System.out.println("===STEP 1 CREATE USER===");
        RequestCreateUser requestBody=new RequestCreateUser("src/main/resources/testData/createUserData.json");
        ResponseCreateUser responseCreateUser = accountService.createAccount(requestBody);
        String userID = responseCreateUser.getUserID();
        System.out.println(userID);
        System.out.println();

        System.out.println("=== STEP 2 CREATE TOKEN FOR USER===");

        ResponseToken responseToken= accountService.generateToken(requestBody);
        String token =responseToken.getToken();
        System.out.println(token);
        accountService.getSpecificAccount(userID,token);
    }
}