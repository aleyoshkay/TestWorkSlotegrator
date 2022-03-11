package stolegrator.ui.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stolegrator.ui.steps.BasicPageDefs;

public class AdminPanelPage extends BasicPageDefs {
    private WebElement logoCasino = driver.findElement(By.xpath("//img[@alt='Casino']"));
    private WebElement dashBoardButton = driver.findElement(By.xpath("//i[@class='fa fa-dashboard']"));
    private WebElement ticketButton = driver.findElement(By.xpath("//p[text()='Tickets']"));
    public WebElement withdrawalRequestsButton = driver.findElement(By.xpath("//p[text()='Withdrawal requests']"));
    private WebElement playersOnlineButton = driver.findElement(By.xpath("//p[text()='Players online / total']"));
    private WebElement activeGameSessionButton = driver.findElement(By.xpath("//p[text()='Active game sessions']"));

    public void assertAdminPanelPage() {
        Assertions.assertAll(
                () -> Assertions.assertTrue((logoCasino).isDisplayed()),
                () -> Assertions.assertTrue((ticketButton).isDisplayed()),
                () -> Assertions.assertTrue((withdrawalRequestsButton).isDisplayed()),
                () -> Assertions.assertTrue((playersOnlineButton).isDisplayed()),
                () -> Assertions.assertTrue((activeGameSessionButton).isDisplayed())
        );
    }

    public void clickPlayersOnlineButton() {
        this.playersOnlineButton.click();
    }

}


