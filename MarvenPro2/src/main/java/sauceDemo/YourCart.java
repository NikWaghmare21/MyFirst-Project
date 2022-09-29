package sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCart {
	@FindBy (xpath="//button[@id='continue-shopping']")
	private WebElement continueShoppingBt;
	
	@FindBy (xpath="//button[@id='checkout']")
	private WebElement checkOutBt;
	
	public YourCart(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void continueShopping() {
		continueShoppingBt.click();
	}
	
	public void checkOut() {
		checkOutBt.click();
	}
}
