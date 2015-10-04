Feature: Log into Gmail account
 Scenario: user login with valid credentials
  Given I navigate to "http://www.gmail.com"
  And I enter username "gobikrishnan0010"
  Then I wait for five sec
  Then I click next button
  Then I wait for five sec
  Then I enter password "gobi@456"
  Then I wait for five sec
  When I click signin button
  Then I wait for sometime
  Then I wait for sometime
  Then I wait for sometime
  Then I wait for sometime
  
    Then I cick on compose button 
  Then I wait for five sec
  Then I wait for sometime
  
  Then I add recption email as "gobikrishnant@gmail.com"
  Then I wait for five sec
  And I add subject as "test"
  Then I wait for five sec
  And I add email message as "test mail body"
  Then I wait for five sec
  Then i click on send button
  Then I wait for sometime
  
  Then i navigate to sent mail page
  Then I wait for five sec
  And I check last sent subject "test"
  Then I wait for five sec
  
  Then I logout from gmail 
  Then I wait for five sec
  And I check that I have logged out 
  
  