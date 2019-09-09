package test.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeAdvertising_ButtonFragment {

	@FindBy (xpath=".//*[@class='inner-container right-btn']/span")
	WebElement nextButton;
	
	public void selectNext(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(nextButton) );
		driver.manage().timeouts().implicitlyWait(400,TimeUnit.MILLISECONDS) ;
		nextButton.click();
		
	}
	
	
}
