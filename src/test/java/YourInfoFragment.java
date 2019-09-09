package test.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import common.SuperTestClass;

public class YourInfoFragment {

	
	
	//@FindBy(xpath= ".//*[@class='contents-card billing-card']")
	private InfoFragment_billingInfo billingInfo;
	
	//@FindBy(xpath="/html/body/div[1]/div[1]/div/div[2]/form/div[2]/div[1]")
	private InfoFragment_company companyInfo;
	
	//@FindBy(className="credit-card-info-container")
	private InfoFragment_CreditCardInfo creditCardInfo;
	
	
	//@FindBy(className="button-container")
	private HomeAdvertising_ButtonFragment buttonContainer;
	
	
	
	
	public void enterCompany(WebDriver driver,String companyName, Super newDataSet) {
		companyInfo.selectCompany(driver ,companyName,newDataSet);
		//System.out.println(companyInfo.getClass());
	}
	public void enterBillingInfo(String Name, String Address,String City, String psCode,String country,Super newDataSet) {
		billingInfo.enterCity(City);
		this.billingInfo.enterPostalCode(psCode);
		this.billingInfo.selectAddress(Address);
		this.billingInfo.selectBillingCompany(Name);
		this.billingInfo.selectCountry(country,newDataSet);
	}
	
	public void enterCreditCardInfo(String cardNo,String month, String year, String name,Super newDataSet) {
		this.creditCardInfo.enterCardNo(cardNo);
		this.creditCardInfo.enterName(name);
		this.creditCardInfo.selectMonth(month,newDataSet);
		this.creditCardInfo.selectYear(year,newDataSet);
	}
	
	public void clickNext(WebDriver driver) {
		buttonContainer.selectNext(driver);
	}
	
	public void Initialisation(WebDriver driver) {
		this.billingInfo = PageFactory.initElements(driver, InfoFragment_billingInfo.class);
		this.companyInfo = PageFactory.initElements(driver, InfoFragment_company.class);
		this.creditCardInfo = PageFactory.initElements(driver, InfoFragment_CreditCardInfo.class);
		this.buttonContainer = PageFactory.initElements(driver, HomeAdvertising_ButtonFragment.class);
		
		
	} 
}
