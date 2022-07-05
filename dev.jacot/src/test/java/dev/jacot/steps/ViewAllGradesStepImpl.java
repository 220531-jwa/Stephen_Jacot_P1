package dev.jacot.steps;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import dev.jacot.pages.ViewGradesPage;
import dev.jacot.runners.ViewAllGradesRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class ViewAllGradesStepImpl 
{
	
	private WebDriver driver = ViewAllGradesRunner.driver;
	private ViewGradesPage viewGradesPage = ViewAllGradesRunner.viewGradesPage;
	
	@Given("a Manager is on the view grades page")
	public void a_manager_is_on_the_view_grades_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://localhost:8010/gradespage.html");
	}

	@When("the manager clicks on the view button")
	public void the_manager_clicks_on_the_view_button() {
	    // Write code here that turns the phrase above into concrete actions
		viewGradesPage.mViewGradesButton.click();
	}

	@Then("the Manager should be able to view all the grades")
	public void the_manager_should_be_able_to_view_all_the_grades() {
	    // Write code here that turns the phrase above into concrete actions
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.visibilityOf(viewGradesPage.mViewGradesButton));
	
		assertEquals(true, viewGradesPage.mViewGradesButton.isDisplayed());
	}

	
}
