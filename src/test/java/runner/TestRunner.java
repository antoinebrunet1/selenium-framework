package runner;

import io.cucumber.java.AfterAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import utils.WebDriverUtil;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\Utilisateur\\IdeaProjects\\selenium-framework\\src\\test\\resources\\features",
        glue = {"stepDefinitions"},
        plugin = {"json:target/cucumber-report/cucumber.json"}
)
public class TestRunner {
}
