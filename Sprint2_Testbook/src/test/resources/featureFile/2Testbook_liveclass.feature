@Testbook_2
Feature: Attend Live Classes
  @live_tab
  Scenario: Live Tab options
    When User clicks on Live Classes from live tab
    Then List of videos should be visible
  
  @attend_class  
  Scenario: Attend Live Class
  	When User selects video
  	Then User is redirected to respective video page
    