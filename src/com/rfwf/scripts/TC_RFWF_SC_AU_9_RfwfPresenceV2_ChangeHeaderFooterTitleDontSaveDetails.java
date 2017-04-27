package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;
import com.pageobjectmodel.pages.Login;
import com.pageobjectmodel.pages.PageLayout;

public class TC_RFWF_SC_AU_9_RfwfPresenceV2_ChangeHeaderFooterTitleDontSaveDetails extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_SC_AU_9_RfwfPresenceV2_ChangeHeaderFooterTitleDontSaveDetails()
			throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		PageLayout pL = new PageLayout(driver);
		Login l = new Login(driver);
		
		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_1();
		String sheetName1 = aPOI.getSheet_2();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
	
		boolean b = false;

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 74, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 75, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 76, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 77, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 78, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 80, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 81, 2);

		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 82, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 84, 2);
		String component = g.getExcelCellValue(xlPath, sheetName, 88, 2);

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
			hP.editField(2,"abc");
			hP.editField(2,"asc");
			
			b = true;
			iFT.logout();
			iFT.switchFrame();
			hP.clickNo();
			iFT.switchOutOfFrame();
			Thread.sleep(5000);
			
			l.loginCreds("H138128", "H138128");
					
			hP.clickOnContentEditor();
			cE.clickOnTenant(tenantName);
			cE.clickOnTenant(subElement);
			cE.clickOnTenant(folderNameToCreate);
			hP.selectSubFolderS1(component, "");
			
			hP.editFieldGetText(2,"UserActivate");
			hP.editFieldGetText(4,"UserActivate");
			g.setExcelCellValue(xlPath, sheetName, 74, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 74, 4, "Executed on - " + date1);
			
		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 74, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 74, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v+ date2);
				g.setExcelCellValue(xlPath, sheetName, 74, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 74, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 74, 5,
						screenShot + v + "_" + date1);

			}
		}
	}

}
