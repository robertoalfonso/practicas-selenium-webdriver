package misael;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import misael.Utilities;

public class CheckPrintersOnSCM implements Utilities{
	 public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
			 driver.get(baseUrl);
		     Utilities.LoginConneXion();
		     new Select(driver.findElement(By.name("newPortal"))).selectByVisibleText("EU");

		     
		     driver.findElement(By.cssSelector("#menu-0-item-12 > a")).click();
		     driver.findElement(By.linkText("Print Labels For Kit Pre-Labeled Tubes")).click();
		     
		     WebElement elem = driver.findElement(By.xpath("//select[@id='scm_supply_chain.labelPrinter']"));

		     Select selectList = new Select(elem);
		     List<WebElement> printers=selectList.getOptions();
		     
		     for (int i = 0; i < printers.size(); i++) {
		    	 System.out.print("'"+printers.get(i).getText()+"',");
				
			}
		     
		     driver.close();

}
}