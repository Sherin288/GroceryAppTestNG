package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestNGBase;
import utilities.ExcelUtility;

public class ManageNewsTest extends TestNGBase{

	@Test    //Test case1 to add new news
	public void verifyAddNews() throws IOException {
        
		String usernameValue=ExcelUtility.getStringData(6, 0, "LoginPage");//Data driven approach is preferred
		String passwordValue=ExcelUtility.getStringData(6, 1, "LoginPage");// here login page is the excel sheet name
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		username.sendKeys(usernameValue);// here the value from excel is passed to the field available
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[text()='Sign In']"));
		login.click();
		WebElement manageNewsTile = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']"));
		manageNewsTile.click();
		WebElement newButton = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		newButton.click();
		
		WebElement newsTextBox = driver.findElement(By.xpath("//textarea[@id='news']"));
		newsTextBox.sendKeys("Sample News");
		WebElement saveButton = driver.findElement(By.xpath("//button[@name='create']"));
		saveButton.click();
			
	}
	
	@Test // Test case to click on home page link
	public void verifyHomePageLink() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(6, 0, "LoginPage");//Data driven approach is preferred
		String passwordValue=ExcelUtility.getStringData(6, 1, "LoginPage");// here login page is the excel sheet name
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		username.sendKeys(usernameValue);// here the value from excel is passed to the field available
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[text()='Sign In']"));
		login.click();
		WebElement manageNewsTile = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']"));
		manageNewsTile.click();
		WebElement homepageLink = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/home' and text()='Home']"));
		homepageLink.click();
	}
	
	
	@Test
	public void verifySearchClickinManageNewsPage() throws IOException //Test case to click on search button in manage news page
	{
		String usernameValue=ExcelUtility.getStringData(6, 0, "LoginPage");//Data driven approach is preferred
		String passwordValue=ExcelUtility.getStringData(6, 1, "LoginPage");// here login page is the excel sheet name
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		username.sendKeys(usernameValue);// here the value from excel is passed to the field available
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[text()='Sign In']"));
		login.click();
		WebElement manageNewsTile = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']"));
		manageNewsTile.click();
		WebElement searchButton = driver.findElement(By.xpath("//a[@onclick='click_button(2)']")); //click on search button
		searchButton.click();
	}
	
	@Test
	public void verifySearchFunctionalityinManageNewsPage() throws IOException //Test case to find search result in manage news page
	{
		String usernameValue=ExcelUtility.getStringData(6, 0, "LoginPage");//Data driven approach is preferred
		String passwordValue=ExcelUtility.getStringData(6, 1, "LoginPage");// here login page is the excel sheet name
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		username.sendKeys(usernameValue);// here the value from excel is passed to the field available
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[text()='Sign In']"));
		login.click();
		WebElement manageNewsTile = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']"));
		manageNewsTile.click();
		WebElement searchButton = driver.findElement(By.xpath("//a[@onclick='click_button(2)']"));
		searchButton.click();
		WebElement searchTextbox = driver.findElement(By.xpath("//input[@placeholder='Title']"));
		searchTextbox.sendKeys("Sample News");
		WebElement searchingButton = driver.findElement(By.xpath("//i[@class='fa fa-search']"));
		searchingButton.click();
	}
	
	@Test
	public void verifySearchRestfunctionalityinManageNewsPage() throws IOException //Test case to click on top yellow reset button after search result in manage news page
	{
		String usernameValue=ExcelUtility.getStringData(6, 0, "LoginPage");//Data driven approach is preferred
		String passwordValue=ExcelUtility.getStringData(6, 1, "LoginPage");// here login page is the excel sheet name
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		username.sendKeys(usernameValue);// here the value from excel is passed to the field available
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[text()='Sign In']"));
		login.click();
		WebElement manageNewsTile = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']"));
		manageNewsTile.click();
		WebElement searchButton = driver.findElement(By.xpath("//a[@onclick='click_button(2)']"));
		searchButton.click();
		WebElement searchTextbox = driver.findElement(By.xpath("//input[@placeholder='Title']"));
		searchTextbox.sendKeys("Sample News");
		WebElement searchingButton = driver.findElement(By.xpath("//i[@class='fa fa-search']"));
		searchingButton.click();
		WebElement searchReset = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-warning']"));
		searchReset.click();
	}
}
