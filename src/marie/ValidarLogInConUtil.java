/*
 Verificar LOG IN y verificar titulo
1.	The code to setup and launch WebDriver (Firefox) should be improved to include Location   Firefox.exe    and a Firefox Profile must be created.
2.	The amount of time the driver should wait when searching for a GUI element should be specified
3.	The code to setup and launch Firefox should be created as a separate method.
4.	All script initialization parameters like Location of Firefox , Base URL, User Name , Password etc should be stored in separate file say Util.java.  This helps in easy maintenance of script

 */

package marie;

import static org.testng.AssertJUnit.assertEquals;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

public class ValidarLogInConUtil {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = misael.Utils.initialize();

		// explicit wait me hace esperar 20 de cada elemento
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String uid = "mngr98967";
		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys(uid);

		String password = "ynytehY";
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.name("btnLogin")).click();

		// Verify that the title is equal to a Welcome title and print it to
		// screen
		String title = driver.getTitle();
		assertEquals("Guru99 Bank Manager HomePage", title);
		System.out.println("* * * Login successful * * *");
		System.out.println("Title of the HomePage: " + title);

		driver.close();
	}

}
