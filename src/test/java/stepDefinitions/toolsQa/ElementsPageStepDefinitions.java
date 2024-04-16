package stepDefinitions.toolsQa;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.toolsQa.elements.CheckBoxPage;
import pages.toolsQa.elements.RadioButtonPage;
import pages.toolsQa.elements.TextBoxPage;

public class ElementsPageStepDefinitions {
    private final TextBoxPage textBoxPage = new TextBoxPage();
    private final CheckBoxPage checkBoxPage = new CheckBoxPage();
    private final RadioButtonPage radioButtonPage = new RadioButtonPage();

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
}
