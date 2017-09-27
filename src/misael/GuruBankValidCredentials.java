package misael;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;

public class GuruBankValidCredentials {
	public static void main (String[] args) {
		String userID="mngr99072";
		String pwd="ybEmeqA";
		String baseURL="http://www.demo.guru99.com/V4/";
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(baseURL);
		
		driver.findElement(By.name("uid")).sendKeys(userID);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("btnLogin")).click();
		

		assertEquals(driver.findElement(By.linkText("Log out")).getText(), "Log out");
		driver.close();
	}
}
