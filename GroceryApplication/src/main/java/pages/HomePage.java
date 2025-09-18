package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {

	public WebDriver driver;
	PageUtility  pageutility = new PageUtility();
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);//this keyword in pagefactory helps to access the details of entire login 
	}
	
	@FindBy(xpath ="//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")WebElement adminIcon;
	public HomePage clickAdminIcon() {
		//WebElement adminIcon = driver.findElement(By.xpath("//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']"));
		//adminIcon.click();
		pageutility.clickElement(adminIcon);
		return this;//return type this because it is staying in same page.
	}
	
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")WebElement logoutOption ;
	public LoginPage clickLogout() {
		//WebElement logoutOption = driver.findElement(By.xpath("//i[@class='ace-icon fa fa-power-off']")); this code is commented
		//because this is replaced with line number 25
		//logoutOption.click();
		pageutility.clickElement(logoutOption);
		return new LoginPage(driver);
	}
	
	//clickAdminInfo cut and pasted from admin page
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'and @class='small-box-footer']")WebElement adminMoreInfo;
	public AdminPage clickAdminInfo()
	{
		//WebElement adminMoreInfo = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'and @class='small-box-footer']"));
		//adminMoreInfo.click(); instead of this line the below line for  page utility line is added
		pageutility.clickElement(adminMoreInfo);
		return new AdminPage(driver);
	}
	
}
