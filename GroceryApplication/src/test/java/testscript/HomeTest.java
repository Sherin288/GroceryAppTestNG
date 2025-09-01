package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestNGBase;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase{
	
	@Test
	public void verifyHomePageLogout() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");//Data driven approach is preferred
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");// here login page is the excel sheet name
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		username.sendKeys(usernameValue);// here the value from excel is passed to the field available
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[text()='Sign In']"));
		login.click();
		
		WebElement adminIcon = driver.findElement(By.xpath("//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']"));
		adminIcon.click();
		WebElement logoutOption = driver.findElement(By.xpath("//i[@class='ace-icon fa fa-power-off']"));
		logoutOption.click();
	}
	

}
