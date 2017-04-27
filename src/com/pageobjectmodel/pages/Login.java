package com.pageobjectmodel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login extends BasePage {
	public Login(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginCreds(String un, String pwd) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@name='UserName']")).clear();
		driver.findElement(By.xpath("//*[@name='UserName']")).sendKeys(un);
		Thread.sleep(3000);
		// Password
		driver.findElement(By.xpath("//input[@id='Password']")).clear();
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//div[@id='login']/input")).click();

	}

	public void verifyLoggedInUser(String msg) throws InterruptedException {
		Thread.sleep(5000);
		String v = driver.findElement(By.xpath("//div/div[2]/div/ul//li[2]")).getText();
	
		if (!(v.contains(msg))) {
			Assert.fail("Page Layout not created");
		}
	}
	
	public void verifyRememberMeCheckBox() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='RememberMe']")).click();
	}
	
	public void verifySavedUN(String msg) throws InterruptedException {
		String v = driver.findElement(By.xpath("//input[@id='UserName']")).getAttribute("value");
		if (!(v.contains(msg))) {
			Assert.fail("Page Layout not created");
		}
	}
	public void verifyUnSavedUN() throws InterruptedException {
		String v = driver.findElement(By.xpath("//input[@id='UserName']")).getAttribute("value");
		if (!(v.contains(""))) {
			Assert.fail("Page Layout not created");
		}
	}
	
	public void forgotPwdUN(String text) {
		String v = driver.findElement(By.xpath("//input[@id='UserNameForgot']")).getAttribute("value");
		if (!(v.contains(text))) {
			Assert.fail("User Name is present");
		}
	}
	
	public void clickBackButtonInForgotPwdPage() {
		driver.findElement(By.xpath("(//a[contains(text(),'Back')])[1]")).click();
	}
	
	public void verifyLoginPage(String text) {
		String	v = driver.findElement(By.xpath("//div[@id='login']/input")).getAttribute("value");
		System.out.println(text);
		System.out.println(v);
		if (!(v.contains(text))) {
			Assert.fail("User Name is present");
		}
	}
	
	public void inputUNInForgotUnPage(String text) {
		driver.findElement(By.xpath("//input[@id='UserNameForgot']")).sendKeys(text);
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
	}
	
	public void verifyAttribute(String attributeName) throws InterruptedException {
		String v = driver.findElement(By.xpath("//input[@id='"+attributeName+"']")).getAttribute("name");
		if (!(v.contains(attributeName))) {
			Assert.fail("Attribute not Found!!");
		}
	}
	
	public void clcikLogInInRegisterPage() {
		driver.findElement(By.xpath("//li[1]/a")).click();
	}
}
