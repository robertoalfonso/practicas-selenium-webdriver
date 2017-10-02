/*
Practice Exercise -1 (Drop Down Box/List)

Launch new Browser
Open “http://toolsqa.wpengine.com/automation-practice-form/”
Select ‘Continents’ Drop down ( Use Id to identify the element )
Select option ‘Europe’ (Use selectByIndex)
Select option ‘Africa’ now (Use selectByVisibleText)
Print all the options for the selected drop down and select one option of your choice
Close the browser
 */

package marie;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDown {

	
	
	@Test
	public void verifyDropDownSelection(){

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		String url = "http://toolsqa.wpengine.com/Automation-practice-form/";
		
		driver.get(url);
		WebElement element = driver.findElement(By.id("continents"));
		Select continents = new Select(element);
		continents.selectByIndex(1);
		System.out.println("Europa Selected");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		continents.selectByVisibleText("Africa");
		System.out.println("Africa Selected");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> options = continents.getOptions();
		int size = options.size();
		System.out.println("* * * Options list: * * * ");
		for (int i = 0; i < size; i++) {
			System.out.println(options.get(i).getText());
			
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		continents.selectByVisibleText("Antartica");
		System.out.println("Antartica Selected - my choice");
	
		driver.close();
	}

}