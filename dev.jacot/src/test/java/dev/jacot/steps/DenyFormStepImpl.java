package dev.jacot.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.jacot.pages.ApproveFormPage;
import dev.jacot.pages.DenyFormPage;
import dev.jacot.pages.ManagerHomePage;
import dev.jacot.runners.ApproveFormRunner;
import dev.jacot.runners.DenyFormRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class DenyFormStepImpl 
{
	private WebDriver driver = DenyFormRunner.driver;
	private DenyFormPage denyFormPage = DenyFormRunner.denyFormPage;
	
	@Given("a manager is on the deny form page")
	public void a_manager_is_on_the_deny_form_page() 
	{
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://localhost:8010/denyformpage.html");
	}

	@When("a Manager inputs {string}>")
	public void a_manager_inputs(String formid) {
	    // Write code here that turns the phrase above into concrete actions
		denyFormPage.mDenyFormInput.sendKeys(formid);
	}

	@Then("the form is denied")
	public void the_form_is_denied() {
	    // Write code here that turns the phrase above into concrete actions
		new WebDriverWait(driver, Duration.ofSeconds(100))
		.until(ExpectedConditions.elementToBeClickable(denyFormPage.mDenyFormButton));
	
		assertEquals(true, denyFormPage.mDenyFormButton.isEnabled());
	}

}
