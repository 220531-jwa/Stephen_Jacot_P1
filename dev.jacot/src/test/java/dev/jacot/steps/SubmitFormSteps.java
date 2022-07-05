package dev.jacot.steps;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.jacot.pages.EmployeeHomePage;
import dev.jacot.pages.FormSubmitPage;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import selenium.runner.SeleniumRunner;

//public class SubmitFormSteps 
//{
//	private WebDriver driver = SeleniumRunner.driver;
//	
//	private FormSubmitPage submitPage = SeleniumRunner.submitPage;
//	
//	private EmployeeHomePage ePage = SeleniumRunner.employeeHomepage;
//	
//	@Given("an Employee is on the Submit Form page")
//	public void an_employee_is_on_the_submit_form_page() {
//	    driver.get("http://localhost:8010/reimbursementform.html");
//	    
//	}
//
//	@When("the Employee enters their {string} and their {string} and their {string} and their {string} and their {string} and their {string} and their \\{int} and their {string} and their {string} and their {string} and their {string}")
//	public void the_employee_enters_their_and_their_and_their_and_their_and_their_and_their_and_their_and_their_and_their_and_their_and_their(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10) {
//		submitPage.eFirstName.sendKeys("Daniel");
//		submitPage.eLastName.sendKeys("Felleman");
//		submitPage.eDate.click();
//		submitPage.eTime.click();
//		submitPage.eLocation.sendKeys("Roosevelt Drive");
//		submitPage.eCost.sendKeys("500");
//		submitPage.eGrades.click();
//		submitPage.eJustification.sendKeys("Just another day");
//		submitPage.eEventDescription.sendKeys("Not too bad");
//		submitPage.eId.sendKeys("1");
//		submitPage.eButton.click();
//	}
//	
//
//	@Then("the Employee should be redirected to the homepage")
//	public void the_employee_should_be_redirected_to_the_homepage() {
//	   new WebDriverWait(driver, Duration.ofSeconds(100)).until(ExpectedConditions.visibilityOf(ePage.eCreateReimbursements));
//	   
//	   
//	}
//
//}
