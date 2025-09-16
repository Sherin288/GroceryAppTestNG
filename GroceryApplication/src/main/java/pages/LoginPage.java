package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class LoginPage {
	
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);//PageFactory is a Selenium class that initializes all the WebElements in the current page class. 
	}
	@FindBy(xpath = "//input[@placeholder='Username']")WebElement username;
	public void enterUsername(String usernameValue)
	{
		//WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));// here the value from excel is passed to the field available
		//line is commented because it is moved to line 17
		//username.sendKeys(usernameValue);
		pageutility.sendDataToElement(username, usernameValue);//sendDataToElement is the name of page utility class
		
	}
	
	@FindBy(xpath = "//input[@placeholder='Password']") WebElement password;// webelement can be reused multiple times within the class , also we can used as password.IsDisplayed
	public void enterPassword(String passwordValue )
	{
		//WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		//password.sendKeys(passwordValue);
		pageutility.sendDataToElement(password, passwordValue);
		
	}
	
	@FindBy (xpath = "//button[text()='Sign In']") WebElement loginBtn;
	public void clickOnSignin()
	{
		//WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Sign In']"));
		//loginBtn.click(); 
		pageutility.clickElement(loginBtn);
	}
	
	//assertion webelement and method
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']") WebElement loginAlert;
    public boolean isLoginAlertDisplayed()
    {
    	return loginAlert.isDisplayed();//isdisplayed is built in function which returns boolean value associated to webelement stored in loginAlert webelement variable
    }
}
