package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;

public class TC_RFWF_SC_FP_1_VerifyErrorForBlankSecureNameForgotPassword extends BaseTestNGPageSiteCoreV2 {
	@Test(priority = 1)
	public void textTC_RFWF_SC_LOG_TempForgotPswd2() throws InterruptedException {
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
				boolean b = false;

		
		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 328, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 329, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 330, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 331, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 332, 2);

		String tenantName = g.getExcelCellValue(xlPath, sheetName, 333, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 334, 2);
		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 335, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 336, 2);
		String err=g.getExcelCellValue(xlPath, sheetName, 327, 2);

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
			iFT.createTemplate("");
			iFT.clickInsert();

			iFT.switchOutOfFrame();
			iFT.switchFrame3();

			cE.verifyBlackSecureError(err);
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 328, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 328, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 328, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 328, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v+ date2);
							g.setExcelCellValue(xlPath, sheetName, 328, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 328, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 328, 5,
						screenShot + v + "_" + date1);

			}
		}
	}

}
