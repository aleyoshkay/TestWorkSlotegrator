package stolegrator.api.model;

import lombok.Data;

@Data
public class GetTokenResponse {
    String token_type;
    Integer expires_in;
    String access_token;
}
