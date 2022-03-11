package stolegrator.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterNewUserResponse {
    Integer id;
    Integer country_id;
    Integer timezone_id;
    String username;
    String email;
    String name;
    String surname;
    String gender;
    Integer phone_number;
    String birthdate;
    boolean bonuses_allowed;
    boolean is_verified;

}
