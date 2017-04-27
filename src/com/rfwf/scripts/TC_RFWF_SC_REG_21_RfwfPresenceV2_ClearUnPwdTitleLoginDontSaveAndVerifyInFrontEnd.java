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

public class TC_RFWF_SC_REG_21_RfwfPresenceV2_ClearUnPwdTitleLoginDontSaveAndVerifyInFrontEnd extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_SC_REG_21_RfwfPresenceV2_ClearUnPwdTitleLoginDontSaveAndVerifyInFrontEnd() throws InterruptedException {
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

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 645, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 646, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 647, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 648, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 649, 2);
		String publish = g.getExcelCellValue(xlPath, sheetName, 650, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 651, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 652, 2);

		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 653, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 655, 2);
		String component = g.getExcelCellValue(xlPath, sheetName, 656, 2);
		String refresh = g.getExcelCellValue(xlPath, sheetName, 657, 2);
		String userActivate = g.getExcelCellValue(xlPath, sheetName, 658, 2);
		String frontEndURL = g.getExcelCellValue(xlPath, sheetName1, 27, 1);
		String pwd = g.getExcelCellValue(xlPath, sheetName, 661, 2);
		String un = g.getExcelCellValue(xlPath, sheetName, 662, 2);
		String fn = g.getExcelCellValue(xlPath, sheetName, 663, 2);
		String ln = g.getExcelCellValue(xlPath, sheetName, 664, 2);
		
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

			cE.clickOnTenant(subElement);
			cE.clickOnTenant(folderNameToCreate);
			cE.clickOnTenant(component);
			
			hP.expandContent();
			cE.clickOnTenant(userActivate);
			cE.selectSubFolderS4("Register",2);
			cE.selectSubFolderS4("Register",2);
			Thread.sleep(3000);
			hP.editField(5,"Edit_PWD"); //password
			hP.editField(16,"Edit_UN"); //username
			hP.editField(31,"Edit_FN"); //First Name
			hP.editField(32,"Edit_LN"); //Last Name
			
		  	iFT.selectSubFolder(publish);
	         cE.publishItem();
	         iFT.switchFrame();
	         cE.clickNo();
	         iFT.switchOutOfFrame();
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
            driver.get(frontEndURL);
	        cE.verifyFrontEndFieldsNegative(pwd,"Edit_PWD");
	        cE.verifyFrontEndFieldsNegative(un,"Edit_UN");
	        cE.verifyFrontEndFieldsNegative(fn,"Edit_FN");
	        cE.verifyFrontEndFieldsNegative(ln,"Edit_LN");
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 645, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 645, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 645, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 645, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v+ date2);
				g.setExcelCellValue(xlPath, sheetName, 645, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 645, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 268, 5,
						screenShot + v + "_" + date1);

			}
		}
	}

}
