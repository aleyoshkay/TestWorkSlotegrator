package stolegrator.ui.steps;

import io.cucumber.java.en.And;
import stolegrator.ui.pages.ListPlayersPage;

public class ListPlayersStepDefs {
    ListPlayersPage listPlayersPage = new ListPlayersPage();

    @And("Checking if there is a table with players on the page")
    public void checkingIsDisplayedPlayersTable() {
        listPlayersPage.checkPlayersListTableOnThePage();
    }

    @And("Click on a column 'Registration Date' name to sort")
    public void clickSortByRegistrationDateButton() throws InterruptedException {
        listPlayersPage.clickSortByRegistrationDate();
    }

    @And("Checking that the table is correctly sorted by the 'Registration Date' column")
    public void tableIsCorrectlySortedByColumnRegistrationDate(){
        listPlayersPage.tableIsCorrectlySortedByColumnRegistrationDate();
    }
}
