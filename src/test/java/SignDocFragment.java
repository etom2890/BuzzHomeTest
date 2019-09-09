package test.java;

//import org.jboss.arquillian.graphene.Graphene;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignDocFragment {
	@FindBy(xpath= ".//label[@class='checkbox-image']")
	WebElement terms;
	
	
	public void checkConditions(WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, 3);
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		//Graphene.waitGui().until().element(terms).is().visible();
		wait.until(ExpectedConditions.visibilityOf(terms));
		terms.click();
	}
	
	
	
}
