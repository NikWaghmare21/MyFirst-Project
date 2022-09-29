package sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy (xpath="//select[@class='product_sort_container']")
	private WebElement dropDown;
	
	@FindBy (xpath="(//button[text()='Add to cart'])[1]")
	private WebElement addToCart;
	
	@FindBy (xpath="//a[@class='shopping_cart_link']")
	private WebElement cart;
	

	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void addToCartButton() {
		addToCart.click();
		
	}
	
	public void toCartButton() {
		cart.click();
	}

}
