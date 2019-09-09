package test.java;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class NewHomeAd_SummaryPage {
 
	@FindBy(xpath ="/html/body/div[1]/div[1]/div/div[2]/div/div/div/div[2]/div")
	WebElement sucessMsg;
	
	public void assertTrue() {
		String value= sucessMsg.getText();
		Assert.assertEquals(value, "Activation Successful");
	}
}
