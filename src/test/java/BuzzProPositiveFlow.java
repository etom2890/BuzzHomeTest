package test.java;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import jdk.nashorn.internal.runtime.ECMAException;

public class BuzzProPositiveFlow extends BuzzproApplication {

	private final String name;
	private final String email;
	private final  String website;
	private final String number;
	private final String interest;
	private final String opinion;
	private final  String brokerage;
	private final String experience;
	private final String professional;
	private final AgentApplicationPage applicationPage;
	private final AgentApplicationSuccessPage successPage;
	//private final LoginPage login;
	private final Professionals Professional ;
    protected WebDriver driver;

	
	public BuzzProPositiveFlow(String name,String email,String website,String number,String interest,String opinion,String brokerage,String experience,
			String professional) {
		

		this.name=name;
		this.email=email;
		this.interest=interest;
		this.number=number;
		this.opinion=opinion;
		this.professional=professional;
		this.website=website;
		this.experience= experience;
		this.brokerage=brokerage;
	    this.driver =setupDriver();
		this.Professional= PageFactory.initElements(driver, Professionals.class);
		this.applicationPage = PageFactory.initElements(driver, AgentApplicationPage.class);
		this.successPage= PageFactory.initElements(driver, AgentApplicationSuccessPage.class);
		this.goTo(driver);
	
	}
	private WebDriver setupDriver()   {
		
		  
        try {	
		
        	DesiredCapabilities dc ;//= DesiredCapabilities.chrome();
	        //if (System.getProperty("browser").equals("firefox"))
        	dc = DesiredCapabilities.firefox();
        	String host = System.getProperty("seleniumHubHost"); 
        	
        	if (host==null) {
        		System.out.println(host);
        		driver = new RemoteWebDriver(new URL("http://10.228.46.26:4444/wd/hub"), dc);}
        	else
        		{driver = new RemoteWebDriver(new URL("http://" + host + ":4444/wd/hub"), dc);}
	      
        	System.out.println(driver);
			
			} 
        catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(driver);
		
		
      //---------------------------------------------------------------------------------------------------------  
		/* System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.20.1-win64 (1)\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
	    options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver(options);
		System.out.println(driver.toString());
	
	//driver.get("https://qa.buzzbuzzhome.com/ca"); */// -----------------------------------------------------------
		
		 
	driver.manage().window().maximize();  
	return driver;
		
	}
	private void goTo(WebDriver driver) {
    	
    	driver.get("https://qa.buzzbuzzhome.com/ca");    
    }
	
	@Override
	void clickProfessional() {
		this.Professional.selectProfessional(professional);
		
		
	}
	@Override
	void clickStart() {
		
		this.Professional.getStarted();
	}

	@Override
	void fillName() {
		this.applicationPage.enterName(name);
		
	}

	@Override
	void fillEmail() {
		this.applicationPage.enterEmail(email);
		
	}

	@Override
	void fillBrokerage() {
		this.applicationPage.enterBrokerage(brokerage);
		
	}

	@Override
	void fillPhoneNo() {
		this.applicationPage.enterPhoneNo(number);
	}

	@Override
	void fillSite() {
		this.applicationPage.enterWebsite(website);
	}

	@Override
	void fillInterest() {
		this.applicationPage.enterInterest(interest);
		
	}

	@Override
	void fillExperience() {
		this.applicationPage.enterExperience(experience);
		
	}

	@Override
	void fillOpinion() {
		this.applicationPage.enterReference(opinion);
		
	}

	@Override
	void clickApply() {
		//this.applicationPage.clickSubmit();
		
	}


	@Override
	void assertAllsuccess() {
		//this.successPage.assertSuccess();
		
	}


	@Override
	void assertAllerrors() {
		// TODO Auto-generated method stub
		
	}
	@Override
	void quitDriver() {
		this.driver.quit();
	}
	
	

}
