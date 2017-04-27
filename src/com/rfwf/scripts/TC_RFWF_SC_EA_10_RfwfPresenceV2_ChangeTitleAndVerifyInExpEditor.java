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

public class TC_RFWF_SC_EA_10_RfwfPresenceV2_ChangeTitleAndVerifyInExpEditor extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_SC_EA_10_RfwfPresenceV2_ChangeTitleAndVerifyInExpEditor()
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

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 924, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 925, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 926, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 927, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 928, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 929, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 930, 2);
		
		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 931, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 932, 2);
		String component = g.getExcelCellValue(xlPath, sheetName,933, 2);
		String refresh = g.getExcelCellValue(xlPath, sheetName, 934, 2);
		String emailActivate = g.getExcelCellValue(xlPath, sheetName, 935, 2);
		String pageLayoutCreated = g.getExcelCellValue(xlPath, sheetName, 936, 2);
		String save = g.getExcelCellValue(xlPath, sheetName, 937, 2);

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
			
			cE.verifyerrorMessage(pageLayoutCreated);
			Thread.sleep(3000);
			driver.close();
			
			Thread.sleep(3000);
			cE.switchBackTpParentWindow();
			cE.rtClickOnelement(tenantName, refresh);		
		
			cE.clickOnTenant(subElement);
			cE.clickOnTenant(folderNameToCreate);
			cE.clickOnTenant(component);
			
			hP.expandContent();
			cE.clickOnTenant(emailActivate);
			cE.selectSubFolderS4("Activate Email",1);
			cE.selectSubFolderS4("Activate Email",1);
			hP.editField(1,"Edited EmailTitle");
			Thread.sleep(3000);
			hP.selectSubFolder(save);
			
			cE.selectSubFolderS4(component,1);
									
			cE.clickOnlyExperienceEditorButton();
			//cE.clickPublishAndExperienceEditor();
			Thread.sleep(30000);
			cE.switchWindow();
			cE.verifyerrorMessage("Edited EmailTitle");
			b=true;
			g.setExcelCellValue(xlPath, sheetName, 924, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 924, 4, "Executed on - " + date1);
			
		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 924, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 924, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v+ date2);
				g.setExcelCellValue(xlPath, sheetName, 924, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 924, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 924, 5,
						screenShot + v + "_" + date1);

			}
		}
	}

}
