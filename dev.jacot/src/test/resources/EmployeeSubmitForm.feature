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
Feature: Submit Form

	Background:
		Given an Employee is on the Submit Form page
  Scenario Outline: the Employee should be able to submit a form
    When the Employee enters their "<date>" and their "<formtime>" and their "<formDescription>" and their "<firstname>" and their "<lastname>" and their "<eventLocation>" and their {int} and their "<formjustification>" and their "<eventtype>" and their "<gradetype>" and their "<id>"
    Then the Employee should be redirected to the homepage
    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
