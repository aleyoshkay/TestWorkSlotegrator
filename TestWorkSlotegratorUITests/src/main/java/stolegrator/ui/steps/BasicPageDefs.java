package stolegrator.ui.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stolegrator.ui.WebDriverFactory;
import stolegrator.ui.WebDriverName;

import java.util.concurrent.TimeUnit;

public class BasicPageDefs  {
    protected static WebDriver driver = null;

    @Before
    public static void startup() {
        int timeout = 3; //переменная для неявного ожидания
        driver = WebDriverFactory.create(WebDriverName.CHROME);
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public static void end() {
        driver.close();
        driver.quit();
    }

    @Given("I go to auth page")
    public void iGoToAuthPage() {
        driver.get("http://test-app.d6.dev.devcaz.com/admin/login");
    }

}
