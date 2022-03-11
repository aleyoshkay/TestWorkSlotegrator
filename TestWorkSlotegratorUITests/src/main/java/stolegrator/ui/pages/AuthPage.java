package stolegrator.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stolegrator.ui.steps.BasicPageDefs;

public class AuthPage extends BasicPageDefs {
    private WebElement loginInput = driver.findElement(By.xpath("//input[@id='UserLogin_username']"));
    private WebElement passwordInput = driver.findElement(By.xpath("//input[@id='UserLogin_password']"));
    private WebElement signInButton = driver.findElement(By.xpath("//input[@value='Sign in']"));

    public void inputLogin(String login) {
        this.loginInput.sendKeys(login);
    }

    public void inputPassword(String password) {
        this.passwordInput.sendKeys(password);
    }

    public void clickSignInButton() {
        this.signInButton.click();
    }

}
