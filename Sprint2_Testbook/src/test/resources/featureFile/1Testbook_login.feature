@Testbook_1
Feature: Login with email
	
	@Login
	Scenario Outline: Login with email
		Given user is on testbook website
		When User clicks on Login button
		And user enters valid <email> and valid <password> and clicks login
		Then Testbook home page is displayed
			
			@Valid
			Examples:
			|email|password|
			|bpt0804@gmail.com | StepupTest@3248 |
			
		  @Invalid
		  Examples: 
			|email|password|
			|bpt0804@gmail.com | 12345 |
			