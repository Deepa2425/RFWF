package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.ForgotPassword;
import com.pageobjectmodel.pages.FrontEnd;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;
import com.pageobjectmodel.pages.PageLayout;

public class TC_RFWF_SC_AP_2_CreateActivatePasswordComponent extends BaseTestNGPageSiteCoreV2 {
	@Test(priority = 1)
	public void textTC_RFWF_SC_LOG_TempForgotPswd2() throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		PageLayout pL = new PageLayout(driver);
		FrontEnd fE = new FrontEnd(driver);
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

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 1376, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 1377, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 1378, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 1379, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 1380, 2);

		String tenantName = g.getExcelCellValue(xlPath, sheetName, 1381, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 1382, 2);
		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 1383, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 1384, 2);

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

		fP.verifyComponentCreated(folderNameToCreate, templateName);
			
			
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 1376, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 1376, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 1376, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 1376, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 1376, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 1376, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 1376, 5, screenShot + v + "_" + date1);

			}
		}
	}

}
