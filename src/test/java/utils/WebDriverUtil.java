package utils;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverUtil {
    private static WebDriver webDriver;
    private static Scenario scenario;

    public static void setDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("start-maximized");

        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public static void setScenario(Scenario scenario) {
        WebDriverUtil.scenario = scenario;
    }

    public static void goToUrl(String url) {
        webDriver.get(url);
    }

    public static void waitForPageToLoad() {
        Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));
    }

    public static void takeScreenshot() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
        byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);

        scenario.attach(screenshot, "image/png", scenario.getName());
    }

    public static void waitForWebElementToBeClickable(String xpath) {
        Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public static  void sendText(String xpath, String text) {
        WebElement webElement = getWebElementByXpath(xpath);

        webElement.sendKeys(text);
    }

    private static WebElement getWebElementByXpath(String xpath) {
        return webDriver.findElement(By.xpath(xpath));
    }

    public static void quitWebDriver() {
        webDriver.quit();
    }
}
