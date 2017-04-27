package com.pageobjectmodel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InsertFromTemplate extends BasePage {

	public InsertFromTemplate(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void createTemplate(String templateName) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='ItemName']")).clear();
		driver.findElement(By.xpath(".//*[@id='ItemName']")).sendKeys(templateName);

	}

	public void expandRfwPresencePagesSelectSecure() throws InterruptedException {
		Thread.sleep(3000);
		String v = driver.findElement(By.xpath(".//*[@id='Templates_B39820EA068943BCB403B02FB24A3138']/img"))
				.getAttribute("src");
		if (!(v.contains("expanded"))) {
			driver.findElement(By.xpath(".//*[@id='Templates_B39820EA068943BCB403B02FB24A3138']/img")).click();
		}
		Thread.sleep(3000);
		String v1 = driver.findElement(By.xpath(".//*[@id='Templates_18F03EB8AB924AD99FD40B53CC436F2F']/img"))
				.getAttribute("src");

		if (!(v1.contains("expanded"))) {
			driver.findElement(By.xpath(".//*[@id='Templates_18F03EB8AB924AD99FD40B53CC436F2F']/img")).click();
		}
	}

	public void switchFrame1() throws InterruptedException {
		Thread.sleep(3000);
		driver.switchTo().frame("scWebEditRibbon");
	}

}
