package test.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




//import common.SuperTestClass;

public class DevelopmentsFragment {
	//SuperTestClass newDataSet = new SuperTestClass(0, null, 0,null);
	@FindBy(xpath=".//*[@class='btn dropdown-toggle selectpicker btn-default']")
	WebElement country;
	
	@FindBy(xpath="//div[@class='dropdown-menu open']/ul/li")
	List <WebElement> countryList;
	
	@FindBy(xpath=".//*[@name='development-name']")
	WebElement addDevelopment;
	
	@FindBy (xpath="//div[@class='item-title']/b")
	List<WebElement> devAutocomplete;
	
	
	
	public void SelectCountry(String countryValue,Super newDataSet) {
		country.click();
		newDataSet.getSelectedItem(countryList, countryValue);
	  }
	
	public void selectDevelopment(WebDriver driver,String development,Super newDataSet) {
		addDevelopment.clear();addDevelopment.sendKeys(development);
		
		
		WebDriverWait wait = new WebDriverWait(driver, 2);
		
		wait.until(ExpectedConditions.visibilityOfAllElements(devAutocomplete)); 
		newDataSet.getSelectedItem(devAutocomplete, development);
		
		
	}
	

}
