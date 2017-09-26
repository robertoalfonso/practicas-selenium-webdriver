package marie;


//NOTAS Y CORRECCIONES

//Tuve que cambiar el xpath del producto porque por alguna raz�n ya no era el mismo que vos usaste.
//Ma�ana cuando vengas vamos a buscar la forma de cambiar la forma de acceder a ese producto indiferentemente del id que tenga
//******** HAY QUE HACERLO ESTATICO ******

//SE TENDRIA QUE HACER UN SOLO ASSERT, PORQUE SI CAMBIAN EL MENSAJE FALLARIA EL TEST
//IDEALMENTE ES 1 ASSERT POR TEST AUTOMATIZADO, POR EL PUNTO GENERAL (EN ESTE CASO SERIA CONCLUIR LA COMPRA)
//SE DEBEN VALIDAR LOS DETALLES CON TRY AND CATCH 

//import static org.testng.AssertJUnit.assertEquals;


import static org.testng.AssertJUnit.assertEquals;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ValidarCompraVestido {

     public static void main(String[] args) throws InterruptedException {

    	 System.setProperty("webdriver.chrome.driver", "/practicas-selenium-webdriver/resources/chromedriver.exe");
    	    //System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            //conviene maximizar para asegurarse de encontrar los elementos
            driver.manage().window().maximize();
            //explicit wait me hace esperar 20 de cada elemento
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            
            String baseUrl = "http://shop.demoqa.com";
            driver.get(baseUrl);
            
     
            driver.findElement(By.cssSelector("#menu-item-2021 > a")).click();
            driver.findElement(By.name("username")).clear();
            driver.findElement(By.name("username")).sendKeys("mlarco@resolvit.com");
            driver.findElement(By.name("password")).clear();
            driver.findElement(By.name("password")).sendKeys("Reg1st#r");
            driver.findElement(By.name("login")).click();

            Thread.sleep(3000);
            
            //HOVER
            WebElement element = driver.findElement(By.cssSelector("#menu-item-2213 > a"));
            Actions action = new Actions(driver);
            action.moveToElement(element).build().perform();
      driver.findElement(By.cssSelector("#menu-item-2219 > a")).click();
      
      
            Thread.sleep(3000);
            driver.findElement(By.xpath("//a[contains(text(),'SAFI SEQUIN TUNIC DRESS')]")).click();
//          driver.findElement(By.xpath("(//a[@href='http://shop.demoqa.com/product/safi-sequin-tunic-dress/'])[4]")).click();
           // System.out.println("detalle de vestido seleccionado");
            
            
            driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
            //System.out.println("pos-add to cart");
            
            driver.findElement(By.cssSelector("a.button.wc-forward")).click();
            
            driver.findElement(By.id("shipping_method_0_free_shipping14")).click();
           // System.out.println("pos-seleccionar free shippingt");
            
            
            //*** ANTES DE CONFIRMAR GUARDO LOS DATOS EN VARIABLES PARA COMPARAR CON EL DETALLE A POSTERIORI
            
            System.out.println("Los datos al momento de la compra son: ");
            
            //  Guarda el precio total de la compra !!! 
            String price = driver.findElement(By.cssSelector("strong > span.woocommerce-Price-amount.amount")).getText();
            System.out.println("Precio: "+ price);
                       
            
            String descripcion = driver.findElement(By.cssSelector("td.product-name")).getText();
            System.out.println("Descripcion: "+ descripcion);
            
            String shipping = driver.findElement(By.xpath("//li[2]/label")).getText();
            System.out.println("Shipping: "+ shipping);
            
            driver.findElement(By.xpath("//a[contains(text(),'Proceed to Checkout')]")).click();

         
            Thread.sleep(5000);
            driver.findElement(By.cssSelector("#terms")).click();

            driver.findElement(By.name("ship_to_different_address")).click();

            Thread.sleep(2000);
            driver.findElement(By.id("payment_method_cod")).click();
            
            
            
            // ******** ESTO NO TENDRIA QUE HACERLO DESPUES DEL CHECKOUT????????
            // Verifica que el valor guardado sea el correcto antes de generar la orden 
           // assertEquals(driver.findElement(By.cssSelector("strong > span.woocommerce-Price-amount.amount")).getText(), price);
           // System.out.println("Precio del detalle correcto: " + price);
            
            //assertEquals(driver.findElement(By.linkText("SAFI SEQUIN TUNIC DRESS")).getText(), descripcion);
            System.out.println("");
            System.out.println(" ----- Finalizando compra ----- ");
            System.out.println("");
            //CONFIRMACION DE LA COMPRA
            driver.findElement(By.name("woocommerce_checkout_place_order")).click();
            
       
            assertEquals(driver.findElement(By.cssSelector("td.product-total > span.woocommerce-Price-amount.amount")).getText(), price);
            System.out.println("Precio correcto: " + price);

            assertEquals(driver.findElement(By.cssSelector("td.product-name > a")).getText(), (descripcion));
            System.out.println("Descripcion de detalle correcto: " + descripcion);
            
            // Exception in thread "main" java.lang.AssertionError: expected:<Free Shipping> but was:<FREE SHIPPING>
            //assertThat(driver.findElement(By.xpath("//tr[2]/td")).getText(), equalToIgnoringCase(shipping));
            //assertThat(driver.findElement(By.xpath("//tr[2]/td")).getText(), IsEqualIgnoringCase.equalToIgnoringCase(shipping));
            assertEquals(driver.findElement(By.xpath("//tr[2]/td")).getText().toUpperCase(), shipping);
            System.out.println("Shipping de detalle correcto: " + shipping);

            
            String actualTitle = driver.getTitle();
            //System.out.println(actualTitle);

            String expectedTitle = "Checkout � Demo Shopping site";
            if (actualTitle.contentEquals(expectedTitle)) {
          	  System.out.println("");
                   System.out.println("* * * * Compra finalizada con exito * * * *");
            } else {
                   System.out.println("Test Failed");
            }
            
            
            driver.close();
     }

}