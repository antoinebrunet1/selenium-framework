package pages.toolsQa.elements;

import utils.FilesUtil;
import utils.WebDriverUtil;
import utils.XpathsPropertiesFile;

import java.io.IOException;

public class UploadAndDownloadPage {
    private final XpathsPropertiesFile xpathsPropertiesFile = new XpathsPropertiesFile(
            "toolsQa//elements",
            "uploadAndDownloadPageXpaths.properties"
    );

    public void navigateToUploadAndDownloadPage() {
        WebDriverUtil.navigateToPage("https://demoqa.com/upload-download");
    }

    public void uploadFile() {
        String absolutePath = "C:\\Users\\Utilisateur\\IdeaProjects\\selenium-framework\\src\\test\\resources\\fileForUpload.txt";
        String uploadButtonXpath = xpathsPropertiesFile.getXpath("uploadButton");

        WebDriverUtil.uploadFile(absolutePath, uploadButtonXpath);
    }

    public void pathOfFileIsThere() {
        WebDriverUtil.verifyText(xpathsPropertiesFile, "pathOfFile",
                "C:\\fakepath\\fileForUpload.txt");
    }

    public void clickOnDownload() throws IOException {
        FilesUtil.clearDownloadFolder();
        WebDriverUtil.waitForWebElementToBeClickable(xpathsPropertiesFile, "downloadButton");
        WebDriverUtil.click(xpathsPropertiesFile, "downloadButton");
    }

    public void fileHasBeenDownloaded() {
        FilesUtil.fileHasBeenDownloaded("sampleFile.jpeg");
    }
}
