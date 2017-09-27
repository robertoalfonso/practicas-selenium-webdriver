package misael;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.chrome.ChromeDriver;

public class GuruSS2 implements Utils{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		String invalidUser="asd";
		String invalidPwd="grge";
		String expectedAlert="User or Password is not valid";
		ChromeDriver driver=Utils.initialize();
		Utils.login(invalidUser, invalidPwd);
		
		assertEquals(driver.switchTo().alert().getText(), expectedAlert);
		
		System.out.println("Test passed!\nAlert text is: "+driver.switchTo().alert().getText());
		driver.close();
	}
}
