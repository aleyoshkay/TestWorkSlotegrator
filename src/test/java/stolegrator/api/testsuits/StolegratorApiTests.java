package stolegrator.api.testsuits;

import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stolegrator.api.chekers.StolegratorChekers;
import stolegrator.api.executor.TokenExecutor;
import stolegrator.api.model.*;

import static org.apache.http.HttpStatus.*;
import static stolegrator.api.executor.BaseExecutor.*;

public class StolegratorApiTests {
    TokenExecutor tokenExecutor = new TokenExecutor();
    StolegratorChekers stolegratorChekers = new StolegratorChekers();
    private final String grantTypeGuest = "client_credentials";
    private final String grantTypeAuth = "password";
    private final String scopeGuest = "guest:default";
    private final int length = 10;
    private final boolean useLetters = true;
    private final boolean useNumbers = false;
    private String userName;
    private String name;
    private String surname;
    private String email;
    private String password = "aBcdefG11==";

    @BeforeEach
    void setUp() {
        authAsGuest();
        userName = RandomStringUtils.random(length, useLetters, useNumbers);
        name = RandomStringUtils.random(length, useLetters, useNumbers);
        surname = RandomStringUtils.random(length, useLetters, useNumbers);
        email = RandomStringUtils.random(length, useLetters, useNumbers) + "@gmail.com";
    }

    @Test
    void getGuestToken() {
        GetTokenResponse getTokenResponse = registerGuestAccount();
        stolegratorChekers.checkAuthGuestFields(getTokenResponse);
    }

    @Test
    void playerRegistration() {
        GetTokenResponse getTokenResponse = registerGuestAccount();
        setAuthToken(getTokenResponse.getAccess_token());
        registerNewPlayer();
    }

    @Test
    void authUnderCreatedPlayer() {
        GetTokenResponse getTokenResponse = registerGuestAccount();
        setAuthToken(getTokenResponse.getAccess_token());
        registerNewPlayer();
        CreateUserResponse createUserResponse = authUnderCreatedUser();
        stolegratorChekers.checkAuthPlayerFields(createUserResponse);
    }

    @Test
    void requestMyPlayerProfile() {
        GetTokenResponse getTokenResponse = registerGuestAccount();
        setAuthToken(getTokenResponse.getAccess_token());
        RegisterNewUserResponse registerNewUserResponse = registerNewPlayer();
        CreateUserResponse createUserResponse = authUnderCreatedUser();
        setAuthToken(createUserResponse.getAccess_token());
        Response response = tokenExecutor.getUserById(registerNewUserResponse.getId());
        stolegratorChekers.checkResponseCode(response, SC_OK);
        RegisterNewUserResponse getUserByIdResponse = response.as(RegisterNewUserResponse.class);
        stolegratorChekers.checkGetUserByIdFields(userName, name, surname, email, getUserByIdResponse);
    }

    @Test
    void requestUnknownPlayerProfile() {
        GetTokenResponse getTokenResponse = registerGuestAccount();
        setAuthToken(getTokenResponse.getAccess_token());
        registerNewPlayer();
        CreateUserResponse createUserResponse = authUnderCreatedUser();
        setAuthToken(createUserResponse.getAccess_token());
        Response response = tokenExecutor.getUserById(Integer.valueOf(generateRandomNum(6)));
        stolegratorChekers.checkResponseCode(response, SC_NOT_FOUND);
    }

    GetTokenResponse registerGuestAccount() {
        GetTokenRequest getTokenRequest = new GetTokenRequest();
        getTokenRequest.setGrant_type(grantTypeGuest);
        getTokenRequest.setScope(scopeGuest);
        Response response = tokenExecutor.getToken(getTokenRequest);
        stolegratorChekers.checkResponseCode(response, SC_OK);
        GetTokenResponse getTokenResponse = response.as(GetTokenResponse.class);
        return getTokenResponse;
    }

    RegisterNewUserResponse registerNewPlayer() {
        RegisterNewUserRequest registerNewUserRequest = new RegisterNewUserRequest();
        registerNewUserRequest.setUsername(userName);
        registerNewUserRequest.setPassword_change(password);
        registerNewUserRequest.setPassword_repeat(password);
        registerNewUserRequest.setEmail(email);
        registerNewUserRequest.setName(name);
        registerNewUserRequest.setSurname(surname);
        Response response = tokenExecutor.registerNewUser(registerNewUserRequest);
        stolegratorChekers.checkResponseCode(response, SC_CREATED);
        RegisterNewUserResponse registerNewUserResponse = response.as(RegisterNewUserResponse.class);
        stolegratorChekers.checkRegisterNewPlayerFields(registerNewUserRequest, registerNewUserResponse);
        return registerNewUserResponse;
    }

    CreateUserResponse authUnderCreatedUser() {
        authAsGuest();
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setUsername(userName);
        createUserRequest.setPassword(password);
        createUserRequest.setGrant_type(grantTypeAuth);
        Response response = tokenExecutor.registerPlayer(createUserRequest);
        stolegratorChekers.checkResponseCode(response, SC_OK);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        return createUserResponse;
    }

}
