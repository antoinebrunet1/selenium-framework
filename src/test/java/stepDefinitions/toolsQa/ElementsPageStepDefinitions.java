package stepDefinitions.toolsQa;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.toolsQa.elements.*;

import java.io.IOException;

public class ElementsPageStepDefinitions {
    private final TextBoxPage textBoxPage = new TextBoxPage();
    private final CheckBoxPage checkBoxPage = new CheckBoxPage();
    private final RadioButtonPage radioButtonPage = new RadioButtonPage();
    private final TablePage tablePage = new TablePage();
    private final ButtonsPage buttonsPage = new ButtonsPage();
    private final UploadAndDownloadPage uploadAndDownloadPage = new UploadAndDownloadPage();

    @Given("I navigate to the text-box page")
    public void iNavigateToTheTextBoxPage() {
        textBoxPage.navigateToTextBoxPage();
    }

    @And("I enter {string} as the full name")
    public void iEnterAsTheFullName(String fullName) {
        textBoxPage.enterFullName(fullName);
    }

    @And("I enter {string} as the email")
    public void iEnterAsTheEmail(String email) {
        textBoxPage.enterEmail(email);
    }

    @And("I enter {string} as the current address")
    public void iEnterAsTheCurrentAddress(String currentAddress) {
        textBoxPage.enterCurrentAddress(currentAddress);
    }

    @And("I enter {string} as the permanent address")
    public void iEnterAsThePermanentAddress(String permanentAddress) {
        textBoxPage.enterPermanentAddress(permanentAddress);
    }

    @And("I click on submit")
    public void iClickOnSubmit() {
        textBoxPage.clickOnSubmit();
    }

    @Then("I see the entered full name {string} in the box below the submit button")
    public void iSeeTheEnteredFullNameInTheBoxBelowTheSubmitButton(String fullName) {
        textBoxPage.enteredFullNameInBoxBelowSubmitButton(fullName);
    }

    @Then("I see the entered email {string} in the box below the submit button")
    public void iSeeTheEnteredEmailInTheBoxBelowTheSubmitButton(String email) {
        textBoxPage.enteredEmailInBoxBelowSubmitButton(email);
    }

    @Then("I see the entered current address {string} in the box below the submit button")
    public void iSeeTheEnteredCurrentAddressInTheBoxBelowTheSubmitButton(String currentAddress) {
        textBoxPage.enteredCurrentAddressInBoxBelowSubmitButton(currentAddress);
    }

    @Then("I see the entered permanent address {string} in the box below the submit button")
    public void iSeeTheEnteredPermanentAddressInTheBoxBelowTheSubmitButton(String permanentAddress) {
        textBoxPage.enteredPermanentAddressIsInBoxBelowSubmitButton(permanentAddress);
    }

    @Given("I navigate to the check box page")
    public void iNavigateToTheCheckBoxPage() {
        checkBoxPage.navigateToTextBoxPage();
    }

    @And("I select Notes which is under Desktop which is under Home")
    public void iSelectNotesWhichIsUnderDesktopWhichIsUnderHome() {
        checkBoxPage.selectNotesWhichIsUnderDesktopWhichIsUnderHome();
    }

    @Then("I see the message indicating I have selected Notes")
    public void iSeeTheMessageIndicatingIHaveSelectedNotes() {
        checkBoxPage.thereIsMessageIndicatingIHaveSelectedNotes();
    }

    @Given("I navigate to the radio button page")
    public void iNavigateToTheRadioButtonPage() {
        radioButtonPage.navigateToRadioButtonPage();
    }

    @And("I select Yes")
    public void iSelectYes() {
        radioButtonPage.selectYes();
    }

    @Then("I see the message indicating I have selected Yes")
    public void iSeeTheMessageIndicatingIHaveSelectedYes() {
        radioButtonPage.thereIsMessageIndicatingIHaveSelectedYes();
    }

    @Given("I navigate to the table page")
    public void iNavigateToTheTablePage() {
        tablePage.navigateToTablePage();
    }

    @And("I click on delete for the first row")
    public void iClickOnDeleteForTheFirstRow() {
        tablePage.clickOnDeleteForFirstRow();
    }

    @Then("I see the row I deleted is no longer present")
    public void iSeeTheRowIDeletedIsNoLongerPresent() {
        tablePage.deletedRowIsNoLongerPresent();
    }

    @And("I click on modify for the first row")
    public void iClickOnModifyForTheFirstRow() {
        tablePage.clickOnModifyForFirstRow();
    }

    @And("I change the first name to {string}")
    public void iChangeTheFirstNameTo(String newFirstName) {
        tablePage.changeFirstNameForFirstRow(newFirstName);
    }

    @Then("I see the first row now has the first name {string}")
    public void iSeeTheFirstRowNowHasTheFirstName(String newFirstName) {
        tablePage.firstRowHasNewFirstName(newFirstName);
    }

    @And("I click on add")
    public void iClickOnAdd() {
        tablePage.clickOnAdd();
    }

    @And("I enter {string} for the first name")
    public void iEnterForTheFirstName(String firstName) {
        tablePage.enterFirstName(firstName);
    }

    @And("I enter {string} for the last name")
    public void iEnterForTheLastName(String lastName) {
        tablePage.enterLastName(lastName);
    }

    @And("I enter {string} for the email")
    public void iEnterForTheEmail(String email) {
        tablePage.enterEmail(email);
    }

    @And("I enter {string} for the age")
    public void iEnterForTheAge(String age) {
        tablePage.enterAge(age);
    }

    @And("I enter {string} for the salary")
    public void iEnterForTheSalary(String salary) {
        tablePage.enterSalary(salary);
    }

    @And("I enter {string} for the department")
    public void iEnterForTheDepartment(String department) {
        tablePage.enterDepartment(department);
    }

    @Then("I see the first name of the new row is {string}")
    public void iSeeTheFirstNameOfTheNewRowIs(String firstName) {
        tablePage.firstNameOfNewRowIsCorrect(firstName);
    }

    @Then("I see the last name of the new row is {string}")
    public void iSeeTheLastNameOfTheNewRowIs(String lastName) {
        tablePage.lastNameOfNewRowIsCorrect(lastName);
    }

    @Then("I see the age of the new row is {string}")
    public void iSeeTheAgeOfTheNewRowIs(String age) {
        tablePage.ageNameOfNewRowIsCorrect(age);
    }

    @Then("I see the email of the new row is {string}")
    public void iSeeTheEmailOfTheNewRowIs(String email) {
        tablePage.emailOfNewRowIsCorrect(email);
    }

    @Then("I see the salary of the new row is {string}")
    public void iSeeTheSalaryOfTheNewRowIs(String salary) {
        tablePage.salaryOfNewRowIsCorrect(salary);
    }

    @Then("I see the department of the new row is {string}")
    public void iSeeTheDepartmentOfTheNewRowIs(String department) {
        tablePage.departmentOfNewRowIsCorrect(department);
    }

    @Given("I navigate to the buttons page")
    public void iNavigateToTheButtonsPage() {
        buttonsPage.navigateToButtonsPage();
    }

    @And("I double click on the first button")
    public void iDoubleClickOnTheFirstButton() {
        buttonsPage.doubleClickOnFirstButton();
    }

    @Then("I see the message indicating I have done a double click")
    public void iSeeTheMessageIndicatingIHaveDoneADoubleClick() {
        buttonsPage.thereIsMessageIndicatingIHaveDoneADoubleClick();
    }

    @And("I right click on the second button")
    public void iRightClickOnTheSecondButton() {
        buttonsPage.rightClickOnSecondButton();
    }

    @Then("I see the message indicating I have done a right click")
    public void iSeeTheMessageIndicatingIHaveDoneARightClick() {
        buttonsPage.thereIsMessageIndicatingIHaveDoneARightClick();
    }

    @Given("I navigate to the upload and download page")
    public void iNavigateToTheUploadAndDownloadPage() {
        uploadAndDownloadPage.navigateToUploadAndDownloadPage();
    }

    @And("I upload a file")
    public void iUploadAFile() {
        uploadAndDownloadPage.uploadFile();
    }

    @Then("I see the path of the file")
    public void iSeeThePathOfTheFile() {
        uploadAndDownloadPage.pathOfFileIsThere();
    }

    @And("I click on download")
    public void iClickOnDownload() throws IOException {
        uploadAndDownloadPage.clickOnDownload();
    }

    @Then("I see that the file is downloaded")
    public void iSeeThatTheFileIsDownloaded() {
        uploadAndDownloadPage.fileHasBeenDownloaded();
    }
}
