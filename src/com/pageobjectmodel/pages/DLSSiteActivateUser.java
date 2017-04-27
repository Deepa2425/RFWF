package com.pageobjectmodel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DLSSiteActivateUser extends BasePage {

	public DLSSiteActivateUser(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void activateUser(String pwd) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(pwd);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
}
