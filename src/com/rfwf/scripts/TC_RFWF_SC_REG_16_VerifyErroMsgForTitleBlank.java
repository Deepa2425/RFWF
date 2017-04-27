package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;

public class TC_RFWF_SC_REG_16_VerifyErroMsgForTitleBlank extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_SC_REG_16_VerifyErroMsgForTitleBlank() throws InterruptedException {
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
		
		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 177, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 178, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 179, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 180, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 181, 2);
		String publish = g.getExcelCellValue(xlPath, sheetName, 182, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 183, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 184, 2);
		String save = g.getExcelCellValue(xlPath, sheetName, 185, 2);
		String refresh = g.getExcelCellValue(xlPath, sheetName, 186, 2);
		String error = g.getExcelCellValue(xlPath, sheetName, 187, 2);
		String title = g.getExcelCellValue(xlPath, sheetName, 188, 2);
		
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
        
         hP.editField(7,"");
         hP.selectSubFolder(save);
         iFT.switchFrame();
         hP.verifyerrorMessage(error);
         hP.clickOK();
         iFT.switchOutOfFrame();
         cE.clickPublishAndExperienceEditor();
		 Thread.sleep(40000);
		 cE.switchWindow();
         hP.getTitle(title);
         driver.close();
         cE.switchBackTpParentWindow();
         
         iFT.rightClickOnElement(folderNameToCreate);
         hP.clickRtClickDelete();
       
         cE.rtClickOnelement(tenantName, refresh);
        // cE.logout();
         
         g.setExcelCellValue(xlPath, sheetName, 177, 3, "PASS");
    	 g.setExcelCellValue(xlPath, sheetName, 177, 4, "Executed on - "+date1);
    	b=true;
    	
		} catch (Exception e1) {
		 	g.setExcelCellValue(xlPath, sheetName, 177, 3, "FAIL");
		 	g.setExcelCellValue(xlPath, sheetName, 177, 4, date1);
		} finally {
			if(!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v+ date2);
				g.setExcelCellValue(xlPath, sheetName, 177, 3, "FAIL");	
				g.setExcelCellValue(xlPath, sheetName, 177, 4, "Executed on - "+date1);
				g.setExcelCellValue(xlPath, sheetName, 177, 5, screenShot+v+"_"+date1);
			}
		}  
	}
}
