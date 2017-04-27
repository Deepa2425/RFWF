package com.basetestng.libraries;

import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.pageobjectmodel.pages.ApachePOIMethods;

public class BaseTestNGPageForgetUserID {

	public static WebDriver edriver;
	public static EventFiringWebDriver driver;

	public BaseTestNGPageForgetUserID() {

	}

	@BeforeMethod
	public void invokeBrowser() throws InterruptedException {
		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_2();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
		String serverFile = aPOI.getServerFiles();
		
		
		String url = g.getExcelCellValue(xlPath, sheetName, 18, 1);
		System.setProperty("webdriver.chrome.driver",
				serverFile);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));

		ChromeOptions options = new ChromeOptions();
		options.addArguments("chrome.switches", "--disable-extensions");
		System.setProperty("webdriver.chrome.driver",
				(System.getProperty("user.dir") + "\\ServerFiles\\chromedriver.exe"));

		// Code to store Landing page templates in specified folder
		String downloadFilepath = "C:/Users";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		options.setExperimentalOption("prefs", chromePrefs);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		// Code to remove default pop up in chrome browser
		options.addArguments("--test-type");
		capabilities.setCapability("chrome.binary",
				serverFile);
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		edriver = new ChromeDriver(capabilities);
		driver = new EventFiringWebDriver(edriver);

		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(5000);
	}

	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		/*
		 * WebDriverWait wt = new WebDriverWait(driver, 100);
		 * wt.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//span[text()='Logout']")));
		 * driver.findElement(By.xpath("//span[text()='Logout']")).click();
		 */
		driver.close();
	}

}
