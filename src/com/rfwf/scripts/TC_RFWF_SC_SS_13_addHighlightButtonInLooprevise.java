package com.rfwf.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.ExperienceEditor;
import com.pageobjectmodel.pages.ForgotPassword;
import com.pageobjectmodel.pages.FrontEnd;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;
import com.pageobjectmodel.pages.PageLayout;

public class TC_RFWF_SC_SS_13_addHighlightButtonInLooprevise extends BaseTestNGPageSiteCoreV2 {
	@Test(priority = 1)
	public void textTC_RFWF_SS_13_addHighlightButtonInLoop() throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		PageLayout pL = new PageLayout(driver);
		FrontEnd fE = new FrontEnd(driver);
		ForgotPassword fP = new ForgotPassword(driver);
		ExperienceEditor eE = new ExperienceEditor(driver);

		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_4();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
		String sheetName1 = aPOI.getSheet_2();
		boolean b = false;

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 3125, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 3126, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 3127, 2);

		String secure = g.getExcelCellValue(xlPath, sheetName, 3128, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 3129, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 3130, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 3131, 2);
		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 3132, 2);

		try {
			hP.clickOnContentEditor();
			cE.clickOnTenant(tenantName);

			cE.rtClickOnAndInsert(subElement);
			iFT.switchFrame();
			iFT.expandFolder(folderNameToSelect);
			iFT.selectSubFolder(subFolder);
			iFT.createTemplate(folderNameToCreate);
			iFT.clickInsert();
			System.out.println("folder created");
			Thread.sleep(5000);
			iFT.switchOutOfFrame();

			cE.rtClickOnAndInsert(folderNameToCreate);
			iFT.switchFrame();
			iFT.expandRfwPresencePagesSelectSecure();
			iFT.selectSubFolder(secure);
			System.out.println("page selected");

			iFT.createTemplate(templateName);
			iFT.clickInsert();
			System.out.println("page created");

			iFT.switchOutOfFrame();
			cE.clickPublishAndExperienceEditor();
			Thread.sleep(40000);
			cE.switchWindow();

			pL.clickPageLayout();
			iFT.switchFrame();

			iFT.selectSubFolder(pageLayout);
			pL.selectPageLayout(5);
			pL.clickSelect();
			iFT.switchOutOfFrame();

			pL.clickPageLayout();
			iFT.switchFrame();
			iFT.selectSubFolder("Collections");
			iFT.selectSubFolder("Slick Slider");
			pL.clickSelect();
			iFT.switchOutOfFrame();
			Thread.sleep(10000);

			cE.switchFrame();

			eE.selectControlPropertiesDrop("Carousel Speed", "Medium");
			eE.selectControlPropertiesDrop("Slider Style", "Default Slider");
			eE.selectControlPropertiesDrop("Transition Speed", "Medium");
			eE.InputControlPropertiesText("Items to Scroll", "3");
			eE.CheckControlPropertiesBox("Vertical Display");
			eE.clickInputButton("OK");

			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();
			Thread.sleep(10000);

			pL.clickPageLayout();
			iFT.switchFrame();
			iFT.selectSubFolder("Slick Slider Item");
			pL.clickSelect();
			iFT.switchOutOfFrame();
			pL.clickPageLayout();
			int k=9;
			WebElement m;
			WebElement bt;
			WebElement e11;
			String img1="";
			WebElement e12;
			//loop start
			for(int i=1;i<7;i++){
			iFT.switchFrame();
			iFT.selectSubFolder("Features");
			iFT.selectSubFolder("HighLight");
			pL.clickSelect();
			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();
			iFT.switchFrame();
			pL.clickCreateNewContent();
			pL.clickOK();

			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//img[@class='scEmptyImage scEnabledChrome']")).click();
			System.out.println("entering block");
			WebElement e1=driver.findElement(By.xpath("(//div[@class='scChromeControls'])[2]"));
			System.out.println("entering img");
			Thread.sleep(5000);
			
			e1.findElement(By.xpath("(//img[@alt='Choose an image.'])[2]")).click();
			System.out.println("after img");
		iFT.switchFrame();
			System.out.println("frame chosen");
			Thread.sleep(10000);
 m=driver.findElement(By.xpath("//section[@class='sc-dialogContent-main']"));
System.out.println("element chosen");

	
m.findElement(
		By.xpath("(//div[div[@class='sc-iconList-item-title'][span[text()='cover']]])[1]/a/img")).click();
		
System.out.println("pic found");

			 img1 =m
					.findElement(
							By.xpath("(//div[div[@class='sc-iconList-item-title'][span[text()='cover']]])[1]/a/img"))
					.getAttribute("src").toString();
			System.out.println(img1);
			Thread.sleep(3000);
			 bt=driver.findElement(By.xpath("//footer"));
			bt.findElement(By.xpath("//footer//button/span[text()='Select']")).click();
			Thread.sleep(5000);
			System.out.println("finding image");
			iFT.switchOutOfFrame();
			
//driver.findElement(By.xpath("//img[contains(@src,'"+img1+"')]"));
//System.out.println("found image");
	driver.findElement(By.xpath("(//div[@class='caption'])["+i+"]/div[2]")).click();
	System.out.println("clicked on blank");

	Thread.sleep(10000);
	pL.clickAddHere(1);
	cE.switchFrame();
iFT.selectSubFolder("Button");
pL.clickSelect();
iFT.switchOutOfFrame();
iFT.switchOutOfFrame();
iFT.switchFrame();
pL.clickCreateNewContent();
pL.clickOK();
Thread.sleep(5000);

//needs change
driver.findElement(By.xpath("(//div[contains(@class,'button')])["+i+"]/span[2]")).click();
 e11=driver.findElement(By.xpath("(//div[@class='scChromeControls'])[2]"));
System.out.println("entering img");
Thread.sleep(5000);

e11.findElement(By.xpath("(//img[@alt='Edits the link destination and appearance'])[2]")).click();

iFT.switchFrame();

 e12=driver.findElement(By.xpath("//div[@class='left-column']"));
System.out.println("entering img");
Thread.sleep(5000);

e12.findElement(By.xpath("//div[text()='Internal Link']")).click();

eE.expandFolderInternalLink("RfwfPresence");
eE.clickFolderInternalLink("home");
eE.clickOK();
iFT.switchOutOfFrame();

iFT.switchFrame5();
System.out.println("adding new ");
pL.clickAddComponent();
System.out.println("added new ");

iFT.switchOutOfFrame();
pL.clickAddHere(k);
System.out.println(k);

k=9+i;
System.out.println("loop new ");

			}
// done
pL.clickOnSave();
iFT.switchOutOfFrame();
driver.close();
cE.switchBackTpParentWindow();
cE.logout();

			b = true;
			g.setExcelCellValue(xlPath, sheetName, 3125, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 3125, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 3125, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 3125, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 3125, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 3125, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 3125, 5, screenShot + v + "_" + date1);

			}
		}
	}

}
