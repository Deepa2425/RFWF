package com.rfwf.scripts;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;

public class TC_RFWF_SC_AP_1_VerifyErrorForBlankSecureName extends BaseTestNGPageSiteCoreV2 {
	@Test(priority = 1)
	public void textTC_RFWF_SC_AP_1_VerifyErrorForBlankSecureName()
			throws InterruptedException, InvalidFormatException, IOException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);

		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_4();
		String sheetNameStatus = aPOI.getSheet_6();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
		boolean b = false;

		String v = this.getClass().getSimpleName();
		int rowCount1 = g.returnRow(xlPath, "RFWF_STATUS");
		int rowCount = rowCount1+1;

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 1419, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 1420, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 1421, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 1422, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 1423, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 1424, 2);
		String err = g.getExcelCellValue(xlPath, sheetName, 1425, 2);

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
		/*	g.setExcelCellValue(xlPath, sheetName, 1419, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 1419, 4, "Executed on - " + date1);*/

			System.out.println(xlPath);
			System.out.println(rowCount + 1);
			System.out.println(sheetNameStatus);
			System.out.println(v);

			g.setExcelCellValue_Status(xlPath,"RFWF_STATUS", 4, 0, v);
			g.setExcelCellValue_Status(xlPath,"RFWF_STATUS", 4, 1, "PASS");
			g.setExcelCellValue_Status(xlPath,"RFWF_STATUS", 4, 2, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 1419, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 1419, 4, date1);
		} finally {
			if (!b) {

				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue_Status(xlPath, sheetName, 328, 3, "FAIL");
				g.setExcelCellValue_Status(xlPath, sheetName, 1419, 4, "Executed on - " + date1);
				g.setExcelCellValue_Status(xlPath, sheetName, 1419, 5, screenShot + v + "_" + date1);

				g.setExcelCellValue(xlPath, sheetNameStatus, rowCount, 0, v);
				g.setExcelCellValue(xlPath, sheetNameStatus, rowCount, 1, "FAIL");
				g.setExcelCellValue(xlPath, sheetNameStatus, rowCount, 2, "Executed on - " + date1);
			}
		}
	}

}
