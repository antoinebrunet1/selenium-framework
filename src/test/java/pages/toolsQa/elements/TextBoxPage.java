package pages.toolsQa.elements;

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
}
