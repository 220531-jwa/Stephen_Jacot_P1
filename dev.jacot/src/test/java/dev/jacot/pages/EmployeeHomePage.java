package dev.jacot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeHomePage 
{
	private WebDriver driver;
	
	public EmployeeHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "approveId")
	public WebElement mApproveInput;
	
	@FindBy(xpath = "gradesubmissions")
	public WebElement mSubmitButton;
	

}
