package misael.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("unused")
public class GetOrderTemplateStudies implements Utilities {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver.get(baseUrl);
		//WebDriverWait wait= new WebDriverWait(driver, 10);
		Utilities.LoginConneXion();
		driver.findElement(By.cssSelector("#menu-0-item-12 > a")).click();
		driver.findElement(By.linkText("Order Templates")).click();
		new Select(driver.findElement(By.id("scm_order_templates.lab"))).selectByVisibleText("GCL-EUROPE");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"study_manager_order_templates.studyTemplateViewForm\"]/table[2]/tbody/tr[2]/td[3]")));
		Utilities.GetOrderTemplates();
//		for (int i = 0; i < OrderTemplates.size(); i++) {
//			System.out.print(OrderTemplates.get(i)+",");
//			
//		}
		driver.close();


}
}