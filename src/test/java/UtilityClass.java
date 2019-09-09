package test.java;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UtilityClass {
	public  WebDriver driver ;
	
	@BeforeMethod
	public void openBrowser() {
		
	/*	DesiredCapabilities dc = DesiredCapabilities.chrome();

        if (System.getProperty("browser").equals("firefox"))
            dc = DesiredCapabilities.firefox();

        String host = System.getProperty("seleniumHubHost");
        
        driver = new RemoteWebDriver(new URL("http://" + host + ":4444/wd/hub"), dc);  */

		System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.20.1-win64 (1)\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
		    options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			driver = new FirefoxDriver(options);
		    System.out.println(driver.toString());
			//driver.get("https://qa.buzzbuzzhome.com/ca");
		
			driver.manage().window().maximize();  
	
	} 

	 
	@AfterMethod
	public void closeDriver() {
		driver.quit();;
	}
	
}
