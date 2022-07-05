package dev.jacot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DenyFormPage 
{

	private WebDriver driver;
	
	public DenyFormPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "formId")
	public WebElement mDenyFormInput;
	
	@FindBy(id = "/html/body/button[1]")
	public WebElement mDenyFormButton;
}
