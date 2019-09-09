package test.java;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddDevTest extends UtilityClass  implements DataProviderInterface {

	
	private LoginPage login;
	private Professionals professional;
	private AddDev_ProjectDetailsPage detailsPage;
	private AddDev_ErrorPage errorPage;
	
	
	
	@BeforeMethod
	public void Initilization() {	
		this.professional = PageFactory.initElements(driver, Professionals.class);
		this.login = PageFactory.initElements(driver, LoginPage.class);
		this.detailsPage = PageFactory.initElements(driver, AddDev_ProjectDetailsPage.class);
		this.errorPage = PageFactory.initElements(driver, AddDev_ErrorPage.class);
	}
	
	@Test(dataProvider="Authentication")
	public void testAddDevelopment(String username,String passwrd,String developer,String development,String address,String saleOrent,String ownership,String buildType,
			String constr_status,String sell_stat,String lease_stat,String prof,String status) {

		login.Login(driver, username, passwrd);
		professional.selectProfessional(prof);
		professional.getStarted();
		if (status.equalsIgnoreCase("neg")) {
			errorPage.CheckAllErrors(driver);
		}
		else {
			detailsPage.enterDetails(driver, developer, development, address, saleOrent, constr_status, sell_stat, lease_stat, ownership,buildType);
		}
	}

	
	@Override
	@DataProvider(name = "Authentication")
		public Object[][] credentials() {
		Object[][] newobj =null;

		  try {
			  newobj = Super.getTableArray("C:\\Users\\Enlil\\Desktop\\testdata\\testdata.xlsx", "addDev");
		  		} 
		  catch (Exception e) {

			e.printStackTrace();
		}
			
		return newobj;
	}

	}


