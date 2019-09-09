package test.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import common.SuperTestClass;

public class YourInfoPge {

	//@FindBy(name="ActivationFormInfo")
	private YourInfoFragment yourInfo; 
	
	public void addYourInfo(WebDriver driver,String company, String billAddress,String billName,String billCity, String billCountry, String psCode,String ccNo,String month,String year,String ccName,Super newDataSet) {
		
		this.PageInitilalisation(driver);
		yourInfo.enterCompany(driver,company,newDataSet);
		yourInfo.enterBillingInfo(billName, billAddress, billCity, psCode, billCountry,newDataSet);
		yourInfo.enterCreditCardInfo(ccNo, month, year, ccName,newDataSet);
		yourInfo.clickNext(driver);
		
	}
	
	public void PageInitilalisation(WebDriver driver) {
		this.yourInfo = PageFactory.initElements(driver, YourInfoFragment.class);
		this.yourInfo.Initialisation(driver);
	}
}
