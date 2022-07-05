package dev.jacot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApproveFormPage {
	
	private WebDriver driver;
	
	public ApproveFormPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "approveId")
	public WebElement mApproveFormInput;
	
	@FindBy(id = "/html/body/button[1]")
	public WebElement mApproveFormButton;

}
