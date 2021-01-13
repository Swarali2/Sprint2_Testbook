package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Login;

public class Login_stepDefinition {
	Login em = new Login();
	@Given("^user is on testbook website$")
    public void user_is_on_testbook_website() throws Throwable {
    	em.openurl();
       
    }

    @When("^User clicks on Login button$")
    public void user_clicks_on_login_button() throws Throwable {
      em.click_login(); 
    }

    @And("^user enters valid (.+) and valid (.+) and clicks login$")
    public void user_enters_valid_and_valid_and_clicks_login(String email, String password) throws Throwable {
        em.enter_email(email);
        Thread.sleep(2000);
        em.enter_password(password);
        Thread.sleep(2000);
    }
    
    @Then("^Testbook home page is displayed$")
    public void testbook_home_page_is_displayed() throws Throwable {
        em.validate_dashboard();
    }

}
