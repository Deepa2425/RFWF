package com.rfwf.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
import com.pageobjectmodel.pages.Login;
import com.pageobjectmodel.pages.PageLayout;

public class TC_RFWF_SC_SS_26_EditAndPublishSite extends BaseTestNGPageSiteCoreV2 {
	@Test(priority = 1)
	public void textTC_RFWF_SC_SS_26_EditAndPublishSite() throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		PageLayout pL = new PageLayout(driver);
		FrontEnd fE = new FrontEnd(driver);
		ForgotPassword fP = new ForgotPassword(driver);
		ExperienceEditor eE = new ExperienceEditor(driver);
		Login l = new Login(driver);


		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_4();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
		String sheetName1 = aPOI.getSheet_2();
		boolean b = false;

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 3146, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 3147, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 3148, 2);
		
		String secure = g.getExcelCellValue(xlPath, sheetName, 3149, 2);
		String templateName =g.getExcelCellValue(xlPath, sheetName, 3150, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 3151, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 3152, 2);
		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 3153, 2);
		String frontEndUrlStrt = g.getExcelCellValue(xlPath, sheetName,3154, 2);

		String ss_frontEndUrl = frontEndUrlStrt + "\\" + folderNameToCreate + "\\" + templateName;

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
			String img1="";
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
			eE.clickImageIcon();
			System.out.println("entering block");
eE.chooseImageOperation("Choose an image.", 2);
			System.out.println("after img");
		iFT.switchFrame();
			System.out.println("frame chosen");
			Thread.sleep(10000);
			img1=eE.choosehighlightImge("cover", 1);		
System.out.println("pic found");

			System.out.println(img1);
			Thread.sleep(3000);
eE.clickFooterSelect();
System.out.println("finding image");
			iFT.switchOutOfFrame();
			
//driver.findElement(By.xpath("//img[contains(@src,'"+img1+"')]"));
//System.out.println("found image");
	eE.clickCaptionArea(i);
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

eE.clickHighlightButton(i);
eE.chooseImageOperation("Edits the link destination and appearance", 2);

iFT.switchFrame();

eE.chooseDestinationOption("Internal Link");

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
cE.rtClickOnelement(folderNameToCreate, "Refresh");
			cE.doubleClick1(templateName);
			hP.editField(1, "username");
			cE.clickOnlyPublishButton();
			hP.clickSave1();
			
			Thread.sleep(5000);
			iFT.switchFrame();
			iFT.clickOK();
			

			Thread.sleep(5000);
			cE.publishOptions();
			cE.publishSite();
			iFT.switchFrame();
			cE.clickPublishButton();
			Thread.sleep(80000);
			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();

			iFT.switchFrame();
			cE.clickClose();
			iFT.switchOutOfFrame();
			cE.logout();
			cE.clearBrowserCache();
			cE.clearBrowserCache();

			driver.get(ss_frontEndUrl);
			cE.getTitlePositive("username");

			b = true;
			

			//done
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 3146, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 3146, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 3146, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 3146, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 3146, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 3146, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 3146, 5, screenShot + v + "_" + date1);

			}
		}
	}

}
