/*
 * Practice Exercise -2 (Multiple Selection Box/List)

Launch new Browser
Open “http://toolsqa.wpengine.com/automation-practice-form/”
Select ‘Selenium Commands’ Multiple selection box ( Use Name locator to identify the element )
Select option ‘Browser Commands’  and then deselect it (Use selectByIndex and deselectByIndex)
Select option ‘Navigation Commands’  and then deselect it (Use selectByVisibleText and deselectByVisibleText)
Print and select all the options for the selected Multiple selection list.
Deselect all options
Close the browser
 */

package marie;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MultipleSelectorBoxList {

	@Test
	public void verifyDropDownSelection() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		String url = "http://toolsqa.wpengine.com/Automation-practice-form/";

		driver.get(url);
		WebElement element = driver.findElement(By.name("selenium_commands"));
		Select comands = new Select(element);
		comands.selectByIndex(0);
		System.out.println("Browswer Commands Selected");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException a) {
			// TODO Auto-generated catch block
			a.printStackTrace();
		}

		comands.deselectByIndex(0);
		System.out.println("Browswer Commands DES - Selected");

		comands.selectByVisibleText("Navigation Commands");
		System.out.println("Navigation Commands Selected");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comands.deselectByVisibleText("Navigation Commands");
		System.out.println("Navigation Commands DES Selected");

		List<WebElement> options = comands.getOptions();
		int size = options.size();
		System.out.println("* * * Commands list: * * * ");
		for (int i = 0; i < size; i++) {
			System.out.println(options.get(i).getText());
			comands.selectByIndex(i);
		}

		comands.deselectAll();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.close();
	}

}