package test.java;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AgentApplicationSuccessPage {

	@FindBy(xpath="/html/body/div[1]/div[1]/div[3]/div/div/div[3]/h1")
	WebElement message;
	
	public void assertSuccess()
	{
		String success = message.getText();
		Assert.assertEquals(success, "Thank you, we've received your application!");
	}
}
