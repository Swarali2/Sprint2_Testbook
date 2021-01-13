package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LiveClasses;

public class Liveclasses_stepDefinition {
	LiveClasses em5 = new LiveClasses();
	
	@When("^User clicks on Live Classes from live tab$")
    public void user_clicks_on_live_classes_from_live_tab() throws Throwable {
        em5.LiveTab();
        Thread.sleep(2000);
    }
	
	@Then("^List of videos should be visible$")
    public void list_of_videos_should_be_visible() throws Throwable {
        em5.expandedView();
    }

    @When("^User selects video$")
    public void user_selects_video() throws Throwable {
       em5.click_Video();
       Thread.sleep(3000);
    }

    @Then("^User is redirected to respective video page$")
    public void user_is_redirected_to_respective_video_page() throws Throwable {
        em5.validate_video_page();
    }


}
