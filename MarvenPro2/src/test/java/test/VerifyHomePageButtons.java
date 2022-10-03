package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
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

public class VerifyHomePageButtons extends Base {
	
	private WebDriver driver;
	private HomePage homepage;
	private SoftAssert soft;
	private LoginPage loginpage;
	private int testID;
	
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
		
	}
	
	@BeforeMethod
	public void beforeMethod() throws Throwable  {
		driver.get("https://www.saucedemo.com/");
		
		String usenName=Utility.excelFetch("LoginDetails",0,0);
		
		loginpage.sendUserName(usenName);
		
		
		
		String password=Utility.excelFetch("LoginDetails",1,0);
		
		loginpage.sendPasswordAndLogin(password);
		
		soft=new SoftAssert();
		
	}
	
	@Test
	public void verifyaddToCartButton() throws Throwable {
		testID=1234;
		
		homepage.addToCartButton();
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		
		String expectedUrl=Utility.excelFetch("Property",1,0);
		String expectedTitle=Utility.excelFetch("Property",1,1);
		
		soft.assertEquals(url,expectedUrl);
		
		soft.assertEquals(title, expectedTitle);
		soft.assertAll();
		
		
	}
	
	@Test
	public void verifyToCartButton() throws Throwable {
		testID=4567;
		
		homepage.toCartButton();
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		
		
		String expectedUrl=Utility.excelFetch("Property",2,0);
		
		
		
		String expectedTitle=Utility.excelFetch("Property",1,1);
		
		soft.assertEquals(url,expectedUrl);
		soft.assertEquals(title, expectedTitle);
		
		soft.assertAll();
		
	}
	
	@AfterMethod
	public void failCadeScreenshot(ITestResult result) throws Throwable {
		
		if(ITestResult.FAILURE == result.getStatus()) {
			
			Utility.captureScreenshot(driver,testID);
		}
		
	}
	
	@AfterClass
	public void clearTheBrowser() {
		loginpage= null;
		homepage=null;
	}
	
	@AfterTest
	public void closeTheBrowser() {
		driver.close();
		driver=null;
		System.gc();
	}
	
	

}
