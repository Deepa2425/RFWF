package com.pageobjectmodel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DLSSiteFrontEnd extends BasePage {

	public DLSSiteFrontEnd(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void login(String userName,String pwd) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='UserName']")).clear();
		driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id='Password']")).clear();
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@type='Submit']")).click();
	}
}
