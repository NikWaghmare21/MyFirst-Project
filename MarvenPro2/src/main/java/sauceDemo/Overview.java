package sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Overview {
	private WebDriverWait wait;
	
	@FindBy (xpath="//button[@name='finish']")
	private WebElement finishBt;
	
	@FindBy (xpath="//button[@id='cancel']")
	private WebElement cancelBt;
	
	public Overview(WebDriver driver){
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 20);
	}
	
	public void finish() {
		
		wait.until(ExpectedConditions.visibilityOf(finishBt));
		finishBt.click();
		
		
	}
	
	public void cancel() {
		wait.until(ExpectedConditions.visibilityOf(cancelBt));
		cancelBt.click();
		
	}

}
