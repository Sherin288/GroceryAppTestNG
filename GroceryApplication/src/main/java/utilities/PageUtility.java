package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	//common method that can be used for all sendkeys action
	public void sendDataToElement(WebElement element,String text) {
		element.sendKeys(text);
	}
	
	//common method that can be used for all click action
	public void clickElement(WebElement element)
	{
		element.click();
	}
	
	//	//common method that can be used to perform action by visible text action
	public void selectdatawithVisibleText(WebElement element,String text)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	public void scrollToElement(WebDriver driver, WebElement element) // this is not used in project added just for reference
	{ 
		Actions actions=new Actions(driver); 
		actions.moveToElement(element).perform();
		} 
	public void clearElementData(WebElement element)// this is not used in project added just for reference
	{ 
		element.clear();
		}

}
