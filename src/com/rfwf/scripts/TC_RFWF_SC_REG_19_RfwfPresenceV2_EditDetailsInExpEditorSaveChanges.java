package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;
import com.pageobjectmodel.pages.PageLayout;

public class TC_RFWF_SC_REG_19_RfwfPresenceV2_EditDetailsInExpEditorSaveChanges extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_SC_REG_19_RfwfPresenceV2_EditDetailsInExpEditorSaveChanges() throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		PageLayout pL = new PageLayout(driver);
		boolean b = false;

		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_1();
		String sheetName1 = aPOI.getSheet_2();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 250, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 251, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 252, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 253, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 254, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 256, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 257, 2);

		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 258, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 260, 2);
		String component = g.getExcelCellValue(xlPath, sheetName, 262, 2);
		String refresh = g.getExcelCellValue(xlPath, sheetName, 263, 2);
		String userActivate = g.getExcelCellValue(xlPath, sheetName, 263, 2);
		String save = g.getExcelCellValue(xlPath, sheetName, 266, 2);
		String login = g.getExcelCellValue(xlPath, sheetName, 265, 2);
		// String frontEndURL = g.getExcelCellValue(xlPath, sheetName1, 21, 1);

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

			iFT.switchFrame1();
			pL.clickOnSave();
			iFT.switchOutOfFrame();
			driver.close();
			Thread.sleep(5000);
			cE.switchBackTpParentWindow();

			cE.rtClickOnelement(tenantName, refresh);

			cE.clickOnTenant(subElement);
			cE.clickOnTenant(folderNameToCreate);
			cE.clickOnTenant(component);

			hP.expandContent();

			cE.clickOnTenant(templateName1);
			cE.selectSubFolderS4("Register", 2);

			hP.editField(6, "EidtConfPW");
			hP.editField(16, "EditUN");

			hP.selectSubFolder(save);
			Thread.sleep(3000);
			cE.selectSubFolderS4(component, 1);
			/*
			 * iFT.switchFrame(); hP.clickNo(); iFT.switchOutOfFrame()
			 */;
			Thread.sleep(3000);
			cE.clickOnlyExperienceEditorButton();
			// cE.clickPublishAndExperienceEditor();
			Thread.sleep(40000);
			cE.switchWindow();
			cE.getTextLabelPositive("EidtConfPW");
			cE.getTextLabelPositive("EditUN");

			driver.close();
			Thread.sleep(5000);
			cE.switchBackTpParentWindow();
			iFT.rightClickOnElement(folderNameToCreate);
			hP.clickRtClickDelete();
			iFT.switchFrame();
			iFT.clickContinue();
			iFT.clickContinue();
			iFT.switchOutOfFrame();
			cE.rtClickOnelement(tenantName, refresh);
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 250, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 250, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 250, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 250, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 250, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 250, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 250, 5, screenShot + v + "_" + date1);

			}
		}
	}

}
