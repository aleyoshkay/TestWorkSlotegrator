package stolegrator.api.executor;

import io.restassured.response.Response;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.stereotype.Service;
import stolegrator.api.model.CreateUserRequest;
import stolegrator.api.model.GetTokenRequest;
import stolegrator.api.model.RegisterNewUserRequest;

import static io.restassured.RestAssured.given;

@Service
public class TokenExecutor extends BaseExecutor {
    public Response getToken(GetTokenRequest request) {
        return given().
                spec(requestSpec).
                when().
                body(request).
                log().all()
                .post("/v2/oauth2/token")
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response registerPlayer(CreateUserRequest request) {
        return given().
                spec(requestSpec).
                when().
                body(request).
                log().all()
                .post("/v2/oauth2/token")
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response registerNewUser(RegisterNewUserRequest request) {
        return given().
                spec(requestSpec).
                when().
                body(request).
                log().all()
                .post("v2/players")
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response getUserById(Integer playerId) {
        return given().
                spec(requestSpec).
                when().
                log().all()
                .get("v2/players/" + playerId)
                .then()
                .log().all()
                .extract()
                .response();
    }
}
