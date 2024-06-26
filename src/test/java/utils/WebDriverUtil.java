package utils;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class WebDriverUtil {
    private static WebDriver webDriver;
    private static Scenario scenario;

    public static void setDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("start-maximized");

        Map<String, Object> prefs = new HashMap<>();

        FilesUtil.createDownloadFolderIfItDoesNotExist();
        prefs.put("download.default_directory", FilesUtil.ABSOLUTE_PATH_OF_DOWNLOAD_FOLDER);
        chromeOptions.setExperimentalOption("prefs", prefs);

        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public static WebDriver getWebDriver() {
        return WebDriverUtil.webDriver;
    }

    public static void setScenario(Scenario scenario) {
        WebDriverUtil.scenario = scenario;
    }

    public static void navigateToPage(String url) {
        webDriver.get(url);
        waitForPageToLoad();
        takeScreenshot();
    }

    private static void waitForPageToLoad() {
        Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));
    }

    public static void takeScreenshot() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
        byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);

        scenario.attach(screenshot, "image/png", scenario.getName());
    }

    public static void waitForWebElementToBeClickable(XpathsPropertiesFile xpathsPropertiesFile, String xpathName) {
        String xpath = xpathsPropertiesFile.getXpath(xpathName);
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

    public static void moveToElement(String xpath) {
        WebElement webElement = getWebElementByXpath(xpath);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public static void click(XpathsPropertiesFile xpathsPropertiesFile, String xpathName) {
        String xpath = xpathsPropertiesFile.getXpath(xpathName);
        WebElement webElement = getWebElementByXpath(xpath);

        webElement.click();
    }

    private static String getElementText(String xpath) {
        WebElement webElement = getWebElementByXpath(xpath);

        return webElement.getText();
    }

    public static void verifyText(XpathsPropertiesFile xpathsPropertiesFile, String xpathName, String expectedText) {
        String xpath = xpathsPropertiesFile.getXpath(xpathName);
        String actualText = WebDriverUtil.getElementText(xpath);

        Assert.assertEquals(expectedText, actualText);

        WebDriverUtil.takeScreenshot();
    }

    public static void waitForElementToBeAbsent(XpathsPropertiesFile xpathsPropertiesFile, String xpathName) {
        String xpath = xpathsPropertiesFile.getXpath(xpathName);
        Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }

    public static void waitForElementToBePresent(String xpath) {
        Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public static void clearElement(String xpath) {
        WebElement webElement = getWebElementByXpath(xpath);

        webElement.clear();
    }

    public static void fillField(XpathsPropertiesFile xpathsPropertiesFile, String xpathName, String text) {
        String xpath = xpathsPropertiesFile.getXpath(xpathName);

        WebDriverUtil.waitForWebElementToBeClickable(xpathsPropertiesFile, xpathName);
        WebDriverUtil.sendText(xpath, text);
        WebDriverUtil.takeScreenshot();
    }

    public static void waitForElementToHaveText(String xpath, String text) {
        Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBe(By.xpath(xpath), text));
    }

    public static void doubleClick(String xpath) {
        Actions actions = new Actions(webDriver);
        WebElement webElement = getWebElementByXpath(xpath);

        actions.doubleClick(webElement).perform();
    }

    public static void rightClick(String xpath) {
        Actions actions = new Actions(webDriver);
        WebElement webElement = getWebElementByXpath(xpath);

        actions.contextClick(webElement).perform();
    }

    public static void uploadFile(String absolutePath, String uploadButtonXpath) {
        WebElement webElement = getWebElementByXpath(uploadButtonXpath);

        webElement.sendKeys(absolutePath);
    }

    public static void quitWebDriver() {
        webDriver.quit();
    }
}
