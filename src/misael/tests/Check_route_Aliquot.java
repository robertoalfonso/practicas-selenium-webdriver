package misael.tests;
import org.openqa.selenium.*;
public class Check_route_Aliquot implements Utilities{
	
	 public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		 //System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
			
			
	     String barcode = "O8321921909";
	     String expectedRoute = "Aliquot: Hepatitis Panel Aliquot";
	     
	     
	     driver.get(baseUrl);
	     Utilities.LoginConneXion();
	     
	     driver.findElement(By.cssSelector("#menu-0-item-5 > a")).click();
	     driver.findElement(By.linkText("Routing")).click();
	     driver.findElement(By.id("slc_routing.barcode")).clear();
	     driver.findElement(By.id("slc_routing.barcode")).sendKeys(barcode+Keys.ENTER);
	     
	     
	     WebElement location = driver.findElement(By.xpath("/html/body/div/span/div/div[2]/span/div/table/tbody/tr/td/div/table/tbody/tr/td/div/div/div/span[1]/div/table/tbody/tr/td/div/table/tbody/tr/td/div/div/div/form/table/tbody/tr[5]/td[2]/b"));
	     String actualRoute = location.getText();
	     if (actualRoute.contains(expectedRoute)){
	            System.out.println("Test Passed!");
	            System.out.println("Actual Route: "+actualRoute);
	        } else {
	            System.out.println("Test Failed");
	            System.out.println("Actual Route: "+actualRoute);
	        }
	     driver.close();
}
}