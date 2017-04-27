package com.rfwf.scripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
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

public class TC_RFWF_SC_CU_4_CheckUpdatedProfile extends BaseTestNGPageSiteCoreV2 {
	@Test(priority = 1)
	public void textTC_RFWF_SC_CU_4_CheckUpdatedProfile() throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		PageLayout pL = new PageLayout(driver);
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
		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 2074, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 2075, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 2076, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 2077, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 2078, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 2079, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 2080, 2);
		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 2081, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 2082, 2);

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
			Thread.sleep(10000);
			//new code
			pL.clickPageLayout();
			iFT.switchFrame();
			iFT.selectSubFolder("CustomProfile");
			pL.clickSelect();
			iFT.switchOutOfFrame();
			iFT.switchFrame();
			pL.clickCreateNewContent();
			pL.clickOK();
			Thread.sleep(10000);
			eE.verifyLabelNamePositive("txtStreet","Street");
			pL.switchFrame5();
			pL.clickOnSave();
			driver.close();
			cE.switchBackTpParentWindow();
			Thread.sleep(5000);
			cE.logout();
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 2074, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 2074, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 2074, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 2074, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 2074, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 2074, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 2074, 5, screenShot + v + "_" + date1);

			}
		}
	}

}
