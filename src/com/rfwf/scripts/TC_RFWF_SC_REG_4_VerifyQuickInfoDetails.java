package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;

public class TC_RFWF_SC_REG_4_VerifyQuickInfoDetails extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_SC_REG_4_VerifyQuickInfoDetails() throws InterruptedException {
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
		String refresh = g.getExcelCellValue(xlPath, sheetName, 173, 2);
		
		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 413, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 414, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 415, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 416, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 417, 2);
		String publish = g.getExcelCellValue(xlPath, sheetName, 418, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 419, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 420, 2);
		String itemID = g.getExcelCellValue(xlPath, sheetName, 421, 2);
		String itemName = g.getExcelCellValue(xlPath, sheetName, 422, 2);
		String itemPath = g.getExcelCellValue(xlPath, sheetName, 423, 2);
		String template = g.getExcelCellValue(xlPath, sheetName, 424, 2);
		String createdFrom = g.getExcelCellValue(xlPath, sheetName, 425, 2);
		String itemOwner = g.getExcelCellValue(xlPath, sheetName, 426, 2);
		String openGraphSiteName = g.getExcelCellValue(xlPath, sheetName, 427, 2);
		String openGraphPageTitle = g.getExcelCellValue(xlPath, sheetName, 428, 2);
		String metaDescription = g.getExcelCellValue(xlPath, sheetName, 429, 2);
		String metaKeyword = g.getExcelCellValue(xlPath, sheetName, 430, 2);
		String openGraphImage = g.getExcelCellValue(xlPath, sheetName, 46, 2);
		String noIndex = g.getExcelCellValue(xlPath, sheetName, 47, 2);
		String noFollow = g.getExcelCellValue(xlPath, sheetName, 48, 2);
		String renderCanonicalOrder = g.getExcelCellValue(xlPath, sheetName, 49, 2);
		String canonicalUrl = g.getExcelCellValue(xlPath, sheetName, 50, 2);
		
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
         hP.getField1(1,itemID);
         hP.getField1(2,itemName);
         hP.getField1(3,itemPath);
         hP.getField1(4,template);
         hP.getField1(5,createdFrom);
         hP.getField1(6,itemOwner);
        
         hP.getField2(2,openGraphSiteName);
         hP.getTextDiv(metaDescription);
 
        iFT.rightClickOnElement(folderNameToCreate);
        hP.clickRtClickDelete();
        iFT.switchFrame();
        iFT.clickContinue();
        iFT.clickContinue();
        iFT.switchOutOfFrame();
        cE.rtClickOnelement(tenantName, refresh);
        // cE.logout();
       
         g.setExcelCellValue(xlPath, sheetName, 413, 3, "PASS");
    	 g.setExcelCellValue(xlPath, sheetName, 413, 4, "Executed on - "+date1);
    	b=true;
    	
		} catch (Exception e1) {
		 	g.setExcelCellValue(xlPath, sheetName, 413, 3, "FAIL");
		 	g.setExcelCellValue(xlPath, sheetName, 413, 4, date1);
		} finally {
			if(!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v+ date2);
				g.setExcelCellValue(xlPath, sheetName, 413, 3, "FAIL");	
				g.setExcelCellValue(xlPath, sheetName, 413, 4, "Executed on - "+date1);
				g.setExcelCellValue(xlPath, sheetName, 413, 5, screenShot+v+"_"+date1);
			}
		}  
	}
}
