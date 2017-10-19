package misael;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public interface Utils {
	String baseURL="http://www.demo.guru99.com/V4/";
	ChromeDriver driver= new ChromeDriver();
	public static ChromeDriver initialize() {
		driver.get(baseURL);
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void login(String user, String pwd) {
		driver.findElement(By.name("uid")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("btnLogin")).click();
	}
	
	 public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

	        //Convert web driver object to TakeScreenshot

	        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	        //Call getScreenshotAs method to create image file

	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination

	                File DestFile=new File(fileWithPath);

	                //Copy file at destination

	                FileUtils.copyFile(SrcFile, DestFile);

	    }

	}

//	public static String[][] readSheet(String filePath,String fileName,String sheetName) throws IOException{
//		//Create an object of File class to open xlsx file
//		
//	    File file =    new File(filePath+"\\"+fileName);
//
//	    //Create an object of FileInputStream class to read excel file
//
//	    FileInputStream inputStream = new FileInputStream(file);
//
//	    Workbook guru99Workbook = null;
//
//	    //Find the file extension by splitting file name in substring  and getting only extension name
//
//	    String fileExtensionName = fileName.substring(fileName.indexOf("."));
//
//	    //Check condition if the file is xlsx file
//
//	    if(fileExtensionName.equals(".xlsx")){
//
//	    //If it is xlsx file then create object of XSSFWorkbook class
//
//	    guru99Workbook = new XSSFWorkbook(inputStream);
//
//	    }
//
//	    //Check condition if the file is xls file
//
//	    else if(fileExtensionName.equals(".xls")){
//
//	        //If it is xls file then create object of XSSFWorkbook class
//
//	        guru99Workbook = new HSSFWorkbook(inputStream);
//
//	    }
//
//	    //Read sheet inside the workbook by its name
//
//	    Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);
//
//	    //Find number of rows in excel file
//
//	    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
//
//	    
//	    //Create a loop over all the rows of excel file to read it
//
//	    for (int i = 0; i < rowCount+1; i++) {
//
//	        Row row = guru99Sheet.getRow(i);
//
//	        //Create a loop to print cell values in a row
//
//	        for (int j = 0; j < row.getLastCellNum(); j++) {
//
//	            //Print Excel data in console
//
//	            System.out.print(row.getCell(j).getStringCellValue()+"|| ");
//
//	        }
//
//	        System.out.println();
//
//	    }
//
//	    
//
//	    
//
//	    
//
//	    //Main function is calling readExcel function to read data from excel file
//
//
//	
//		return null;
//		
//	} 
//
//}
