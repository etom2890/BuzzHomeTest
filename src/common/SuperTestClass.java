 package common;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public  class  SuperTestClass extends TestClass {
	
	private static XSSFSheet ExcelWSheet;
	 
	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell cell;

	private static XSSFRow Row;
	
	 WebDriverWait wait = new WebDriverWait(driver, 2);
	 int noOfColumns;
  //Iterator<Row> rowIterator;
	 String[] Headers;
  int rowCounter;
   XSSFSheet sheet;
  JavascriptExecutor js = (JavascriptExecutor) driver;
  public SuperTestClass(int noOfColumns,String[] Headers,int rowCounter,XSSFSheet sheet)
  {
	  this.noOfColumns= noOfColumns;
	 // this.rowIterator= rowIterator;
	  this.Headers= Headers;
	  this.rowCounter=rowCounter;
	  this.sheet =sheet;
  }
  

  
  public SuperTestClass ReadFromExcel(String sheetName, String filePath) throws InvalidFormatException, IOException {
	    OPCPackage pkg = OPCPackage.open(new File(filePath));
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(pkg);
		
		//HSSFWorkbook workbook = new HSSFWorkbook(file);
		 sheet =  (XSSFSheet) wb.getSheet(sheetName)   ;
		noOfColumns = sheet.getRow(0).getLastCellNum();
		rowCounter = sheet.getLastRowNum()-sheet.getFirstRowNum(); 
	    Headers = new String[noOfColumns];
	    System.out.println(sheet.getLastRowNum());
	    for (int j=0;j<noOfColumns;j++){
             Headers[j] = sheet.getRow(0).getCell(j).getStringCellValue();
	       }
	    SuperTestClass testData =new SuperTestClass(noOfColumns,Headers,rowCounter,sheet);
	    return testData;
	
}
  
  public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   
	  
	   String[][] tabArray = null;

	   try {

		   FileInputStream ExcelFile = new FileInputStream(FilePath);

		   // Access the required test data sheet

		   ExcelWBook = new XSSFWorkbook(ExcelFile);

		   ExcelWSheet = ExcelWBook.getSheet(SheetName);

		   int startRow = 1;

		   int startCol = 0;

		   int ci,cj;

		   int totalRows = ExcelWSheet.getLastRowNum();

		   // you can write a function as well to get Column count

		   int totalCols = ExcelWSheet.getRow(0).getLastCellNum();

		   tabArray=new String[totalRows][totalCols];

		   ci=0;

		   for (int i=startRow;i<=totalRows;i++, ci++) {           	   

			  cj=0;

			   for (int j=startCol;j<totalCols;j++, cj++){

				   tabArray[ci][cj]=getCellData(i,j);

				   System.out.println(tabArray[ci][cj]);  

					}

				}

			}

		catch (FileNotFoundException e){

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

			}

		catch (IOException e){

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

			}

		return(tabArray);

		}

	public static String getCellData(int RowNum, int ColNum) throws Exception {
		 String CellData= null;
		try{

			cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
           
			@SuppressWarnings("deprecation")
			int dataType = cell.getCellType();

			if  (dataType == 3) {

				return "";

			}else if (dataType == Cell.CELL_TYPE_STRING){

				 CellData = cell.getStringCellValue();
				 

			}
			else if  (dataType == Cell.CELL_TYPE_NUMERIC) {
                int data = (int)cell.getNumericCellValue();
				 CellData = String.valueOf(data);//Cell.getStringCellValue();
				 

			}
		}
			catch (Exception e){

			System.out.println(e.getMessage());

			throw (e);

			}

		return CellData;
	

}

  public  void getSelectedItem(List<WebElement> webelements,  String cellValue)
  {
	  WebElement selectedValue = null;
	//  int i = 0;
	for (int j=0;j<webelements.size();j++)
	{
		if (webelements.get(j).getText().toString().equals(cellValue))
				
				 {
			
			selectedValue=webelements.get(j);
			//i=j;
			selectedValue.click();
			break;
					}
	
	}

	  //return i;
  }
  

  public void scrollDown() {
	  Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
  }

  
}


	
