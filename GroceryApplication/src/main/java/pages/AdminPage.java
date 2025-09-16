package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminPage {

public WebDriver driver;
PageUtility  pageutility = new PageUtility();
	
	public AdminPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);//this keyword in pagefactory helps to access the details of entire login 
	}
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'and @class='small-box-footer']")WebElement adminMoreInfo;
	public void clickAdminInfo()
	{
		//WebElement adminMoreInfo = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'and @class='small-box-footer']"));
		//adminMoreInfo.click(); instead of this line the below line for  page utility line is added
		pageutility.clickElement(adminMoreInfo);
	}
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")WebElement newButton;
	public void clickNewButton()
	{
		//WebElement newButton = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		//newButton.click();
		pageutility.clearElementData(newButton);
	}
	
	@FindBy(xpath = "//input[@id='username']")WebElement addUsername;
	public void enterUsername(String randomName)
	{
		//WebElement addUsername = driver.findElement(By.xpath("//input[@id='username']"));
		//addUsername.sendKeys(randomName);
		pageutility.sendDataToElement(addUsername, randomName);
	}
	
	@FindBy(xpath = "//input[@id='password']")WebElement addPassword;
	public void enterPassword(String randomPassword)
	{
		//WebElement addPassword = driver.findElement(By.xpath("//input[@id='password']"));
		//addPassword.sendKeys(randomPassword);
		pageutility.sendDataToElement(addPassword, randomPassword);
	}
	
	@FindBy(xpath = "//select[@id='user_type']")WebElement usertype;	
	public void chooseUsertype(String userTypeValue)
	{
		//WebElement usertype = driver.findElement(By.xpath("//select[@id='user_type']"));
		//Select select = new Select(usertype);
		//select.selectByVisibleText(userType);
		pageutility.selectdatawithVisibleText(usertype, userTypeValue);
	}
	
	@FindBy(xpath ="//button[@name='Create']")WebElement savebutton;
	public void clickSaveButton()
	{
		//WebElement savebutton=driver.findElement(By.xpath("//button[@name='Create']"));
		
		//savebutton.click();
		pageutility.clickElement(savebutton);
	
	}
	
	//assertion web element and method
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement addUseralert;
	public boolean isAlertDisplayed()
	{
		return addUseralert.isDisplayed();
	}
}
