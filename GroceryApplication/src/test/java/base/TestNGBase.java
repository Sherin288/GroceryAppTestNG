package base;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenshotUtility;

public class TestNGBase {
	
	public WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")//from testng xml name= "browser" value should be same in @parameters and testng xml
	public void BrowserInitializer(String browser) throws Exception
	{
		if(browser.equalsIgnoreCase("Chrome")) {  // this is used to if the value given is Chrome that will be executed
			//driver=new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			Map<String,Object> prefs=new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			options.setExperimentalOption("prefs", prefs);
			driver=new ChromeDriver(options);
		}
		else if(browser.equalsIgnoreCase("Firefox")) { // this is used to if the value given is Firefox that will be executed
			driver=new FirefoxDriver();
		}
    else {
			throw new Exception("Invalid browser name");
		}
		
		
		driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//wait for the webelements to load to avoid timeout issues
		//for all @findBy xpath webelement is not found it will wait for sometime
		
	}
	
	@AfterMethod
	public void quitAndClose() 
	{
		//driver.close();
		//driver.quit();
	}
	
	@AfterMethod(alwaysRun = true)//always runs after each testcase is executed to ensure that the method follwing is excuted before testcase is terminated
	public void driverQuit(ITestResult iTestResult) throws IOException//ITestResult is an interface provided by TestNG
	{
		if(iTestResult.getStatus()==ITestResult.FAILURE)  // if testcase fails then this screenshot utility will be invoked with screenshot name we specified(testcasename and timestamp)
		{
			ScreenshotUtility screenShot=new ScreenshotUtility();
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
		driver.quit();

	}

}
