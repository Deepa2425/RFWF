package com.pageobjectmodel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ForgotPassword extends BasePage {

	public ForgotPassword(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	//Princy 7th march

	public void doubleClickFp2(String userID) throws InterruptedException {
		WebElement v = driver.findElement(By.xpath("(//span[text()='" + userID + "'])[2]"));
		Actions action = new Actions(driver);
		action.doubleClick(v).build().perform();
	}

	public void doubleClickFp(String userID) throws InterruptedException {
		WebElement v = driver.findElement(By.xpath("(//span[text()='" + userID + "'])"));
		Actions action = new Actions(driver);
		action.doubleClick(v).build().perform();
	}

	public void singleClickFp(String userID) throws InterruptedException {
		driver.findElement(By.xpath("(//span[text()='" + userID + "'])")).click();

	}//Princy 7th march

	public void verifyComponentCreated(String msg, String msg1) throws InterruptedException {
		Thread.sleep(5000);
		String v = driver
				.findElement(By.xpath("//div[a[span[text()='" + msg + "']]]//div//span[text()='" + msg1 + "']"))
				.getText();

		if (!(v.contains(msg1))) {
			Assert.fail("Something went wrong while creating");
		}
	}
public void clickLinkText(String temp){
	driver.findElement(By.xpath("//a[text()='"+temp+"']")).click();

}
}
