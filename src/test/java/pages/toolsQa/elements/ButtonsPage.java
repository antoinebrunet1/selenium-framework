package pages.toolsQa.elements;

import utils.WebDriverUtil;
import utils.XpathsPropertiesFile;

public class ButtonsPage {
    private final XpathsPropertiesFile xpathsPropertiesFile = new XpathsPropertiesFile(
            "toolsQa//elements",
            "buttonsPageXpaths.properties"
    );

    public void navigateToButtonsPage() {
        WebDriverUtil.navigateToPage("https://demoqa.com/buttons");
    }

    public void doubleClickOnFirstButton() {
        String xpath = xpathsPropertiesFile.getXpath("doubleClickButton");

        WebDriverUtil.waitForWebElementToBeClickable(xpathsPropertiesFile, "doubleClickButton");
        WebDriverUtil.doubleClick(xpath);
    }

    public void thereIsMessageIndicatingIHaveDoneADoubleClick() {
        WebDriverUtil.verifyText(xpathsPropertiesFile, "messageIndicatingIHaveDoneADoubleClick",
                "You have done a double click");
    }

    public void rightClickOnSecondButton() {
        String xpath = xpathsPropertiesFile.getXpath("rightClickButton");

        WebDriverUtil.waitForWebElementToBeClickable(xpathsPropertiesFile, "rightClickButton");
        WebDriverUtil.rightClick(xpath);
    }

    public void thereIsMessageIndicatingIHaveDoneARightClick() {
        WebDriverUtil.verifyText(xpathsPropertiesFile, "messageIndicatingIHaveDoneARightClick",
                "You have done a right click");
    }
}
