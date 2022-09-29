package sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Details {

	
	@FindBy (xpath="//input[@id='first-name']")
	private WebElement firstName;
	
	@FindBy (xpath="//input[@id='last-name']")
	private WebElement lastName;
	
	@FindBy (xpath="//input[@id='postal-code']")
	private WebElement zipCode;
	
	@FindBy (xpath="//input[@id='continue']")
	private WebElement continueBt;
	
	@FindBy (xpath="//button[@id='cancel']")
	private WebElement cancelBt;
	
	

	public Details(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void sendFirstName(String name) throws Exception {
		
		firstName.sendKeys(name);
		
	}	
	public void sendLastName(String lastname) throws Exception {
		
		lastName.sendKeys(lastname);
		
	}	
	
	public void sendZipCodeAndContinue(String zipcode) throws Exception {
		
		zipCode.sendKeys(zipcode);
		Thread.sleep(3000);
		continueBt.click();
		
	}		
		
	public void cancel() {
		cancelBt.click();
	}

}
