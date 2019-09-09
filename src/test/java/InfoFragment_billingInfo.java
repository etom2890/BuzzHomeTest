package test.java;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



//import common.SuperTestClass;

public class InfoFragment_billingInfo {
	//SuperTestClass newDataSet = new SuperTestClass(0, null, 0,null);
	
	@FindBy(xpath=".//*[@id='Customer_CustomerName']")
	WebElement companyName;
	
	@FindBy(xpath=".//*[@id='Customer_AddressInfo_StreetAddress']")
	WebElement companyAddress;
	
	@FindBy(xpath=".//button[@title='Country']")
	WebElement companyCountry;
	
	@FindBy(xpath="//div[@class='dropdown-menu open']/ul/li")
	List<WebElement> billingCountries;
	
	@FindBy(xpath=".//*[@id='Customer_AddressInfo_PostalOrZip']")
	WebElement postalCode;
	
	@FindBy(xpath=".//*[@id='Customer_AddressInfo_City']")
	WebElement companyCity;
	
	public void selectBillingCompany(String company) {
		companyName.clear();
		companyName.sendKeys(company);
	}
	
	public void selectCountry(String country,Super newDataSet) {
		companyCountry.click();
		newDataSet.getSelectedItem(billingCountries, country);
		
	}
	public void enterPostalCode(String psCode) {
		postalCode.sendKeys(psCode);
	}
	public void selectAddress(String address) {
		companyAddress.sendKeys(address);
	}
	public void enterCity(String city) {
		companyCity.sendKeys(city);
	}
}
