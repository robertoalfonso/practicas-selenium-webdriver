package misael.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class GetItems implements Utilities{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver.get(baseUrl);
		Utilities.LoginConneXion();
		driver.findElement(By.cssSelector("#menu-0-item-12 > a")).click();
		driver.findElement(By.linkText("Order Templates")).click();
		driver.findElement(By.linkText("+ Create")).click();
		new Select(driver.findElement(By.name("wlw-select_key:{actionForm.studyCode}"))).selectByVisibleText("MLAR0007 (Main)");
		driver.findElement(By.cssSelector("a.button > span")).click();
		Utilities.GetItems();
		driver.close();

	}

}
