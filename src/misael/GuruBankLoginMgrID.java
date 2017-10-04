package misael;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GuruBankLoginMgrID {
	public WebDriver driver;
	public String expectedAlert = "User or Password is not valid";

	@DataProvider(name = "Credentials")
	public static Object[][] credentials() {
		return new Object[][] { { "mngr99072", "ybEmeqA" }, { "asdas", "ybEmeqA" }, { "mngr99072", "asdasd" },
				{ "asdasd", "asdas" } };
	}

	@Test(dataProvider = "Credentials")
	public void guruBankLoginMgrID(String user, String pass) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.demo.guru99.com/V4/");
		driver.manage().window().maximize();
		driver.findElement(By.name("uid")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.name("btnLogin")).click();
		// Utils.login(user, pass);
		if (user == "mngr99072" & pass == "ybEmeqA") {
			Assert.assertEquals(driver.findElement(By.xpath("//tr[3]/td")).getText(), "Manger Id : "+user);
		} else {
			Assert.assertEquals(driver.switchTo().alert().getText(), expectedAlert);
		}
		driver.quit();// Closing the driver here since the test will be re ran with many credentials
	}

}
