package dev.jacot.steps;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import dev.jacot.pages.ManagerHomePage;
import dev.jacot.pages.ApproveFormPage;
import dev.jacot.runners.ApproveFormRunner;
import dev.jacot.runners.ViewAllFormsRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApproveFormImpl 
{
	private WebDriver driver = ApproveFormRunner.driver;
	private ManagerHomePage managerHomePage = ApproveFormRunner.managerHomePage;
	private ApproveFormPage approveFormPage = ApproveFormRunner.approveFormPage;
	@Given("a Manager is on the Manager Home Page")
	public void a_manager_is_on_the_manager_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://localhost:8010/managerhomepage.html");
	}

	@When("the Manager clicks on the hyperlink")
	public void the_manager_clicks_on_the_hyperlink() {
	    // Write code here that turns the phrase above into concrete actions
	    managerHomePage.mApproveForm.click();
	}

	@Then("they are redirected to the approve form page")
	public void they_are_redirected_to_the_approve_form_page() {
	    // Write code here that turns the phrase above into concrete actions
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.titleContains("Approve Form"));
	
		assertEquals("Approve Form", driver.getTitle());
	}

	@When("the Manager inputs {string}")
	public void the_manager_inputs(String formid) {
	    // Write code here that turns the phrase above into concrete actions
	    approveFormPage.mApproveFormInput.sendKeys(formid);
	    approveFormPage.mApproveFormButton.click();
	}

	@Then("the form is approved")
	public void the_form_is_approved() {
	    // Write code here that turns the phrase above into concrete actions
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.titleContains("ManagerHomepage"));
	
		assertEquals("ManagerHomepage", driver.getTitle());
	}
}
