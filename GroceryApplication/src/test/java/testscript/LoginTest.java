package testscript;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import constant.Constants;
import constant.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {
	
	@Test(priority = 1,description = "Login with valid credentials",retryAnalyzer = retry.Retry.class) // retry analyser is used to execute the test case again when it  fails first time 
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
		Assert.assertEquals(actual, expected,Messages.VALIDCREDENTIALERROR);//Login failed is displayed when test case fails
		
	}
	
	@Test  (priority = 2,description ="Login With Invalid Password" ,groups = {"smoke"})//Testcase 2
	public void VerifyLoginWithInvalidPassword() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(2, 0, Constants.LOGINSHEET);
		String passwordValue = ExcelUtility.getStringData(2, 1, Constants.LOGINSHEET);
		
		LoginPage loginpage = new LoginPage(driver);//object for Loginpage class is created
		loginpage.enterUsername(usernameValue);	//username method is invoked in LoginPage class
		loginpage.enterPassword(passwordValue);// password method is invoked in LoginPage class
		loginpage.clickOnSignin();
		
		boolean isloginalertdisplayed = loginpage.isLoginAlertDisplayed();// test calls the isLoginAlertDisplayed() method → it gets either true or false.
		Assert.assertTrue(isloginalertdisplayed, Messages.INVALIDPASSWORDERROR);
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
		Assert.assertTrue(isloginalertdisplayed, Messages.INVALIDUSERNAMEERROR);
	}
	
	@Test  (priority = 4,description = "Login With Invalid Username and Password",dataProvider = "loginProvider")//Testcase 4 , dataprovider pass 3 combination of values
	public void VerifyLoginWithInvalidUsernameandPassword(String usernameValue , String passwordValue ) throws IOException
	{
		//String usernameValue = ExcelUtility.getStringData(4, 0, Constants.LOGINSHEET);
		//String passwordValue = ExcelUtility.getStringData(4, 1, Constants.LOGINSHEET);
		
		LoginPage loginpage = new LoginPage(driver);//object for Loginpage class is created
		loginpage.enterUsername(usernameValue);	//username method is invoked in LoginPage class
		loginpage.enterPassword(passwordValue);// password method is invoked in LoginPage class
		loginpage.clickOnSignin();
		
		boolean isloginalertdisplayed = loginpage.isLoginAlertDisplayed();// test calls the isLoginAlertDisplayed() method → it gets either true or false.
		Assert.assertTrue(isloginalertdisplayed, Messages.INVALIDUSERNAMEERRORANDPASSWORD);
	}
	@DataProvider(name="loginProvider")//data provider annotation provided by testng and we name it as "login provider"  
	public Object[][] getDataFromDataProvider() throws IOException//2 parameters are passed
	{
		return new Object[][] { new Object[] {"user","password"},//here 3 set of values are passed as parameter for username and password
			new Object[] {"username","pass"},
			new Object[] {"user1","password1"}
		};
	}
}
