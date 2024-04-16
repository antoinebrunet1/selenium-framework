package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class FilesUtil {
    public static final String ABSOLUTE_PATH_OF_DOWNLOAD_FOLDER = "C:\\Users\\Utilisateur\\IdeaProjects\\selenium-framework\\src\\test\\resources\\downloadFolder";

    public static void createDownloadFolderIfItDoesNotExist() {
        File directory = new File(ABSOLUTE_PATH_OF_DOWNLOAD_FOLDER);

        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    public static void clearDownloadFolder() throws IOException {
        FileUtils.cleanDirectory(new File(ABSOLUTE_PATH_OF_DOWNLOAD_FOLDER));
    }

    public static void fileHasBeenDownloaded(String fileName) {
        Wait<WebDriver> wait = new FluentWait<>(WebDriverUtil.getWebDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(250));

        wait.until(d -> fileIsPresentInDownloadFolder(fileName));
    }

    private static boolean fileIsPresentInDownloadFolder(String fileName) {
        File file = new File(ABSOLUTE_PATH_OF_DOWNLOAD_FOLDER + "//" + fileName);

        return file.exists() && !file.isDirectory();
    }
}
