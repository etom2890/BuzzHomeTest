package test.java;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class AddDevelopement extends TestClass implements DataProviderInterface  {
	@Override
	@DataProvider(name = "Authentication")
	
	public Object[][] credentials() {
		Object[][] newobj =null;
		// TODO Auto-generated method stub
		  try {
			  newobj = Super.getTableArray("C:\\Users\\Enlil\\Desktop\\testdata\\testdata.xlsx", "addDev");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return newobj;
	}
	@Test(dataProvider = "Authentication")
	public void addNewDevelopment(String status,String sUsername, String sPassword,String company, String address,String saleOrRent,String building_type, String conStatus,String ownership,String sellinStatus,String leasingStatus) throws InterruptedException {
		/* SuperTestClass newDataSet = new SuperTestClass(0, null, 0,null);
		 WebDriverWait  block = new WebDriverWait(driver,10);
		 //WebDriverWait wait = new WebDriverWait(driver, 2);
		 driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.professionals"))).click();
		  List<WebElement> elements = driver.findElements(By.xpath(properties.getProperty("buzzbuzzhome.professionals.dropdown")));
		  elements.get(2).click();
		  driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.getstarted"))).click();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		  WebElement     modal = block.until(ExpectedConditions.visibilityOfElementLocated(By.id("mdlUserAccountBody")));
		  WebElement  username    = modal.findElement(By.xpath(properties.getProperty("buzzbuzzhome.login.username")));
		  username.clear();username.sendKeys(sUsername);
	      WebElement passwrd    = modal.findElement(By.xpath(properties.getProperty("buzzbuzzhome.login.password")));
	      passwrd.clear();passwrd.sendKeys(sPassword); 
	      WebElement submit = modal.findElement(By.xpath(properties.getProperty("buzzbuzzhome.login.submit")));submit.click();
	      if (status.equalsIgnoreCase("neg"))
	      {
	    	  WebElement savebutton = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.save")));
	    	  savebutton.click();
	    	  WebElement     errorModal = block.until(ExpectedConditions.visibilityOfElementLocated(By.id("warningPopUp")));
	    	 
	    	  List <WebElement> errorList =errorModal.findElements(By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.errorList")));
	    	  for ( WebElement error :errorList) {
	    		  String errorMsg =error.getText().toString();
	    		  switch (errorMsg) {
	    		  case "-Development Name" : 
	    			  Assert.assertEquals("-Development Name", errorMsg);
	    			  break;
	    		  case "-Address" : 
	    			  Assert.assertEquals("-Address", errorMsg);
	    			  break;
	    		  case "-Sale/Rent" : 
	    			  Assert.assertEquals("-Sale/Rent", errorMsg);
	    			  break;
	    		  case "-Building Type(s)" : 
	    			  Assert.assertEquals("-Building Type(s)", errorMsg);
	    			  break;
	    		  case "-Construction Status" : 
	    			  Assert.assertEquals("-Construction Status", errorMsg);
	    			  break;
	    		  }
	    	  }
	    	  driver.findElement(By.id("warningOK")).click();
	    	  String developerError = driver.findElement((By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.deverror")))).getText();
	    	  Assert.assertEquals("Development name is required", developerError);	    	  
	    	  String addressError = driver.findElement((By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.address.error")))).getText();
	    	  Assert.assertEquals("Address is required.", addressError);
	    	  String saleError = driver.findElement((By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.sale.error")))).getText();
	    	  Assert.assertEquals("Please select Sale/Rent", saleError);
	    	  String buildError = driver.findElement((By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.buildtype.error")))).getText();
	    	  Assert.assertEquals("Please select a building type", buildError);
	    	  String projError = driver.findElement((By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.construction.error")))).getText();
	    	  Assert.assertEquals("*", projError);
	      }
	      
	      else
	      {
	   
	    	  if (building_type.equalsIgnoreCase("Apartment")) {
	    		  WebElement build = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.buildtype.apartment")));
	    		  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.buildtype.apartment"))));
	    		boolean  isChecked = build.isSelected();
	    		if(isChecked== false) {
	    			build.click();} 
	    	                                                   }
	    	  else if (building_type.equalsIgnoreCase("House")) {
	    		  driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.buildtype.house"))).click();
	    	  }
	    	  else  if (building_type.equalsIgnoreCase("Townhouse")) {
	    		  driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.buildtype.townhouse"))).click();
	    	  }
	    	  
	    	  if (saleOrRent.equalsIgnoreCase("HomesForSale")) {
		    		 WebElement clickable = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.homeForSale")));
		    		 clickable.click();
		    		
		      }
		      else if (saleOrRent.equalsIgnoreCase("HomesForRent")) {
		    		  driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.homeForRent"))).click();
		    		  System.out.println(saleOrRent);
		    		  WebElement leasingButton= driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.leasing.status")));leasingButton.click();
				    	 List <WebElement> leasingStatusdrpdwn = driver.findElements(By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.common.dropdown")));
				    	 newDataSet.getSelectedItem(leasingStatusdrpdwn, leasingStatus); 
		      }
	    	  if (ownership.equalsIgnoreCase("Condo")) {
	    		  driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.ownershiptype.condo"))).click(); 
	    	  }
	    	  else if (ownership.equalsIgnoreCase("Condop")) {
	    		  driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.ownershiptype.condop"))).click(); 
	    	  }
	    	  else if (ownership.equalsIgnoreCase("coop")) {
	    		  driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.ownershiptype.coop"))).click(); 
	    	  }
	    	  else if (ownership.equalsIgnoreCase("freehold")) {
	    		  driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.ownershiptype.freehold"))).click(); 
	    	  }
	    	  WebElement sellingButton= driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.selling.status")));sellingButton.click();
	    	  List <WebElement> sellingStatusdrpdwn = driver.findElements(By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.common.dropdown")));
	    	  newDataSet.getSelectedItem(sellingStatusdrpdwn, sellinStatus); 
	    	  WebElement developer = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.developer.Name")));
	    	  developer.clear();developer.sendKeys(company);	    	  
	    	  WebElement devAddress = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.developer.adress")));
	    	  devAddress.clear();devAddress.sendKeys(address);
	    	  WebElement statusButton= driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.construction.status")));
	    	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0,500);", statusButton);
	    	  boolean isVisible = statusButton.isDisplayed();
	    	  if (isVisible== true) {
	    		  statusButton.click();  
	    	  } 
	    	  List <WebElement> constructStatus = driver.findElements(By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.common.dropdown")));
	    	  newDataSet.getSelectedItem(constructStatus, conStatus); 
	    	  WebElement savebutton = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.addnewdevelopments.save")));
	    	  savebutton.click(); 
	    	  
	      } */
	      
	      	  
		    
	      
		  
		  
		  
		  
	}
	
}
