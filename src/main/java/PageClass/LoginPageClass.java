package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class LoginPageClass extends BaseClass
{
WebDriver driver; //self // Global variable --> non-static
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement Email ;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password ; 
	
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement submit ;
	
	public LoginPageClass(WebDriver driver) //local variable
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); //initiate all the web elements on driver
	}
	
	
	public void login(String Username, String userPassword)
	{
		Email.sendKeys(Username);
		password.sendKeys(userPassword);
		submit.click();
	}


}
