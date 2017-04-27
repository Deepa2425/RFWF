package com.rfwf.scripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.ExperienceEditor;
import com.pageobjectmodel.pages.FrontEnd;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;
import com.basetestng.libraries.BaseTestNGPageDLSSiteFrontEnd;
import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.Login;
import com.pageobjectmodel.pages.PageLayout;

public class TC_RFWF_SC_FP_24_PublishExistingItemWithREPUBLISH extends BaseTestNGPageSiteCoreV2 {
	@Test(priority = 1)
	public void textRFWF_SC_FP_24_PublishExistingItemWithREPUBLISH() throws InterruptedException {

		// --Publish item code
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		PageLayout pL = new PageLayout(driver);
		Login l = new Login(driver);
		FrontEnd fE = new FrontEnd(driver);
		ReadDataFromExcel g = new ReadDataFromExcel();

		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_4();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
		String sheetName1 = aPOI.getSheet_2();
		boolean b = false;

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 606, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 607, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 608, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 609, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 610, 2);

		String tenantName = g.getExcelCellValue(xlPath, sheetName, 611, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 612, 2);
		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 613, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 614, 2);
		String frontEndUrlStrt = g.getExcelCellValue(xlPath, sheetName, 615, 2);
		String frontEndUrl = frontEndUrlStrt + "/" + folderNameToCreate + "/" + templateName;

		try {
			hP.clickOnContentEditor();

			cE.clickOnTenant(tenantName);
			cE.rtClickOnAndInsert(subElement);
			iFT.switchFrame();
			iFT.expandFolder(folderNameToSelect);
			iFT.selectSubFolder(subFolder);
			iFT.createTemplate(folderNameToCreate);
			iFT.clickInsert();
			Thread.sleep(5000);
			iFT.switchOutOfFrame();

			cE.rtClickOnAndInsert(folderNameToCreate);
			iFT.switchFrame();
			iFT.expandRfwPresencePagesSelectSecure();
			iFT.selectSubFolder(secure);
			iFT.createTemplate(templateName);
			iFT.clickInsert();
			iFT.switchOutOfFrame();

			cE.unlockTemplate();
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
			iFT.selectSubFolderS1(templateName, templateName1);
			pL.clickSelect();
			iFT.switchOutOfFrame();
			iFT.switchFrame();
			pL.clickCreateNewContent();
			pL.clickOK();
			iFT.switchOutOfFrame();
			iFT.switchFrame5();
			pL.clickOnSave();
			iFT.switchOutOfFrame();
			driver.close();

			cE.switchBackTpParentWindow();
			Thread.sleep(5000);
			hP.clickSave();
			Thread.sleep(5000);
			iFT.switchFrame();
			iFT.clickOK();

			cE.publishOptions();
			cE.publishSite();
			iFT.switchFrame();
			cE.clickPublishButton();
			Thread.sleep(8000);
			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();

			iFT.switchFrame();
			cE.clickClose();
			iFT.switchOutOfFrame();

			Thread.sleep(5000);

			cE.rtClickOnelement(folderNameToCreate, "Refresh");
			cE.expandFolder1(folderNameToCreate, 2);
			cE.expandFolder1(folderNameToCreate, 3);
			cE.expandFolder1(folderNameToCreate, 4);

			cE.doubleClick2(templateName1);
			hP.editField(12, "EditUN");
			hP.clickSave1();
			cE.clickOnlyPublishButton();
			cE.publishOptions();

			cE.publishItem();
			iFT.switchFrame();
			cE.clickRepublish();
			cE.checkRelatedItem();
			cE.clickPublishButton();
			iFT.switchOutOfFrame();
			iFT.switchFrame3();
			cE.clickOK();
			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();
			Thread.sleep(20000);

			iFT.switchFrame();
			cE.clickClose();
			iFT.switchOutOfFrame();
			cE.logout();
			cE.clearBrowserCache();
			cE.clearBrowserCache();

			Thread.sleep(20000);
			driver.get(frontEndUrl);
			Thread.sleep(5000);
			fE = new FrontEnd(driver);

			fE.verifyFPUsernameLabelPositive("EditUN");
			driver.close();
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 606, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 606, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 606, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 606, 4, date1);
		} finally {
			if (b == false) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 606, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 606, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 606, 5, screenShot + v + "_" + date1);

			}
		}
	}

}
