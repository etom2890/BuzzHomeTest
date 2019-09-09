package test.java;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//import common.SuperTestClass;



public class InfoFragment_CreditCardInfo {
	//SuperTestClass newDataSet = new SuperTestClass(0, null, 0,null);
	
	@FindBy(xpath="//input[@id='Customer_NewCreditCard_CardNumber']")
	WebElement cardNo;
	
	@FindBy(xpath=".//*[@title='Jan (01)']")
	WebElement month;
	
	@FindBy(xpath=".//*[@title='2018']")
	WebElement year;
	
	@FindBy(xpath="//div[@class='dropdown-menu open']/ul/li")
	List<WebElement> dropdown;
	
	@FindBy(xpath=".//*[@id='Customer_NewCreditCard_CardName']")
	WebElement name;
	
	
	public void enterCardNo(String cardNumber) {
		cardNo.clear();
		cardNo.sendKeys(cardNumber);
	}
	
	public void selectMonth(String cardMonth,Super newDataSet) {
		month.click();
		newDataSet.getSelectedItem(dropdown, cardMonth);
		
	}
	public void selectYear(String cardYear,Super newDataSet) {
		year.click();
		newDataSet.getSelectedItem(dropdown, cardYear);
		
	}
	public void enterName(String cardHolder) {
		name.sendKeys(cardHolder);
	}
	
}
