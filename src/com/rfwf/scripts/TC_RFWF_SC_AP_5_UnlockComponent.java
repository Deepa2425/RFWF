package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;

public class TC_RFWF_SC_AP_5_UnlockComponent extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_SC_AP_5_UnlockComponent() throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
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

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 1387, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 1388, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 1389, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 1390, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 1391, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 1392, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 1393, 2);

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
			
			cE.logout();

			g.setExcelCellValue(xlPath, sheetName, 1387, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 1387, 4, "Executed on - " + date1);
			b = true;

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 1387, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 1387, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 1387, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 1387, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 1387, 5, screenShot + v + "_" + date1);
			}
		}
	}
}
