package com.pageobjectmodel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOnContentEditor() throws InterruptedException {
		//WebDriverWait wt = new WebDriverWait(driver, 50);
		Thread.sleep(5000);
		//wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//a//span[contains(text(),'Content Editor')]")));
		driver.findElement(By.xpath("//a//span[contains(text(),'Content Editor')]")).click();

	}

	public void editField(int index, String name) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@class='scContentControl'])[" + index + "]")).clear();
		driver.findElement(By.xpath("(//input[@class='scContentControl'])[" + index + "]")).sendKeys(name);
	}
	
	public void editFieldGetText(int index, String name) {
		String v = driver.findElement(By.xpath("(//input[@class='scContentControl'])[" + index + "]")).getAttribute("value");
		if (!(v.contains(name))) {
			Assert.fail("Exception");
		}
	}
	
	public void editFieldGetTextNegative(int index, String name) {
		String v = driver.findElement(By.xpath("(//input[@class='scContentControl'])[" + index + "]")).getAttribute("value");
		System.out.println("1111111111111111111" + v);
		if ((v.contains(name))) {
			Assert.fail("Exception");
		}
	}


	public void editFieldUnPwd(int index, String name) {
		driver.findElement(By.xpath("(//input[contains(@id,'FIELD')])[" + index + "]")).clear();
		driver.findElement(By.xpath("(//input[contains(@id,'FIELD')])[" + index + "]")).sendKeys(name);
	}

	public void editTextAreaField(int index, String name) {
		driver.findElement(By.xpath("(//textarea[contains(@class,'scContentControlMemo')])[" + index + "]")).clear();
		driver.findElement(By.xpath("(//textarea[contains(@class,'scContentControlMemo')])[" + index + "]"))
				.sendKeys(name);
	}
	
	public void editTextAreaFieldGetText(int index, String name) {
		String v = driver.findElement(By.xpath("(//textarea[contains(@class,'scContentControlMemo')])[" + index + "]")).getText();
		System.out.println(v);
		if ((v.contains(name))) {
			Assert.fail("Exception");
		}	
	}

	public void getItemPathText(String path) {
		String v = driver.findElement(By.xpath(".//*[@id='EditorPanel']//tbody/tr[3]/td[2]/input"))
				.getAttribute("value");
		
		if (!(v.contains(path))) {
			Assert.fail("Exception");
		}
	}

	public void clickRtClickDelete() throws InterruptedException {
		driver.findElement(By.xpath("//tr[contains(@id,'ContextMenu_')]//td[text()='Delete']")).click();
		Thread.sleep(5000);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		iFT.switchFrame();
		driver.findElement(By.xpath("//button[@id='OK']")).click();
	}

	public void getField1(int index, String name) {
		String v = driver
				.findElement(By.xpath(".//*[@id='EditorPanel']/table/tbody/tr/td/table/tbody/tr[" + index + "]/td[1]"))
				.getText();
		System.out.println("Field Name - " + v);

		if (!(v.contains(name))) {
			Assert.fail("Exception");
		}

	}

	public void getField2(int index, String name) {
		String v = driver
				.findElement(By.xpath(".//*[@id='EditorPanel']/div[3]/div/table[2]/tbody/tr/td/table[3]/tbody/tr/td["+index+"]/div[1]"))
				.getText();
									  
		System.out.println("Field Name - " + v);

		if (!(v.contains(name))) {
			Assert.fail("Exception");
		}

	}
	//Princy 6 march
	public void insertRegisterLink(){
		driver.findElement(By.xpath(".//td[div[text()='Register:']]//a[text()='Insert link']")).click();
		
	}
	public void insertForgotPasswordLink(){
		driver.findElement(By.xpath(".//td[div[text()='Forgot Password:']]//a[text()='Insert link']")).click();
		
	}
	
	public void insertForgetUseridLink(){
		driver.findElement(By.xpath(".//td[div[text()='Forget User ID:']]//a[text()='Insert link']")).click();

	}//Princy 10th march
	public void insertRedirectionLink(String txt){
		//SetTheUserActivateUrl:
		driver.findElement(By.xpath(".//td[div[text()='"+txt+"']]//a[text()='Insert link']")).click();

	}
//Princy 28th march 2017
	public void editField1(int index, String name) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@class='scContentControl'])[" + index + "]")).clear();
		driver.findElement(By.xpath("(//*[@class='scContentControl'])[" + index + "]")).sendKeys(name);
	}
	
//princy 26th april 2017
	public void BrowseRedirectionLink(String txt){
		//SetTheUserActivateUrl:
		driver.findElement(By.xpath(".//td[div[text()='"+txt+"']]//a[text()='Browse']")).click();

	}

}
