package misael.tests;

import java.util.ArrayList;

public class ATP90 implements Utilities {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

		@SuppressWarnings("unused")
		String barcode = "O8321921909";
		@SuppressWarnings("unused")
		String expectedRoute = "No Tests or Services - Route to GSS";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		Utilities.LoginConneXion();

		// driver.findElement(By.linkText("Sample Inspector")).click();
		// driver.findElement(By.id("sample_inspector_sample_inspector.barcode")).sendKeys(barcode+Keys.ENTER);
		// driver.findElement(By.linkText("Cancel Service")).click(); //PUEDE HABER MAS
		// DE UN CANCEL SERVICE
		// driver.switchTo().alert().accept();
		// //HASTA ACA, CANCELE EL SERVICIO DE ALIQUOT
		//
		// driver.findElement(By.cssSelector("#menu-0-item-5 > a")).click();
		// driver.findElement(By.linkText("Routing")).click();
		// driver.findElement(By.id("slc_routing.barcode")).clear();
		// driver.findElement(By.id("slc_routing.barcode")).sendKeys(barcode+Keys.ENTER);
		// WebElement location =
		// driver.findElement(By.xpath("/html/body/div/span/div/div[2]/span/div/table/tbody/tr/td/div/table/tbody/tr/td/div/div/div/span[1]/div/table/tbody/tr/td/div/table/tbody/tr/td/div/div/div/form/table/tbody/tr[5]/td[2]/b"));
		// String actualRoute = location.getText();
		//
		// if (actualRoute.contains(expectedRoute)){
		// System.out.println("Test Passed!");
		// System.out.println("Actual Route: "+actualRoute);
		// } else {
		// System.out.println("Test Failed");
		// System.out.println("Actual Route: "+actualRoute);
		// }
		//
		// driver.findElement(By.linkText("Sample Inspector")).click();
		// driver.findElement(By.id("sample_inspector_sample_inspector.barcode")).sendKeys(barcode+Keys.ENTER);
		// driver.findElement(By.linkText("Reset To Pending")).click(); //PUEDE HABER
		// MAS DE UN RESET
		// driver.switchTo().alert().accept();
		// //EN ESTE BLOQUE VUELVO A DEJAR AL SERVICIO EN PENDING PARA FUTUROS USOS

		@SuppressWarnings("unused")
		String KitAccessionNumber = Utilities.GenerateKitAccession("TKDA0027");
		
		java.util.List<String> sans = new ArrayList<String>();
		sans = Utilities.GetSANumbers();
		Utilities.AccessKit(KitAccessionNumber);
		Utilities.AccessSamples(sans);
		driver.close();
	}
}
