package stolegrator.api.model;

import lombok.Data;

@Data
public class GetTokenRequest {
    String grant_type;
    String scope;
}
