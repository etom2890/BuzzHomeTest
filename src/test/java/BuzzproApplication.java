package test.java;

import org.openqa.selenium.WebDriver;

public abstract class BuzzproApplication {

	 abstract void clickStart();
	 abstract void clickProfessional();
	 abstract void fillName();
	 abstract void fillEmail();
	 abstract void fillBrokerage();
	 abstract void fillPhoneNo();
	 abstract void fillSite();
	 abstract void fillInterest();
	 abstract void fillExperience();
	 abstract void fillOpinion();
	 abstract void clickApply();
	 abstract void assertAllsuccess();
	 abstract void assertAllerrors();
	 abstract void quitDriver();
	 
	
	public final void BuzzProApply() {
		clickProfessional();
		clickStart();
		fillName();
		fillEmail();
		fillBrokerage();
		fillPhoneNo();
		fillSite();
		fillInterest();
		fillExperience();
		fillOpinion();
		clickApply();
		assertAllsuccess();
		assertAllerrors();
		quitDriver();
		
	}
	
}
