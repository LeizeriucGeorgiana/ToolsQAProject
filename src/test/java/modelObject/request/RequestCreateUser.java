package modelObject.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;

@Getter
@Setter
public class RequestCreateUser {
    private String userName;
    private String password;
//consdtructor care incarca fisierul  json fara mapare manuala
    public RequestCreateUser (String jsonFilePath){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.readerForUpdating(this).readValue(new File(jsonFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load JSON file: " + jsonFilePath, e);
        }
        perfomModification();
    }

    private void perfomModification(){
        this.userName += System.currentTimeMillis();
    }
}
