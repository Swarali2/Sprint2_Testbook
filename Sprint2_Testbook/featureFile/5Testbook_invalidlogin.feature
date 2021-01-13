@Testbook_5
Feature: Login with invalid credentials
	
	@Login
	Scenario Outline: Login with email
		Given user is on testbook website
		When User clicks on Login button
		And user enters valid <email> and valid <password> and clicks login
		Then Testbook home page is displayed
			
			@Valid
			Examples:
			|email|password|
			|swaranand421@gmail.com|Shivani|