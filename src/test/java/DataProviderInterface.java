package test.java;

import org.testng.annotations.DataProvider;

public interface DataProviderInterface {

	@DataProvider(name = "Authentication")
	 
	  public abstract  Object[][] credentials();
}
