package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.TestNGBase;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNGBase{
	
	@Test
	public void verifyAddUserFunctionality() throws IOException
	{
		//To Login to website
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");//Data driven approach is preferred
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");// here login page is the excel sheet name
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		username.sendKeys(usernameValue);// here the value from excel is passed to the field available
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[text()='Sign In']"));
		login.click();
		//to click on More Info option in home page
		WebElement adminMoreInfo = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'and @class='small-box-footer']"));
		adminMoreInfo.click();
		
		FakerUtility fakerUtility = new FakerUtility();
		String randomName=fakerUtility.createRandomUserName();
		String randomPassword=fakerUtility.createRandomPassword();
		String userType=ExcelUtility.getStringData(1, 2,"HomePage");
		
		WebElement newButton = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		newButton.click();
		
		WebElement addUsername = driver.findElement(By.xpath("//input[@id='username']"));
		addUsername.sendKeys(randomName);
		
		WebElement addPassword = driver.findElement(By.xpath("//input[@id='password']"));
		addPassword.sendKeys(randomPassword);
		
		WebElement usertype = driver.findElement(By.xpath("//select[@id='user_type']"));
		Select select = new Select(usertype);
		select.selectByVisibleText(userType);
			
		
	}

}
