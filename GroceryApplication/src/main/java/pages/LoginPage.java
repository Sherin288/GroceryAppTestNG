package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class LoginPage {
	
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();//explicit wait
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);//PageFactory is a Selenium class that initializes all the WebElements in the current page class. 
	}
	@FindBy(xpath = "//input[@placeholder='Username']")WebElement username;
	public LoginPage enterUsername(String usernameValue)
	{
		
		pageutility.sendDataToElement(username, usernameValue);//sendDataToElement is the name of page utility class
		return this;
	}
	
	@FindBy(xpath = "//input[@placeholder='Password']") WebElement password;// webelement can be reused multiple times within the class , also we can used as password.IsDisplayed
	public LoginPage enterPassword(String passwordValue )
	{
		
		pageutility.sendDataToElement(password, passwordValue);
		return this;//to return current class object this is 
		
	}
	
	@FindBy (xpath = "//button[text()='Sign In']") WebElement loginBtn;
	public HomePage clickOnSignin()
	{
		
		waitutility.waitUntilClickable(driver, loginBtn);//from wait utility wait until the element is clickable for 5 sec , explicit wait
		pageutility.clickElement(loginBtn);
		return new HomePage(driver);//to return object of  home page ,
	}
	
	//assertion webelement and method
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']") WebElement loginAlert;
    public boolean isLoginAlertDisplayed()
    {
    	return loginAlert.isDisplayed();//isdisplayed is built in function which returns boolean value associated to webelement stored in loginAlert webelement variable
    }
}
