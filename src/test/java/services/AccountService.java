package services;

import io.restassured.response.Response;
import modelObject.request.RequestCreateUser;
import modelObject.response.ResponseCreateUser;
import modelObject.response.ResponseToken;
import org.testng.Assert;

import java.util.Map;

public class AccountService extends CommonService {

    // Metodă care creează un cont, primind un Map ca requestBody (corpul cererii)
    public ResponseCreateUser createAccount(RequestCreateUser requestBody) {

        // Trimite o cerere POST cu requestBody la endpoint-ul "/Account/v1/User"
        Response response = post(requestBody, "/Account/v1/User");
        // Verifică dacă codul de status al răspunsului este 201 (Created)
        Assert.assertEquals(response.getStatusCode(),201);
        return response.as(ResponseCreateUser.class);

    }

    // Metodă care generează un token, primind un Map ca requestBody (corpul cererii)
    public ResponseToken generateToken(RequestCreateUser requestBody) {
        Response response = post(requestBody, "/Account/v1/GenerateToken");
        Assert.assertEquals(response.getStatusCode(),200);
        return response.as(ResponseToken.class);
    }

    public void getSpecificAccount (String userID, String token){
        Response response= get("/Account/v1/User/" + userID, token);
        Assert.assertEquals(response.getStatusCode(),200);
    }


}