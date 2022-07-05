package dev.jacot.steps;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.jacot.pages.LoginPage;
import dev.jacot.runners.EmployeeLoginRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFeatureStepImpl 
{
	
	private WebDriver driver = EmployeeLoginRunner.driver;
	private LoginPage loginPage = EmployeeLoginRunner.loginPage;

	@Given("a Employee is on the EmployeeLoginPage")
	public void a_employee_is_on_the_employee_login_page() {
		driver.get("http://localhost:8010/loginpage.html");
	}

	@When("the Employee types in their {string} and {string} and clicks the EmployeeLoginButton")
	public void the_employee_types_in_their_and_and_clicks_the_employee_login_button(String username, String password) {
		loginPage.usernameInput.sendKeys(username);
		loginPage.passwordInput.sendKeys(password);
		loginPage.loginButton.click();
	}

	@Then("the Employee should be on the EmployeeHomePage")
	public void the_employee_should_be_on_the_employee_home_page() {
		// we need to incorporate a WAIT here....
		// here's an Explicit Wait
		new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.titleContains("Employee Homepage"));
		
		assertEquals("Employee Homepage", driver.getTitle());
	}

}
