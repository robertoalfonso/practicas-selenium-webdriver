package misael;

import org.openqa.selenium.chrome.ChromeDriver;

public interface Utils {
	String baseURL="http://www.demo.guru99.com/V4/";

	public static ChromeDriver initialize() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
		return driver;
	}

}
