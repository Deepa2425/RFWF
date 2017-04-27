package com.pageobjectmodel.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailLogin extends BasePage {

	public MailLogin(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOnRegisterButton() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='btnRegisteration']")).click();
	}

	public void clickRegistrationLink() throws InterruptedException {
		Thread.sleep(20000);
		/*while (true) {
			try {
				List<WebElement> v = driver
						.findElements(By.xpath("//div//span//b[contains(text(),'New User Registration')]"));
				v.get(0).click();
				Thread.sleep(7000);
				driver.findElement(By.xpath("//a[contains(text(),'http://vm-rfwfv1-hon.cloudapp.')]")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//a[contains(text(),'Inbox')]")).click();
				Thread.sleep(3000);
			}
		}*/
		
		while (true) {
			try {
			driver.findElement(By.xpath("//span[text()='收件箱']")).click();
			Thread.sleep(7000);
			List<WebElement> v = driver
					.findElements(By.xpath("//span[text()='New User Registration']"));
			v.get(0).click();
			Thread.sleep(7000);
			driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[@src='read/readhtml.jsp?mid=99:1tbiYxMkFlaDqgDXFgAAs8&font=15&color=064977']")));
			//driver.findElement(By.tagName("iframe"));
		 String v1 = driver.findElement(By.xpath("html/body/pre[contains(text(),'http://iauthor.rfwfpresence20.honeywell.com/CWA/activateuser')]")).getText();
	    System.out.println(v1);
	    int v2 = v1.lastIndexOf("http");
	    System.out.println(v2);
	    int v3 = v1.lastIndexOf('/');
	    System.out.println(v3);
	    String v4 = v1.substring(v2, v3+54);
	    System.out.println(v4);
        driver.switchTo().defaultContent();
	    driver.get(v4); 
	    break;
			} catch(Exception e) {
				driver.findElement(By.xpath("//span[text()='收件箱']")).click();
			}
		
		}

	}

	public void clickChangeEmailActivation() throws InterruptedException {
		Thread.sleep(20000);
		while (true) {
			try {
				List<WebElement> v = driver
						.findElements(By.xpath("//div//span//b[contains(text(),'Change Email Activation')]"));
				v.get(0).click();
				Thread.sleep(7000);
				driver.findElement(By.xpath("//a[contains(text(),'http://vm-rfwfv1-hon.cloudapp.')]")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//a[contains(text(),'Inbox')]")).click();
				Thread.sleep(3000);
				
			}
		}

	}
	
	public void yahooClickChangeEmailActivation() throws InterruptedException {
		Thread.sleep(20000);
		while (true) {
			try {
				List<WebElement> v = driver
						.findElements(By.xpath("//span[contains(text(),'Change Email Activation')]"));
				v.get(0).click();
				Thread.sleep(7000);
				driver.findElement(By.xpath("//a[contains(text(),'http://vm-rfwfv1-hon.cloudapp.')]")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[contains(text(),'Inbox')]")).click();
				Thread.sleep(3000);
			}	
			}
		}
	
	public void yahooLogin(String userName, String pwd) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys(userName);
		driver.findElement(By.xpath("//button[@id='login-signin']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='login-passwd']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@id='login-signin']")).click();
	}
	
	//Princy 11th march
public void gmailLogin(String user,String psd){
	
    driver.findElement(By.id("Email")).sendKeys(user);
    driver.findElement(By.id("next")).click();
    driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    WebElement element1 = driver.findElement(By.id("Passwd"));
   
    element1.sendKeys(psd);
    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

    WebElement ele= driver.findElement(By.xpath("//*[@type='checkbox' and @name='PersistentCookie']"));
    if(ele.isSelected()==true)
    {
    	System.out.println("chkbox is selected");
    	ele.click();
    }
    driver.findElement(By.id("signIn")).click();
    driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

}

public void searchEmail(String from, String reguser) throws InterruptedException{
	
    Thread.sleep(20000);
 
	driver.findElement(By.xpath("//tr[td[div[span[@email='"+from+"']]]]/td//span[contains(text(),'"+reguser+"')]"));
      System.out.println("search successfull");
      Thread.sleep(8000);

      WebElement m= driver.findElement(By.xpath("//tr[td[div[span[@email='"+from+"']]]]/td//span[contains(text(),'"+reguser+"')]"));
      Actions action1=new Actions(driver);
      action1.moveToElement(m);
      System.out.println("move successfull");
      action1.doubleClick(m).build().perform();

}

public void clickUserActivationLink(){
	
	 driver.findElement(By.xpath("//a[contains(@href,'cloudapp.net')]")).click();
     
}
public void searchEmail1(String from,String txt,int index) throws InterruptedException{
    Thread.sleep(20000);
    
	  WebElement m= driver.findElement(By.xpath("(//tr[td[div[span[@email='"+from+"']]]]/td//span[contains(text(),'"+txt+"')])["+index+"]"));
      Actions action1=new Actions(driver);
      action1.moveToElement(m);
      System.out.println("move successfull");
      action1.doubleClick(m).build().perform();

	
}
}


