package misael;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.chrome.ChromeDriver;

public class GuruValidPwd implements Utils{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		String invalidUser="asd";
		String validPwd="ybEmeqA";
		String expectedAlert="User or Password is not valid";
		ChromeDriver driver=Utils.initialize();
		Utils.login(invalidUser, validPwd);
		
		assertEquals(driver.switchTo().alert().getText(), expectedAlert);
		
		System.out.println("Test passed!\nAlert text is: "+driver.switchTo().alert().getText());
		driver.close();
	}
}
