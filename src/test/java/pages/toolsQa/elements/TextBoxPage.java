package pages.toolsQa.elements;

import utils.WebDriverUtil;
import utils.XpathsPropertiesFile;

public class TextBoxPage {
    private final XpathsPropertiesFile xpathsPropertiesFile = new XpathsPropertiesFile(
      "toolsQa//elements",
      "textBoxPageXpaths.properties"
    );

    public void navigateToTextBoxPage() {
        WebDriverUtil.navigateToPage("https://demoqa.com/text-box");
    }

    public void enterFullName(String fullName) {
        WebDriverUtil.fillField(xpathsPropertiesFile, "fullName", fullName);
    }

    public void enterEmail(String email) {
        WebDriverUtil.fillField(xpathsPropertiesFile, "email", email);
    }

    public void enterCurrentAddress(String currentAddress) {
        WebDriverUtil.fillField(xpathsPropertiesFile, "currentAddress", currentAddress);
    }

    public void enterPermanentAddress(String permanentAddress) {
        WebDriverUtil.fillField(xpathsPropertiesFile, "permanentAddress", permanentAddress);
    }

    public void clickOnSubmit() {
        String xpath = xpathsPropertiesFile.getXpath("submitButton");
        WebDriverUtil.moveToElement(xpath);
        WebDriverUtil.waitForWebElementToBeClickable(xpath);
        WebDriverUtil.click(xpath);
    }

    public void enteredFullNameInBoxBelowSubmitButton(String fullName) {
        String expectedText = "Name:" + fullName;
        WebDriverUtil.verifyText(xpathsPropertiesFile, "fullNameInBoxUnderSubmitButton", expectedText);
    }

    public void enteredEmailInBoxBelowSubmitButton(String email) {
        String expectedText = "Email:" + email;
        WebDriverUtil.verifyText(xpathsPropertiesFile, "emailInBoxUnderSubmitButton", expectedText);
    }

    public void enteredCurrentAddressInBoxBelowSubmitButton(String currentAddress) {
        String expectedText = "Current Address :" + currentAddress;
        WebDriverUtil.verifyText(xpathsPropertiesFile, "currentAddressInBoxUnderSubmitButton", expectedText);
    }

    public void enteredPermanentAddressIsInBoxBelowSubmitButton(String permanentAddress) {
        String expectedText = "Permananet Address :" + permanentAddress;
        WebDriverUtil.verifyText(xpathsPropertiesFile, "permanentAddressInBoxUnderSubmitButton", expectedText);
    }
}
