package misael;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

public class GuruSS1withUtil implements Utils {
	public static void main (String[] args) {
		String userID="mngr99072";
		String pwd="ybEmeqA";
		ChromeDriver driver=Utils.initialize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.name("uid")).sendKeys(userID);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("btnLogin")).click();
		

		assertEquals(driver.findElement(By.linkText("Log out")).getText(), "Log out");
		driver.close();
	}
}
