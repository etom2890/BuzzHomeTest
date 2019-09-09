package test.java;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BuzzProErrorPage {

	@FindBy(id="emailErrMsg")
	WebElement emailError;
	
	
	@FindBy(xpath=".//h3[1]")
	WebElement requireError;
	
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[2]/div/div[2]/div[6]/h3[2]")
	WebElement buzzAssistance;
	
	public void assertInvalidEmail() {
		String error = emailError.getText();
		Assert.assertEquals("* Not a valid email address", error);
	}
	
	public void assertNullField() {
		String nullError = requireError.getText();
		String assistance = buzzAssistance.getText();
		Assert.assertEquals("Required fields cannot be empty.", nullError);
		Assert.assertEquals("Please email us at buzzpro@buzzbuzzhome.com for assistance.", assistance);
	}
	
	
	
}
