package test.java;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;



//import common.SuperTestClass;
//import common.TestClass;

public class BuzzproAgentAdvertising extends TestClass  {

	//public WebDriver driver;
	//public static Properties pro;

	
	
/* @BeforeTest
	public void openBrowser() throws IOException {
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver(options);
		driver.get("https://www.buzzbuzzhome.com");
		driver.manage().window().maximize(); 
	} 
	
*/	
	@Ignore
	public void searchbar() {
		driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.searchbar")));

	}

	@Test
	public void AgentAdvertising() throws Exception {
		driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.professionals"))).click();
		List<WebElement> elements = driver
				.findElements(By.xpath(properties.getProperty("buzzbuzzhome.professionals.dropdown")));
		System.out.println(elements.size());
		elements.get(1).click();
		
		// user in agent advertising page; click on the get started button
		driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.getstarted"))).click();
		

		//filling the agent advertising form
		
		/*OPCPackage pkg = OPCPackage.open(new File("C:\\Users\\Enlil\\Desktop\\testdata\\testdata.xlsx"));
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(pkg);
	
		
		//HSSFWorkbook workbook = new HSSFWorkbook(file);
		XSSFSheet sheet =  (XSSFSheet) wb.getSheetAt(0);
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		Iterator<Row> rowIterator = sheet.iterator();
		String[] Headers = new String[noOfColumns];
		for (int j=0;j<noOfColumns;j++){
            Headers[j] = sheet.getRow(0).getCell(j).getStringCellValue();
        }
		*/
		Super newDataSet = new Super();
	}
	/*	newDataSet = newDataSet.ReadFromExcel("agentAd","C:\\Users\\Enlil\\Desktop\\testdata\\testdata.xlsx");

		for (int i=0; i<=1;i++ ) {
			Row row = newDataSet.sheet.getRow(i);
			if (row.getRowNum()!=0) {
			for (int a=0;a<newDataSet.noOfColumns;a++){
				String header = newDataSet.Headers[a];
				switch(header) {
				
				case "Full Name" : 
					WebElement element = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.agentadvertisng.name")));
				    element.sendKeys(row.getCell(a).getStringCellValue());
				    break;
				case "Email":
					WebElement element1 = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.agentadvertisng.email")));
					element1.sendKeys(row.getCell(a).getStringCellValue());
					break;
				case "Brokerage":
					WebElement element2 = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.agentadvertisng.brokerage")));
					element2.sendKeys(row.getCell(a).getStringCellValue());
					break;
				case "Phone":
					WebElement element3 = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.agentadvertisng.phone")));
					element3.sendKeys(String.valueOf(row.getCell(a).getNumericCellValue()));
					break;
				case "Website":
					WebElement element4 = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.agentadvertisng.Website")));
					element4.sendKeys(row.getCell(a).getStringCellValue());
					break;
				case "Location":
					WebElement element5 = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.agentadvertisng.location")));
					element5.sendKeys(row.getCell(a).getStringCellValue());
					break;
				case "Tell Us":
					WebElement element6 = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.agentadvertisng.tellus")));
					element6.sendKeys(row.getCell(a).getStringCellValue());
					break;
				case "Why Buzzpro":
					WebElement element7 = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.agentadvertisng.whybuzz")));
					element7.sendKeys(row.getCell(a).getStringCellValue());
					break;
				default : System.out.println("no more values");
				break;
				}
			}	
			ScreenShot takescreenshot = new ScreenShot();
			takescreenshot.takeSnapShot(driver, "c://test.png");
			}
			
			WebElement Apply = driver.findElement(By.xpath(properties.getProperty("buzzbuzzhome.agentadvertisng.applybutton")));
			Apply.click();
			
			
		}
		
		

	} */

	@Ignore
	public void DevelopmentAdvertising() {

	}

	@Ignore
	public void testSetup() {
		String str = "I am done with Junit setup";
		assertEquals("I am done with Junit setup", str);
	}
}