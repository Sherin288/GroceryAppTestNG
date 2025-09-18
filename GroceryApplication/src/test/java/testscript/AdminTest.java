package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import constant.Constants;
import constant.Messages;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNGBase{
	HomePage homepage;
	AdminPage adminpage;
	@Test(description = "To verify Add User Functionality")
	public void verifyAddUserFunctionality() throws IOException
	{
		//To Login to website
		String usernameValue=ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);//Data driven approach is preferred
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);// here login page is the excel sheet name
		
		LoginPage loginpage = new LoginPage(driver);//object for Loginpage class is created
		loginpage.enterUsername(usernameValue).enterPassword(passwordValue);	//username method is invoked in LoginPage class
		//loginpage.enterPassword(passwordValue);// password method is invoked in LoginPage class
		homepage = loginpage.clickOnSignin();
		
		//to click on More Info option in home page
		
		adminpage = homepage.clickAdminInfo();//this method is now moved to home page
		
		//to generate random username and password faker utility is used
		FakerUtility fakerUtility = new FakerUtility();
		String randomName=fakerUtility.createRandomUserName();
		String randomPassword=fakerUtility.createRandomPassword();
		String userType=ExcelUtility.getStringData(1, 2,Constants.HOMESHEET);
		
		adminpage.clickNewButton().enterUsername(randomName).chooseUsertype(userType).clickSaveButton();//chaining is done here
		/*
		 * adminpage.enterUsername(randomName); adminpage.enterPassword(randomPassword);
		 * adminpage.chooseUsertype(userType); adminpage.clickSaveButton();
		 */
		boolean isAlertDisplayed = adminpage.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Messages.USERNOTADDEDERROR);//here the message given is displayed when testcase failes
			
		}

}
