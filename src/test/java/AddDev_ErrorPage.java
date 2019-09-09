package test.java;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddDev_ErrorPage {

	
	@FindBy(id="ctl00_ContentPlaceHolder1_btnSaveWiki")
	WebElement saveButton;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_reqDevelopmentName")
	WebElement deverror;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_reqAddress")
	WebElement address_error;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_saleRentValidation")
	WebElement sale_error;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_ProjectTypeValidation")
	WebElement buildtype_error;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_reqddlConstructionStatus")
	WebElement construct_error;
	
   public  WebElement    errorModal;
//test

	public void CheckAllErrors(WebDriver driver) {
		
		WebDriverWait  block = new WebDriverWait(driver,10);
		this.submit();
		errorModal = block.until(ExpectedConditions.visibilityOfElementLocated(By.id("warningPopUp")));
  	  	List <WebElement> errorList = errorModal.findElements(By.xpath(".//span[@id='spWarningField']/ul/li"));
  	  	this.CheckModal(driver, errorList);
  	  	this.clickOk();
		this.CheckOtherErrors();
		
		}
	
	
	public void submit() {
		 saveButton.click();
	 }
	 
	public void CheckOtherErrors() {
		
  	  Assert.assertEquals("Development name is required", deverror.getText());	    	  
  	  
  	  Assert.assertEquals("Address is required.", address_error.getText());
  	  
  	  Assert.assertEquals("Please select Sale/Rent", sale_error.getText());
  	 
  	  Assert.assertEquals("Please select a building type", buildtype_error.getText());
  	 
  	  Assert.assertEquals("*", construct_error.getText());
	}
	public void CheckModal(WebDriver driver, List<WebElement> errors) {
		for ( WebElement error :errors) {
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
	}
	
	public void clickOk() {
		WebElement	errorModalOk = errorModal.findElement(By.id("warningOK"));
		errorModalOk.click();
	}
	
	
}
