package com.pageobjectmodel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ForgetUserID extends BasePage {

	public ForgetUserID(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void enterUserID(String userID) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='txtNewEmail']")).sendKeys(userID);
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
	}

	}
