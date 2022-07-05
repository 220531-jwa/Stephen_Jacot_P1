package dev.jacot.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import dev.jacot.pages.ManagerHomePage;
import dev.jacot.runners.ViewAllFormsRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewAllFromsStepImpl 
{
	private WebDriver driver = ViewAllFormsRunner.driver;
	private ManagerHomePage managerHomePage = ViewAllFormsRunner.managerHomePage;
	@Given("a Manager is on the Manager Homepage")
	public void a_manager_is_on_the_manager_homepage() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://localhost:8010/managerhomepage.html");
	}

	@When("the Manager clicks on the View forms button")
	public void the_manager_clicks_on_the_view_forms_button() {
	    // Write code here that turns the phrase above into concrete actions
		managerHomePage.mViewForms.click();
	}

	@Then("the Manager should be able to view all employee forms")
	public void the_manager_should_be_able_to_view_all_employee_forms() {
	    // Write code here that turns the phrase above into concrete actions
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.visibilityOf(managerHomePage.mViewForms));
	
		assertEquals(true, managerHomePage.mViewForms.isDisplayed());
	}

}
