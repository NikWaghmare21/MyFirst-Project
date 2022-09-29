package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import sauceDemo.Details;
import sauceDemo.HomePage;
import sauceDemo.LoginPage;
import sauceDemo.Overview;
import sauceDemo.YourCart;
import setup.Base;
import utilis.Utility;

public class VerifyOverviewPage extends Base{
	
	private WebDriver driver;
	private Overview overview; 
	private LoginPage loginpage;
	private HomePage homepage;
	private YourCart yourcart;
	private Details details;
	
	
	
	@Parameters("browser")
	@BeforeTest
	public void launchMultipleBrowser(String browserName) {
		
		if(browserName.equals("Chrome")) {
			driver=openChromeBroswer();
		}
		
		if(browserName.equals("Firefox")) {
			driver=openFirefoxBroswer();
		}
		
	}
	
	
	@BeforeClass
	public void beforeClass() throws Exception {
		 loginpage= new LoginPage(driver);
		 homepage=new HomePage(driver);
		 yourcart=new YourCart(driver);
		 details=new Details(driver);
		 overview =new Overview(driver);
	}
	
	@BeforeMethod
	public void beforeMethod() throws Throwable {
		driver.get("https://www.saucedemo.com/");
		
		
		String usenName=Utility.excelFetch("LoginDetails",0,0);
		loginpage.sendUserName(usenName);
		
		String password=Utility.excelFetch("LoginDetails",1,0);
		loginpage.sendPasswordAndLogin(password);
		
		homepage.addToCartButton();
		homepage.toCartButton();
		
		yourcart.checkOut();
		
		String FirstName=Utility.excelFetch("LoginDetails",0,2);
		details.sendFirstName(FirstName);
		String LastName=Utility.excelFetch("LoginDetails",1,2);
		details.sendLastName(LastName);
		String zipCode=Utility.excelFetch("LoginDetails",2,2);
		details.sendZipCodeAndContinue(zipCode);
		
	}
	
	@Test
	public void verifyFinishButton() {
		overview.finish();
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(url, "https://www.saucedemo.com/checkout-complete.html");
	
		soft.assertAll();
	}
	
	@Test
	public void verifyCancelButton() {
		overview.cancel();
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		
		Assert.assertEquals(url, "https://www.saucedemo.com/inventory.html");
		Assert.assertEquals(title, "Swag Labs");
	}
	
	@AfterClass
	public void closeTheBrowser() {
		driver.close();
	}

	
	

}
