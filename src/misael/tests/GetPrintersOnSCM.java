package misael.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GetPrintersOnSCM implements Utilities {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver.get(baseUrl);
		Utilities.LoginConneXion();
		new Select(driver.findElement(By.name("newPortal"))).selectByVisibleText("PhenoPath");

		driver.findElement(By.linkText("Labels")).click();
		driver.findElement(By.linkText("Generate Patients and Print Labels")).click();
		driver.findElement(By.id("studyCode")).sendKeys("MLAR0009"+Keys.ENTER);
		
		WebElement rlp = driver.findElement(By.id("selPrinter"));

		Select rlpList = new Select(rlp);
		List<WebElement> printers = rlpList.getOptions();
		
		System.out.println(printers.size());
		for (int j = 0; j < printers.size(); j++) {
			System.out.print("'" + printers.get(j).getText() + "',");
		}

		driver.close();

	}
}