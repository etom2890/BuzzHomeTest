package test.java;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Professionals {
	
	private WebDriver driver;
	
	@FindBy(xpath=".//*[@class='dropdown-toggle']")
	WebElement professionals;
	
	@FindBy(xpath=".//ul[@class='dropdown-menu']/li")
	List <WebElement> professionalDropdown;
	
	@FindBy(xpath =".//*[@class='center']/a")
	WebElement getStarted;
	
	public void selectProfessional(String value)
	{
		 professionals.click();
		 WebElement selectedValue = null;
			
			for (int j=0;j<professionalDropdown.size();j++)
			{
				if (professionalDropdown.get(j).getText().toString().equals(value))
				{
					selectedValue=professionalDropdown.get(j);
					selectedValue.click();
					break;
			    }
		
			}
	}
	
	public void getStarted() {
		getStarted.click();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		
	}
	
	
}
