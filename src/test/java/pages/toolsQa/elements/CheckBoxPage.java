package pages.toolsQa.elements;

import utils.WebDriverUtil;
import utils.XpathsPropertiesFile;

public class CheckBoxPage {
    private final XpathsPropertiesFile xpathsPropertiesFile = new XpathsPropertiesFile(
            "toolsQa//elements",
            "checkBoxPageXpaths.properties"
    );

    public void navigateToTextBoxPage() {
        WebDriverUtil.navigateToPage("https://demoqa.com/checkbox");
    }

    public void selectNotesWhichIsUnderDesktopWhichIsUnderHome() {
        click("homeExpandButton");
        click("desktopExpandButton");
        click("notesCheckBox");
    }

    private void click(String xpathName) {
        WebDriverUtil.waitForWebElementToBeClickable(xpathsPropertiesFile, xpathName);
        WebDriverUtil.click(xpathsPropertiesFile, xpathName);
        WebDriverUtil.takeScreenshot();
    }

    public void thereIsMessageIndicatingIHaveSelectedNotes() {
        WebDriverUtil.verifyText(xpathsPropertiesFile, "firstPartOfMessageWhenSomethingIsSelected",
                "You have selected :");
        WebDriverUtil.verifyText(xpathsPropertiesFile, "secondPartOfMessageWhenSomethingIsSelected",
                "notes");
    }
}
