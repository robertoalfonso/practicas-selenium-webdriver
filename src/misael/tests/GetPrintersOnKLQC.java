package misael.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GetPrintersOnKLQC implements Utilities {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver.get(baseUrl);
		Utilities.LoginConneXion();
		new Select(driver.findElement(By.name("newPortal"))).selectByVisibleText("PhenoPath");

		driver.findElement(By.cssSelector("#menu-0-item-12 > a")).click();
		driver.findElement(By.linkText("Kit Linking QC")).click();

		WebElement rlp = driver.findElement(By.xpath("//*[@id=\"scm_supply_chain.labelPrinter\"]"));

		Select rlpList = new Select(rlp);
		List<WebElement> printers = rlpList.getOptions();
		
		WebElement psp = driver.findElement(By.xpath("//*[@id=\"scm_supply_chain.labelPrinter\"]"));

		Select pspList = new Select(psp);
		printers.addAll(pspList.getOptions());
		
		WebElement slp = driver.findElement(By.xpath("//*[@id=\"scm_supply_chain.labelPrinter\"]"));

		Select slpList = new Select(slp);
		printers.addAll(slpList.getOptions());

		for (int j = 0; j < printers.size(); j++) {
			System.out.print("'" + printers.get(j).getText() + "',");
		}

		driver.close();

	}
}