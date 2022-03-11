package stolegrator.api.model;

import lombok.Data;

@Data
public class CreateUserRequest {
    String grant_type;
    String username;
    String password;
}
