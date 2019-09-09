package test.java;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AgentApplicationPage {
	
	@FindBy(xpath= "//*[@id='txtFullName']")
	 WebElement username;
	
	@FindBy(id= "txtEmail")
	private WebElement emailId;
	
	@FindBy(name= "brokerage")
	private WebElement brokerage;
	
	@FindBy(id= "txtPhone")
	private WebElement phoneNo;
	
	@FindBy(id= "txtWebsite")
	WebElement website;
	
	@FindBy(name= "locationInterests")
	WebElement locationIntrest;

	@FindBy(name= "experience")
	WebElement experience;
	
	@FindBy(id= "txtReference")
	WebElement whyBuzz;
	
	@FindBy(id= "btnSubmit")
	WebElement applyButton;
	
	
	
	public void enterName(String name) {
		System.out.println(username.getText());
		this.username.sendKeys(name);
	}
	public void enterEmail(String mail) {
		this.emailId.sendKeys(mail);
		System.out.println(emailId.getText());
	}
	public void enterBrokerage(String brokerag) {
		brokerage.sendKeys(brokerag);
	}
	public void enterPhoneNo(String number) {
		phoneNo.sendKeys(number);
	}
	public void enterWebsite(String site) {
		website.sendKeys(site);
	}
	public void enterInterest(String interest) {
		locationIntrest.sendKeys(interest);
	}
	public void enterExperience(String exp) {
		experience.sendKeys(exp);
	}
	public void enterReference(String reference) {
		whyBuzz.sendKeys(reference);
	}
	
	public void clickSubmit() {
		applyButton.click();
		System.out.println(applyButton.getText());
	}
	
	/*public void testPositiveFlow(String name,String email,String website,String number,String interest,String opinion,String brokerage,String experience)
	{
		this.enterName(name);
		this.enterEmail(email);
		this.enterWebsite(website);
		this.enterPhoneNo(number);
		this.enterInterest(interest);
		this.enterReference(opinion);
		this.enterBrokerage(brokerage);
		this.enterExperience(experience);
	} */
}
