package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestClass {
	public  WebDriver driver ;
	public  Properties properties ;
	//public Actions actions;
	
	
	//@BeforeTest
	
	public   void propertyFileLoad() throws IOException {
		File src = new File("Object_Repo.properties");
		FileInputStream fis = new FileInputStream(src);
		properties = new Properties();
		properties.load(fis);	
		 
		
	}
	//@BeforeMethod
	//@Parameters({"browser"})
	public void openBrowser(String browser) throws IOException {
		if(browser=="firefox") {
			System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.20.1-win64 (1)\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
		    options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			driver = new FirefoxDriver(options);
		}
		else if(browser=="chrome") {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Enlil\\Desktop\\Driver files\\chromedriver_win32 (1)\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
		    options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			driver = new ChromeDriver(options);
		}
		
		driver.get("https://qa.buzzbuzzhome.com/ca");
		driver.manage().window().maximize(); 
		//actions = new Actions(driver);
	}
	 
	//@AfterMethod
	public void closeDriver() {
		driver.close();
	}
} 