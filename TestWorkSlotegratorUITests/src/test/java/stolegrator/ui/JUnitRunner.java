package stolegrator.ui;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "pretty",
        glue = "stolegrator/ui/steps",
        features = "src/test/resources/features"
)
public class JUnitRunner {

}
