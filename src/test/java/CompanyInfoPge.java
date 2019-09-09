package test.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import common.SuperTestClass;

public class CompanyInfoPge {
	
	//@FindBy(name="ActivationFormInfo")
	private DevelopmentsFragment developmentsTab;
	
	//@FindBy(className="button-container")
	private HomeAdvertising_ButtonFragment buttonContainer;

	
	
	public void addDev(WebDriver driver,String countryValue,String development,Super newDataSet) {
		
		this.PageInitilization(driver);

		developmentsTab.SelectCountry(countryValue,newDataSet);
		developmentsTab.selectDevelopment(driver, development,newDataSet);
		//Graphene.waitGui().until().element(By.className("button-container")).is().clickable();
		buttonContainer.selectNext(driver);
	}
	

	public void PageInitilization(WebDriver driver) {
		this.developmentsTab = PageFactory.initElements(driver, DevelopmentsFragment.class);
		this.buttonContainer = PageFactory.initElements(driver, HomeAdvertising_ButtonFragment.class);
	}
	
	
	
	
	
}
