package testscript;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import constant.Constants;
import pages.AdminPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNGBase{
	
	@Test(description = "To verify Add User Functionality")
	public void verifyAddUserFunctionality() throws IOException
	{
		//To Login to website
		String usernameValue=ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);//Data driven approach is preferred
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);// here login page is the excel sheet name
		
		LoginPage loginpage = new LoginPage(driver);//object for Loginpage class is created
		loginpage.enterUsername(usernameValue);	//username method is invoked in LoginPage class
		loginpage.enterPassword(passwordValue);// password method is invoked in LoginPage class
		loginpage.clickOnSignin();
		
		//to click on More Info option in home page
		AdminPage adminpage = new AdminPage(driver);
		adminpage.clickAdminInfo();
		
		//to generate random username and password faker utility is used
		FakerUtility fakerUtility = new FakerUtility();
		String randomName=fakerUtility.createRandomUserName();
		String randomPassword=fakerUtility.createRandomPassword();
		String userType=ExcelUtility.getStringData(1, 2,Constants.HOMESHEET);
		
		adminpage.clickNewButton();
		adminpage.enterUsername(randomName);
		adminpage.enterPassword(randomPassword);
		adminpage.chooseUsertype(userType);
		adminpage.clickSaveButton();
		boolean isAlertDisplayed = adminpage.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, "User is not added successfully");//here the message given is displayed when testcase failes
			
		}

}
