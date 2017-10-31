package misael.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationPageStore {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		String baseUrl="http://store.demoqa.com/";
		String username="mmagi";
		String password="pph&f1HRWXeC@PnS";
		driver.get(baseUrl);
		
		//LOGIN
	    driver.findElement(By.id("account")).click();
	    driver.findElement(By.id("log")).sendKeys(username);
	    driver.findElement(By.id("pwd")).sendKeys(password);
	    driver.findElement(By.id("login")).click();
	    new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log out")));
	    
	    WebElement productCatalog = driver.findElement(By.linkText("Product Category"));
	    Actions action = new Actions(driver);
	    action.moveToElement(productCatalog).build().perform();
	    
	    driver.findElement(By.xpath("//*[@id=\"menu-item-35\"]/a")).click();
	    driver.findElement(By.linkText("Magic Mouse")).click();
	    driver.findElement(By.name("Buy")).click();
	    new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fancy_notification_content\"]/a[1]"))).click();
	    
	    driver.findElement(By.cssSelector("a.step2 > span")).click();
	    new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.name("collected_data[15]"))).clear();
	    driver.findElement(By.name("collected_data[15]")).sendKeys("buenos aires");
	    
	    driver.findElement(By.id("wpsc_checkout_form_9")).sendKeys("misaelmagi@gmail.com");
	    driver.findElement(By.id("wpsc_checkout_form_2")).sendKeys("Misael");
	    driver.findElement(By.id("wpsc_checkout_form_3")).sendKeys("Magi");
	    driver.findElement(By.id("wpsc_checkout_form_4")).sendKeys("1288 Arias st.");
	    driver.findElement(By.id("wpsc_checkout_form_5")).sendKeys("Lanus");
	    driver.findElement(By.id("wpsc_checkout_form_6")).sendKeys("Buenos Aires");
	    new Select(driver.findElement(By.id("wpsc_checkout_form_7"))).selectByVisibleText("Argentina");
	    driver.findElement(By.cssSelector("#wpsc_checkout_form_7 > option[value=\"AL\"]")).click();
	    driver.findElement(By.id("wpsc_checkout_form_8")).sendKeys("1824");
	    driver.findElement(By.id("wpsc_checkout_form_18")).sendKeys("541168355721");
	   
	    driver.findElement(By.id("wpsc_checkout_form_11")).sendKeys("Misael");
	    driver.findElement(By.id("wpsc_checkout_form_12")).sendKeys("Magi");
	    driver.findElement(By.id("wpsc_checkout_form_13")).sendKeys("1288 Arias st.");
	    driver.findElement(By.id("wpsc_checkout_form_14")).sendKeys("Lanus");
	    driver.findElement(By.id("wpsc_checkout_form_15")).sendKeys("Buenos Aires");
	    new Select(driver.findElement(By.id("wpsc_checkout_form_16"))).selectByVisibleText("Argentina");
	    driver.findElement(By.cssSelector("#wpsc_checkout_form_16 > option[value=\"AL\"]")).click();
	    driver.findElement(By.id("wpsc_checkout_form_17")).sendKeys("1824");
	   
	    
	    driver.findElement(By.xpath("//*[@id=\"wpsc_shopping_cart_container\"]/form/div[4]/div/div/span/input")).click();
	    driver.close();
	}
}
