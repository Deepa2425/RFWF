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

public class TC_RFWF_SC_LOG_29_LeaveBlankTitleLogin extends BaseTestNGPageSiteCoreV2 {
	@Test(priority = 1)
	public void textRFWF_SC_LOG_29_LeaveBlankTitleLogin() throws InterruptedException {

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

		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 88, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 89, 2);

		String tenantName = g.getExcelCellValue(xlPath, sheetName, 90, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 91, 2);
		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 92, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 93, 2);
		String frontEndUrlStrt = g.getExcelCellValue(xlPath, sheetName, 94, 2);
		String frontEndUrl = frontEndUrlStrt + "/" + folderNameToCreate + "/" + templateName;
		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 95, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 96, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 97, 2);

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

			iFT.expandFolder(subElement);
			cE.rtClickOnelement(folderNameToCreate, "Refresh");
			cE.singleClick1(templateName);
			hP.editField(1, "");
			hP.clickSave1();
			Thread.sleep(5000);
			iFT.switchFrame();
			iFT.clickOK();

			cE.clickOnlyPublishButton();
			cE.publishOptions();
			cE.publishItem();
			iFT.switchFrame();
			cE.clickRepublish();
			cE.checkSubItem();
			cE.clickPublishButton();
			iFT.switchOutOfFrame();

			iFT.switchFrame3();
			cE.clickOK();
			Thread.sleep(5000);
			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();

			iFT.switchFrame();
			cE.clickClose();
			iFT.switchOutOfFrame();
			cE.logout();
			cE.clearBrowserCache();
			cE.clearBrowserCache();

			Thread.sleep(20000);
			driver.get(frontEndUrl);
			Thread.sleep(5000);
			fE.verifyBlankTitle();
			b = true;

			g.setExcelCellValue(xlPath, sheetName, 88, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 88, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 88, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 88, 4, date1);
		} finally {
			if (b == false) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 88, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 88, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 88, 5, screenShot + v + "_" + date1);

			}
		}
	}

}
