package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;
import com.pageobjectmodel.pages.PageLayout;

public class TC_RFWF_SC_EA_12_RfwfPresenceV2_ClickOnLastEleAndVerifyErrorMsg extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_SC_EA_12_RfwfPresenceV2_ClickOnLastEleAndVerifyErrorMsg() throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		PageLayout pL = new PageLayout(driver);

		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_1();
		String sheetName1 = aPOI.getSheet_2();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();

		boolean b = false;

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 953, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 954, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 955, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 956, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 957, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 959, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 960, 2);

		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 961, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 963, 2);
		String component = g.getExcelCellValue(xlPath, sheetName, 965, 2);
		String refresh = g.getExcelCellValue(xlPath, sheetName, 966, 2);
		String error = g.getExcelCellValue(xlPath, sheetName, 968, 2);
		String emailActivate = g.getExcelCellValue(xlPath, sheetName, 969, 2);

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
			cE.clickOnTenant(emailActivate);
			cE.selectSubFolderS4("Activate Email", 1);
			cE.selectSubFolderS4("Activate Email", 1);

			cE.clickOnlyExperienceEditorButton();
			iFT.switchFrame();
			cE.verifyerrorMessage(error);
			cE.clickCancel();
			iFT.switchOutOfFrame();

			iFT.rightClickOnElement(folderNameToCreate);
			hP.clickRtClickDelete();
			iFT.switchFrame();
			iFT.clickContinue();
			iFT.clickContinue();
			iFT.switchOutOfFrame();
			cE.rtClickOnelement(tenantName, refresh);
			// cE.logout();
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 953, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 953, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 953, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 953, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 953, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 953, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 953, 5, screenShot + v + "_" + date1);

			}
		}
	}

}