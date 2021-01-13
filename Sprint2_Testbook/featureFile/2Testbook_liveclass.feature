#Author: Swarali
#Date: 13/1/2021
@Testbook_2
Feature: Attend Live Classes
  
  Scenario: Live Tab options
    When User clicks on Live Classes from live tab
    Then List of videos should be visible 
    
  Scenario: Attend Live Class
  	When User selects video
  	Then User is redirected to respective video page 
    