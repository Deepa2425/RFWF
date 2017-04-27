package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.ForgotPassword;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;
import com.pageobjectmodel.pages.Login;
import com.pageobjectmodel.pages.PageLayout;

public class TC_RFWF_SC_FP_18_EditDetailsAndSaveInExperienceEditor_RfwfPresence extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_SC_FP_18_EditDetailsAndSaveInExperienceEditor_RfwfPresence() throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		PageLayout pL = new PageLayout(driver);
		Login l = new Login(driver);
		ForgotPassword fP = new ForgotPassword(driver);

		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_4();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
		String sheetName1 = aPOI.getSheet_2();
		boolean b = false;

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 558, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 559, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 560, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 561, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 562, 2);
		String publish = g.getExcelCellValue(xlPath, sheetName, 563, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 564, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 565, 2);
		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 566, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 567, 2);

		try {
			hP.clickOnContentEditor();
			cE.clickOnTenant(tenantName);
			cE.rtClickOnAndInsert1(subElement);
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

			cE.rtClickOnelement(folderNameToCreate, "Refresh");

			fP.singleClickFp(templateName);
			Thread.sleep(3000);
			cE.clickOnlyPublishButton();
			hP.clickSave();

			iFT.logout();
			Thread.sleep(5000);

			l.loginCreds("H138128", "H138128");

			hP.clickOnContentEditor();
			cE.clickOnTenant(tenantName);

			Thread.sleep(10000);
			cE.rtClickOnelement(folderNameToCreate, "Refresh");
			cE.expandFolder1(folderNameToCreate, 2);
			cE.expandFolder1(folderNameToCreate, 3);
			cE.expandFolder1(folderNameToCreate, 4);

			Thread.sleep(50000);
			hP.editFieldGetText(3, "EditPW");
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 558, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 558, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 558, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 558, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 558, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 558, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 558, 5, screenShot + v + "_" + date1);

			}
		}
	}

}