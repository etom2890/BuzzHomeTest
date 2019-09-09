package test.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BuzzproAdvertisingTest implements DataProviderInterface{
    WebDriver driver;
	/* @Drone
	WebDriver driver;
	
	@Page
	LoginPage login;
	
	@Page
	Professionals prof;
	
	@Page
	AgentApplicationPage applicationPage; */
	

	
	@Test(dataProvider = "Authentication")
	public void testBuzzProApplication(	BuzzproApplication applications) {
		//driver.manage().window().maximize(); 
		//login.launchSite(driver);
		//prof.selectProfessional(professional);
		//prof.getStarted(driver);
		//applicationPage.enterName(name);
		//driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS) ;
	    applications.BuzzProApply();
		
			}

	@Override
	@DataProvider(name = "Authentication")
		public Object[][] credentials() {
		
		return new  Object[][] {
			{ new BuzzProPositiveFlow("test","toolip@tatoo.com", "www.test.com", "9524326541","torornto", "good", "test", "service","Agent Advertising")},
			
			//,{ new BuzzProErrorFlow("test","Agent Advertising")}
			

		};


	} 
	
	 /*  @BeforeTest
	    public void beforeTest() {
	       // driver = new FirefoxDriver();
	    	System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.20.1-win64 (1)\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
		    options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			driver = new FirefoxDriver(options);
			System.out.println(driver.toString());
		
		driver.get("https://qa.buzzbuzzhome.com/ca");
		driver.manage().window().maximize(); 
	    } 
	   
	   @AfterTest
	    public void afterTest() {
		   System.out.println("after");
	        driver.close();
	    } */
}
