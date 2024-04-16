package pages.toolsQa.elements;

import utils.WebDriverUtil;
import utils.XpathsPropertiesFile;

public class RadioButtonPage {
    private final XpathsPropertiesFile xpathsPropertiesFile = new XpathsPropertiesFile(
            "toolsQa//elements",
            "radioButtonPageXpaths.properties"
    );

    public void navigateToRadioButtonPage() {
        WebDriverUtil.navigateToPage("https://demoqa.com/radio-button");
    }

    public void selectYes() {
        String xpath = xpathsPropertiesFile.getXpath("yesButton");

        WebDriverUtil.waitForWebElementToBeClickable(xpath);
        WebDriverUtil.click(xpath);
    }

    public void thereIsMessageIndicatingIHaveSelectedYes() {
        WebDriverUtil.verifyText(xpathsPropertiesFile, "messageWhenSomethingIsSelected",
                "You have selected Yes");
    }
}
