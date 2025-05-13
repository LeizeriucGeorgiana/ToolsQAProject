package backend.client;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {
    // Metodă care execută o cerere HTTP pe baza tipului (GET, POST, etc.)
    //requestType: un șir de caractere care specifică tipul cererii (ex: "GET", "POST").
    //requestSpecification: un obiect care conține configurarea cererii (body).
    //endpoint: URL-ul la care se face cererea (doar partea finală, pentru că baza este setată separat).
    public Response performRequest(String requestType, RequestSpecification requestSpecification, String endpoint) {
        switch (requestType) {
            case "POST":
                // Trimite o cerere POST către endpoint, folosind clientul pregătit
                return prepareClient(requestSpecification).post(endpoint);
            case "PUT":
                // Trimite o cerere PUT către endpoint
                return prepareClient(requestSpecification).put(endpoint);
            case "GET":
                // Trimite o cerere GET către endpoint
                return prepareClient(requestSpecification).get(endpoint);
            case "DELETE":
                // Trimite o cerere DELETE către endpoint
                return prepareClient(requestSpecification).delete(endpoint);
        }
        return null;
    }
    // Metodă care pregătește clientul HTTP (setări de bază pentru cerere)
    public RequestSpecification prepareClient(RequestSpecification requestSpecification) {
        // Setează baza URI pentru toate cererile (adresa principală a serverului)
        requestSpecification.baseUri("https://demoqa.com");

        // Setează tipul de conținut la JSON
        requestSpecification.contentType(ContentType.JSON);
        // Returnează obiectul configurat
        return requestSpecification;
    }
}