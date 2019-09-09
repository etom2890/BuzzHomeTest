package test.java;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AddDev_ErrorModalFragment {

	@FindBy(xpath=".//span[@id='spWarningField']/ul/li")
	List <WebElement> errorList;
	
	@FindBy(id="warningPopUp")
	WebElement errorModal;

	@FindBy(id="warningOK")
	WebElement errorModalOk;
	
	public void CheckModal(WebDriver driver) {
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
	}
	
	public void clickOk() {
		errorModalOk.click();
	}
}

