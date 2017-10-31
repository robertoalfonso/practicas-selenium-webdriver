package misael.tests;

import java.util.ArrayList;

public class GenerateAndAccessionKit implements Utilities {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		Utilities.LoginConneXion();

		
		String KitAccessionNumber = Utilities.GenerateKitAccession("TKDA0027");
		
		java.util.List<String> sans = new ArrayList<String>();
		sans = Utilities.GetSANumbers();
		Utilities.AccessKit(KitAccessionNumber);
		Utilities.AccessSamples(sans);
		driver.close();
	}
}
