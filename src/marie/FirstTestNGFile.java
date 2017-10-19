package marie;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestNGFile {
	public String baseUrl = "http://demo.guru99.com/selenium/newtours/";
	String driverPath = "C:\\chromedriver.exe";

	public WebDriver driver;

	@Test(description = "This TC verify the title of the home page", priority = 20)
	public void verifyHomepageTitle() {
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.close();
	}

	@Test(priority = 2)
	public void seleccionarFemenino() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		String url = "http://toolsqa.wpengine.com/Automation-practice-form/";
		driver.get(url);
		boolean femSeleccionado = driver.findElement(By.id("sex-1")).isSelected();
		if (!femSeleccionado) {
			System.out.println("Sexo femenino no seleccionado, procedo a seleccionar");
			driver.findElement(By.id("sex-1")).click();
		}

		driver.findElement(By.id("exp-2")).click();
		

	}

	@Test(priority = 3)
	public void seleccionarAutomationTester() {
		List<WebElement> profesiones = driver.findElements(By.name("profession"));
		int sizeProf = profesiones.size();
		for (int i = 0; i < sizeProf; i++) {
			String value = profesiones.get(i).getAttribute("value");

			if (value.equalsIgnoreCase("Automation Tester")) {
				profesiones.get(i).click();
				System.out.println("Automation Tester seleccionado");
				break;
			}

		}
		driver.close();
	}

	@Test(priority = 4)
	public void seleccionarSeleniumIDE() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		String url = "http://toolsqa.wpengine.com/Automation-practice-form/";
		driver.get(url);
		driver.findElement(By.cssSelector("input[value='Selenium IDE']")).click();
		System.out.println("Selenium IDE seleccionado");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		// Close every associated window.
		
		driver.close();
	}
	
	/*The Select class in Selenium.Support.UTI supports only native select element which is
<select>
  <option>Item 1</option1>
  <option>Item 2</option1>
  ...
	 */
	@Test(priority = -5, description="DeSelect all Automation Tool",enabled=false)
	public void DeSeleccionarAllTools() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		String url = "http://toolsqa.wpengine.com/Automation-practice-form/";
		driver.get(url);
		driver.findElement(By.cssSelector("input[value='Selenium IDE']")).click();
		System.out.println("Selenium IDE seleccionado - listo para DesSelectALL");
		//WebElement element = driver.findElement(By.name("tool"));
		Select tools = new Select(driver.findElement(By.name("tool")));
		tools.deselectAll();
		System.out.println("All tools deselected");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		// Close every associated window.
		driver.close();

	}
	
	
	/*The Select class in Selenium.Support.UTI supports only native select element which is
	<select>
	  <option>Item 1</option1>
	  <option>Item 2</option1>
	  ...
		 */
	@Test(priority = -6, description="DeSelect Automation Tool by Index",enabled=false)
	public void DeSeleccionarSeleniumIDEByIndex() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		String url = "http://toolsqa.wpengine.com/Automation-practice-form/";
		driver.get(url);
		driver.findElement(By.cssSelector("input[value='Selenium IDE']")).click();
		System.out.println("Selenium IDE seleccionado - listo para DesSelect by Index");
		//WebElement element = driver.findElement(By.name("tool"));
		Select tools = new Select(driver.findElement(By.name("tool")));
		//tools.deselectByIndex(1);
		tools.deselectByVisibleText("Selenium IDE");
		System.out.println(" Selenium IDE deselected");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		// Close every associated window.
		driver.close();

	}
	
	
	@Test(priority = 10, description="This TC will select South America from a Drop Down using Visibly Text")
	public void selectFromDropDownByVisibleText() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		String url = "http://toolsqa.wpengine.com/Automation-practice-form/";
		driver.get(url);
		
		//new Select(driver.findElement(By.id("continents"))).selectByVisibleText("South America");

		WebElement element = driver.findElement(By.id("continents"));
		Select oSelection = new Select(element);
		oSelection.selectByVisibleText("South America");
		driver.quit();
		

	}
	@Test(priority = 11, description="This TC will select Europe from a Drop Down using Index")
	public void selectFromDropDownByIndex() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		String url = "http://toolsqa.wpengine.com/Automation-practice-form/";
		driver.get(url);
		
		WebElement element = driver.findElement(By.id("continents"));
		Select oSelection = new Select(element);
		//1 is for Europe, starts from 0!!!
		oSelection.selectByIndex(1);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	
	
	//FAILS, no Values settled
	@Test(priority = 12, description="This TC will select Antartica from a Drop Down using Value", enabled=false)
	public void selectFromDropDownByValue() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		String url = "http://toolsqa.wpengine.com/Automation-practice-form/";
		driver.get(url);
		WebElement element = driver.findElement(By.id("continents"));
		Select oSelection = new Select(element);
		//1 is for Europe, starts from 0!!!
		oSelection.selectByValue("Antartica");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}
	
	@Test(priority = 13, description="This TC will get Size of options and will print all the options")
	public void selectGetOptions() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		String url = "http://toolsqa.wpengine.com/Automation-practice-form/";
		driver.get(url);
		WebElement element = driver.findElement(By.id("continents"));
		Select oSelection = new Select(element);
		
		List <WebElement> options = oSelection.getOptions();
		int size = options.size();
		for (int i=0;i<size;i++){
			System.out.println(options.get(i).getText());
		}
		driver.close();
	}

}
