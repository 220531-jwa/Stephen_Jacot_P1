package dev.jacot.steps;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.jacot.pages.ManagerHomePage;
import dev.jacot.pages.StatusViewPage;
import dev.jacot.runners.ViewAllEmployeeFormRunner;
import dev.jacot.runners.ViewAllFormsRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class ViewAllFormsEmployeeImpl 
{
	private WebDriver driver = ViewAllEmployeeFormRunner.driver;
	private StatusViewPage statusViewPage = ViewAllEmployeeFormRunner.statusViewPage;
	@Given("a Employee is on the view status page")
	public void a_employee_is_on_the_view_status_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://localhost:8010/viewstatuspage.html");
	}

	@When("the Employee clicks on the view button")
	public void the_employee_clicks_on_the_view_button() {
	    // Write code here that turns the phrase above into concrete actions
		statusViewPage.eViewStatus.click();
	}

	@Then("the Employee should be able to view all of their forms")
	public void the_employee_should_be_able_to_view_all_of_their_forms() {
	    // Write code here that turns the phrase above into concrete actions
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.visibilityOf(statusViewPage.eViewStatus));
	
		assertEquals(true, statusViewPage.eViewStatus.isDisplayed());
	}
}
