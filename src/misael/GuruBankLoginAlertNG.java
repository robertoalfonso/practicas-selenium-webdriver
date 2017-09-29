package misael;

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class GuruBankLoginAlertNG {

	String filePath = System.getProperty("user.dir") + "\\src\\misael";
	String fileName = "Credentials.xlsx";
	String sheetName = "Sheet1";
	String expectedAlert = "User or Password is not valid";
	String user = "";
	String pass = "";
	public WebDriver driver;
	
	@Test
	public void f() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver=Utils.initialize();
		File file = new File(filePath + "\\" + fileName);

		// Create an object of FileInputStream class to read excel file

		FileInputStream inputStream = new FileInputStream(file);

		Workbook guru99Workbook = null;

		// Find the file extension by splitting file name in substring and getting only
		// extension name

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		// Check condition if the file is xlsx file

		if (fileExtensionName.equals(".xlsx")) {

			// If it is xlsx file then create object of XSSFWorkbook class

			guru99Workbook = new XSSFWorkbook(inputStream);

		}

		// Check condition if the file is xls file

		else if (fileExtensionName.equals(".xls")) {

			// If it is xls file then create object of XSSFWorkbook class

			guru99Workbook = new HSSFWorkbook(inputStream);

		}

		// Read sheet inside the workbook by its name

		Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);

		// Find number of rows in excel file

		int rowCount = guru99Sheet.getLastRowNum() - guru99Sheet.getFirstRowNum();

		// Create a loop over all the rows of excel file to read it
		System.out.println("User  ||  Password");
		for (int i = 0; i < rowCount + 1; i++) {

			Row row = guru99Sheet.getRow(i);

			// Create a loop to print cell values in a row

			for (int j = 0; j < row.getLastCellNum(); j++) {

				// Print Excel data in console

				if (j == 0) {
					user = row.getCell(j).getStringCellValue().toString();
				}

				if (j == 1) {
					pass = row.getCell(j).getStringCellValue().toString();
				}
				System.out.println(user + " || " + pass);
			}
			Utils.login(user, pass);
			Assert.assertEquals(driver.switchTo().alert().getText(), expectedAlert);
			driver.switchTo().alert().accept();
		}
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Passed with above credentials!");
		driver.close();
	}

}
