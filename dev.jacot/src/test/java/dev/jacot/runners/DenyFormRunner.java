package dev.jacot.runners;

import java.io.File;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.jacot.pages.ApproveFormPage;
import dev.jacot.pages.DenyFormPage;
import dev.jacot.pages.ManagerHomePage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "dev.jacot.steps")
public class DenyFormRunner 
{
	public static DenyFormPage denyFormPage;
	
	public static WebDriver driver;
	
	@BeforeAll
	public static void setup() {
		
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		driver = new ChromeDriver();
		
		denyFormPage = new DenyFormPage(driver);
	}
	
	@AfterAll
	public static void teardown() 
	{
		driver.quit();
	}

}
