package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Logout;

public class Logout_stepDefinition {
	
	Logout em4 = new Logout();
	
	@When("^User clicks on profile icon and clicks logout$")
	    public void user_clicks_on_profile_icon_and_clicks_logout() throws Throwable {
	        em4.click_logout();
	        Thread.sleep(2000);
	    }

	    @Then("^User should be logged out$")
	    public void user_should_be_logged_out() throws Throwable {
	    	em4.logout_validation();
	        
	    }


}
