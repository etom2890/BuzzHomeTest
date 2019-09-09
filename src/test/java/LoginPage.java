package test.java;


//import org.jboss.arquillian.drone.api.annotation.Drone;
//import org.jboss.arquillian.graphene.Graphene;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

public class LoginPage  {

	@FindBy(xpath ="/html/body/div[1]/header/div/div[2]/div/ul/li[5]/span/a")
	 WebElement loginButton;
	
	@FindBy(id="mdlUserAccountBody")
	private WebElement modal;
	
	//@FindBy(xpath =".//*[@id='UserName']")
	//private WebElement userName;
	
	//@FindBy(xpath =".//*[@id='Password']")
	//private WebElement passWord;
	@FindBy(xpath =".//*[@class='ladda-button']")
	private WebElement submit; 
	
	public void Login (WebDriver driver,String username,String passwrd) {
		
		this.launchSite(driver);
		loginButton.click();
		
		//Graphene.waitModel(driver).until().element(modal).is().visible();
		this.enterLoginDetails(username, passwrd,driver );
		
		
	}
	
	public void launchSite(WebDriver driver) {
		driver.get("https://qa.buzzbuzzhome.com/ca");
	}

	public void enterLoginDetails(String username,String passwrd,WebDriver driver) {
		WebDriverWait  block = new WebDriverWait(driver,10);
		 WebElement     modal = block.until(ExpectedConditions.visibilityOfElementLocated(By.id("mdlUserAccountBody")));
		  WebElement  name    = modal.findElement(By.xpath(".//*[@id='UserName']"));
		  name.clear();name.sendKeys(username);
	      WebElement passw    = modal.findElement(By.xpath(".//*[@id='Password']"));
	      passw.clear();passw.sendKeys(passwrd); 
		//userName.sendKeys(username);
		//passWord.sendKeys(passwrd);
		submit.click();
	} 
}
