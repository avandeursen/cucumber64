package nl.tudelft.cucumber64;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by arie on 12/24/16.
 */
public class FeatureSteps {

    @Given("^I have chosen to sign up$")
    public void iHaveChosenToSignUp() throws Throwable {
        // Code to bring me to sign up state.
    }

    @When("^I sign up with valid details$")
    public void iSignUpWithValidDetails() throws Throwable {
        // Code to enter valid detials.
    }

    @Then("^I should receive a confirmation email$")
    public void iShouldReceiveAConfirmationEmail() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @Then("^I should see a personalized greeting message$")
    public void iShouldSeeAPersonalizedGreetingMessage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }
}

