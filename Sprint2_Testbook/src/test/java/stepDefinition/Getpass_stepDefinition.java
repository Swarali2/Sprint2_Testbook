package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Getpass;

public class Getpass_stepDefinition {
	Getpass em = new Getpass();
	
	 @When("^User clicks on get pass$")
	    public void user_clicks_on_get_pass() throws Throwable {
	        em.click_getpass();
	    }

	    @Then("^Payment options should be displayed$")
	    public void payment_options_should_be_displayed() throws Throwable {
	        em.payment_options();
	    }

	    @And("^Selects a type of pass$")
	    public void selects_a_type_of_pass() throws Throwable {
	        em.select_type_of_pass();
	    }


}
