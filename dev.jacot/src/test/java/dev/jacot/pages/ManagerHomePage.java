package dev.jacot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerHomePage 
{
	
	private WebDriver driver;
	
	public ManagerHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "denyform")
	public WebElement mDenyForm;
	
	@FindBy(id = "approveform")
	public WebElement mApproveForm;
	
	@FindBy(id = "viewforms")
	public WebElement mViewForms;
	
	@FindBy(id = "viewgrades")
	public WebElement mViewGrades;

}
