package test.java;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



//import common.SuperTestClass;

public class InfoFragment_company   {
	
	
	//SuperTestClass newDataSet = new SuperTestClass(0, null, 0,null);
	/*@FindBy(className="developer-create-container create-developer")
	private */

	@FindBy (xpath=".//*[@name='developer-name']")
	WebElement addCompany;
	
	@FindBy (xpath="//div[@class='item-title']/b")
	List<WebElement> companies;
	
	public void selectCompany(WebDriver driver,String companyValue,Super newDataSet) {
		WebDriverWait wait = new WebDriverWait(driver, 2); 
		//Graphene.waitGui().until().element(addCompany).is().visible();
		addCompany.clear();
		addCompany.click();
		addCompany.sendKeys(companyValue);
		wait.until(ExpectedConditions.visibilityOfAllElements(companies));
	    newDataSet.getSelectedItem(companies, companyValue);
	}
}
	