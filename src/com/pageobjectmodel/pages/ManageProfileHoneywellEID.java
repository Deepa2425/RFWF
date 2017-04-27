package com.pageobjectmodel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ManageProfileHoneywellEID extends BasePage {

	public ManageProfileHoneywellEID(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void verifyDisabledField(String fieldName) throws InterruptedException {
		Thread.sleep(5000);
		String v = driver.findElement(By.xpath("//input[@name='"+fieldName+"']")).getAttribute("disabled");
		System.out.println("vvvvvvvvvvvvv"+v);
		if(!(v.contains("true"))) {
			Assert.fail("User Not Activated!");
		}
	}
	
	
	
	public void verifyManageProfilEditEmailSuccessMessage(String msg) throws InterruptedException {
		Thread.sleep(5000);
		String v = driver.findElement(By.xpath("//div[contains(text(),'An email has been sent to you. Please follow the directions in that email to change your email address.')]")).getText();
		System.out.println(v);
		if(!(v.contains(msg))) {
			Assert.fail("User Not Activated!");
		}
	}
	
	
}
