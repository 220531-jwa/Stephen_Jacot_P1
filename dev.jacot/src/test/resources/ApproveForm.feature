#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Approve Form Feature

	Background: 
	Given a Manager is on the Manager Home Page

  Scenario: A Manager can click the Approve Employee Reimbursement hyperlink
    When the Manager clicks on the hyperlink
    Then they are redirected to the approve form page
    
  Scenario Outline: After being redirected the manager is prompted to enter a form id
    When the Manager inputs "<formid>"
    Then the form is approved

    Examples: 
      | formid|
      | 1     |