package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;
import com.pageobjectmodel.pages.PageLayout;

public class TC_RFWF_SC_EA_7_TestMultiTenantV2_VerifyErrorForLockedItemExpEdtr extends BaseTestNGPageSiteCoreV2 {
	@Test(priority = 1)
	public void textTC_RFWF_SC_EA_7_TestMultiTenantV2_VerifyErrorForLockedItemExpEdtr() throws InterruptedException {
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

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 895, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 896, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 897, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 898, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 899, 2);

		String tenantName = g.getExcelCellValue(xlPath, sheetName, 900, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 901, 2);
		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 902, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 903, 2);

		String adminLockErrorMsg = g.getExcelCellValue(xlPath, sheetName, 907, 2);

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
			pL.verifyUnlockErrorMessage(adminLockErrorMsg);
			driver.quit();
			Thread.sleep(5000);

			b = true;
			g.setExcelCellValue(xlPath, sheetName, 895, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 895, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 895, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 895, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 895, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 895, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 895, 5, screenShot + v + "_" + date1);

			}
		}
	}

}
