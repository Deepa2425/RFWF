package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;

public class TC_RFWF_SC_REG_7_ConfigureLockedRegisterComponent extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_SC_REG_7_ConfigureLockedRegisterComponent() throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		boolean b = false;
		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_1();
		String sheetName1 = aPOI.getSheet_2();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
	

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 62, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 63, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 64, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 65, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 66, 2);
		String publish = g.getExcelCellValue(xlPath, sheetName, 67, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 68, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 69, 2);

		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 70, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 71, 2);
		String lockErrorMessage = g.getExcelCellValue(xlPath, sheetName, 72, 2);

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

			cE.getTextSpan(lockErrorMessage);
	
			g.setExcelCellValue(xlPath, sheetName, 62, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 62, 4, "Executed on - " + date1);
			b = true;

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 62, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 62, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v+ date2);
				g.setExcelCellValue(xlPath, sheetName, 62, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 62, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 62, 5,
						screenShot + v + "_" + date1);
			}
		}
	}
}
