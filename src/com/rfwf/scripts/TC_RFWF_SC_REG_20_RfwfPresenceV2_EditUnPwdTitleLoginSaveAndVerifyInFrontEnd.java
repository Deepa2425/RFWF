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

public class TC_RFWF_SC_REG_20_RfwfPresenceV2_EditUnPwdTitleLoginSaveAndVerifyInFrontEnd extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_SC_REG_20_RfwfPresenceV2_EditUnPwdTitleLoginSaveAndVerifyInFrontEnd() throws InterruptedException {
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
		
		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 686, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 687, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 688, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 689, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 690, 2);
		String publish = g.getExcelCellValue(xlPath, sheetName, 691, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 692, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 693, 2);

		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 694, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 696, 2);
		String component = g.getExcelCellValue(xlPath, sheetName, 697, 2);
		String refresh = g.getExcelCellValue(xlPath, sheetName, 698, 2);
		String userActivate = g.getExcelCellValue(xlPath, sheetName, 699, 2);
		String save = g.getExcelCellValue(xlPath, sheetName, 282, 2);
		String login = g.getExcelCellValue(xlPath, sheetName, 283, 2);
		String frontEndURL = g.getExcelCellValue(xlPath, sheetName1, 28, 1);

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
			cE.selectSubFolderS4("Register",2);
			cE.selectSubFolderS4("Register",2);
			hP.editField(6,"EidtConfPW");
			hP.editField(16,"EditUN");
			hP.selectSubFolder(save);
		  	iFT.selectSubFolder(publish);
		  	 cE.publishItem();
	         iFT.switchFrame();
	         cE.clickPublishButton();
	         iFT.switchOutOfFrame();
	         iFT.switchFrame2();
	         cE.clickOK();
	         iFT.switchOutOfFrame();
	         iFT.switchFrame();
	         cE.clickClose();
	         iFT.switchOutOfFrame();
	     cE.logout();
	     cE.clearBrowserCache();
	        driver.get(frontEndURL);
	        cE.verifyFrontEndFieldsPositive("txtUsername","EditUN");
	        cE.verifyFrontEndFieldsPositive("txtConfirmationPassword","EidtConfPW");
	     
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 686, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 686, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 686, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 686, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v+ date2);
				g.setExcelCellValue(xlPath, sheetName, 686, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 686, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 686, 5,
						screenShot + v + "_" + date1);

			}
		}
	}

}
