package selenium.runner;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

import java.io.File;

import org.junit.jupiter.api.Tag;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.jacot.pages.EmployeeHomePage;
import dev.jacot.pages.FormSubmitPage;
import dev.jacot.pages.LoginPage;

@Suite
@Tag("CucumberTests")
@IncludeTags("CucumberTests")
public class SeleniumRunner {
	
	public static WebDriver driver;
	public static LoginPage loginPage;
	public static EmployeeHomePage employeeHomepage;
	public static FormSubmitPage submitPage;
	
	
	@BeforeAll
	public static void setup()
	{
		File chrome = new File("src/test/resources/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		
		driver = new ChromeDriver();
		
		loginPage = new LoginPage(driver);
		employeeHomepage = new EmployeeHomePage(driver);
		submitPage = new FormSubmitPage(driver);
		
	}
	
	@AfterAll
	public static void teardown()
	{
		driver.quit();
	}

}
