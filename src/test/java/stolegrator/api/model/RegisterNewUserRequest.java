package stolegrator.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.swing.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterNewUserRequest {
    String username;
    String password_change;
    String password_repeat;
    String email;
    String name;
    String surname;
    Integer country_id = null;
    Integer timezone_id = null;
    Integer phone_number;
    String birthdate;
    boolean bonuses_allowed;
    boolean is_verified;

}
