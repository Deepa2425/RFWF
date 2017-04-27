package com.pageobjectmodel.pages;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ContentEditor extends BasePage {

	public ContentEditor(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOnTenant(String tenantName) throws InterruptedException {
		WebDriverWait wt = new WebDriverWait(driver, 50);
		Thread.sleep(5000);
		System.out.println(tenantName);
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[a[span[text()='"+tenantName+"']]]//img[contains(@id,'Tree_Glyph_')]")));
		driver.findElement(By
				.xpath("//div[a[span[text()='"+tenantName+"']]]//img[contains(@id,'Tree_Glyph_')]"))
				.click();
		Thread.sleep(5000);
	}

	public void rtClickOnHome() throws InterruptedException {
		WebDriverWait wt = new WebDriverWait(driver, 50);
		Thread.sleep(5000);
		wt.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//a[@id='Tree_Node_0C7F8A45DA9646A48477E820784DA1C4']/span")));

		// rt click on home
		Actions action = new Actions(driver);
		WebElement v = driver.findElement(By.xpath("//a[@id='Tree_Node_0C7F8A45DA9646A48477E820784DA1C4']/span"));
		action.contextClick(v).build().perform();

		// select Insert
		driver.findElement(By.xpath("//tr[contains(@id,'ContextMenu_')]//td[text()='Insert']")).click();

		// Select Insert from template
		driver.findElement(By
				.xpath("(//tr[contains(@id,'M')]//td/img[contains(@src,'/temp/IconCache/Office/16x16/insert_from_template.png')])[2]"))
				.click();

	}

	public void rtClickOnAndInsert(String folderName) throws InterruptedException {
		Thread.sleep(5000);
		WebElement v;
		try{
		     v = driver.findElement(By.xpath("//span[text()='"+folderName+"']"));
		} catch(Exception e) {
			 v = driver.findElement(By.xpath("(//span[text()='" + folderName + "'])[2]"));	
		}
		Actions action = new Actions(driver);
		action.contextClick(v).build().perform();

		// select Insert
		driver.findElement(By.xpath("//tr[contains(@id,'ContextMenu_')]//td[text()='Insert']")).click();

		// Select Insert from template
		try{
			System.out.println("in try");
		driver.findElement(By
				.xpath("(//tr[contains(@id,'M')]//td/img[contains(@src,'/temp/IconCache/Office/16x16/insert_from_template.png')])[2]"))
				.click();
		System.out.println("try completed");

		Thread.sleep(5000);
		} catch(Exception e) {
			System.out.println("in catch");

			driver.findElement(By
					.xpath("(//img[contains(@src,'/temp/iconcache/office/16x16/insert_from_template.png')])[3]"))
					.click();
			System.out.println("catch completed");

		}

	}
	
	public void rtClickOnAndInsert1(String folderName) throws InterruptedException {
		Thread.sleep(5000);
		WebElement v = driver.findElement(By.xpath("(//span[text()='" + folderName + "'])[2]"));	
		
		Actions action = new Actions(driver);
		action.contextClick(v).build().perform();

		// select Insert
		driver.findElement(By.xpath("//tr[contains(@id,'ContextMenu_')]//td[text()='Insert']")).click();

		// Select Insert from template
		try{
		driver.findElement(By
				.xpath("(//tr[contains(@id,'M')]//td/img[contains(@src,'/temp/IconCache/Office/16x16/insert_from_template.png')])[2]"))
				.click();
		Thread.sleep(5000);
		} catch(Exception e) {
			driver.findElement(By
					.xpath("(//img[contains(@src,'/temp/iconcache/office/16x16/insert_from_template.png')])[3]"))
					.click();
		}

	}

	public void unlockTemplate() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath("//img[contains(@title,'Locked by admin')]")).click();
	}

	public void clickPublishAndExperienceEditor() throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(By.xpath("//a[text()='Publish']")).click();
		Thread.sleep(10000);
		driver.findElement(
				By.xpath("//a[contains(@title,'Start the Experience Editor.')]//span[text()='Experience Editor']"))
				.click();
	}
	
	public void clickOnlyPublishButton() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Publish']")).click();
		Thread.sleep(7000);
	}
	
	public void clickOnlyExperienceEditorButton() throws InterruptedException {
		driver.findElement(
				By.xpath("//a[contains(@title,'Start the Experience Editor.')]//span[text()='Experience Editor']"))
				.click();
		Thread.sleep(7000);
	}


	public void switchBackTpParentWindow() throws InterruptedException {
		Iterator<String> wh = driver.getWindowHandles().iterator();
		String parent = wh.next();
		// String child = wh.next();
		Thread.sleep(5000);
		driver.switchTo().window(parent);
		Thread.sleep(5000);
		String title = driver.getTitle();
		System.out.println("Title : " + title);
	}

	public void publishItem() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//td[text()='Publish item'])[2]")).click();
	}
	
	public void verifyErrorMessagerOfCreateTempplateBlank(String msg) throws InterruptedException {
		Thread.sleep(5000);
		String v = driver.findElement(By.xpath("//span[@id='scMessage']")).getText();
		if(!(v.contains(msg))) {
			Assert.fail("Something went wrong while registering");
		}
	}
	
	public void clickOnExtandFolder1(int index) throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath("(//img[contains(@id,'Tree_Glyph_')])["+index+"]")).click();
	}
	public void clickOnExtandFolder(int index) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[contains(text(), 'useractivate')]/following::*)[1]//img[contains(@id,'Tree_Glyph_')]")).click();
	}
	
	public void rtClickToUnlock() {
		WebElement v = driver.findElement(By.xpath("//img[contains(@title,'Locked by admin')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(v);
		actions.click();
		actions.contextClick(v).build().perform();
		//driver.findElement(By.xpath("//td[text()='Locked Items']")).click();
		System.out.println("try1");
		
	    actions.contextClick(v).build().perform();
		System.out.println("try2");

	    actions.contextClick(v).build().perform();
		System.out.println("try3");

	    actions.contextClick(v).build().perform();
		System.out.println("try4");
		 actions.contextClick(v).build().perform();
			System.out.println("try5");
			 actions.contextClick(v).build().perform();
				System.out.println("try6");
				 actions.contextClick(v).build().perform();
					System.out.println("try7");

					 actions.contextClick(v).build().perform();
						System.out.println("try8");
						 actions.contextClick(v).build().perform();
							System.out.println("try8");
							 actions.contextClick(v).build().perform();
								System.out.println("try8");

								 actions.contextClick(v).build().perform();
									System.out.println("try8");
									 actions.contextClick(v).build().perform();
										System.out.println("try8");
										 actions.contextClick(v).build().perform();
											System.out.println("try8");
											actions.contextClick(v).build().perform();
											System.out.println("try8");
											
		//driver.findElement(By.xpath("//td[text()='Locked Items']")).click();
	}
	
	public void verifyItemPath(String path) {
		String v = driver.findElement(By.xpath("(//input[@class='scEditorHeaderQuickInfoInput'])[2]")).getAttribute("value");
		
		if(!(v.contains(path))) {
			Assert.fail("Item Path not Found!");
		}
	}
	
	public void clickOnContent() {
		driver.findElement(By.xpath("(//span[text()='Content'])[3]")).click();
	}
	
	public void clickOnRebublish() {
		driver.findElement(By.xpath("//input[@id='Republish']")).click();
	}
	//Princy 6 march
	public void verifyBlackSecureError(String err) {
		err="You must specify a name for the new item.";
			String v=driver.findElement(By.xpath("//span[contains(text(),'You must specify a name for the new item.')]")).getText();
		

		if(!((v.equals(err)))) {
			Assert.fail("Item Path not Found!");
		}
		
	}public void publishSite() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//td[text()='Publish site'])[2]")).click();
	}
	public void publishOptions() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Publish']")).click();
		Thread.sleep(7000);

	}
//Princy 10th march
	public void rtClickOnAndInsert2(String folderName) throws InterruptedException {
		Thread.sleep(5000);
		WebElement v;
		try{
		     v = driver.findElement(By.xpath("//span[text()='"+folderName+"']"));
		} catch(Exception e) {
			 v = driver.findElement(By.xpath("(//span[text()='" + folderName + "'])[2]"));	
		}
		Actions action = new Actions(driver);
		action.contextClick(v).build().perform();

		// select Insert
		driver.findElement(By.xpath("//tr[contains(@id,'ContextMenu_')]//td[text()='Insert']")).click();

		// Select Insert from template
		try{
			System.out.println("in try");
		driver.findElement(By
				.xpath("(//tr[contains(@id,'M')]//td/img[contains(@src,'/temp/IconCache/Office/16x16/insert_from_template.png')])[2]"))
				.click();
		System.out.println("try completed");

		Thread.sleep(5000);
		} catch(Exception e) {
							try{				System.out.println("try 2");

				driver.findElement(By
						.xpath("(//img[contains(@src,'/temp/iconcache/office/16x16/insert_from_template.png')])[2]"))
						.click();
			}
				catch(Exception e3){
					System.out.println("in catch");
					driver.findElement(By
							.xpath("(//img[contains(@src,'/temp/iconcache/office/16x16/insert_from_template.png')])[3]"))
							.click();
}
				}
					}
	//Princy 19th march
public void checkRememberLoginSetting(){
	driver.findElement(By.xpath("//td[div[text()='Display \"Remember Username\"']]/div/input[@type='checkbox']")).click();
}

public void clickOnTenant_01() throws InterruptedException {
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//div[a[span[text()='Home']]]//img[@class='scContentTreeNodeGlyph'])[2]")).click();
	Thread.sleep(5000);
}
	}



