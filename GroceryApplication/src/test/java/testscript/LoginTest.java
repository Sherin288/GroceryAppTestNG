package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestNGBase;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {
	
	@Test
	public void verifyLoginWithValidCredentials() throws IOException {
        
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");//Data driven approach is preferred
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");// here login page is the excel sheet name
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		username.sendKeys(usernameValue);// here the value from excel is passed to the field available
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[text()='Sign In']"));
		login.click();
	}
	
	@Test  //Testcase 2
	public void VerifyLoginWithInvalidPassword() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(2, 1, "LoginPage");
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		username.sendKeys(usernameValue);
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[text()='Sign In']"));
		login.click();
	}
	
	@Test  //Testcase 3
	public void VerifyLoginWithInvalidUsername() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(3, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(3, 1, "LoginPage");
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		username.sendKeys(usernameValue);
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[text()='Sign In']"));
		login.click();
	}
	
	@Test  //Testcase 4
	public void VerifyLoginWithInvalidUsernameandPassword() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(4, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(4, 1, "LoginPage");
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		username.sendKeys(usernameValue);
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[text()='Sign In']"));
		login.click();
	}
}
