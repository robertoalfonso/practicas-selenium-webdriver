package misael;

import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.AssertJUnit.assertEquals;
import java.util.concurrent.TimeUnit;

public class GuruValidCredentialswithUtil implements Utils {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		String userID = "mngr99072";
		String pwd = "ybEmeqA";
		ChromeDriver driver = Utils.initialize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Utils.login(userID,pwd);

		String title = driver.getTitle();
		assertEquals("Guru99 Bank Manager HomePage", title);

		System.out.println("* * * Login successful * * *");
		System.out.println("Title of the HomePage: " + title);

		driver.close();
	}
}
