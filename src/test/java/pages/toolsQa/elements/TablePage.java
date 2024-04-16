package pages.toolsQa.elements;

import utils.WebDriverUtil;
import utils.XpathsPropertiesFile;

public class TablePage {
    private final XpathsPropertiesFile xpathsPropertiesFile = new XpathsPropertiesFile(
            "toolsQa//elements",
            "tablePageXpaths.properties"
    );

    public void navigateToTablePage() {
        WebDriverUtil.navigateToPage("https://demoqa.com/webtables");
    }

    public void clickOnDeleteForFirstRow() {
        WebDriverUtil.waitForWebElementToBeClickable(xpathsPropertiesFile, "deleteButtonForFirstRow");
        WebDriverUtil.click(xpathsPropertiesFile, "deleteButtonForFirstRow");
    }

    public void deletedRowIsNoLongerPresent() {
        WebDriverUtil.waitForElementToBeAbsent(xpathsPropertiesFile, "firstRow");
        WebDriverUtil.takeScreenshot();
    }

    public void clickOnModifyForFirstRow() {
        WebDriverUtil.waitForWebElementToBeClickable(xpathsPropertiesFile, "modifyButtonForFirstRow");
        WebDriverUtil.click(xpathsPropertiesFile, "modifyButtonForFirstRow");
    }

    public void changeFirstNameForFirstRow(String newFullName) {
        waitForWindowToModifyRowsAndToAddRow();

        String xpath = xpathsPropertiesFile.getXpath("firstNameInput");

        WebDriverUtil.clearElement(xpath);
        WebDriverUtil.takeScreenshot();
        WebDriverUtil.sendText(xpath, newFullName);
        WebDriverUtil.takeScreenshot();
    }

    private void waitForWindowToModifyRowsAndToAddRow() {
        String xpath = xpathsPropertiesFile.getXpath("windowToModifyRowsAndToAddRow");

        WebDriverUtil.waitForElementToBePresent(xpath);
        WebDriverUtil.takeScreenshot();
    }

    public void firstRowHasNewFirstName(String newFullName) {
        waitForWindowToModifyRowsAndToAddRowToBeAbsent();

        WebDriverUtil.verifyText(xpathsPropertiesFile, "firstNameInTable", newFullName);
    }

    private void waitForWindowToModifyRowsAndToAddRowToBeAbsent() {
        WebDriverUtil.waitForElementToBeAbsent(xpathsPropertiesFile, "windowToModifyRowsAndToAddRow");
    }

    public void clickOnAdd() {
        WebDriverUtil.waitForWebElementToBeClickable(xpathsPropertiesFile, "addButton");
        WebDriverUtil.click(xpathsPropertiesFile, "addButton");
    }

    public void enterFirstName(String firstName) {
        waitForWindowToModifyRowsAndToAddRow();
        WebDriverUtil.fillField(xpathsPropertiesFile, "firstNameInput", firstName);
    }

    public void enterLastName(String lastName) {
        WebDriverUtil.fillField(xpathsPropertiesFile, "lastNameInput", lastName);
    }

    public void enterEmail(String email) {
        WebDriverUtil.fillField(xpathsPropertiesFile, "emailInput", email);
    }

    public void enterAge(String age) {
        WebDriverUtil.fillField(xpathsPropertiesFile, "ageInput", age);
    }

    public void enterSalary(String salary) {
        WebDriverUtil.fillField(xpathsPropertiesFile, "salaryInput", salary);
    }

    public void enterDepartment(String department) {
        WebDriverUtil.fillField(xpathsPropertiesFile, "departmentInput", department);
    }

    public void firstNameOfNewRowIsCorrect(String firstName) {
        fieldIsCorrect("firstNameOfNewRow", firstName);
    }

    public void lastNameOfNewRowIsCorrect(String lastName) {
        fieldIsCorrect("lastNameOfNewRow", lastName);
    }

    public void ageNameOfNewRowIsCorrect(String age) {
        fieldIsCorrect("ageOfNewRow", age);
    }

    public void emailOfNewRowIsCorrect(String email) {
        fieldIsCorrect("emailOfNewRow", email);
    }

    public void salaryOfNewRowIsCorrect(String salary) {
        fieldIsCorrect("salaryOfNewRow", salary);
    }

    public void departmentOfNewRowIsCorrect(String department) {
        fieldIsCorrect("departmentOfNewRow", department);
    }

    private void fieldIsCorrect(String xpathName, String expectedText) {
        String xpath = xpathsPropertiesFile.getXpath(xpathName);

        WebDriverUtil.waitForElementToHaveText(xpath, expectedText);
        WebDriverUtil.takeScreenshot();
    }
}
