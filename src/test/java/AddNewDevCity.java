package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class AddNewDevCity extends TestClass {

	//AddDevelopement dev = new AddDevelopement();
	
	@Test(dependsOnMethods = {"addNewDevelopment"})
	public void AddNewDevelopmentCity() {
		
		WebElement cities= (WebElement) driver.findElements(By.xpath(properties.getProperty("buzzbuzzhome.professionals.dropdown")));
		cities.click();
		
	}
	
	
	
	
	
}
