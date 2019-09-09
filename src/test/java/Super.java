package test.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Super {
	//WebDriver driver ;
	static XSSFSheet ExcelWSheet;
	 
	static XSSFWorkbook ExcelWBook;

	 static XSSFCell cell;

	 XSSFRow Row;
	
	
  int rowCounter;
   XSSFSheet sheet;
 public  Super() {
	 int test = 1;
 }
  
  public static Object[][] getTableArray(String FilePath, String SheetName) throws NullPointerException {   
	  
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

		   for (int i=startRow;i<=totalRows && ci<=totalRows;i++, ci++) {           	   

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

	public static String getCellData(int RowNum, int ColNum) throws NullPointerException {
		 String CellData= null;
		try{

			cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		
			
           
			@SuppressWarnings("deprecation")
			int dataType = cell.getCellType(); 
			
			
			if    (dataType == 3 )  {

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
}
