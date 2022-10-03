package sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	@FindBy (xpath="//input[@type='text']")
	private WebElement userName;
	
	@FindBy (xpath="//input[@id='password']")
	private WebElement passWord;
	
	@FindBy (xpath="//input[@type='submit']")
	private WebElement loginButton;
	

	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver, 20);
	}
	
	public void sendUserName(String username) throws Exception {
		
		userName.sendKeys(username);
		
			
	}
	
	public void sendPasswordAndLogin(String password) throws Exception {
		
		passWord.sendKeys(password);
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		loginButton.click();
		
		
	}


}
