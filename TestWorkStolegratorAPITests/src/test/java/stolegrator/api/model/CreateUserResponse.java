package stolegrator.api.model;

import lombok.Data;

@Data
public class CreateUserResponse {
    String token_type;
    Integer expires_in;
    String access_token;
    String refresh_token;
}
