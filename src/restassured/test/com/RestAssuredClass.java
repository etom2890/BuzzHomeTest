package restassured.test.com;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class RestAssuredClass {

	
	@Test(dataProvider="Authentication")
	public void ApiTest(String slider, String city, String state, String country, String routeCountry) {
		
		RestAssured.baseURI ="https://qa.buzzbuzzhome.com/bbhAjax/home/slider";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.POST, "/"+slider+"?"+ "city=" + city + "&state=" +state+ "&country=" +country+"&routeCountry="+ routeCountry);
		System.out.println(response);
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
				
	}
	
	@DataProvider(name = "Authentication")
	public Object[][] credentials() {
		 return new Object[][] {
	            {"nh","","","","ca"},
		 };

			
	
}
}
