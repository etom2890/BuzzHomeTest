package test.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



//import common.SuperTestClass;
//import common.TestClass;

public class NewHomeAdvertising extends TestClass implements DataProviderInterface {
	@Override
	@DataProvider(name = "Authentication")
	
	public Object[][] credentials() {
		Object[][] newobj =null;
		// TODO Auto-generated method stub
		  try {
			  newobj = Super.getTableArray("C:\\Users\\Enlil\\Desktop\\testdata\\testdata.xlsx", "login");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return newobj;
	}

	  @Test(dataProvider = "Authentication") //,dependsOnMethods= {"openBrowser"}
	  public void AddHomeAdvertsing(String sUsername, String sPassword, String country, String development) throws Exception {
		 
		/*  
		  Super newDataSet = new Super();		 
		  driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.professionals"))).click();// By.cssSelector( "ul.nav.navbar-nav>li.dropdown>a")
		  List<WebElement> elements = driver.findElements(By.xpath(properties.getProperty("buzzbuzzhome.professionals.dropdown"))); 

		  elements.get(0).click(); 
		  driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.getstarted"))).click();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		  String currentURL = driver.getCurrentUrl();
		      if (currentURL.endsWith("/login"))
		    	  // logon function
		         {
			       WebElement userName = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.login.username")));
			       userName.clear();   userName.sendKeys(sUsername);
			      
			       WebElement password = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.login.password")));
			       password.clear();  password.sendKeys(sPassword);
			       
			       driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.login.submit"))).click();
			       
			  
		         }	
		      
		      driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.selectcountry"))).click();
			  List<WebElement> countries = driver
						.findElements(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.common.dropdown")));
			  newDataSet.getSelectedItem(countries, country);
			  
			  WebElement aDDdevelopment = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.developmentname")));
			  aDDdevelopment.clear(); aDDdevelopment.sendKeys(development);
			  WebDriverWait wait = new WebDriverWait(driver, 2);

			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.autocomplete"))));
			  List<WebElement> selectedDev = driver.findElements(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.autocomplete")));
			  newDataSet.getSelectedItem(selectedDev, development);
			  driver.manage().timeouts().implicitlyWait(400,TimeUnit.MILLISECONDS) ;
			 
			  WebElement next= driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.nextbutton")));
			  next.click();
			  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
			  //newDataSet = newDataSet.ReadFromExcel("newHomeAd","C:\\Users\\Enlil\\Desktop\\testdata\\testdata.xlsx");
				/*while(newDataSet.rowIterator.hasNext()) {
					
					Row row = newDataSet.rowIterator.next(); */
					
				/*	for (int i=0; i<=1;i++ ) {
						Row row = newDataSet.sheet.getRow(i);
						
						if (row.getRowNum()!=0) {
					for (int a=0;a<newDataSet.noOfColumns;a++){
						
						String header = newDataSet.Headers[a];
						switch(header) {
						
						case "Company" : 
							WebElement addCompany = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.developername")));
						    if(row.getCell(a).getStringCellValue().equalsIgnoreCase("new")) {
						    	
						    	addCompany.clear(); addCompany.sendKeys(row.getCell(a).getStringCellValue());
								List<WebElement> companies = driver
											.findElements(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.developerdropdown")));
								  companies.get(0).click();

						    	WebElement address= driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.newcompany.address")));
						    	address.sendKeys(row.getCell(12).getStringCellValue());
						    	WebElement city= driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.newcompany.city")));
						    	city.sendKeys(row.getCell(13).getStringCellValue());
						    	WebElement companycountry= driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.newcompany.country")));
						    	companycountry.sendKeys(row.getCell(14).getStringCellValue());
						    	WebElement state= driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.newcompany.province")));
						    	state.sendKeys(row.getCell(15).getStringCellValue());
						    	WebElement zip= driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.newcompany.postalcode")));
						    	zip.sendKeys(row.getCell(16).getStringCellValue());
						    	WebElement companyEmail= driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.newcompany.email")));
						    	companyEmail.sendKeys(row.getCell(17).getStringCellValue());
						    	WebElement phone= driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.newcompany.phone")));
						    	phone.sendKeys(row.getCell(18).getStringCellValue());
						    	driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.differentbilling"))).click();
	
						    	break;
						    	//need to find out logic for adding new company
						    }
						    else
						    	addCompany.clear(); addCompany.sendKeys(row.getCell(a).getStringCellValue());
						    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.autocomplete"))));
								  List<WebElement> companies = driver
											.findElements(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.autocomplete")));
								  String value =row.getCell(a).getStringCellValue();
								  newDataSet.getSelectedItem(companies, value);
						    break;
						    
						case "CardNo":
							WebElement element1 = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.creditcardinfo.number")));
							
							element1.sendKeys(row.getCell(a).getStringCellValue());
							
							
							break;
						
						case "Address" :
							WebElement element5 = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.newbilling.address")));
							element5.sendKeys(row.getCell(a).getStringCellValue());
							break;
						case "City" :
							WebElement element6 = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.newbilling.city")));
							element6.sendKeys(row.getCell(a).getStringCellValue());
							break;
						case "Country" :
							driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.newbilling.country"))).click();
							List <WebElement>  billingcountries =   driver.findElements(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.common.dropdown")));
							String company =row.getCell(a).getStringCellValue();
							newDataSet.getSelectedItem(billingcountries, company);

							break;
						/*case "state/province" :
							driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.newbilling.province"))).click();
							List <WebElement>  billingstates = driver.findElements(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.common.dropdown")));
							billingstates.selectByVisibleText(row.getCell(a).getStringCellValue());
							
							newDataSet.getSelectedItem(billingstates, row.getCell(a).getStringCellValue());
							selectedState.click();
							break; 
						case "zip" :
							WebElement element9 = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.newbilling.postalcode")));
							element9.sendKeys(row.getCell(a).getStringCellValue());
							break;
						case "billing_name" :
							WebElement element10 = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.newbilling.name")));
							element10.sendKeys(row.getCell(a).getStringCellValue());
							break;
						case "ExpiryMonth":
							driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.creditcardinfo.month"))).click();
							List <WebElement> element2 =  driver.findElements(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.common.dropdown")));
							newDataSet.getSelectedItem(element2, row.getCell(a).getStringCellValue());
							break;
						case "ExpiryYear" :
							driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.creditcardinfo.year"))).click();;
							List <WebElement> element3 =  driver.findElements(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.common.dropdown")));
							int Instance = (int) row.getCell(a).getNumericCellValue(); 
							newDataSet.getSelectedItem(element3, String.valueOf(Instance));
							break;
						case "creditcard_name" :
							WebElement element11 = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.creditcardinfo.name")));
							element11.sendKeys(row.getCell(a).getStringCellValue());
							break;

						default : System.out.println("no more values");
							break;
						}
					}	
					}
					
					}
					
					WebElement next1 = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.nextbutton")));
					next1.click();			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			 
			WebElement terms= driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.termsandconditions")));
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
			
			wait.until(ExpectedConditions.visibilityOf(terms));terms.click();
			
			driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.nextbutton"))).click();
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			ScreenShot takescreenshot = new ScreenShot();
			takescreenshot.takeSnapShot(driver, "c://test.png");
			driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.homeadvertising.nextbutton"))).click();
			
			
			
			
			
		
				
	  }  */
}
}
 