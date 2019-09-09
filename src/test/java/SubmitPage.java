package test.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubmitPage {

	//@FindBy(className="button-container")
	private HomeAdvertising_ButtonFragment buttonContainer;
	
	public void submitApplication(WebDriver driver){
		this.buttonContainer = PageFactory.initElements(driver, HomeAdvertising_ButtonFragment.class);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		buttonContainer.selectNext(driver);
		
	}
	
}
