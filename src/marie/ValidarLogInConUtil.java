package marie;

import static org.testng.AssertJUnit.assertEquals;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class ValidarLogInConUtil {
	
	 public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver","/practicas-selenium-webdriver/resources/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    
	//conviene maximizar para asegurarse de encontrar los elementos
    driver.manage().window().maximize();
    //explicit wait me hace esperar 20 de cada elemento
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    
    String baseUrl = "http://www.demo.guru99.com/V4/";
    driver.get(baseUrl);
    
    String uid = "mngr98967";
    driver.findElement(By.name("uid")).clear();
    driver.findElement(By.name("uid")).sendKeys(uid);

    String password = "ynytehY";
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(password);

    driver.findElement(By.name("btnLogin")).click();
    
    //Verify that the title is equal to a Welcome title and print it to screen
    String title = driver.getTitle();
    assertEquals("Guru99 Bank Manager HomePage", title);
    System.out.println("* * * Login successful * * *");
    System.out.println("Title of the HomePage: " + title);
  
    driver.close();
	 }

}
