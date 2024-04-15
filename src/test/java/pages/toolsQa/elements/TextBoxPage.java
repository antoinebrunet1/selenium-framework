package pages.toolsQa.elements;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.WebDriverUtil;
import utils.XpathsPropertiesFile;

public class TextBoxPage {
    private final XpathsPropertiesFile xpathsPropertiesFile = new XpathsPropertiesFile(
      "toolsQa//elements",
      "textBoxPageXpaths.properties"
    );

    public void navigateToTextBoxPage() {
        WebDriverUtil.goToUrl("https://demoqa.com/text-box");
        WebDriverUtil.waitForPageToLoad();
        WebDriverUtil.takeScreenshot();
    }

    public void enterFullName(String fullName) {
        fillField("fullName", fullName);
    }

    public void enterEmail(String email) {
        fillField("email", email);
    }

    public void enterCurrentAddress(String currentAddress) {
        fillField("currentAddress", currentAddress);
    }

    public void enterPermanentAddress(String permanentAddress) {
        fillField("permanentAddress", permanentAddress);
    }

    private void fillField(String xpathName, String text) {
        String xpath = xpathsPropertiesFile.getXpath(xpathName);

        WebDriverUtil.waitForWebElementToBeClickable(xpath);
        WebDriverUtil.sendText(xpath, text);
        WebDriverUtil.takeScreenshot();
    }

    public void clickOnSubmit() {
        String xpath = xpathsPropertiesFile.getXpath("submitButton");
        WebDriverUtil.moveToElement(xpath);
        WebDriverUtil.waitForWebElementToBeClickable(xpath);
        WebDriverUtil.click(xpath);
    }

    public void enteredFullNameInBoxBelowSubmitButton(String fullName) {
        String xpath = xpathsPropertiesFile.getXpath("fullNameInBoxUnderSubmitButton");
        String expectedText = "Name:" + fullName;

        verifyText(xpath, expectedText);
    }

    public void enteredEmailInBoxBelowSubmitButton(String email) {
        String xpath = xpathsPropertiesFile.getXpath("emailInBoxUnderSubmitButton");
        String expectedText = "Email:" + email;

        verifyText(xpath, expectedText);
    }

    public void enteredCurrentAddressInBoxBelowSubmitButton(String currentAddress) {
        String xpath = xpathsPropertiesFile.getXpath("currentAddressInBoxUnderSubmitButton");
        String expectedText = "Current Address :" + currentAddress;

        verifyText(xpath, expectedText);
    }

    public void enteredPermanentAddressInBoxBelowSubmitButton(String permanentAddress) {
        String xpath = xpathsPropertiesFile.getXpath("permanentAddressInBoxUnderSubmitButton");
        String expectedText = "Permananet Address :" + permanentAddress;

        verifyText(xpath, expectedText);
    }

    private void verifyText(String xpath, String expectedText) {
        String actualText = WebDriverUtil.getElementText(xpath);

        WebDriverUtil.waitForElement(xpath);

        Assert.assertEquals(expectedText, actualText);

        WebDriverUtil.takeScreenshot();
    }
}
