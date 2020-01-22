@SmokeTest
Feature:Login Action

Scenario Outline:Successfull login with valid credentials
		Given User navigate to login page
		When User enters "<usernames>" and "<passwords>"
		Then Login should be Successfull
		Examples:
		
				| usernames | passwords |
				|trainee    | trainee   |
				|admin      | manager   |
				
@Smoke
Feature:Search Action

Scenario: When user opens browser
		  And user enters url
		  When user search for kadas
		  And user selects one item
		  And user clicks on Buy Now button
		  Then error message must be displayed