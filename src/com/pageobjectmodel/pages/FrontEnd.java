package com.pageobjectmodel.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FrontEnd extends BasePage {
	public FrontEnd(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyUsernameLabelNegative(String text) {
		String v = driver.findElement(By.xpath("//div[div[input[@id='UserName']]]//label[@class='control-label']"))
				.getText();
		System.out.println(text);
		System.out.println(v);
		if ((v.contains(text))) {
			Assert.fail("Exception");
		}
	}

	public void verifyUsernameLabelPositive(String text) {
		System.out.println(text);

		String v = driver.findElement(By.xpath("//div[div[input[@id='UserName']]]//label[@class='control-label']"))
				.getText();
		System.out.println(v);
		if (!((v.contains(text)))) {
			Assert.fail("Exception");
		}
	}

	public void verifyFPUsernameLabelPositive(String text) {
		System.out.println(text);

		String v = driver.findElement(By.xpath("//div[div[input[@id='txtUsername']]]//label[@class='control-label']"))
				.getText();
		System.out.println(v);
		if (!((v.contains(text)))) {
			Assert.fail("Exception");
		}
	}

	public void verifyLinkContent(String iid, String hre) {
		String v = driver.findElement(By.xpath("//a[text()='" + iid + "']")).getAttribute("href");
		System.out.println(iid);
		System.out.println(v);
		if (!((v.contains(hre)))) {
			Assert.fail("Exception");
		}
	}

	public void verifyLinkRedirection(String ExpectedUrl) {
		String v = driver.getCurrentUrl();
		if (!((v.contains(ExpectedUrl)))) {
			Assert.fail("Exception");
		}
	}

	public void verifyPasswordLabelPositive(String text) {
		String v = driver.findElement(By.xpath("//div[div[input[@id='Password']]]//label[@class='control-label']"))
				.getText();
		System.out.println(text);
		System.out.println(v);
		if (!((v.contains(text)))) {
			Assert.fail("Exception");
		}
	}

	public void verifyPasswordLabelNegative(String text) {
		String v = driver.findElement(By.xpath("//div[div[input[@id='Password']]]//label[@class='control-label']"))
				.getText();
		System.out.println(text);
		System.out.println(v);
		if ((v.contains(text))) {
			Assert.fail("Exception");
		}
	}

	public void verifyLoginButtonTextPositive(String val) {

		String v = driver.findElement(By.xpath("//input[@id='Backend_LoginBtn']")).getAttribute("value");
		System.out.println(val);
		System.out.println(v);
		if (!((v.contains(val)))) {
			Assert.fail("Exception");
		}
	}

	public boolean verifyTitleText(String val) {
		boolean res = true;
		String v = driver.findElement(By.xpath("//title")).getText();
		System.out.println(val);
		System.out.println(v);
		if ((v.contains(val))) {
			res = false;
		}
		return res;
	}

	public void verifyBlankTitle() {

		String blnk = " | RFWFV2";
		String m = driver.findElement(By.xpath("//title[text()=' | RFWFV2']")).getText();

		if (!(m.equals(blnk))) {
			Assert.fail("Exception");

		}
	}

	public void verifyRememberCheckTextPositive(String val) {
		String v = driver.findElement(By.xpath(".//span[@class='rfwf-rememberUsername_span']")).getText();
		System.out.println(val);
		System.out.println(v);
		if (!((v.contains(val)))) {
			Assert.fail("Exception");

		}
	}

	public void verifyFrontEndServerError() {

		driver.findElement(By.xpath("//*[text()='Server Error']"));
	}

	public void verifyNoFrontEndServerError() {
		if ((driver.getPageSource().contains("Server Error"))) {
			Assert.fail("Exception");
		}

	}

	public void verifyLoginComponents(String pwd) {

		String chk = driver.findElement(By.xpath("//div[div[input[@id='Password']]]")).getAttribute("id").toString();
		if (!(chk.contains(pwd))) {
			Assert.fail("Exception");

		}
	}
	// Princy 8march

	public void verifyFPUsernameLabelNegative(String text) {
		System.out.println(text);

		String v = driver.findElement(By.xpath("//div[div[input[@id='txtUsername']]]//label[@class='control-label']"))
				.getText();
		System.out.println(v);
		if ((v.contains(text))) {
			Assert.fail("Exception");
		}
	}

	// Princy 9th march
	public void verifyFPComponents(String sub, String msg) {

		String chk = driver.findElement(By.xpath("//div/div/input[@id='txtUsername']")).getText();
		String submit = driver.findElement(By.xpath("//input[@type='submit']")).getAttribute("value").toString();
		//String msg1 = driver.findElement(By.xpath("")).getText();

		if (!(chk.equals(""))) {
			Assert.fail("Exception");

		}
		if (!(submit.equals(sub))) {
			Assert.fail("Exception");

		}
		/*if (!(msg1.equals(msg))) {
			Assert.fail("Exception");

		}*/

	}

	public void EnterFPUserName(String name) {

		driver.findElement(By.xpath("//div/div/input[@id='txtUsername']")).sendKeys(name);

	}

	public void clickFpSubmit() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	public void AlertUserMsg(String msg) {

		String v = driver.findElement(By.xpath("//div[@id='alertMsg']")).getText();
		System.out.println(v);
		if (!((v.contains(msg)))) {
			Assert.fail("Message doesn't match");
		}
	}

	// Princy 10th march
	public void EnterRegTextBox(String path1, String data) {

		driver.findElement(By.xpath(".//input[@id='txt" + path1 + "']")).sendKeys(data);

	}

	public void SelectDropDown(String name, String value) throws InterruptedException {

		WebElement vc = driver.findElement(By.xpath(".//select[@name='" + name + "']"));
		Select s = new Select(vc);
		s.selectByVisibleText(value);
	}

	public void FillRegistrationForm(String reguser,String newPswd,String Fname,String Lname,String gmailLog,String compName,String jobTitle,String
			phn,String city,String state,String cntry,String postalcde,String q1,String a1,String q2,String a2,String q3,String a3) throws InterruptedException {

		EnterRegTextBox("Username", reguser);
		// password
		EnterRegTextBox("NewPassword", newPswd);
		// confirm password
		EnterRegTextBox("ConfirmationPassword", newPswd);
		// First name
		EnterRegTextBox("FirstName", Fname);
		// Last name
		EnterRegTextBox("LastName", Lname);
		// Email
		EnterRegTextBox("NewEmail", gmailLog);

		EnterRegTextBox("ConfirmEmail",gmailLog);
/*
		// company
		EnterRegTextBox("CompanyName", compName);
		// job title
		EnterRegTextBox("JobTitle", jobTitle);
		// phone
		EnterRegTextBox("WorkPhoneNo", phn);
		// city
		EnterRegTextBox("City", city);
		// state
		EnterRegTextBox("State", state);
	*/	// country
		SelectDropDown("Country", cntry);

		EnterRegTextBox("PostalCode",postalcde);

		SelectDropDown("SelectQuestion1", q1);
		EnterRegTextBox("Answer1", a1);
		EnterRegTextBox("ConfirmAnswer1", a1);

		SelectDropDown("SelectQuestion2", q2);
		EnterRegTextBox("Answer2", a2);
		EnterRegTextBox("ConfirmAnswer2", a2);

		SelectDropDown("SelectQuestion3", q3);
		EnterRegTextBox("Answer3", a3);
		EnterRegTextBox("ConfirmAnswer3", a3);
		Thread.sleep(50000);
		driver.findElement(By.xpath(".//*[@id='PrivacyAgree']")).click();
		driver.findElement(By.xpath(".//*[@id='btnRegisteration']")).click();

	}
	
	//Princy 14th march
public void FillrecoverPassword(String q1,String q2,String q3,String a1,String a2,String a3,String pswd1,String pswd2) throws InterruptedException{
	String v=driver.findElement(By.xpath("//input[@id='Question']")).getAttribute("value").toString();
	String answer="";
if(v.equals(q1)){
	answer=a1;
}
if(v.equals(q2)){
	answer=a2;
}
if(v.equals(q3)){
	answer=a3;
}

EnterRegTextBox("Answer",answer);
EnterRegTextBox("NewPassword",pswd1);
EnterRegTextBox("ConfirmationPassword",pswd2);

}
public void confirmSecurityQuestion(String q1,String q2,String q3,String a1,String a2,String a3){
	System.out.println("in neutral condition");

	String v=driver.findElement(By.xpath("//input[@id='Question']")).getAttribute("value").toString();
if(!(((v.equals(q1))||((v.equals(q2))||((v.equals(q3))))))){
	System.out.println("in negative condition");
	Assert.fail();
}
}
public void clickSubmitButton(String val){
	driver.findElement(By.xpath("//input[@type='submit' and @value='"+val+"']")).click();

}
public void verifyPasswordRecoveryOptionText(String optionPath,String Answertext){
	String v=driver.findElement(By.xpath("//*[contains(text(),'"+optionPath+"')]")).getText();
	String v1=driver.findElement(By.xpath("//div[div[*[contains(text(),'"+optionPath+"')]]]//div[contains(text(),'"+Answertext+"')]")).getText();
	if(!(v.contains(optionPath)))
	{
		Assert.fail();
	}	
	if(!(v1.contains(Answertext)))
	{
		Assert.fail();
	}	
	
}
public void verifySecurityLabels(String securityQ,String ans,String psd,String cnfrmPsd){
	
String v1=	driver.findElement(By.xpath("//label[contains(text(),'"+securityQ+"')]")).getText();
String v2=driver.findElement(By.xpath("//label[contains(text(),'"+ans+"')]")).getText();
String v3=driver.findElement(By.xpath("//label[contains(text(),'"+psd+"')]")).getText();
	
String v4=driver.findElement(By.xpath("//label[contains(text(),'"+cnfrmPsd+"')]")).getText();
if(!(v1.contains(securityQ)))
{
	Assert.fail();
}	
if(!(v2.contains(ans)))
{
	Assert.fail();
}	
if(!(v3.contains(psd)))
{
	Assert.fail();
}	
if(!(v4.contains(cnfrmPsd)))
{
	Assert.fail();
}	

}
public void clickLoginButton(){
	driver.findElement(By.xpath("//input[@id='Backend_LoginBtn']")).click();
	
}
public void click_ImgIcon(String p1){
	driver.findElement(By.xpath("//img[contains(@src,'"+p1+"')]")).click();
}
public void verifyQuestionPop(String id){
	String v=driver.findElement(By.xpath("//div[@id='"+id+"']")).getAttribute("id").toString();
if(!(v.equals(id))){
	Assert.fail();
	
}
}//princy 16 march
public void verifySccessfullEmailMsg(String m){
	String v=driver.findElement(By.xpath("//div[contains(text(),'"+m+"')]")).getText();
if(!(v.contains(m))){
	Assert.fail();
}

}
//Princy 18 march
public void verifyDivErrorMsg(String txt){
String v=driver.findElement(By.xpath("//div[contains(text(),'"+txt+"')]")).getText();
	if(!(v.contains(txt))){
		Assert.fail();
	}
}//Princy 20th march

public void verifyInputText(String id,String val){
	
	String v=driver.findElement(By.xpath("//div[div[input[@id='"+id+"']]]")).getAttribute("value").toString();
	if(!(v.contains(val))){
		Assert.fail();
	}
}
//Princy 21 march
public void verifyAPUsernameLabelPositive(String text) {
	System.out.println(text);

	String v = driver.findElement(By.xpath("//div[div[input[@id='txtUsername2']]]//label[@class='control-label']"))
			.getText();
	System.out.println(v);
	if (!((v.contains(text)))) {
		Assert.fail("Exception");
	}
}
public void verifySubmitButtonPositive(String id){
	String v1=driver.findElement(By.xpath("//input[@type='submit' and @value='"+id+"']")).getAttribute("id").toString();
	if(!((v1.contains(id))))
	{
		Assert.fail();
	}
}//Princy modified 28th march 2017
public void verifyHeading(String heading){
	String h=driver.findElement(By.xpath("//div//*[contains(text(),'"+heading+"')]")).getText();
if(!(h.contains(heading))){
	Assert.fail();
}
}
//Princy 24th march 2017
public void verifyFUEmailLabelPositive(String text) {
	System.out.println(text);

	String v = driver.findElement(By.xpath("//div[div[*[@id='txtNewEmail']]]//label[@class='control-label']"))
			.getText();
	System.out.println(v);
	if (!((v.contains(text)))) {
		Assert.fail("Exception");
	}
}
public void verifyCUStreetLabelPositive(String text) {
	System.out.println(text);

	String v = driver.findElement(By.xpath("//div[div[*[@id='txtStreet']]]//label[@class='control-label']"))
			.getText();
	System.out.println(v);
	if (!((v.contains(text)))) {
		Assert.fail("Element not found");
	}
}
//Princy 30 march
public void verifyBackToTopImg(String id){
	String v1=driver.findElement(By.xpath("//div[contains(@style,'"+id+"')]")).getAttribute("style").toString();
	if(!((v1.contains(id))))
	{
		Assert.fail("Image is not present");
	}
}//Princy 31 march
public void CheckValidationField(String id){
	Actions act1=new Actions(driver);
	act1.moveToElement(driver.findElement(By.xpath("//input[@id='"+id+"']")));
	String m=driver.findElement(By.xpath("//input[@id='"+id+"']")).getAttribute("validationMessage");
	System.out.println(m);

}//Princy 4th april
public void verifyLabelPositive(String pth,String text) {
	System.out.println(text);

	String v = driver.findElement(By.xpath("//div[div[*[@id='"+pth+"']]]//label[@class='control-label']"))
			.getText();
	System.out.println(v);
	if (!((v.contains(text)))) {
		Assert.fail("Exception");
	}
}
//Princy 5th april 2017
public void verifyReadOnly(String id) {
	String v = driver.findElement(By.xpath(".//*[@id='"+id+"']")).getAttribute("readonly").toString();
	System.out.println(v);
	if (!((v.contains("true")))) {
		Assert.fail("Exception");
	}
}
public void verifyDisabledButton(String val) {
	String v = driver.findElement(By.xpath(".//*[@value='"+val+"']")).getAttribute("disabled").toString();
	System.out.println(v);
	if (!((v.contains("disabled")))) {
		Assert.fail("Exception");
	}
}
public void clickSubmitButton1(String val){
	driver.findElement(By.xpath("//input[@value='"+val+"']")).click();

}


public void verifyFrontEndCreationREG_Negative() throws InterruptedException {
	List<WebElement> v = driver.findElements(By.xpath("//h1[contains(text(),' Register')]"));
	if (!(v.size() == 0)) {
		Assert.fail("Page Layout Created");
	}
}


public void verifyFrontEndCreation_Negative() throws InterruptedException {
		List<WebElement> v = driver.findElements(By.xpath("//h1[contains(text(),' Activate User')]"));
        if(!(v.size()==0)) {
        	Assert.fail("Page Layout Created");
        }
	}

public void verifyReadOnly1(String id,int index) {
	String v = driver.findElement(By.xpath("(.//*[@id='"+id+"'])["+index+"]")).getAttribute("readonly").toString();
	System.out.println(v);
	if (!((v.contains("true")))) {
		Assert.fail("Exception");
	}
}

public void verifyLinkText(String val) {
	String v = driver.findElement(By.xpath("//a[contains(text(),'"+val+"')]")).getText();
	System.out.println(v);
	if (!((v.contains(val)))) {
		Assert.fail("Exception");
	}
}

public void verifyInputText1(String id,String val){
	
	String v=driver.findElement(By.xpath("//input[@id='"+id+"']")).getAttribute("value").toString();
	if(!(v.contains(val))){
		Assert.fail();
	}

}

}
