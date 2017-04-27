package com.pageobjectmodel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ManageProfile extends BasePage {

	public ManageProfile(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void verifyManageProfilePage(String msg) throws InterruptedException {
		Thread.sleep(5000);
		String v = driver.findElement(By.xpath("//h1[contains(text(),'Manage Profile')]")).getText();
		System.out.println(v);
		if(!(v.contains(msg))) {
			Assert.fail("User Not Activated!");
		}
	}
	
	public void fillManageProfilePageDetails(String email,String jobTitle,String countryCode,String street) throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@id='txtNewEmail']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='txtConfirmEmail']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='JobTitle']")).sendKeys(jobTitle);
		driver.findElement(By.xpath("//input[@id='txtCountryCode']")).clear();
		driver.findElement(By.xpath("//input[@id='txtCountryCode']")).sendKeys(countryCode);
		driver.findElement(By.xpath("//textarea[@id='txtStreet']")).sendKeys(street);
		driver.findElement(By.xpath("//input[@value='Change Profile']")).click();
	}
	
	public void firstNameLastName(String firstName,String lastName,String phone) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='txtFirstName']")).clear();
		driver.findElement(By.xpath("//input[@id='txtFirstName']")).sendKeys(firstName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtLastName']")).clear();
		driver.findElement(By.xpath("//input[@id='txtLastName']")).sendKeys(lastName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtPhone']")).clear();
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys(phone);
		
		
	}
	
	public void verifyManageProfileSuccessMessage(String msg) throws InterruptedException {
		Thread.sleep(5000);
		String v = driver.findElement(By.xpath("//div[contains(text(),'Your account has been updated successfully')]")).getText();
		System.out.println(v);
		if(!(v.contains(msg))) {
			Assert.fail("User Not Activated!");
		}
	}
	
	public void editEmail(String email) {
		driver.findElement(By.xpath("//input[@id='txtNewEmail']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='txtConfirmEmail']")).sendKeys(email);
	}
	
	public void clickChangeEmail() {
		driver.findElement(By.xpath("//input[@value='Change Email']")).click();
	}
	
	public void verifyEditEmailSuccessMessage(String msg) throws InterruptedException {
		Thread.sleep(5000);
		String v = driver.findElement(By.xpath("//div//h1[contains(text(),'Email Activate')]")).getText();
		System.out.println(v);
		if(!(v.contains(msg))) {
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
