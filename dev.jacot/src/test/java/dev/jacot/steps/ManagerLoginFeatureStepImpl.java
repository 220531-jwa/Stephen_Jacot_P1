package dev.jacot.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import dev.jacot.pages.ManagerLoginPage;
import dev.jacot.runners.ManagerLoginRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class ManagerLoginFeatureStepImpl 
{
	private WebDriver driver = ManagerLoginRunner.driver;
	private ManagerLoginPage managerLoginPage = ManagerLoginRunner.managerLoginPage;

	@Given("a Manager is on the Manager login page.")
	public void a_manager_is_on_the_manager_login_page() {
		driver.get("http://localhost:8010/managerloginpage.html");
	}

	@When("the Manager types in their {string} and {string} and clicks on the login button")
	public void the_manager_types_in_their_and_and_clicks_on_the_login_button(String manageUsername, String managePassword) {
		managerLoginPage.usernameInput.sendKeys(manageUsername);
		managerLoginPage.passwordInput.sendKeys(managePassword);
		managerLoginPage.loginButton.click();
	}

	@Then("the Manager should be on the Manager Homepage")
	public void the_manager_should_be_on_the_manager_home_page() {
		// we need to incorporate a WAIT here....
		// here's an Explicit Wait
		new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.titleContains("ManagerHomepage"));
		
		assertEquals("ManagerHomepage", driver.getTitle());
	}

}
