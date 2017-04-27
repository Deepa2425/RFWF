package com.basetestng.libraries;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestNGPageRFWFFrontEnd {

	public static WebDriver edriver;
	public static EventFiringWebDriver driver;

	public BaseTestNGPageRFWFFrontEnd() {

	}

	@BeforeMethod
	public void invokeBrowser() throws InterruptedException {
		 //  driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		ReadDataFromExcel g = new ReadDataFromExcel();
		String xlPath = "C:/Users/24023/Workspace_Dec2016/RFWF/test-input/config.xlsx";
		String sheetName = "URL";
		String sheetName1 = "NewScriptsPrincy";

		//String url = g.getExcelCellValue(xlPath, sheetName, 27, 1);
		String url = g.getExcelCellValue(xlPath, sheetName, 28, 1);
		
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName1, 90, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName1, 91, 2);
		
	//	String frontEndUrl=url+"/"+folderNameToCreate+"/"+templateName;

		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\24023\\Workspace_Dec2016\\RFWF\\ServerFiles\\chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));

		ChromeOptions options = new ChromeOptions();
		options.addArguments("chrome.switches", "--disable-extensions");
		System.setProperty("webdriver.chrome.driver",
				(System.getProperty("user.dir") + "\\ServerFiles\\chromedriver.exe"));

		// Code to store Landing page templates in specified folder
		String downloadFilepath = "C:/Users/19403/Workspace_Dec2016/RFWF/test-input";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		options.setExperimentalOption("prefs", chromePrefs);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		// Code to remove default pop up in chrome browser
		options.addArguments("--test-type");
		capabilities.setCapability("chrome.binary",
				"C:\\Users\\24023\\Workspace_Dec2016\\RFWF\\ServerFiles\\chromedriver.exe");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		edriver = new ChromeDriver(capabilities);
		driver = new EventFiringWebDriver(edriver);

		driver.manage().window().maximize();
		//driver.get(frontEndUrl);
//		driver.get(url);

	//	Thread.sleep(5000);
	}

	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		/*
		 * WebDriverWait wt = new WebDriverWait(driver, 100);
		 * wt.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//span[text()='Logout']")));
		 * driver.findElement(By.xpath("//span[text()='Logout']")).click();
		 */
		//driver.close();
	}

}
