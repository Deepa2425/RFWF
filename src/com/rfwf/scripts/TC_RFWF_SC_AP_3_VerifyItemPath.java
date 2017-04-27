package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.ForgotPassword;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;

public class TC_RFWF_SC_AP_3_VerifyItemPath extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_SC_AP_3_VerifyItemPath() throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		ForgotPassword fP = new ForgotPassword(driver);

		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_4();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();	
		String sheetName1 = aPOI.getSheet_2();
		boolean b = false;
				String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 1429, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 1430, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 1431, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 1432, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 1433, 2);

		String tenantName = g.getExcelCellValue(xlPath, sheetName, 1434, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 1435, 2);
		String refresh = g.getExcelCellValue(xlPath, sheetName, 1436, 2);
		String path = g.getExcelCellValue(xlPath, sheetName, 1437, 2);

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

			hP.getItemPathText(path);

			cE.logout();
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 1429, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 1429, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 1429, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 1429, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v+ date2);
				g.setExcelCellValue(xlPath, sheetName, 1429, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 1429, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 1429, 5,
						screenShot+ v + "_" + date1);
			}
		}
	}
}
