package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;

public class TC_RFWF_SC_AU_11_RfwfPresenceV2_VerifyExperienceEditorDetails extends BaseTestNGPageSiteCoreV2 {
	@Test(priority = 1)
	public void textTC_RFWF_SC_REG_11_RfwfPresenceV2_VerifyExperienceEditorDetails()
			throws InterruptedException {
		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_1();
		String sheetName1 = aPOI.getSheet_2();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
		
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		boolean b = false;

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 74, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 75, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 108, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 77, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 78, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 80, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 81, 2);

		String component = g.getExcelCellValue(xlPath, sheetName, 118, 2);
		
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
			hP.selectSubFolderS1(component, "");
			cE.clickPublishAndExperienceEditor();
		
			b=true;
			g.setExcelCellValue(xlPath, sheetName, 106, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 106, 4, "Executed on - " + date1);
			
		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 106, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 106, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v+ date2);
				g.setExcelCellValue(xlPath, sheetName, 106, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 106, 4, "Executed on - " + date1);
			
				g.setExcelCellValue(xlPath, sheetName, 106, 5,
						screenShot + v + "_" + date1);

			}
		}
	}

}
