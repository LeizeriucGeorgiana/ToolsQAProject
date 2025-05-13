package backend.services;

import backend.endpoints.Endpoints;
import io.restassured.response.Response;
import modelObject.backend.request.RequestCreateUser;
import modelObject.backend.response.ResponseCreateUser;
import modelObject.backend.response.ResponseToken;
import org.testng.Assert;

public class AccountService extends CommonService {

    // Metodă care creează un cont, primind un Map ca requestBody (corpul cererii)
    public ResponseCreateUser createAccount(RequestCreateUser requestBody) {

        // Trimite o cerere POST cu requestBody la endpoint-ul "/Account/v1/User"
        Response response = post(requestBody, Endpoints.ACCOUNT_CREATE_USER_ENDPOINT);
        // Verifică dacă codul de status al răspunsului este 201 (Created)
        Assert.assertEquals(response.getStatusCode(),201);
        return response.as(ResponseCreateUser.class);

    }

    // Metodă care generează un token, primind un Map ca requestBody (corpul cererii)
    public ResponseToken generateToken(RequestCreateUser requestBody) {
        Response response = post(requestBody, Endpoints.ACCOUNT_GENERATE_TOKEN_ENDPOINT);
        Assert.assertEquals(response.getStatusCode(),200);
        return response.as(ResponseToken.class);
    }

    public void getSpecificAccount (String userID, String token){
        Response response= get(Endpoints.ACCOUNT_GET_USER_ENDPOINT + userID, token);
        Assert.assertEquals(response.getStatusCode(),200);
    }


}