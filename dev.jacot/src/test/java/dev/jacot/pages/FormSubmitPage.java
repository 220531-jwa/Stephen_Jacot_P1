package dev.jacot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormSubmitPage 
{
	private WebDriver driver;
	
	public FormSubmitPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "firstN")
	public WebElement eFirstName;
	
	@FindBy(id = "lastName")
	public WebElement eLastName;
	
	@FindBy(id = "date")
	public WebElement eDate;
	
	@FindBy(id = "eventTime")
	public WebElement eTime;
	
	@FindBy(id = "eLocation")
	public WebElement eLocation;
	
	@FindBy(id = "select")
	public WebElement eSelect;
	
	@FindBy(id = "cost")
	public WebElement eCost;
	
	@FindBy(id = "grading")
	public WebElement eGrades;
	
	@FindBy(id = "justification")
	public WebElement eJustification;
	
	@FindBy(id = "eventDescription")
	public WebElement eEventDescription;
	
	@FindBy(id = "eId")
	public WebElement eId;
	
	@FindBy(id = "button")
	public WebElement eButton;

}
