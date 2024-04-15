package stepDefinitions.toolsQa;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.toolsQa.elements.TextBoxPage;

public class ElementsPageStepDefinitions {
    TextBoxPage textBoxPage = new TextBoxPage();

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
}
