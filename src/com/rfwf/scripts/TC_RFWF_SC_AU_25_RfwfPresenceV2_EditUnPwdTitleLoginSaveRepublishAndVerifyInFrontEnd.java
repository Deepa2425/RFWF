package com.rfwf.scripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;
import com.pageobjectmodel.pages.PageLayout;

public class TC_RFWF_SC_AU_25_RfwfPresenceV2_EditUnPwdTitleLoginSaveRepublishAndVerifyInFrontEnd extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_SC_AU_25_RfwfPresenceV2_EditUnPwdTitleLoginSaveRepublishAndVerifyInFrontEnd() throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		PageLayout pL = new PageLayout(driver);
		
		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_1();
		String sheetName1 = aPOI.getSheet_2();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
			
		boolean b = false;

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 770, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 771, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName,772, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 773, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 774, 2);
		String publish = g.getExcelCellValue(xlPath, sheetName, 775, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 776, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 777, 2);

		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 778, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 780, 2);
		String component = g.getExcelCellValue(xlPath, sheetName, 781, 2);
		String refresh = g.getExcelCellValue(xlPath, sheetName, 782, 2);
		String userActivate = g.getExcelCellValue(xlPath, sheetName, 783, 2);
		String save = g.getExcelCellValue(xlPath, sheetName, 784, 2);
		String frontEndURL = g.getExcelCellValue(xlPath, sheetName1, 32, 1);

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

			cE.clickPublishAndExperienceEditor();
			Thread.sleep(40000);
			cE.switchWindow();
			pL.clickPageLayout();
			iFT.switchFrame();
			iFT.selectSubFolder(pageLayout);
			pL.selectPageLayout(5);
			pL.clickSelect();
			iFT.switchOutOfFrame();
			pL.clickPageLayout();
			iFT.switchFrame();
			iFT.selectSubFolderS1(templateName, templateName1);
			pL.clickSelect();
			iFT.switchOutOfFrame();
			iFT.switchFrame();
			pL.clickCreateNewContent();
			pL.clickOK();
			iFT.switchOutOfFrame();
			
			iFT.switchFrame1();
			pL.clickOnSave();
			iFT.switchOutOfFrame();
			driver.close();
			Thread.sleep(5000);
			cE.switchBackTpParentWindow();
			cE.rtClickOnelement(tenantName, refresh);
			
			//cE.clickOnTenant(tenantName);
			cE.clickOnTenant(subElement);
			cE.clickOnTenant(folderNameToCreate);
			cE.clickOnTenant(component);
			
			hP.expandContent();
			cE.clickOnTenant(userActivate);
			cE.selectSubFolderS4("Activate User",1);
			cE.selectSubFolderS4("Activate User",1);
			Thread.sleep(3000);
			hP.editField(3,"EH");
			hP.editField(19,"EPU");
			hP.editField(21,"EUN");
			hP.selectSubFolder(save);
			iFT.selectSubFolder(publish);
		  	
		  	 cE.publishItem();
		  	 iFT.switchFrame();
		  	cE.checkBoxNegative(1);
		  	cE.checkBoxNegative(2);
	         
	         cE.clickPublishButton();
	         iFT.switchOutOfFrame();
	       
	         iFT.switchFrame();
	         cE.clickClose();
	         iFT.switchOutOfFrame();
	         cE.logout();
	         cE.clearBrowserCache();
	       
	         driver.get(frontEndURL);
	        
	        cE.verifyFrontEndFieldsPositive("txtUsername","EUN");
	        cE.verifyFrontEndFieldsPositive("txtPassword","EPU");
	       
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 770, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 770, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 770, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 770, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v+ date2);
				g.setExcelCellValue(xlPath, sheetName, 770, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 770, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 770, 5,
						screenShot + v + "_" + date1);

			}
		}
	}

}
