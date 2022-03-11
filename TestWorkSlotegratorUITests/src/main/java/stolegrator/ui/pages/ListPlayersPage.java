package stolegrator.ui.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stolegrator.ui.steps.BasicPageDefs;

import java.util.*;

public class ListPlayersPage extends BasicPageDefs {
    private WebElement playerListTable = driver.findElement(By.xpath("//table[@class='table table-hover table-striped table-bordered table-condensed']"));
    private WebElement sortByRegistrationDate = driver.findElement(By.xpath("//*[text()='Registration date']"));

    public List<String> webElements() {
        List<String> values = new ArrayList<>();
        List<WebElement> columnRegistrationDate = driver.findElements(By.xpath("//tbody//td[10]"));
        for (WebElement element : columnRegistrationDate) {
            values.add(element.getText());
        }
        return values;
    }

    public void clickSortByRegistrationDate() {
        this.sortByRegistrationDate.click();
        new WebDriverWait(driver, 1).until(ExpectedConditions.
                invisibilityOfElementLocated(By.xpath("//div[@class='grid-view grid-view-loading']")));
    }

    public void checkPlayersListTableOnThePage() {
        Assertions.assertTrue(playerListTable.isDisplayed());

    }

    public void tableIsCorrectlySortedByColumnRegistrationDate() {
        List<String> values = webElements();
        List<String> valuesAfterShuffle = new ArrayList<>();
        //Fill the list valuesAfterShuffle with the same values
        for (String value : values) {
            valuesAfterShuffle.add(value);
        }
        //List valuesAfterShuffle shuffle values
        Collections.shuffle(valuesAfterShuffle);
        //Assert sort list values not equals shuffle list valuesAfterShuffle
        Assertions.assertNotEquals(values, valuesAfterShuffle);
        //Sort Ascending list valuesAfterShuffle
        Collections.sort(valuesAfterShuffle);
        //Checking if two sorted lists are equal
        Assertions.assertEquals(values, valuesAfterShuffle);

    }
}
