package test.java;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddDev_ProjectDetailsPage {

	SuperTestClass newDataSet = new SuperTestClass(0, null, 0, null);
	
	
	@FindBy(xpath=".//span[@id='customChkBox_ctl00_ContentPlaceHolder1_chkCondo']")
	WebElement apartment;
	
	@FindBy(xpath=".//span[@id='customChkBox_ctl00_ContentPlaceHolder1_chkHouse']")
	WebElement house;
	
	@FindBy(xpath=".//span[@id='customChkBox_ctl00_ContentPlaceHolder1_chkTownHouse']")
	WebElement townhouse;
	
	@FindBy(xpath=".//a[@id='ctl00_ContentPlaceHolder1_ddlConstructionStatus-button']")
	WebElement construction_Status;
	
	@FindBy(xpath=".//a[@id='ctl00_ContentPlaceHolder1_ddlSellingStatus-button']")
	WebElement selling_status;
	
	@FindBy(xpath=".//a[@id='ctl00_ContentPlaceHolder1_ddlLeasingStatus-button']")
	WebElement leasing_status;
	
	@FindBy(xpath="//div[@class='ui-selectmenu-menu ui-selectmenu-open']/ul/li")
	List <WebElement> Types;
	
	@FindBy(xpath=".//span[@id='customChkBox_ctl00_ContentPlaceHolder1_chkOwnerCondo']")
	WebElement owner_condo;
	
	@FindBy(xpath=".//span[@id='customChkBox_ctl00_ContentPlaceHolder1_chkCoop']")
	WebElement owner_coop;
	
	@FindBy(xpath=".//span[@id='customChkBox_ctl00_ContentPlaceHolder1_chkCondop']")
	WebElement owner_condop;
	
	@FindBy(xpath=".//span[@id='customChkBox_ctl00_ContentPlaceHolder1_chkFreehold']")
	WebElement owner_freehold;
	
	@FindBy(xpath=".//a[@id='ctl00_ContentPlaceHolder1_ddlSellingStatus-button']")
	WebElement sellingstatus_button;
	
	@FindBy(xpath=".//input[@id='ctl00_ContentPlaceHolder1_txtDevelopmentName']")
	WebElement developerName;
	
	@FindBy(xpath=".//input[@id='ctl00_ContentPlaceHolder1_txtAddress']")
	WebElement dev_address;
	
	@FindBy(xpath="//*[@class='edit-input-box']/ul/li	")
	WebElement address_dropdown;
	
	@FindBy(xpath=".//span[@id='customChkBox_ctl00_ContentPlaceHolder1_chkHomesForSale']")
	WebElement homeForSale;
	
	@FindBy(xpath=".//span[@id='customChkBox_ctl00_ContentPlaceHolder1_chkHomesForRent']")
	WebElement homeForRent;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_txtDeveloper")
	WebElement developmentName;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_btnSaveWiki")
	WebElement saveButton;
	
	@FindBy(className="locationBox_middle")
	private AddDev_SuccessModalFragment successModal;
	
	public void enterDevelopmentName(String name) {
		developmentName.sendKeys(name);
	}
	
	public void enterDeveloper(String developer) {
		developerName.sendKeys(developer);
	}
	
	public void enterDevAddress(String address) {
		dev_address.sendKeys(address);
	}
	
    public void selectBuildingType(String building_type) {
	 
		if (building_type.equalsIgnoreCase("Apartment")) {
			boolean  isChecked = apartment.isSelected();
			if(isChecked== false) {
				apartment.click();} 
	                                                   }
	  else if (building_type.equalsIgnoreCase("House")) {
		  house.click();
	  }
	  else  if (building_type.equalsIgnoreCase("Townhouse")) {
		  townhouse.click();
	  }
	  
    }
 
 public void selectSaleOrRent(String selection,String sellingStatus,String leasingStatus) {
	 if (selection.equalsIgnoreCase("sale")) {
		 homeForSale.click();
		 this.selectSellingStatus(sellingStatus);
		 
		
        }
    else if (selection.equalsIgnoreCase("rent")) {
    	homeForRent.click();
    	this.selectLeasingStatus(leasingStatus);		  
  }
 }
 
 public void selectOwnership(String ownership) {
	 if (ownership.equalsIgnoreCase("Condo")) {
		 owner_condo.click(); 
	  }
	  else if (ownership.equalsIgnoreCase("Condop")) {
		  owner_condop.click(); 
	  }
	  else if (ownership.equalsIgnoreCase("coop")) {
		  owner_coop.click(); 
	  }
	  else if (ownership.equalsIgnoreCase("freehold")) {
		  owner_freehold.click(); 
	  }
 }
 
 public void selectLeasingStatus(String leasingStatus) {
	 leasing_status.click();
	 newDataSet.getSelectedItem(Types, leasingStatus); 
 }
 
 public void selectConstructionStatus(WebDriver driver,String constr_Status) {
	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0,500);", construction_Status);
	  boolean isVisible = construction_Status.isDisplayed();
	  if (isVisible== true) {
		  construction_Status.click();  
	  }
	  newDataSet.getSelectedItem(Types, constr_Status); 
 }
 
 public void selectSellingStatus(String sellingStatus) {
	 selling_status.click();
	 newDataSet.getSelectedItem(Types, sellingStatus);
 }
 
 public void submit() {
	 saveButton.click();
 }
 

 
 
 public void enterDetails(WebDriver driver,String developer,String development,String address,String saleOrRent,String constr_status,String sell_status,String leasing_status,String ownership,String buildType) {
	 
	 this.selectBuildingType(buildType);
	 this.selectSaleOrRent(saleOrRent,sell_status,leasing_status);
	 this.selectOwnership(ownership);
	 this.enterDevelopmentName(development);
	 this.enterDeveloper(developer);
	 this.enterDevAddress(address);
	 this.selectConstructionStatus(driver, constr_status);
	 this.submit();
	 this.clickSuccessModal(driver);
	 
 }
 
 public void clickSuccessModal(WebDriver driver) {
		// Graphene.waitModel(driver).until().element(successModal).is().visible();
	 	WebDriverWait  block = new WebDriverWait(driver,10);
	 	WebElement Modal = block.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[3]/div[4]/div[1]/div[6]/div/div[2]")));
	 	WebElement closeButton  = Modal.findElement(By.className("btn_closewindow"));
	 
		closeButton.click();
		}
 
 
}
