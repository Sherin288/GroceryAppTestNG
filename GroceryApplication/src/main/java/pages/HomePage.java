package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);//this keyword in pagefactory helps to access the details of entire login 
	}
	
	@FindBy(xpath ="//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")WebElement adminIcon;
	public void clickAdminIcon() {
		//WebElement adminIcon = driver.findElement(By.xpath("//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']"));
		adminIcon.click();
	}
	
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")WebElement logoutOption ;
	public void clickLogout() {
		//WebElement logoutOption = driver.findElement(By.xpath("//i[@class='ace-icon fa fa-power-off']")); this code is commented
		//because this is replaced with line number 25
		logoutOption.click();
	}
	
	
}
