package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminPage {

public WebDriver driver;
PageUtility  pageutility = new PageUtility();
WaitUtility waitutility = new WaitUtility();
	
	public AdminPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);//this keyword in pagefactory helps to access the details of entire login 
	}
	
	
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")WebElement newButton;
	public AdminPage clickNewButton()
	{
		//WebElement newButton = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		//newButton.click();
		waitutility.waitUntilClickable(driver, newButton);//explict wait with waitutility class
		pageutility.clearElementData(newButton);
		return this;
	}
	
	@FindBy(xpath = "//input[@id='username']")WebElement addUsername;
	public AdminPage enterUsername(String randomName)
	{
		//WebElement addUsername = driver.findElement(By.xpath("//input[@id='username']"));
		//addUsername.sendKeys(randomName);
		pageutility.sendDataToElement(addUsername, randomName);
		return this;
	}
	
	@FindBy(xpath = "//input[@id='password']")WebElement addPassword;
	public AdminPage enterPassword(String randomPassword)
	{
		//WebElement addPassword = driver.findElement(By.xpath("//input[@id='password']"));
		//addPassword.sendKeys(randomPassword);
		pageutility.sendDataToElement(addPassword, randomPassword);
		return this;
	}
	
	@FindBy(xpath = "//select[@id='user_type']")WebElement usertype;	
	public AdminPage chooseUsertype(String userTypeValue)
	{
		//WebElement usertype = driver.findElement(By.xpath("//select[@id='user_type']"));
		//Select select = new Select(usertype);
		//select.selectByVisibleText(userType);
		pageutility.selectdatawithVisibleText(usertype, userTypeValue);
		return this;
	}
	
	@FindBy(xpath ="//button[@name='Create']")WebElement savebutton;
	public AdminPage clickSaveButton()
	{
		//WebElement savebutton=driver.findElement(By.xpath("//button[@name='Create']"));
		
		//savebutton.click();
		pageutility.clickElement(savebutton);
		return this;
	
	}
	
	//assertion web element and method
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement addUseralert;
	public boolean isAlertDisplayed()
	{
		return addUseralert.isDisplayed();
	}
}
