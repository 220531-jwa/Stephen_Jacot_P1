package dev.jacot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerLoginPage 
{
	private WebDriver driver;
	
	public ManagerLoginPage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "mname")
	public WebElement usernameInput;
	
	@FindBy(id = "mpass")
	public WebElement passwordInput;
	
	@FindBy(xpath= "/html/body/div/button")
	public WebElement loginButton;
	
	
}
