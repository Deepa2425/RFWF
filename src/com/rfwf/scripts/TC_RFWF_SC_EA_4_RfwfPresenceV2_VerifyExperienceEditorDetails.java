package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;

public class TC_RFWF_SC_EA_4_RfwfPresenceV2_VerifyExperienceEditorDetails extends BaseTestNGPageSiteCoreV2 {
	@Test(priority = 1)
	public void textTC_RFWF_SC_EA_4_RfwfPresenceV2_VerifyExperienceEditorDetails()
			throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		
		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_1();
		String sheetName1 = aPOI.getSheet_2();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
		
		boolean b = false;

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 871, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 872, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 873, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 874, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 875, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 877, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 878, 2);
		String component = g.getExcelCellValue(xlPath, sheetName, 885, 2);
		String pageTitle = g.getExcelCellValue(xlPath, sheetName, 886, 2);
		String openGraphText = g.getExcelCellValue(xlPath, sheetName, 887, 2);
		String openGraphDesc = g.getExcelCellValue(xlPath, sheetName, 888, 2);
		String metaDesc = g.getExcelCellValue(xlPath, sheetName, 889, 2);
		String metaKeywords = g.getExcelCellValue(xlPath, sheetName, 890, 2);
		
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
			cE.getTextDiv(pageTitle);
			cE.getTextDiv(openGraphText);
			cE.getTextDiv(openGraphDesc);
			cE.getTextDiv(metaDesc);
			cE.getTextDiv(metaKeywords);
									
		    b=true;
			g.setExcelCellValue(xlPath, sheetName, 871, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 871, 4, "Executed on - " + date1);
			
		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 871, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 871, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v+ date2);
				g.setExcelCellValue(xlPath, sheetName, 871, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 871, 4, "Executed on - " + date1);
			
				g.setExcelCellValue(xlPath, sheetName, 871, 5,
						screenShot + v + "_" + date1);

			}
		}
	}

}
