package simon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyLoginSection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/practicas-selenium-webdriver/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "http://demo.guru99.com";
		driver.get(baseUrl + "/V4/");

		driver.findElement(ById.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys("mngr98945");

		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("AtEmAsE");

		driver.findElement(By.name("btnLogin")).click();

	}

}
