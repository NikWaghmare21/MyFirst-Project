package setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilis.Utility;

public class Base {
	
	public static WebDriver openChromeBroswer() {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium file\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		return driver;
		
	}
		
	public static WebDriver openFirefoxBroswer() {
	
			System.setProperty("webdriver.gecko.driver", "F:\\Selenium file\\geckodriver.exe");
			WebDriver driver=new FirefoxDriver();
			return driver;
		
	}

}
