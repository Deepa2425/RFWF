package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;

public class TC_RFWF_SC_FP_4_VerifyQuickInfoDetailsTestMultiTenant extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_SC_REG_4_VerifyQuickInfoDetails() throws InterruptedException {
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
		String refresh = g.getExcelCellValue(xlPath, sheetName, 173, 2);

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 361, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 362, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 363, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 364, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 365, 2);
		String publish = g.getExcelCellValue(xlPath, sheetName, 366, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 367, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 368, 2);
		String itemID = g.getExcelCellValue(xlPath, sheetName, 369, 2);
		String itemName = g.getExcelCellValue(xlPath, sheetName, 370, 2);
		String itemPath = g.getExcelCellValue(xlPath, sheetName, 371, 2);
		String template = g.getExcelCellValue(xlPath, sheetName, 372, 2);
		String createdFrom = g.getExcelCellValue(xlPath, sheetName, 373, 2);
		String itemOwner = g.getExcelCellValue(xlPath, sheetName, 374, 2);
		String metaDescription = g.getExcelCellValue(xlPath, sheetName, 377, 2);
		
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
			hP.getField1(1, itemID);
			hP.getField1(2, itemName);
			hP.getField1(3, itemPath);
			hP.getField1(4, template);
			hP.getField1(5, createdFrom);
			hP.getField1(6, itemOwner);

			hP.getTextDiv(metaDescription);

			cE.logout();
			b = true;

			g.setExcelCellValue(xlPath, sheetName, 376, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 376, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 376, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 376, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 376, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 376, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 376, 5, screenShot + v + "_" + date1);
			}
		}
	}
}
