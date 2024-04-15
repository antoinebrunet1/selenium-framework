package stepDefinitions.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.WebDriverUtil;

public class Hooks {
    @Before
    public static void setDriverAndScenario(Scenario scenario) {
        WebDriverUtil.setDriver();
        WebDriverUtil.setScenario(scenario);
    }

    @After
    public static void takeScreenshotIfFailedAndQuitWebDriver(Scenario scenario) {
        if (scenario.isFailed()) {
            WebDriverUtil.takeScreenshot();
        }

        WebDriverUtil.quitWebDriver();
    }
}
