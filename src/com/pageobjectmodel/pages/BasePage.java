package com.pageobjectmodel.pages;

import java.awt.AWTException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.basetestng.libraries.ReadDataFromExcel;

public class BasePage {
	public static WebDriver driver;
	ReadDataFromExcel g = new ReadDataFromExcel();
	ApachePOIMethods aPOI = new ApachePOIMethods();
	String xlPath = aPOI.getConfigFilePath();
	String sheetName = aPOI.getSheet_2();
	String date1 = aPOI.getDate_1();
	String date2 = aPOI.getDate_2();
	String serverFile = aPOI.getServerFiles();
	
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickSelect() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Select']")).click();
		Thread.sleep(3000);
	}

	public void clickOK() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(3000);
	}

	public void clickPublishButton() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Publish']")).click();
		Thread.sleep(3000);
	}

	public void clickCancel() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Cancel']")).click();
		Thread.sleep(3000);
	}

	public void clickClose() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Close']")).click();
		Thread.sleep(3000);
	}

	public void clickNo() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='No']")).click();
		Thread.sleep(3000);
	}
	
	public void clickContinue() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		Thread.sleep(3000);
	}
	
	public void clickYes() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Yes']")).click();
		Thread.sleep(3000);
	}


	public void switchFrame() throws InterruptedException {
		Thread.sleep(3000);
		driver.switchTo().frame("jqueryModalDialogsFrame");
		driver.switchTo().frame("scContentIframeId0");
	}

	public void switchFrame3() throws InterruptedException {
		Thread.sleep(3000);
		driver.switchTo().frame("jqueryModalDialogsFrame");
		driver.switchTo().frame("scContentIframeId1");

	}
	
	public void switchFrame5() throws InterruptedException {
		Thread.sleep(3000);
		driver.switchTo().frame("scWebEditRibbon");

	}
	
	public void switchFrame6() throws InterruptedException {
		Thread.sleep(3000);
		driver.switchTo().frame("jqueryModalDialogsFrame");

	}

	public void switchOutOfFrame() {
		driver.switchTo().defaultContent();
	}

	public void expandFolder(String folderName) throws InterruptedException {
		Thread.sleep(3000);
		String v = driver
				.findElement(
						By.xpath("//div[a[span[text()='" + folderName + "']]]//img[@class='scContentTreeNodeGlyph']"))
				.getAttribute("src");

		if (!(v.contains("expanded"))) {
			driver.findElement(
					By.xpath("//div[a[span[text()='" + folderName + "']]]//img[@class='scContentTreeNodeGlyph']"))
					.click();
		}
		Thread.sleep(5000);
	}

	public void selectSubFolder(String subFolderName) throws InterruptedException {
		Thread.sleep(5000);
		try {
			driver.findElement(By.xpath("//span[text()='" + subFolderName + "']")).click();
		} catch (Exception e) {
			driver.findElement(By.xpath("//span[text()='CWA']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[text()='" + subFolderName + "']")).click();
		}
	}

	public void selectSubFolderS1(String s1, String subFolderName) throws InterruptedException {
		System.out.println(s1);
		System.out.println(subFolderName);
		Thread.sleep(5000);
		try {
			driver.findElement(By.xpath("//span[text()='" + s1 + "']")).click();
		} catch (Exception e) {
			driver.findElement(By.xpath("//span[text()='CWA']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[text()='" + subFolderName + "']")).click();
		}
	}

		public void selectSubFolderS4(String text,int index) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[text()='"+text+"'])["+index+"]")).click();		
	}

	public void clickInsert() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Insert']")).click();
		Thread.sleep(3000);
	}

	public void clickSave() throws InterruptedException {
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(3000);
	}

	public void clickSave1() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		Thread.sleep(3000);
	}
	
	public void clickLink(String name) throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='"+name+"']")).click();
		Thread.sleep(3000);
	}

	public void switchWindow() throws InterruptedException {
		Iterator<String> wh = driver.getWindowHandles().iterator();
		Thread.sleep(5000);
		String parent = wh.next();
		String child = wh.next();

		driver.switchTo().window(child);
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println("Title : " + title);
	}

	public void switchWindowChild2() throws InterruptedException {
		Iterator<String> wh = driver.getWindowHandles().iterator();
		Thread.sleep(5000);
		String parent = wh.next();
		String child = wh.next();
		String child1 = wh.next();

		driver.switchTo().window(child1);
		Thread.sleep(5000);
		String title = driver.getTitle();
		System.out.println("Title : " + title);
	}

	public void switchFrame2() throws InterruptedException {
		Thread.sleep(3000);
		driver.switchTo().frame("jqueryModalDialogsFrame");
		driver.switchTo().frame("scContentIframeId1");
	}

	public void switchFrame4() throws InterruptedException {
		Thread.sleep(3000);
		driver.switchTo().frame("scWebEditRibbon");
		//driver.switchTo().frame("scContentIframeId1");
	}

	public void gmailLogin(String userName, String pwd) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id='next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='Passwd']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@id='PersistentCookie']")).click();
		driver.findElement(By.xpath("//input[@id='signIn']")).click();
	}

	public void mail163(String userName, String pwd) throws InterruptedException {
		driver.switchTo().frame("x-URS-iframe");
		driver.findElement(By.xpath(".//*[@name='email']")).sendKeys(userName);
		driver.findElement(By.xpath(".//*[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//a[@id='dologin']")).click();
		driver.switchTo().defaultContent();
	}

	public void clickLogOut() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='gb_7a gbii']")).click();
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();
	}

	public void switchToSpecificChildWindow(String windowTitle) throws InterruptedException {
		Set<String> s = driver.getWindowHandles();
		System.out.println("total no of windows" + s.size());
		Iterator<String> ite = s.iterator();
		int i = 1;
		while (ite.hasNext() && i < 10) {
			String popupHandle = ite.next().toString();
			driver.switchTo().window(popupHandle);
			Thread.sleep(5000);
			if (driver.getTitle().contains(windowTitle))
				break;
			i++;

		}
	}

	public void clickAddDifferentMail() throws Exception {
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath("//a[contains(text(),'Sign in with a different account')]")).click();
			driver.findElement(By.xpath("//a[@id='account-chooser-add-account']")).click();
		} catch (Exception e) {
			driver.findElement(By.xpath("//a[contains(text(),'Add account')]")).click();
		}
	}

	public void switchToNewTab() throws InterruptedException, AWTException {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");

	}

	public void clearBrowserCache() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

	public void logout() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Logout']")).click();
		Thread.sleep(3000);
	}

	public void logout1() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		Thread.sleep(3000);
	}

	public void verifyerrorMessage(String name) throws InterruptedException {
		Thread.sleep(10000);
		try {
			String v = driver.findElement(By.xpath("//div/h1[contains(text(),'" + name + "')]")).getText();
			System.out.println(v);
			if (!(v.contains(name))) {
				Assert.fail("Page Layout not created");
			}

		} catch (Exception e) {
            System.out.println(name);
			String v = driver.findElement(By.xpath("//span[contains(text(),'" + name + "')]")).getText();
			System.out.println(v);
			if (!(v.contains(name))) {
				Assert.fail("Exception");
			}
		}

	}

	public void getText(String text) throws InterruptedException {
		Thread.sleep(5000);
		String v = driver.findElement(By.xpath("//span[text()='" + text + "']")).getText();
		if (!(v.contains(text))) {
			Assert.fail("Edited field not displayed");
		}
	}

	public void getTextInput(String text) throws InterruptedException {
		Thread.sleep(5000);
		String v = driver.findElement(By.xpath("//input[text()='" + text + "']")).getText();
		if (!(v.contains(text))) {
			Assert.fail("Edited field not displayed");
		}
	}

	public void getTextDiv(String text) throws InterruptedException {
		Thread.sleep(5000);
		String v = driver.findElement(By.xpath("//div[text()='" + text + "']")).getText();
		if (!(v.contains(text))) {
			Assert.fail("Edited field not displayed");
		}
	}

	public void getTextLabel(String text) throws InterruptedException {
		Thread.sleep(5000);
		String v = driver.findElement(By.xpath("//label[text()='" + text + "']")).getText();
		if (!(v.contains(text))) {
			Assert.fail("Edited field not displayed");
		}
	}
	
	public void getTextLabelNegative(String text) throws InterruptedException {
		Thread.sleep(5000);
		List<WebElement> v = driver.findElements(By.xpath("//label[contains(text(),'"+text+"')]"));
		int l = v.size();
		if (!(l==0)) {
			Assert.fail("Exception");
		}
		
	}
	
	public void getTextLabelPositive(String text) throws InterruptedException {
		Thread.sleep(5000);
		List<WebElement> v = driver.findElements(By.xpath("//label[contains(text(),'"+text+"')]"));
		int l = v.size();
		if (!(l>=1)) {
			Assert.fail("Exception");
		}
		
	}

	public void getTextValue(String text) throws InterruptedException {
		Thread.sleep(5000);
		String v = driver.findElement(By.xpath("//input[@value='" + text + "']")).getAttribute("value");
		if (!(v.contains(text))) {
			Assert.fail("Edited field not displayed");
		}
	}

	public void getTextSpan(String text) throws InterruptedException {
		Thread.sleep(5000);

		String v = driver.findElement(By.xpath("//span[contains(text(),'" + text + "']")).getText();
		if (!(v.contains(text))) {
			Assert.fail("Edited field not displayed");
		}
	}

	public void rightClickOnElement(String ele) {
		WebElement v = driver.findElement(By.xpath("//span[text()='" + ele + "']"));
		Actions action = new Actions(driver);
		action.contextClick(v).build().perform();
	}

	public void verifyExpEditorUserName(String name) {
		String v = driver.findElement(By.xpath("//div[2]/div/ul/li[2]")).getText();
		System.out.println(v);
		if (!(v.contains(name))) {
			Assert.fail("User Name not displayed");
		}
	}
	
	public void verifyLink(String text) {
		String v = driver.findElement(By.xpath("//a[text()='"+text+"']")).getText();
		System.out.println(v);
		if (!(v.contains("Logout"))) {
			Assert.fail("User Name not displayed");
		}
	}
	
	public void rtClickOnelement(String folderName,String text) {
		  WebElement v = driver.findElement(By.xpath("//span[text()='"+folderName+"']"));
			Actions action = new Actions(driver);
			action.contextClick(v).build().perform();
			
			driver.findElement(By.xpath("//td[text()='"+text+"']")).click();
	}
	
	public void getTitle(String text) {
		String v = driver.getTitle();
		System.out.println(v);
		if(v.contains(text)) {
			Assert.fail("Title is not erased");
		}
	}
	
	public void expandContent() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[a[span[text()='Content']]])[3]//img[@class='scContentTreeNodeGlyph']")).click();
	}
	
	public void getAttributeValue(String text) {
		String v = driver.findElement(By.xpath("//input[@type='Submit']")).getAttribute("value");
		if(v.contains(text)) {
			Assert.fail("Title is not erased");
		}
	}
	
	public void verifyFrontEndFieldsNegative(String text, String editText) {
		System.out.println(editText);
	 WebElement v = driver.findElement(By.xpath("//div[div[input[@id='"+text+"']]]//label[contains(@class,'control-label')]"));
	String v1 = v.getText();
	System.out.println(v1);
		if((v1.contains(editText))) {
			Assert.fail("Title is not erased");
		}
	}
	
	public void verifyFrontEndFieldsPositive(String text, String editText) {
		System.out.println(editText);
	 WebElement v = driver.findElement(By.xpath("//div[div[input[@id='"+text+"']]]//label[contains(@class,'control-label')]"));
	String v1 = v.getText();
	System.out.println(v1);
		if(!(v1.contains(editText))) {
			Assert.fail("Title is not erased");
		}
	}
	
	public void checkBox(int index) {
		 WebElement v = driver.findElement(By.xpath("(//input[@type='checkbox'])["+index+"]"));
	  	 boolean v1 = v.isSelected();
	  	 if(!v1) {
	  		 v.click();
	  	 }
	}
	
	public void checkBoxNegative(int index) {
		 WebElement v = driver.findElement(By.xpath("(//input[@type='checkbox'])["+index+"]"));
	  	 boolean v1 = v.isSelected();
	  	 if(v1) {
	  		 v.click();
	  	 }
	}
	public void clickOK1() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//button[text()='OK']")).click();
		Thread.sleep(3000);
	}


	public void clickRepublish() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='Republish']")).click();
		Thread.sleep(3000);
	}

	public void clickIncrementalPublish() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='IncrementalPublish']")).click();
		Thread.sleep(3000);
	}

	public void checkRelatedItem() throws InterruptedException {
		Thread.sleep(3000);
		WebElement e1 = driver.findElement(By.xpath("//input[@id='PublishRelatedItems']"));
		if (!e1.isSelected()) {
			e1.click();
		}
	}

	public void unCheckRelatedItem() throws InterruptedException {
		Thread.sleep(3000);
		WebElement e1 = driver.findElement(By.xpath("//input[@id='PublishRelatedItems']"));
		if ((e1.isSelected())) {
			e1.click();

		}
		Thread.sleep(3000);
	}

	public void checkSubItem() throws InterruptedException {
		Thread.sleep(3000);
		WebElement e1 = driver.findElement(By.xpath("//input[@id='PublishChildren']"));
		if (!(e1.isSelected())) {
			e1.click();
		}
		Thread.sleep(3000);
	}

	public void unCheckSubItem() throws InterruptedException {
		Thread.sleep(3000);
		WebElement e1 = driver.findElement(By.xpath("//input[@id='PublishChildren']"));
		if ((e1.getAttribute("checked").contains("checked")))
			e1.click();
		Thread.sleep(3000);
	}

	public void clickFolderInternalLink(String fol) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div/a/span[text()='" + fol + "']")).click();
	}

	public void expandFolderInternalLink(String fol) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//div[a[span[text()='" + fol + "']]]/img[contains(@class,'scContentTreeNodeGlyph')]"))
				.click();
	}

	public void expandFolder1(String folderName, int i) throws InterruptedException {
		Thread.sleep(3000);
		String v = driver.findElement(By.xpath(
				"(//div[a[span[text()='" + folderName + "']]]//img[@class='scContentTreeNodeGlyph'])[" + i + "]"))
				.getAttribute("src");

		if (!(v.contains("expanded"))) {

			driver.findElement(By.xpath(
					"(//div[a[span[text()='" + folderName + "']]]//img[@class='scContentTreeNodeGlyph'])[" + i + "]"))
					.click();
		}
		Thread.sleep(5000);
	}

	public void verifyAlertErrorMessage(String name) throws InterruptedException {
		Thread.sleep(10000);

		String v = driver.switchTo().alert().getText();
		System.out.println(v);
		if (!((v.contains(name)))) {
			Assert.fail("Page Layout not created");
		}
		driver.switchTo().alert().accept();

	}
	public void inputText(String ip, String val) throws InterruptedException {
		Thread.sleep(5000);

		driver.findElement(By.xpath(".//input[@id='" + ip + "']")).sendKeys(val);
	}

	//Princy 7th march

	public void doubleClick2(String userID) throws InterruptedException {
		WebElement v = driver.findElement(By.xpath("(//span[text()='" + userID + "'])[2]"));
		Actions action = new Actions(driver);
		action.doubleClick(v).build().perform();
	}

	public void doubleClick1(String userID) throws InterruptedException {
		WebElement v = driver.findElement(By.xpath("(//span[text()='" + userID + "'])"));
		Actions action = new Actions(driver);
		action.doubleClick(v).build().perform();
	}

	public void singleClick1(String userID) throws InterruptedException {
		driver.findElement(By.xpath("(//span[text()='" + userID + "'])")).click();

	}

//Princy 8 march
	public void clickSmartPublish() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='SmartPublish']")).click();
		Thread.sleep(3000);
	}
	public String getInputValue(String id){
		String val=driver.findElement(By.xpath("//div/input[@id='"+id+"]")).getAttribute("value").toString();
		return val;
	}//Princy 30th march 2017
	public void expandFolderImg(String folderName) throws InterruptedException {
		Thread.sleep(3000);
		String v = driver.findElement(By.xpath(
				"//div[div[text()='" + folderName + "']]/img[contains(@src,'tree')]"))
				.getAttribute("src");

		if (!(v.contains("expanded"))) {

			driver.findElement(By.xpath(
					"//div[div[text()='" + folderName + "']]/img[contains(@src,'tree')]"))
							.click();
		}
		Thread.sleep(5000);
	}
	public void clickInputButton(String val){
		driver.findElement(By.xpath("//input[@type='button' and @value='"+val+"']")).click();
	}
public void clickDropDownImg(){
	driver.findElement(By.xpath("(//tr//tr[*//*[text()='Background Image']])//tr//img[contains(@src,'ribbondropdown')]")).click();		

}

public void getAttributeValueLabel(String text) {
	 List<WebElement> v = driver.findElements(By.xpath("//label[text()='"+text+"']"));
	if(!(v.size()==0)) {
		Assert.fail("Values not saved in Experience editor!");
	}
}//Princy 16th april 2017
public void expandFolderInternalLink1(String fol,int index) throws InterruptedException {
	Thread.sleep(5000);
	driver.findElement(
			By.xpath("(//div[a[span[text()='" + fol + "']]]/img[contains(@class,'scContentTreeNodeGlyph')])["+index+"]"))
			.click();
}
//Princy 17 april
public void verifyLabelText(String txt){
	String txt1=driver.findElement(By.xpath("//label[contains(text(),'"+txt+"')]")).getText();
	if(!(txt1.contains(txt))){
		Assert.fail("label not present");
	}
}
public void verifyButtonText(String txt){
	String txt1=driver.findElement(By.xpath("//button[contains(text(),'"+txt+"')]")).getText();
	if(!(txt1.contains(txt))){
		Assert.fail("button not present");
	}
}
//Princy 25th april 2017
public void getTitlePositive(String text) {
	String v = driver.getTitle();
	System.out.println(v);
	if(!(v.contains(text))) {
		Assert.fail("Title is not erased");
	}
}

public void clickOK_01() throws InterruptedException {
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@value='OK']")).click();
	Thread.sleep(3000);
}
}
