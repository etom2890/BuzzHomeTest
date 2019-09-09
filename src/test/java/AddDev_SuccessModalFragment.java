package test.java;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddDev_SuccessModalFragment {
	
	@FindBy(className="btn_closewindow")
	WebElement closeButton;

	 public void clickSuccessModal(WebDriver driver) {
		// Graphene.waitModel(driver).until().element(successModal).is().visible();
		 closeButton.click();
		}
}
