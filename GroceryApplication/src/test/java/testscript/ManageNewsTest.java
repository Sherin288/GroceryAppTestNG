package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import constant.Constants;
import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends TestNGBase{
	HomePage homepage;
	ManageNewsPage managenewspage;

	@Test(description = "To verify add news funtionality")   //Test case1 to add new news
	public void verifyAddNews() throws IOException {
        
		String usernameValue=ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);//Data driven approach is preferred
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);// here login page is the excel sheet name
		
		LoginPage loginpage = new LoginPage(driver);//object for Loginpage class is created
		loginpage.enterUsername(usernameValue).enterPassword(passwordValue);	//chaining is applied
	
		homepage = loginpage.clickOnSignin();
		managenewspage = homepage.clickManageNewsTile();//here manage news tile is on homepage so homepage.clickmanagenewstile 
		//after click manage news tile we will be navigated to managenewspage hence the return type is manage newspage . ie , managenews=
		managenewspage.clickNewButton().enternewsTextBox().clickSaveButton();
		boolean isadduseralertdisplayed = managenewspage.isaddNewsAlertDisplayed();
		Assert.assertTrue(isadduseralertdisplayed,Messages.ADDUSERALERTDISPLAYEDERROR);
	}
	
	@Test(description = "To verify HomePage Link ") // Test case to click on home page link
	public void verifyHomePageLink() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(6, 0, Constants.LOGINSHEET);//Data driven approach is preferred
		String passwordValue=ExcelUtility.getStringData(6, 1, Constants.LOGINSHEET);// here login page is the excel sheet name
		LoginPage loginpage = new LoginPage(driver);//object for Loginpage class is created
		loginpage.enterUsername(usernameValue).enterPassword(passwordValue);	//username method is invoked in LoginPage class
		homepage = loginpage.clickOnSignin();
		managenewspage = homepage.clickManageNewsTile();
		homepage = managenewspage.clickhomepageLink();//here accessing click home page link from managenews page and then it is redirected to home page
		String actual=driver.getCurrentUrl();
		String expected="https://groceryapp.uniqassosiates.com/admin/home";
		Assert.assertEquals(actual, expected,Messages.NAVIGATETOHOMEPAGEERROR);
	}
	
		
	@Test(description = "To verify Search Functionality")
	public void verifySearchFunctionality() throws IOException //Test case to find search result in manage news page
	{
		String usernameValue=ExcelUtility.getStringData(6, 0, Constants.LOGINSHEET);//Data driven approach is preferred
		String passwordValue=ExcelUtility.getStringData(6, 1,Constants.LOGINSHEET);// here login page is the excel sheet name
		
		LoginPage loginpage = new LoginPage(driver);//object for Loginpage class is created
		loginpage.enterUsername(usernameValue).enterPassword(passwordValue);	//username method is invoked in LoginPage class
		
		homepage = loginpage.clickOnSignin();
		managenewspage = homepage.clickManageNewsTile();
		managenewspage.clicksearchButton().searchText().clickSearchingButton();
				
		String actualNewsSearched = managenewspage.isSearchedNewsListedIntable();//here the text  value in search table first row is fetched and stord in actualNewsSearched
		String expectedNews = "sample news";
		Assert.assertEquals(actualNewsSearched,expectedNews,Messages.SEARCHEDNEWSNOTFOUNDERROR);
	}
	
	@Test(description = "To verify Search Reset functionality")
	public void verifySearchResetfunctionality() throws IOException //Test case to click on top yellow reset button after search result in manage news page
	{
		String usernameValue=ExcelUtility.getStringData(6, 0,Constants.LOGINSHEET);//Data driven approach is preferred
		String passwordValue=ExcelUtility.getStringData(6, 1, Constants.LOGINSHEET);// here login page is the excel sheet name
		
		LoginPage loginpage = new LoginPage(driver);//object for Loginpage class is created
		loginpage.enterUsername(usernameValue).enterPassword(passwordValue);	//username method is invoked in LoginPage class
		
		homepage = loginpage.clickOnSignin();
		managenewspage = homepage.clickManageNewsTile();
		managenewspage.clicksearchButton().searchText().clickSearchingButton().clickSearchReset();		
		boolean issearchandmangenewscarddispalyed=managenewspage.isSearchAndMangeNewsCarddisplayed();
		Assert.assertFalse(issearchandmangenewscarddispalyed, Messages.RESETERROR);
	}
}
