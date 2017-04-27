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

public class TC_RFWF_SC_REG_17_RfwfPresenceV2_ClearUnPwdTitleLoginAndVerifyInExpEditor extends BaseTestNGPageSiteCoreV2 {
	@Test(priority = 1)
	public void textTC_RFWF_SC_REG_17_RfwfPresenceV2_ClearUnPwdTitleLoginAndVerifyInExpEditor() throws InterruptedException {
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

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 626, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 627, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 628, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 629, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 630, 2);
		String publish = g.getExcelCellValue(xlPath, sheetName, 631, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 632, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 633, 2);

		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 634, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 636, 2);
		String component = g.getExcelCellValue(xlPath, sheetName, 637, 2);
		String refresh = g.getExcelCellValue(xlPath, sheetName, 638, 2);
		String r1 = g.getExcelCellValue(xlPath, sheetName, 635, 2);
		String save = g.getExcelCellValue(xlPath, sheetName, 639, 2);
		String login = g.getExcelCellValue(xlPath, sheetName, 641, 2);
		String fn = g.getExcelCellValue(xlPath, sheetName, 642, 2);
		String ln = g.getExcelCellValue(xlPath, sheetName, 643, 2);

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
			cE.clickOnTenant(r1);
			cE.selectSubFolderS4("Register",2);
			cE.selectSubFolderS4("Register",2);
			Thread.sleep(3000);
			hP.editField(4,"");
			hP.editField(5,"");
			hP.editField(16,"");
			hP.editField(33,"");
			hP.editField(31,"");
			hP.editField(32,"");
			
			hP.selectSubFolder(save);
			
			iFT.switchFrame();
			hP.clickYes();
			iFT.switchOutOfFrame();
			
			cE.selectSubFolderS4(component,1);
			Thread.sleep(3000);
			cE.clickOnlyExperienceEditorButton();
			//cE.clickPublishAndExperienceEditor();
			Thread.sleep(40000);
			cE.switchWindow();
			cE.getTextLabelNegative(fn);
			cE.getTextLabelNegative(ln);
			
			driver.close();
			Thread.sleep(5000);
			cE.switchBackTpParentWindow();
			iFT.rightClickOnElement(folderNameToCreate);
			 hP.clickRtClickDelete();
		        iFT.switchFrame();
		        iFT.clickContinue();
		        iFT.clickContinue();
		        iFT.switchOutOfFrame();
		        cE.rtClickOnelement(tenantName, refresh);
	       // cE.logout();
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 626, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 626, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 626, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 626, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v+ date2);
				g.setExcelCellValue(xlPath, sheetName, 626, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 626, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 626, 5,
						screenShot+ v + "_" + date1);

			}
		}
	}

}
