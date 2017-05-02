package com.pageobjectmodel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageLayout extends BasePage {

	public PageLayout(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickPageLayout() throws InterruptedException {
		WebDriverWait wt = new WebDriverWait(driver, 50);
		Thread.sleep(5000);
		wt.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='scEnabledChrome scEmptyPlaceholder'])[2]")));
		driver.findElement(By.xpath("(//div[@class='scEnabledChrome scEmptyPlaceholder'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Add here']")).click();
		Thread.sleep(5000);
	}
	
	public void clickPageLayout1(int index) throws InterruptedException {
		WebDriverWait wt = new WebDriverWait(driver, 50);
		Thread.sleep(5000);
		wt.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='scEnabledChrome scEmptyPlaceholder'])["+index+"]")));
		driver.findElement(By.xpath("(//div[@class='scEnabledChrome scEmptyPlaceholder'])["+index+"]")).click();
		driver.findElement(By.xpath("//span[text()='Add here']")).click();
		Thread.sleep(5000);
	}

	public void selectPageLayout(int indexNumber) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='scImageContainer']//img)[" + indexNumber + "]")).click();
	}

	public void verifyPageLayoutCretaed(String name) throws InterruptedException {
		Thread.sleep(10000);
		try{			
			String v = driver.findElement(By.xpath("//div/h1[contains(text(),'" + name + "')]")).getText();
			   System.out.println(v);
			if (!(v.contains(name))) {
				Assert.fail("Page Layout not created");
			}
				
		} catch(Exception e) {
			
			String v = driver.findElement(By.xpath("//span[contains(text(),'" + name + "')]")).getText();
			   System.out.println(v);
			if (!(v.contains(name))) {
				Assert.fail("Page Layout not created");
			}
	}
	}
	
	public void verifyPageLayoutCretaed1(String name) throws InterruptedException {
		Thread.sleep(15000);
		String v = driver.findElement(By.xpath("//span//strong[contains(text(),'" + name + "')]")).getText();
		   System.out.println(v);
		if (!(v.contains(name))) {
			Assert.fail("Page Layout not created");
		}
	}
	
	public void clickOnSave() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath("//a//img[contains(@alt,'Save changes.')]")).click();
		Thread.sleep(25000);
	}

	public void clickCreateNewContent() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='mode']//div//img[@id='CreateIcon']")).click();
	}
	
	public void verifyHeaderFooter(String header,String footer,String title) {
		String v1 = driver.findElement(By.xpath("//body")).getText();
		if(!(v1.contains(header))) {
			Assert.fail("Header not Present - "+header);
		}
		
		if(!(v1.contains(footer))) {
			Assert.fail("Footer not Present - "+footer);
		}
		
		String v2 = driver.getTitle();
		if(!(v2.contains(title))) {
			Assert.fail("Title not Present - "+title);
		}
	}
	
	public void verifyUnlockErrorMessage(String text) {
		 driver.switchTo().frame("scWebEditRibbon");
    	 String v = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[2]/div")).getText();
    	 System.out.println(v);
         	driver.switchTo().defaultContent();
     	if(!(v.contains(text))) {
 			Assert.fail("Item Path not Found!");
 		}
		
	}
	//princy 30 march
public void clickAddComponent(){
	driver.findElement(By.xpath("(//img[@alt='Add a new component.'])[1]")).click();
	
}
public void clickAddHere(int index){
	driver.findElement(By.xpath("(//span[text()='Add here'])["+index+"]")).click();

}

}
