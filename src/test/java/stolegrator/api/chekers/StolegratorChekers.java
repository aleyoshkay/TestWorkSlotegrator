package stolegrator.api.chekers;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.springframework.stereotype.*;
import stolegrator.api.model.CreateUserResponse;
import stolegrator.api.model.GetTokenResponse;
import stolegrator.api.model.RegisterNewUserRequest;
import stolegrator.api.model.RegisterNewUserResponse;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@Service
public class StolegratorChekers {
    public void checkResponseCode(Response response, int code) {
        int actualCode = response.getStatusCode();
        MatcherAssert.assertThat("Response code is wrong", actualCode, CoreMatchers.equalTo(code));
    }

    public void checkAuthGuestFields(GetTokenResponse getTokenResponse) {
        Assertions.assertAll(
                () -> assertNotNull(getTokenResponse.getAccess_token(), "access token equals null"),
                () -> assertNotNull(getTokenResponse.getToken_type(), "token_type equals null"),
                () -> assertNotNull(getTokenResponse.getExpires_in(), "epires_in equals null")
        );
    }

    public void checkAuthPlayerFields(CreateUserResponse createUserResponse) {
        Assertions.assertAll(
                () -> assertNotNull(createUserResponse.getAccess_token(), "access token equals null"),
                () -> assertNotNull(createUserResponse.getToken_type(), "token_type equals null"),
                () -> assertNotNull(createUserResponse.getExpires_in(), "epires_in equals null"),
                () -> assertNotNull(createUserResponse.getRefresh_token(), "refresh_token equals null")
        );
    }

    public void checkRegisterNewPlayerFields(RegisterNewUserRequest expectedFields, RegisterNewUserResponse actualFields) {
        Assertions.assertAll(
                () -> assertNotNull(actualFields.getId(), "access token equals null"),
                () -> assertEquals(expectedFields.getUsername(), actualFields.getUsername(), "token_type equals null"),
                () -> assertEquals(expectedFields.getName(), actualFields.getName(), "name from response does not match expected"),
                () -> assertEquals(expectedFields.getSurname(), actualFields.getSurname(), "surname from response does not match expected"),
                () -> assertEquals(expectedFields.getEmail(), actualFields.getEmail(), "email from response does not match expected")
        );
    }

    public void checkGetUserByIdFields(String userName, String name, String surname, String email,
                                       RegisterNewUserResponse actualFields) {
        Assertions.assertAll(
                () -> assertNotNull(actualFields.getId(), "access token equals null"),
                () -> assertEquals(userName, actualFields.getUsername(), "token_type equals null"),
                () -> assertEquals(name, actualFields.getName(), "name from response does not match expected"),
                () -> assertEquals(surname, actualFields.getSurname(), "surname from response does not match expected"),
                () -> assertEquals(email, actualFields.getEmail(), "email from response does not match expected")
        );
    }
}
