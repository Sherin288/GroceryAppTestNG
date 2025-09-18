package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageNewsPage {
	
public WebDriver driver;
PageUtility pageutility = new PageUtility();
	
	public ManageNewsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);//this keyword in pagefactory helps to access the details of entire login 
	}
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement manageNewsTile;
	public ManageNewsPage clickManageNewsTile()
	{
		//WebElement manageNewsTile = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']"));
		//manageNewsTile.click();
		pageutility.clickElement(manageNewsTile);
		return new ManageNewsPage(driver);
	}
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")WebElement newButton;
	public ManageNewsPage clickNewButton()
	{
		//WebElement newButton = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		//newButton.click();
		pageutility.clickElement(newButton);
		return this;
	}
	
	@FindBy(xpath = "//textarea[@id='news']")WebElement newsTextBox ;
	public ManageNewsPage enternewsTextBox()
	{
		//WebElement newsTextBox = driver.findElement(By.xpath("//textarea[@id='news']"));
		//newsTextBox.sendKeys("Sample News");
		pageutility.sendDataToElement(newsTextBox, "Sample News");
		return this;
		
	}
	
	@FindBy(xpath = "//input[@placeholder='Title']")WebElement searchTextBox;
	public ManageNewsPage searchText()
	{
		//searchTextBox.sendKeys("Testing");
		pageutility.sendDataToElement(searchTextBox, "Testing");
		return this;
	}
	
	@FindBy(xpath = "//button[@name='create']")WebElement saveButton;
	public ManageNewsPage clickSaveButton()
	{
		//WebElement saveButton = driver.findElement(By.xpath("//button[@name='create']"));
		//saveButton.click();
		pageutility.clickElement(saveButton);
		return this;
	}
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/home' and text()='Home']")WebElement homepageLink;
	public HomePage clickhomepageLink()
	{
		//WebElement homepageLink = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/home' and text()='Home']"));
		//homepageLink.click();
		pageutility.clickElement(homepageLink);
		return new HomePage(driver);
		
	}
	
	@FindBy(xpath = "//a[@onclick='click_button(2)']")WebElement searchButton;
	public ManageNewsPage clicksearchButton()
	{
		//WebElement searchButton = driver.findElement(By.xpath("//a[@onclick='click_button(2)']")); //click on search button
		//searchButton.click();
		pageutility.clickElement(searchButton);
		return this;
	}
	
	@FindBy(xpath = "//input[@placeholder='Title']")WebElement searchTextbox;
	public ManageNewsPage enterValueSearchTextbox()
	{
		//WebElement searchTextbox = driver.findElement(By.xpath("//input[@placeholder='Title']"));
		//searchTextbox.sendKeys("Sample News");
		pageutility.sendDataToElement(searchTextbox, "Sample News");
		return this;
	}
	
	@FindBy(xpath = "//i[@class='fa fa-search']")WebElement searchingButton;
	public ManageNewsPage clickSearchingButton()
	{
		//WebElement searchingButton = driver.findElement(By.xpath("//i[@class='fa fa-search']"));
		//searchingButton.click();
		pageutility.clickElement(searchingButton);
		return this;
		
	}
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")WebElement searchReset;
	public ManageNewsPage clickSearchReset()
	{
		//WebElement searchReset = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-warning']"));
		//searchReset.click();
		pageutility.clickElement(searchReset);
		return this;
	}
	
	//assertions for webelement method
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement addNewsAlert; //for add news alert
	public boolean isaddNewsAlertDisplayed()
	{
		return addNewsAlert.isDisplayed();
	}
	
	 @FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement fistcelloftable;
	  public String isSearchedNewsListedIntable()
	  {
		return fistcelloftable.getText();
	  }
  
	  @FindBy(xpath = "//form[@role='form' ]") WebElement searchandmangenewscard;
	  	  public boolean isSearchAndMangeNewsCarddisplayed() 
	  	  {
		  return searchandmangenewscard.isDisplayed();
		  }
	  

	
}
