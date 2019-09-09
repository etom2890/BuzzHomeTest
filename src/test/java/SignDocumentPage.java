package test.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignDocumentPage {
	//@FindBy(xpath= ".//*[@class='content-card-inner agree-check-container']")
	private SignDocFragment signdoc;
	
	/* @FindBy(className="button-container")
	private HomeAdvertising_ButtonFragment buttonContainer; */
	
	@FindBy (xpath=".//*[@class='inner-container right-btn']/span")
	WebElement nextButton;
	
	public void termsConditions(WebDriver driver){
		
		this.signdoc = PageFactory.initElements(driver, SignDocFragment.class);
		signdoc.checkConditions(driver);
		nextButton.click();
	}
	
}
