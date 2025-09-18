package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import constant.Constants;
import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase{
	HomePage homepage;
	@Test(description = "To verify Home Page Logout Functionality")
	public void verifyHomePageLogout() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);//Data driven approach is preferred
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);// here login page is the excel sheet name
		
		LoginPage loginpage = new LoginPage(driver);//object for Loginpage class is created
		loginpage.enterUsername(usernameValue).enterPassword(passwordValue);	//username method is invoked in LoginPage class
		//loginpage.enterPassword(passwordValue);// password method is invoked in LoginPage class
		homepage = loginpage.clickOnSignin();
		
		//HomePage homepage = new HomePage(driver);//object for homepage class is created and driver is passed as argument
		homepage.clickAdminIcon();
		loginpage = homepage.clickLogout();//chaining of pages, after logout login page is displayed so it is assigned
		
		//Assertion used to find whether the test case fails
		String actual = driver.getCurrentUrl();
		String expected = "https://groceryapp.uniqassosiates.com/admin/login";
		Assert.assertEquals(actual,expected,Messages.LOGOUTERROR);//Logout is not successful prints when test case fails
		
		
	}
	

}
