package testscript;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import constant.Constants;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {
	
	@Test(priority = 1,description = "Login with valid credentials")
	public void verifyLoginWithValidCredentials() throws IOException {
        
		String usernameValue=ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);//Data driven approach is preferred
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);// here login page is the excel sheet name
		
		LoginPage loginpage = new LoginPage(driver);//object for Loginpage class is created
		loginpage.enterUsername(usernameValue);	//username method is invoked in LoginPage class
		loginpage.enterPassword(passwordValue);// password method is invoked in LoginPage class
		loginpage.clickOnSignin();
		//Assertion
		String actual = driver.getCurrentUrl();
		String expected = "https://groceryapp.uniqassosiates.com/admin";
		Assert.assertEquals(actual, expected,"Login Failed");//Login failed is displayed when test case fails
		
	}
	
	@Test  (priority = 2,description ="Login With Invalid Password" )//Testcase 2
	public void VerifyLoginWithInvalidPassword() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(2, 0, Constants.LOGINSHEET);
		String passwordValue = ExcelUtility.getStringData(2, 1, Constants.LOGINSHEET);
		
		LoginPage loginpage = new LoginPage(driver);//object for Loginpage class is created
		loginpage.enterUsername(usernameValue);	//username method is invoked in LoginPage class
		loginpage.enterPassword(passwordValue);// password method is invoked in LoginPage class
		loginpage.clickOnSignin();
		
		boolean isloginalertdisplayed = loginpage.isLoginAlertDisplayed();// test calls the isLoginAlertDisplayed() method → it gets either true or false.
		Assert.assertTrue(isloginalertdisplayed, "Login with invalid password functionality failed");
	}
	
	@Test (priority = 3,description = "Login With Invalid Username") //Testcase 3
	public void VerifyLoginWithInvalidUsername() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(3, 0, Constants.LOGINSHEET);
		String passwordValue = ExcelUtility.getStringData(3, 1,Constants.LOGINSHEET);
		
		LoginPage loginpage = new LoginPage(driver);//object for Loginpage class is created
		loginpage.enterUsername(usernameValue);	//username method is invoked in LoginPage class
		loginpage.enterPassword(passwordValue);// password method is invoked in LoginPage class
		loginpage.clickOnSignin();
		
		boolean isloginalertdisplayed = loginpage.isLoginAlertDisplayed();// test calls the isLoginAlertDisplayed() method → it gets either true or false.
		Assert.assertTrue(isloginalertdisplayed, "Login with invalid username functionality failed");
	}
	
	@Test  (priority = 4,description = "Login With Invalid Username and Password")//Testcase 4
	public void VerifyLoginWithInvalidUsernameandPassword() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(4, 0, Constants.LOGINSHEET);
		String passwordValue = ExcelUtility.getStringData(4, 1, Constants.LOGINSHEET);
		
		LoginPage loginpage = new LoginPage(driver);//object for Loginpage class is created
		loginpage.enterUsername(usernameValue);	//username method is invoked in LoginPage class
		loginpage.enterPassword(passwordValue);// password method is invoked in LoginPage class
		loginpage.clickOnSignin();
		
		boolean isloginalertdisplayed = loginpage.isLoginAlertDisplayed();// test calls the isLoginAlertDisplayed() method → it gets either true or false.
		Assert.assertTrue(isloginalertdisplayed, "Login with invalid username and  password functionality failed");
	}
}
