package com.basetestng.libraries;

import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.pageobjectmodel.pages.ApachePOIMethods;

public class BaseTestNGPageSiteCoreV1 {

	public static WebDriver edriver;
	public static EventFiringWebDriver driver;

	@BeforeMethod
	public void invokeBrowser() throws InterruptedException {
		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_2();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
		String serverFile = aPOI.getServerFiles();
	
		//URL ->V1 - 7, V2 - 8
		
		String url = g.getExcelCellValue(xlPath, sheetName, 7, 1);
		String un = g.getExcelCellValue(xlPath, sheetName, 7, 2);
		String pwd = g.getExcelCellValue(xlPath, sheetName, 7, 3);
		
		System.setProperty("webdriver.chrome.driver",
				serverFile);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));

		ChromeOptions options = new ChromeOptions();
		options.addArguments("chrome.switches", "--disable-extensions");
		System.setProperty("webdriver.chrome.driver",
				(System.getProperty("user.dir") + "\\ServerFiles\\chromedriver.exe"));

		// Code to store Landing page templates in specified folder
		String downloadFilepath = "C:/Userst";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		options.setExperimentalOption("prefs", chromePrefs);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	
		//Code to remove default pop up in chrome browser
		options.addArguments("--test-type");
		capabilities.setCapability("chrome.binary",
				serverFile);
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	
		edriver = new ChromeDriver(capabilities);
		driver = new EventFiringWebDriver(edriver);

		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(5000);
		try {
			WebDriverWait wt = new WebDriverWait(driver, 100);
			//wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='UserName']")));
			Thread.sleep(5000);
			//UserName
			driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys(un);
			Thread.sleep(5000);
			//wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='Password']")));
			
			//Password
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(pwd);

			wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='login']/input")));
			driver.findElement(By.xpath("//div[@id='login']/input")).click();
		} catch (Exception e) {
			Assert.fail("Username/Password is incorrect or not entered");
		}
	}

	@AfterMethod
	public void closeBrowser() throws InterruptedException {
	
    	//driver.findElement(By.xpath("//span[text()='Logout']")).click();
		///driver.close();
	}

}
