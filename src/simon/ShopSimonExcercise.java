package simon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//comment the above line and uncomment below line to use Chrome
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopSimonExcercise {
       public static void main(String[] args) {
             // declaration and instantiation of objects/variables

             System.setProperty("webdriver.chrome.driver", "/practicas-selenium-webdriver/resources/chromedriver.exe");
             WebDriver driver = new ChromeDriver();
             String baseUrl = "http://store.demoqa.com";
             driver.get(baseUrl);
             driver.findElement(By.cssSelector("a.account_icon > span.icon")).click();
             driver.findElement(By.id("log")).clear();
             driver.findElement(By.id("log")).sendKeys("sbustama");
             driver.findElement(By.id("pwd")).clear();
             driver.findElement(By.id("pwd")).sendKeys("Alpina21");
             driver.findElement(By.id("login")).click();
             new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log out")));

             WebElement productCatalog = driver.findElement(By.linkText("Product Category"));
             Actions action = new Actions(driver);
             action.moveToElement(productCatalog).build().perform();
             driver.findElement(By.cssSelector("#menu-item-37 > a")).click();
             driver.findElement(By.name("Buy")).click();

             new WebDriverWait(driver, 30).until(
                           ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fancy_notification_content\"]/a[1]")))
                           .click();
             driver.findElement(By.cssSelector("a.step2 > span")).click();
             new Select(driver.findElement(By.id("current_country"))).selectByVisibleText("Argentina");
             // driver.findElement(By.cssSelector("option[value=\"AR\"]")).click();
             new WebDriverWait(driver, 30)
                           .until(ExpectedConditions.visibilityOfElementLocated(By.name("collected_data[15]"))).clear();
             driver.findElement(By.name("collected_data[15]")).sendKeys("Buenos Aires");
             driver.findElement(By.id("wpsc_checkout_form_9")).clear();
              driver.findElement(By.id("wpsc_checkout_form_9")).sendKeys("s.bustamante.amigo@outlook.com");
             driver.findElement(By.id("wpsc_checkout_form_2")).clear();
             driver.findElement(By.id("wpsc_checkout_form_2")).sendKeys("Simon");
             driver.findElement(By.id("wpsc_checkout_form_3")).clear();
             driver.findElement(By.id("wpsc_checkout_form_3")).sendKeys("Bustamante Amigo");
             driver.findElement(By.id("wpsc_checkout_form_4")).clear();
             driver.findElement(By.id("wpsc_checkout_form_4")).sendKeys("Av. Ricardo Balbin 963, 12th Floor, Apt. C");
             driver.findElement(By.id("wpsc_checkout_form_5")).clear();
             driver.findElement(By.id("wpsc_checkout_form_5")).sendKeys("San Miguel");
             driver.findElement(By.id("wpsc_checkout_form_6")).clear();
             driver.findElement(By.id("wpsc_checkout_form_6")).sendKeys("Buenos Aires");
             driver.findElement(By.cssSelector("#wpsc_checkout_form_7 > option[value=\"AO\"]")).click();
             new Select(driver.findElement(By.id("wpsc_checkout_form_7"))).selectByVisibleText("Argentina");
             driver.findElement(By.cssSelector("#wpsc_checkout_form_7 > option[value=\"AR\"]")).click();
             driver.findElement(By.id("wpsc_checkout_form_8")).clear();
             driver.findElement(By.id("wpsc_checkout_form_8")).sendKeys("1663");
             driver.findElement(By.id("wpsc_checkout_form_18")).clear();
             driver.findElement(By.id("wpsc_checkout_form_18")).sendKeys("(011)1530852978");
             driver.findElement(By.id("shippingSameBilling")).click();

       }
}
