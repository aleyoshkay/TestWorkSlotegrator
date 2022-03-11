package stolegrator.ui.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import stolegrator.ui.pages.AdminPanelPage;

public class AdminPageStepDefs  {
    AdminPanelPage adminPanelPage = new AdminPanelPage();

    @Then("User Successfully authorized, the admin panel has loaded")
    public void userSuccessfullyAuthorizedTheAdminPanelHasLoaded() {
        adminPanelPage.assertAdminPanelPage();
    }

    @And("Click on the list of players button")
    public void clickListPlayersButton() {
        adminPanelPage.clickPlayersOnlineButton();
    }

}
