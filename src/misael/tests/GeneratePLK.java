package misael.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneratePLK implements Utilities{
	public static void GenerateKit(String StudyCode) {
		driver.findElement(By.cssSelector("#menu-0-item-15 > a")).click();
		driver.findElement(By.linkText("Create Pre-Labeled Kits")).click();
		driver.findElement(By.linkText("Create Kit(s)")).click();
		driver.findElement(By.id("util_util.study")).sendKeys(StudyCode);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("util_util.siteSelectBox")));
			driver.findElement(By.id("util_util.lotNumber")).clear();
			driver.findElement(By.id("util_util.lotNumber")).sendKeys("123");
			driver.findElement(By.id("util_util.expDate")).clear();
			driver.findElement(By.linkText("30")).click();
			driver.findElement(By.id("util_util.numKits")).clear();
			driver.findElement(By.id("util_util.numKits")).sendKeys("1");
			
			driver.findElement(By.cssSelector("a.button > span")).click();
//			List <WebElement> rows = driver.findElements(By.xpath("//*[@id=\"util_util.StudyKitSelectionForm\"]/table"));
//			System.out.println("No of rows are : " + rows.size());
			
			WebElement location = driver.findElement(By.xpath("//*[@id=\"util_util.StudyKitSelectionForm\"]/table/tbody/tr[1]/td/font/b"));
			String reqNumber = location.getText().substring(5);
			System.out.println("Kit Accession number: "+reqNumber);
			
			
		}
}
