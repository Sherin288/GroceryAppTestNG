package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestNGBase {
	
	public WebDriver driver;
	
	@BeforeMethod	
	public void BrowserInitializer()
	{
		driver = new FirefoxDriver(); 
		driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void quitAndClose() 
	{
		//driver.close();
		//driver.quit();
	}

}
