package test.java;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/*import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.testng.Arquillian; */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import common.SuperTestClass;

public class NewHomeAdvertisingTest extends UtilityClass implements DataProviderInterface {
	//@Drone
	//WebDriver driver;
	
	//@Page
	LoginPage login;
	
	//@Page
	Professionals prof;
	
	//@Page
	CompanyInfoPge devAdvertising;
	
	//@Page 
	YourInfoPge infopages;
   
	//@Page
    SignDocumentPage signing;
    
    //@Page
    SubmitPage submit;
   // @Page
    NewHomeAd_SummaryPage successPage;
    
  @BeforeMethod
	public void PageInitilization() {
		this.prof = PageFactory.initElements(driver, Professionals.class);
		this.login = PageFactory.initElements(driver, LoginPage.class);
		this.devAdvertising = PageFactory.initElements(driver, CompanyInfoPge.class);
		this.infopages = PageFactory.initElements(driver, YourInfoPge.class);
		this.signing = PageFactory.initElements(driver, SignDocumentPage.class);
		this.submit = PageFactory.initElements(driver, SubmitPage.class);
		this.successPage = PageFactory.initElements(driver, NewHomeAd_SummaryPage.class);
	} 
    
	@Test(dataProvider = "Authentication")
    public void testAdvertising(String user, String pass, String countryValue,String development, String professional,String company, String infoCompany,
    		String billAddress,String billCity, String billCountry, String psCode,String ccNo,String month,String year,String ccName ) throws IOException {
		
		SuperTestClass newDataSet = new SuperTestClass(0, null, 0, null);
		
		login.Login(driver, user, pass);
		driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS) ;
		prof.selectProfessional(professional);
		prof.getStarted();
		driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS) ;
		//devAdvertising.addDev(driver,countryValue, development,newDataSet);
		driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS) ;
		//infopages.addYourInfo(driver,infoCompany, billAddress,  company,  billCity, billCountry, psCode, ccNo, month, year, ccName,newDataSet);
		driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS) ;
		signing.termsConditions(driver);
		submit.submitApplication(driver);
		driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS) ;
		this.successPage.assertTrue(); 
    }
	
	
	@Override
	@DataProvider(name = "Authentication")
		public Object[][] credentials() {
		//SuperTestClass newDataSet = new SuperTestClass(0, null, 0,null);
		Object[][] newobj =null;
		  try {

			  newobj = Super.getTableArray("C:\\Users\\Enlil\\Desktop\\testdata\\testdata.xlsx", "newHomeAd");
		  } catch (Exception e) {
			e.printStackTrace();
		}
			
		return newobj;
	}
	
	
	
}
