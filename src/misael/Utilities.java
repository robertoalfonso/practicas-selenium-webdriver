package misael;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface Utilities {
	String username = "magimj9c";
	String password = "Chu.cho4";
	String baseUrl = "http://vhhsconxas202.mrli.ppdi.com/gclportal/portlets/com/gcl/myaccount/myaccountController.jpf?npl=login_login#";

	WebDriver driver = new ChromeDriver();
	// WebDriver driver = new FirefoxDriver();

	public static void LoginConneXion() {
		driver.findElement(By.id("login_login.username")).clear();
		driver.findElement(By.id("login_login.username")).sendKeys(username);
		driver.findElement(By.name("{actionForm.password}")).clear();
		driver.findElement(By.name("{actionForm.password}")).sendKeys(password);
		driver.findElement(By.cssSelector("a.button-left > span")).click();
		return;
	}

	public static String GenerateKitAccession(String StudyCode) {
		driver.findElement(By.cssSelector("#menu-0-item-15 > a")).click();
		driver.findElement(By.linkText("Create Pre-Labeled Kits")).click();
		driver.findElement(By.linkText("Create Kit(s)")).click();
		driver.findElement(By.id("util_util.study")).sendKeys(StudyCode);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("util_util.siteSelectBox")));
		driver.findElement(By.id("util_util.lotNumber")).clear();
		driver.findElement(By.id("util_util.lotNumber")).sendKeys("123");
		driver.findElement(By.id("util_util.expDate")).clear();
		driver.findElement(By.linkText("30")).click();
		driver.findElement(By.id("util_util.numKits")).clear();
		driver.findElement(By.id("util_util.numKits")).sendKeys("1");

		driver.findElement(By.cssSelector("a.button > span")).click();
		// List <WebElement> rows =
		// driver.findElements(By.xpath("//*[@id=\"util_util.StudyKitSelectionForm\"]/table"));
		// System.out.println("No of rows are : " + rows.size());

		WebElement location = driver
				.findElement(By.xpath("//*[@id=\"util_util.StudyKitSelectionForm\"]/table/tbody/tr[1]/td/font/b"));
		String reqNumber = location.getText().substring(5);
		return reqNumber;

	}

	public static void GimmeKitAccession(String StudyCode) {
		System.out.println(GenerateKitAccession(StudyCode));
	}

	public static void AccessKit(String KitAccessionNumber) {
		driver.findElement(By.linkText("SLC")).click();
		driver.findElement(By.cssSelector("#menu-0-item-5 > a")).click();
		driver.findElement(By.name("actionOverride:gotoModule?module=boxReception")).click();
		driver.findElement(By.name("actionOverride:requisitionForms")).click();
		driver.findElement(By.name("{pageFlow.enteredReqId}")).sendKeys(KitAccessionNumber);
		driver.findElement(By.name("actionOverride:reqIdSubmit")).click();
		new Select(driver.findElement(By.id("VISIT"))).selectByVisibleText("Visit 1 - Screening");
		driver.findElement(By.name("{pageFlow.preAccessionData.idFormFields[0].fieldValue}"))
				.sendKeys("123" + Keys.TAB);
		driver.findElement(By.linkText("Continue")).click();
		driver.findElement(By.xpath("//form[@id='mainForm']/table[3]/tbody/tr/td[2]/a[2]/span")).click();
	}

	public static boolean IsElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static List<String> GetSANumbers() {
		List<String> SANList = new ArrayList<String>();
		for (int i = 2; IsElementPresent(
				By.xpath("//*[@id=\"util_util.StudyKitSelectionForm\"]/table/tbody/tr[" + (i + 1) + "]/td")); i++) {
			String xpath = "//*[@id=\"util_util.StudyKitSelectionForm\"]/table/tbody/tr[" + i + "]/td";
			String elem = driver.findElement(By.xpath(xpath)).getText();
			SANList.add(elem);

		}
		return SANList;

	}
	public static void AccessSamples(List<String> samples) {
		driver.findElement(By.cssSelector("#menu-0-item-5 > a")).click();
		//driver.findElement(By.name("actionOverride:gotoModule?module=boxReception")).click();
		driver.findElement(By.id("chAirwaybill")).click();
		driver.findElement(By.name("actionOverride:ambientSamples")).click();
		for (int i = 0; i < samples.size(); i++) {
			driver.findElement(By.id("txtBarcode"+i)).clear();
			driver.findElement(By.id("txtBarcode"+i)).sendKeys(samples.get(i)+Keys.ENTER);
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("txtBarcode"+(i+1))));
		}
		driver.findElement(By.xpath("(//button[@value='Click'])[5]")).click();


	}
}
