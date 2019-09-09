package test.java;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class BuzzProErrorFlow extends BuzzproApplication{
	
	private final String email;
	private final String professional;
	private final AgentApplicationPage applicationPage;
	private final BuzzProErrorPage applicationErrorPage;

	private final Professionals Prof ;
	private WebDriver driver;
	public  BuzzProErrorFlow (String mail,String professional) {
		
		this.email=mail;
		this.professional=professional;
		this.driver = setupDriver();
		this.applicationPage=PageFactory.initElements(driver, AgentApplicationPage.class);
		this.Prof= PageFactory.initElements(driver, Professionals.class);
		this.applicationErrorPage = PageFactory.initElements(driver, BuzzProErrorPage.class);
	    this.goTo(driver);
	}
	
	
	private WebDriver setupDriver() {
	   
		try {	
			
        	DesiredCapabilities dc ;//= DesiredCapabilities.chrome();
	        //if (System.getProperty("browser").equals("firefox"))
        	dc = DesiredCapabilities.firefox();
        	//String host = System.getProperty("seleniumHubHost");      
	      
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
			
			} 
        catch (MalformedURLException e) {
				
				e.printStackTrace();
			}
	driver.manage().window().maximize(); 
	return driver;
		
	}
	private void goTo(WebDriver driver) {
    	
    	driver.get("https://qa.buzzbuzzhome.com/ca");    
    }


	@Override
	void clickStart() {
		this.Prof.getStarted();
		
	}

	@Override
	void clickProfessional() {
		this.Prof.selectProfessional(professional);
		
	}

	@Override
	void fillName() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void fillEmail() {
		this.applicationPage.enterEmail(email);
		
	}

	@Override
	void fillBrokerage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void fillPhoneNo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void fillSite() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void fillInterest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void fillExperience() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void fillOpinion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void clickApply() {
		//this.applicationPage.clickSubmit();
		
	}

	@Override
	void assertAllsuccess() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void assertAllerrors() {
		//this.applicationErrorPage.assertInvalidEmail();
		//this.applicationErrorPage.assertNullField();
		
	}


	@Override
	void quitDriver() {
		this.driver.quit();
		
	}

}
