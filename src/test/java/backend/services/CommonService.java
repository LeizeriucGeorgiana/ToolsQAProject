package backend.services;
import backend.client.RestClient;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import loggerUtility.LoggerUtility;
import java.util.Map;

public class CommonService {

    // Metodă care efectuează o cerere POST cu un corp de cerere (requestBody) și un endpoint
    public Response post(Object requestBody, String endpoint) {

        // Creează o instanță a obiectului RequestSpecification, care definește configurarea cererii
        RequestSpecification requestSpecification = RestAssured.given();

        // Setează corpul cererii cu datele transmise în requestBody (un Map de parametri)
        requestSpecification.body(requestBody);

        LoggerUtility.requestLogs(requestSpecification,endpoint,"POST");

        // Setează corpul cererii cu datele transmise în requestBody (un Map de parametri)
        Response response=performRequest("POST", requestSpecification, endpoint);
        LoggerUtility.responseLogs(response);
        return response;

    }

    public Response get(String endpoint) {
        RequestSpecification requestSpecification = RestAssured.given();
        LoggerUtility.requestLogs(requestSpecification,endpoint,"GET");
        Response response=performRequest("GET", requestSpecification, endpoint);
        LoggerUtility.responseLogs(response);
        return response;
    }

    public Response get(String endpoint,String token) {
        RequestSpecification requestSpecification = RestAssured.given();
        //adaugare autentificare la metoda
        requestSpecification.header("Authorization","Bearer " + token);
        LoggerUtility.requestLogs(requestSpecification,endpoint,"GET");
        Response response= performRequest("GET", requestSpecification, endpoint);
        LoggerUtility.responseLogs(response);
        return response;
    }

    public Response put(Map<String, String> requestBody, String endpoint) {
        RequestSpecification requestSpecification = RestAssured.given();
        // Setează corpul cererii cu datele transmise în requestBody (un Map de parametri)
        requestSpecification.body(requestBody);
        return performRequest("PUT", requestSpecification, endpoint);
    }

    public Response delete(Map<String, String> requestBody, String endpoint) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.body(requestBody);
        return performRequest("DELETE", requestSpecification, endpoint);
    }

    public Response delete(String endpoint) {
        RequestSpecification requestSpecification = RestAssured.given();
        return performRequest("DELETE", requestSpecification, endpoint);
    }
    // Metodă privată care efectuează cererea efectivă, apelând RestClient pentru a trimite cererea HTTP
    private Response performRequest(String requestType, RequestSpecification requestSpecification, String endpoint) {

        // Creează un obiect RestClient și apelează metoda performRequest din el pentru a efectua cererea
        return new RestClient().performRequest(requestType, requestSpecification, endpoint);
    }
}