package newPackage;


import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ItemCostInCheckout {
       public static void main(String[] args) {
              System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
              ChromeDriver driver = new ChromeDriver();

              String baseUrl = "http://store.demoqa.com/";
              String username = "mmagi";
              String password = "pph&f1HRWXeC@PnS";
              driver.get(baseUrl);

              driver.findElement(By.id("account")).click();
              driver.findElement(By.id("log")).sendKeys(username);
              driver.findElement(By.id("pwd")).sendKeys(password);
              driver.findElement(By.id("login")).click();
              new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log out")));

              WebElement productCatalog = driver.findElement(By.linkText("Product Category"));
              Actions action = new Actions(driver);
              action.moveToElement(productCatalog).build().perform();

              driver.findElement(By.xpath("//*[@id=\"menu-item-35\"]/a")).click();
              driver.findElement(By.linkText("Magic Mouse")).click();
              driver.findElement(By.name("Buy")).click();
              new WebDriverWait(driver, 30).until(
                            ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fancy_notification_content\"]/a[1]")))
                           .click();

              driver.findElement(By.name("quantity")).clear();
              driver.findElement(By.name("quantity")).sendKeys("1");
              driver.findElement(By.name("submit")).click();

              String expectedPrice = driver
                            .findElement(By.xpath("//*[@id=\"checkout_page_container\"]/div[1]/table/tbody/tr[2]/td[5]/span/span"))
                           .getText();
              System.out.println("The total price is: " + expectedPrice);
              driver.findElement(By.cssSelector("a.step2 > span")).click();

              String actualPrice = driver.findElement(By.cssSelector("span.pricedisplay > span.pricedisplay")).getText();
              assertEquals("1", actualPrice);
              System.out.println("Test passed!");
              driver.close();
       }
}


