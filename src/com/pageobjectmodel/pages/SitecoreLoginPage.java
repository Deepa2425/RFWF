package com.pageobjectmodel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SitecoreLoginPage extends BasePage {

	public SitecoreLoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyErrorMessageInvalidPwd(String msg) throws InterruptedException {
		String v = driver.findElement(By.xpath("//span[contains(text(),'" + msg + "')]")).getText();
		if (!(v.contains(msg))) {
			Assert.fail("Page Layout not created");
		}

	}

}
