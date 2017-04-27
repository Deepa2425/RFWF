package com.pageobjectmodel.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.basetestng.libraries.ReadDataFromExcel;

public class DLSSiteRegisterPage extends BasePage {
	/*String xlPath = "C:\\Users\\19403\\Workspace_Dec2016\\RFWF\\test-input\\config.xlsx";
	String sheetName = "DLSSiteRegisterUser";
	
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	Date date = new Date();
	String date1= dateFormat.format(date);
	ReadDataFromExcel g = new ReadDataFromExcel();*/
	
	ReadDataFromExcel g = new ReadDataFromExcel();
	ApachePOIMethods aPOI = new ApachePOIMethods();
	String xlPath = aPOI.getConfigFilePath();
	String sheetName = aPOI.getSheet_2();
	String date1 = aPOI.getDate_1();
	String date2 = aPOI.getDate_2();
	String serverFile = aPOI.getServerFiles();
	//Creata one more sheet for questionaries
	
	public DLSSiteRegisterPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
			
	}

	public void clickOnRegisterButton() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='btnRegisteration']")).click();
	}
	
	public void verifyToolTip() throws InterruptedException {
		String script = "return document.getElementById('hlpUserName').getAttribute('onclick');";
		String value = ((JavascriptExecutor) driver).executeScript(script).toString();
		System.out.println("VVVVVVVVVValue - "+value);
	}
	
	public void registerUser(String userName,String pwd,String confPwd,String firstName,String lastName,String email,String confEmail,String company,String jobTitle,String phone,String city,String state,int country
			,String postalCode,int Q1,String A1,int Q2,String A2,int Q3,String A3) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id='txtNewPassword']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@id='txtConfirmationPassword']")).sendKeys(confPwd);
		driver.findElement(By.xpath("//input[@id='txtFirstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='txtLastName']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@id='txtNewEmail']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='txtConfirmEmail']")).sendKeys(confEmail);
		driver.findElement(By.xpath("//input[@id='txtCompanyName']")).sendKeys(company);
		driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys(jobTitle);
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys(phone);
		driver.findElement(By.xpath("//input[@id='txtCity']")).sendKeys(city);
		driver.findElement(By.xpath("//input[@id='txtState']")).sendKeys(state);
		
		WebElement element=driver.findElement(By.id("ddlCountries"));
		Select se=new Select(element);
		se.selectByIndex(country);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='txtPostalCode']")).sendKeys(postalCode);
		
		WebElement element1=driver.findElement(By.id("ddlSecQ1"));
		Select se1=new Select(element1);
		se1.selectByIndex(Q1);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='txtAnswer1']")).sendKeys(A1);
		driver.findElement(By.xpath("//input[@id='txtConfirmAnswer1']")).sendKeys(A1);
		
		WebElement element2=driver.findElement(By.id("ddlSecQ2"));
		Select se2=new Select(element2);
		se2.selectByIndex(Q2);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='txtAnswer2']")).sendKeys(A2);
		driver.findElement(By.xpath("//input[@id='txtConfirmAnswer2']")).sendKeys(A2);
		Thread.sleep(3000);
		
		WebElement element3=driver.findElement(By.id("ddlSecQ3"));
		Select se3=new Select(element3);
		se3.selectByIndex(Q3);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='txtAnswer3']")).sendKeys(A3);
		driver.findElement(By.xpath("//input[@id='txtConfirmAnswer3']")).sendKeys(A3);
		Thread.sleep(20000);
		
	
			
	}
	
	public void clickPrivacyAgree() {
		driver.findElement(By.xpath("//input[@id='PrivacyAgree']")).click();
	}
	
	public void verifySuccessMessage(String msg) throws InterruptedException {
		Thread.sleep(5000);
		String v = driver.findElement(By.xpath("//div[contains(text(),'An email has been sent to the following email address:')]")).getText();
		if(!(v.contains(msg))) {
			Assert.fail("Something went wrong while registering");
		}
	}
	
	public void clickOnQuestionMark(int index) {
		driver.findElement(By.xpath("(//img[@class='helpError'])["+index+"]")).click();
		
	}
	
	public void verifyAllQuestionaries(String a[]) {
		List<WebElement> v = driver.findElements(By.xpath("//div[@id='rfwf-modal']//li"));
		int len = v.size();
		for(int i =0;i<len;i++) {
			String s = v.get(i).getText();
			System.out.println("aaaaaaaaa"+a[i]);
			System.out.println("sssssssss"+s);
			if(!(s.contains(a[i]))) {
				g.setExcelCellValue(xlPath, sheetName, 34, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 34, 4, date1);
				Assert.fail("Questionaries are not displayed properly!");
			}
		}
		
		System.out.println("************************************************");
	}
	
	public void closeQuestionerPopUp() {
		driver.findElement(By.xpath("//div[@id='rfwf-modal']/a/b")).click();
	}
	
	public void verifyText(String s) {
		String v = driver.findElement(By.xpath("//div[contains(text(),'A valid email address is required to activate your account.')]")).getText();
		if(!(v.contains(s))) {
			Assert.fail("Text Not Found -"+s);
		}
	}

	public void clickRefresh() {
		driver.findElement(By.xpath("//a[text()='Refresh']")).click();
	}
	
	public void clickOnHelpMenu() {
		driver.findElement(By.xpath("//a[contains(text(),'Help')]")).click();
	}
	
	public void verifyHelpMenu(String a[]) {
			for(int i=0;i<6;i++) {
			String S1 = driver.findElement(By.xpath("//div[@id='TandCModal_Help']//h3[contains(text(),'"+a[i]+"')]")).getText();
			if(!(S1.contains(a[i]))) {
					Assert.fail("Text Not Found - "+a[i]);
				}
			}
	}
	
	public void verifyQuestionariesInNextField(int Q1,String questionIndex,int option,int index) throws InterruptedException {
		WebElement element1=driver.findElement(By.id("ddlSec"+questionIndex+""));
		Select se1=new Select(element1);
		se1.selectByIndex(Q1);
		Thread.sleep(3000);
		
		String v = driver.findElement(By.xpath("//select[@id='ddlSec"+questionIndex+"']//option["+option+"]")).getText();
		System.out.println(v);
		String v1 = driver.findElement(By.xpath("//input[@id='txtQuestion"+index+"']")).getAttribute("value");
		System.out.println(v1);
		if(!(v.contains(v1))) {
			Assert.fail("Mismatch found in both the fields!");
		}
	}
	}

