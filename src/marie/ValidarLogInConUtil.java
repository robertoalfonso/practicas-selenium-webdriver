/*
 Verificar LOG IN y verificar titulo
1.	The code to setup and launch WebDriver (Firefox) should be improved to include Location   Firefox.exe    and a Firefox Profile must be created.
2.	The amount of time the driver should wait when searching for a GUI element should be specified
3.	The code to setup and launch Firefox should be created as a separate method.
4.	All script initialization parameters like Location of Firefox , Base URL, User Name , Password etc should be stored in separate file say Util.java.  This helps in easy maintenance of script

 */

package marie;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import misael.Utils;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

public class ValidarLogInConUtil implements Utils {
	public static void main (String[] args) {
		ChromeDriver driver = misael.Utils.initialize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String uid = "mngr98967";
		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys(uid);

		String password = "ynytehY";
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.name("btnLogin")).click();

		//ESTO NO VALIDA, MEJOR FIJANDOSE QUE TIENE LOG OUT.
		//assertEquals(driver.findElement(By.partialLinkText("out")).getText(), "Log out");
		assertEquals(driver.findElement(By.partialLinkText("out")).getText().toString(), "Log out".toString());
		System.out.println("Log in successful");
		//assertEquals(driver.findElement(By.linkText("Log out")).getText(), "Log out");
		driver.close();
	}
}