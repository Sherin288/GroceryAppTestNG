package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestNGBase;
import constant.Messages;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends TestNGBase{

	@Test(description = "To verify add news funtionality")   //Test case1 to add new news
	public void verifyAddNews() throws IOException {
        
		String usernameValue=ExcelUtility.getStringData(6, 0, "LoginPage");//Data driven approach is preferred
		String passwordValue=ExcelUtility.getStringData(6, 1, "LoginPage");// here login page is the excel sheet name
		
		LoginPage loginpage = new LoginPage(driver);//object for Loginpage class is created
		loginpage.enterUsername(usernameValue);	//username method is invoked in LoginPage class
		loginpage.enterPassword(passwordValue);// password method is invoked in LoginPage class
		loginpage.clickOnSignin();
		
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickManageNewsTile();
		managenewspage.clickNewButton();
		managenewspage.enternewsTextBox();
		managenewspage.clickSaveButton();
		
		boolean isadduseralertdisplayed = managenewspage.isaddNewsAlertDisplayed();
		Assert.assertTrue(isadduseralertdisplayed,Messages.ADDUSERALERTDISPLAYEDERROR);
	}
	
	@Test(description = "To verify HomePage Link ") // Test case to click on home page link
	public void verifyHomePageLink() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(6, 0, "LoginPage");//Data driven approach is preferred
		String passwordValue=ExcelUtility.getStringData(6, 1, "LoginPage");// here login page is the excel sheet name
		LoginPage loginpage = new LoginPage(driver);//object for Loginpage class is created
		loginpage.enterUsername(usernameValue);	//username method is invoked in LoginPage class
		loginpage.enterPassword(passwordValue);// password method is invoked in LoginPage class
		loginpage.clickOnSignin();
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickManageNewsTile();
		managenewspage.clickhomepageLink();
		
		String actual=driver.getCurrentUrl();
		String expected="https://groceryapp.uniqassosiates.com/admin/home";
		Assert.assertEquals(actual, expected,Messages.NAVIGATETOHOMEPAGEERROR);
	}
	
		
	@Test(description = "To verify Search Functionality")
	public void verifySearchFunctionality() throws IOException //Test case to find search result in manage news page
	{
		String usernameValue=ExcelUtility.getStringData(6, 0, "LoginPage");//Data driven approach is preferred
		String passwordValue=ExcelUtility.getStringData(6, 1, "LoginPage");// here login page is the excel sheet name
		
		LoginPage loginpage = new LoginPage(driver);//object for Loginpage class is created
		loginpage.enterUsername(usernameValue);	//username method is invoked in LoginPage class
		loginpage.enterPassword(passwordValue);// password method is invoked in LoginPage class
		loginpage.clickOnSignin();
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickManageNewsTile();
		managenewspage.clicksearchButton();
		managenewspage.searchText();
		managenewspage.clickSearchingButton();
		
		String actualNewsSearched = managenewspage.isSearchedNewsListedIntable();//here the text  value in search table first row is fetched and stord in actualNewsSearched
		String expectedNews = "sample news";
		Assert.assertEquals(actualNewsSearched,expectedNews,Messages.SEARCHEDNEWSNOTFOUNDERROR);
	}
	
	@Test(description = "To verify Search Reset functionality")
	public void verifySearchResetfunctionality() throws IOException //Test case to click on top yellow reset button after search result in manage news page
	{
		String usernameValue=ExcelUtility.getStringData(6, 0, "LoginPage");//Data driven approach is preferred
		String passwordValue=ExcelUtility.getStringData(6, 1, "LoginPage");// here login page is the excel sheet name
		
		LoginPage loginpage = new LoginPage(driver);//object for Loginpage class is created
		loginpage.enterUsername(usernameValue);	//username method is invoked in LoginPage class
		loginpage.enterPassword(passwordValue);// password method is invoked in LoginPage class
		loginpage.clickOnSignin();
		
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickManageNewsTile();
		managenewspage.clicksearchButton();
		managenewspage.searchText();
		managenewspage.clickSearchingButton();                          
		managenewspage.clickSearchReset();
		
		boolean issearchandmangenewscarddispalyed=managenewspage.isSearchAndMangeNewsCarddisplayed();
		Assert.assertFalse(issearchandmangenewscarddispalyed, Messages.RESETERROR);
	}
}
