package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV1;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;

public class TC_RFWF_SC_EA_1_VerifyErrorMessageCreateComponent extends BaseTestNGPageSiteCoreV1 {
	@Test
	public void textTC_RFWF_SC_EA_1_VerifyErrorMessageCreateComponent() throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE =  new ContentEditor(driver);
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
	    String home = g.getExcelCellValue(xlPath, sheetName, 810, 2);
		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 811, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 812, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 819, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 813, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 814, 2);
			
		
		try {
         hP.clickOnContentEditor();
         cE.clickOnTenant(tenantName);
         cE.rtClickOnAndInsert(home);
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
         cE.verifyErrorMessagerOfCreateTempplateBlank("You must specify a name for the new item.");//
         cE.clickOK();
         iFT.switchOutOfFrame();
         iFT.switchFrame();
         iFT.clickCancel();  
         iFT.switchOutOfFrame();
         iFT.logout();
         g.setExcelCellValue(xlPath, sheetName, 810, 3, "PASS");
    	 g.setExcelCellValue(xlPath, sheetName, 810, 4, "Executed on - "+date1);
    	b=true;
    	
		} catch (Exception e1) {
		 	g.setExcelCellValue(xlPath, sheetName, 810, 3, "FAIL");
		 	g.setExcelCellValue(xlPath, sheetName, 810, 4, date1);
		} finally {
			if(!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v+ date2);
				g.setExcelCellValue(xlPath, sheetName, 810, 3, "FAIL");	
				g.setExcelCellValue(xlPath, sheetName, 810, 4, "Executed on - "+date1);
				g.setExcelCellValue(xlPath, sheetName, 810, 5, screenShot+v+"_"+date1);
			}
		}  
	}
}
