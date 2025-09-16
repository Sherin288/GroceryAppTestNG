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
	public void clickManageNewsTile()
	{
		//WebElement manageNewsTile = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']"));
		//manageNewsTile.click();
		pageutility.clickElement(manageNewsTile);
	}
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")WebElement newButton;
	public void clickNewButton()
	{
		//WebElement newButton = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		//newButton.click();
		pageutility.clickElement(newButton);
	}
	
	@FindBy(xpath = "//textarea[@id='news']")WebElement newsTextBox ;
	public void enternewsTextBox()
	{
		//WebElement newsTextBox = driver.findElement(By.xpath("//textarea[@id='news']"));
		//newsTextBox.sendKeys("Sample News");
		pageutility.sendDataToElement(newsTextBox, "Sample News");
	}
	
	@FindBy(xpath = "//input[@placeholder='Title']")WebElement searchTextBox;
	public void searchText()
	{
		//searchTextBox.sendKeys("Testing");
		pageutility.sendDataToElement(searchTextBox, "Testing");
	}
	
	@FindBy(xpath = "//button[@name='create']")WebElement saveButton;
	public void clickSaveButton()
	{
		//WebElement saveButton = driver.findElement(By.xpath("//button[@name='create']"));
		//saveButton.click();
		pageutility.clickElement(saveButton);
	}
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/home' and text()='Home']")WebElement homepageLink;
	public void clickhomepageLink()
	{
		//WebElement homepageLink = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/home' and text()='Home']"));
		//homepageLink.click();
		pageutility.clickElement(homepageLink);
	}
	
	@FindBy(xpath = "//a[@onclick='click_button(2)']")WebElement searchButton;
	public void clicksearchButton()
	{
		//WebElement searchButton = driver.findElement(By.xpath("//a[@onclick='click_button(2)']")); //click on search button
		//searchButton.click();
		pageutility.clickElement(searchButton);
	}
	
	@FindBy(xpath = "//input[@placeholder='Title']")WebElement searchTextbox;
	public void enterValueSearchTextbox()
	{
		//WebElement searchTextbox = driver.findElement(By.xpath("//input[@placeholder='Title']"));
		searchTextbox.sendKeys("Sample News");
		pageutility.sendDataToElement(searchTextbox, "Sample News");
	}
	
	@FindBy(xpath = "//i[@class='fa fa-search']")WebElement searchingButton;
	public void clickSearchingButton()
	{
		//WebElement searchingButton = driver.findElement(By.xpath("//i[@class='fa fa-search']"));
		//searchingButton.click();
		pageutility.clickElement(searchingButton);
	}
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")WebElement searchReset;
	public void clickSearchReset()
	{
		//WebElement searchReset = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-warning']"));
		//searchReset.click();
		pageutility.clickElement(searchReset);
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
