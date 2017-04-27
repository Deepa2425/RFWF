package com.pageobjectmodel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ExperienceEditor extends BasePage {

	public ExperienceEditor(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}


	public void verifyUserNameLabelNegative(String text) {
		String UNlabel=	driver.findElement(By.xpath("//div[div[input[@id='txtUsername']]]/label")).getText();
		if(!(UNlabel.equals(text))){
		}else{
			Assert.fail("editing changed");

	}}
	public void verifyTitleText(String val){
		String	v = driver.findElement(By.xpath("/html/head/title")).getText();
		
		System.out.println(val);
		System.out.println(v);
		if (!((v.contains(val)))) {
			Assert.fail("editing changed");
		}
	}
	public void verifyBlankTitle(){
		
		String val=" | RFWFV2";
		String	v = driver.findElement(By.xpath("//title")).getText();
		System.out.println(v);
		if (!((v.equals(val)))) {
			Assert.fail("editing changed");
		}
	}

	public void verifyUserNameLabelPositive(String text) {
		String UNlabel=	driver.findElement(By.xpath("//div[div[input[@id='txtUsername']]]/label")).getText();
		if(!((UNlabel.equals(text)))){
			Assert.fail("editing not changed");
		}
	}
	public void verifyForgotPasswordAssociate(String text) {
	 String v = driver.findElement(By.xpath("//h1[contains(text(),'Forgot Password')]")).getText();
	 if(!((v.equals(text)))){
			Assert.fail("Layout not created!");
		}  	    	
		
	}//Princy 15th march
	public void verifyEditorAssociate(String text) {
		 String v = driver.findElement(By.xpath("//h1[contains(text(),'"+text+"')]")).getText();
		 if(!((v.equals(text)))){
				Assert.fail("Layout not created!");
			}  	    	
			
		}
	public void verifyLoginUserNameLabelPositive(String text) {
		String UNlabel=	driver.findElement(By.xpath("//div[div[input[@id='UserName']]]/label")).getText();
		if(!((UNlabel.equals(text)))){
			Assert.fail("editing not changed");
		}
	}
	//Princy 24 march
		public void verifyLabelNamePositive(String lbl,String txt){
			String UNlabel=	driver.findElement(By.xpath("//div[div[*[@id='"+lbl+"']]]/label")).getText();
			if(!((UNlabel.equals(txt)))){
				Assert.fail("editing not changed");
			}
		}
//Princy 30 march 2017
		public void clickDivImg(String txt){
			driver.findElement(By.xpath("//div[contains(text(),'"+txt+"')]/img[contains(@alt,'"+txt+"')]")).click();
		}
		public void verifyLoginStatus(String name){
			String txt=driver.findElement(By.xpath("//div[@class='score-center']//div[contains(text(),'Welcome')]")).getText();
			if(!(txt.contains(name))){
				Assert.fail("login status is not displayed");
			}
		}
		public void verifyLoginLink(String name){
			String txt=driver.findElement(By.xpath("//div[@class='score-center']//a[contains(text(),'"+name+"')]")).getText();
			if(!(txt.contains(name))){
				Assert.fail("login link is not displayed");
			}
		}
		//Princy 17 april 2017
public void verifyTitleText1(String val){
	String	v =driver.getTitle();
	System.out.println(val);
	System.out.println(v);
	if (!((v.contains(val)))) {
		Assert.fail("editing not changed");
	}
}//Princy 18th april 2017
public void selectControlPropertiesDrop(String txt,String value){
	WebElement vc = driver.findElement(By.xpath("//td[div[contains(text(),'"+txt+"')]]//select"));
	Select s = new Select(vc);
	s.selectByVisibleText(value);

}
public void InputControlPropertiesText(String txt,String value){
	WebElement vc = driver.findElement(By.xpath("//td[div[contains(text(),'"+txt+"')]]//input"));
	vc.clear();
	vc.sendKeys(value);
}
public void CheckControlPropertiesBox(String txt){
	WebElement vc = driver.findElement(By.xpath("//td[div[contains(text(),'"+txt+"')]]//input[@type='checkbox']"));
vc.click();
}
//Princy 18 april
public void verifySpanTextInCaptionClass(String txt){
	System.out.println(txt);

	String txt1=driver.findElement(By.xpath("//div[@class='caption']//span[contains(text(),'"+txt+"')]")).getText();
	System.out.println(txt1);
	if(!(txt1.contains(txt))){
		Assert.fail("text not present");
	}
}
//Princy 26th april 2017
public void clickImageIcon(){
	driver.findElement(By.xpath("//img[@class='scEmptyImage scEnabledChrome']")).click();

}
public void chooseImageOperation(String imgtxt,int imgindex) throws InterruptedException{
	WebElement e1=driver.findElement(By.xpath("(//div[@class='scChromeControls'])[2]"));
	System.out.println("entering img");
	Thread.sleep(5000);
	
	e1.findElement(By.xpath("(//img[@alt='"+imgtxt+"'])["+imgindex+"]")).click();
	System.out.println("after img");

}
public String choosehighlightImge(String txt,int imgindex){
WebElement m=driver.findElement(By.xpath("//section[@class='sc-dialogContent-main']"));
	 System.out.println("element chosen");

	 	
	 m.findElement(
	 		By.xpath("(//div[div[@class='sc-iconList-item-title'][span[text()='"+txt+"']]])["+imgindex+"]/a/img")).click();
	 		
	 String src =m
				.findElement(
						By.xpath("(//div[div[@class='sc-iconList-item-title'][span[text()='cover']]])[1]/a/img"))
				.getAttribute("src").toString();
		return src;
}
public void clickFooterSelect() throws InterruptedException{
WebElement bt=driver.findElement(By.xpath("//footer"));
	bt.findElement(By.xpath("//footer//button/span[text()='Select']")).click();
	Thread.sleep(5000);

}
public void clickCaptionArea(int index){
	driver.findElement(By.xpath("(//div[@class='caption'])["+index+"]/div[2]")).click();

}
public void clickHighlightButton(int index){
	driver.findElement(By.xpath("(//div[contains(@class,'button')])["+index+"]/span[2]")).click();

}
public void chooseDestinationOption(String opt ) throws InterruptedException{
	WebElement e12=driver.findElement(By.xpath("//div[@class='left-column']"));
	 System.out.println("entering img");
	 Thread.sleep(5000);

	 e12.findElement(By.xpath("//div[text()='"+opt+"']")).click();

}
public void editHighlightheading(int cnt,String txt){
	int m=cnt*2;
	WebElement v1=	driver.findElement(By.xpath("(//h2/span)["+m+"]"));
	System.out.println("found v1");

Actions action = new Actions(driver);
action.doubleClick(v1).build().perform();
System.out.println("double click");

v1.clear();
System.out.println("clear image");

v1.sendKeys(txt);

}
public void editHighlightDesc(int i,String txt){
	WebElement v2=	driver.findElement(By.xpath("(//div[h2[span]]/div/span[@scdefaulttext='[No text in field]'])["+i+"]"));
	System.out.println("found v1");

	Actions action2 = new Actions(driver);
	action2.doubleClick(v2).build().perform();
	System.out.println("double click");

	v2.sendKeys("");
	System.out.println("clear image");

	v2.sendKeys(txt);

}
public void verifyImageSrc(String img1){
	String match = "jpg";
    
	  int index = img1.indexOf(match);
	       
	  index=index+2;
	      
	  System.out.println(index);
	   
	  String finalstring=img1.substring(0,index);

	String ans=driver.findElement(By.xpath("//img[contains(@src,'" + finalstring + "')]")).getAttribute("src");
if(!(ans.contains(finalstring))){
	Assert.fail("image noty found");
}
}
}
