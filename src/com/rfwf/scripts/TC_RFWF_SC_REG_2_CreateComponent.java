package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;

public class TC_RFWF_SC_REG_2_CreateComponent extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_SC_REG_2_CreateComponent() throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE =  new ContentEditor(driver);
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
		
		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 395, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 396, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 397, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 398, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 399, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 34, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 35, 2);
		
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
       
         g.setExcelCellValue(xlPath, sheetName, 395, 3, "PASS");
    	 g.setExcelCellValue(xlPath, sheetName, 395, 4, "Executed on - "+date1);
    	b=true;
    	
		} catch (Exception e1) {
		 	g.setExcelCellValue(xlPath, sheetName, 395, 3, "FAIL");
		 	g.setExcelCellValue(xlPath, sheetName, 395, 4, date1);
		} finally {
			if(!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v+ date2);
				g.setExcelCellValue(xlPath, sheetName, 395, 3, "FAIL");	
				g.setExcelCellValue(xlPath, sheetName, 395, 4, "Executed on - "+date1);
				g.setExcelCellValue(xlPath, sheetName, 395, 5, screenShot+v+"_"+date1);
			}
		}  
	}
}
