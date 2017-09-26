/*
 * 
Hi Marie , 
 http://www.demo.guru99.com/V4/
The following test case needs to be automated - LOG IN with valid credentials
The client has requested you to use WebDriver (Firefox Driver) for the project.

User ID : 	mngr98967
Password : 	ynytehY 

Good luck!

 */

package marie;

import static org.testng.AssertJUnit.assertEquals;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class ValidarLogIn {
	
	 public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver","/practicas-selenium-webdriver/resources/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    
	//conviene maximizar para asegurarse de encontrar los elementos
    driver.manage().window().maximize();
    //explicit wait me hace esperar 20 de cada elemento
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    
    String baseUrl = "http://www.demo.guru99.com/V4/";
    driver.get(baseUrl);
    
    driver.findElement(By.name("uid")).clear();
    driver.findElement(By.name("uid")).sendKeys("mngr98967");

    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("ynytehY");

    driver.findElement(By.name("btnLogin")).click();
    
    //Verify that the title is equal to a Welcome title
    assertEquals("Guru99 Bank Manager HomePage", driver.getTitle());
    System.out.println("Login successfull");
  
    driver.close();
	 }

}
