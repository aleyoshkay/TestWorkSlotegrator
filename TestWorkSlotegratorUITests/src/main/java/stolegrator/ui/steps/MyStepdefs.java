package stolegrator.ui.steps;

import io.cucumber.java.en.And;
import stolegrator.ui.pages.AuthPage;

public class MyStepdefs {
    AuthPage authPage = new AuthPage();

    @And("I login as {string} with password {string}")
    public void iLoginAsWithPassword(String login, String password) {
        authPage.inputLogin(login);
        authPage.inputPassword(password);
        authPage.clickSignInButton();
    }
}
