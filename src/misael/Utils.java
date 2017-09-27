package misael;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public interface Utils {
	String baseURL="http://www.demo.guru99.com/V4/";
	ChromeDriver driver= new ChromeDriver();
	public static ChromeDriver initialize() {
		driver.get(baseURL);
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void login(String user, String pwd) {
		driver.findElement(By.name("uid")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("btnLogin")).click();
	}

}
