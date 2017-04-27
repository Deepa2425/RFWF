package com.rfwf.scripts;
import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;
import com.pageobjectmodel.pages.PageLayout;

public class TC_RFWF_SC_AU_16_RfwfPresenceV2_ClearUnPwdTitleLoginAndVerifyInExpEditor extends BaseTestNGPageSiteCoreV2 {
	@Test(priority = 1)
	public void textTTC_RFWF_SC_AU_16_RfwfPresenceV2_ClearUnPwdTitleLoginAndVerifyInExpEditor() throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		PageLayout pL = new PageLayout(driver);
		
		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_1();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
		
		boolean b = false;
		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 192, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 193, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 194, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 195, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 196, 2);
		String publish = g.getExcelCellValue(xlPath, sheetName, 197, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 198, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 199, 2);

		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 200, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 202, 2);
		String component = g.getExcelCellValue(xlPath, sheetName, 204, 2);
		String refresh = g.getExcelCellValue(xlPath, sheetName, 147, 2);
		String userActivate = g.getExcelCellValue(xlPath, sheetName, 206, 2);
		String save = g.getExcelCellValue(xlPath, sheetName, 207, 2);
		String login = g.getExcelCellValue(xlPath, sheetName, 208, 2);

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
			hP.editField(3,"");
			hP.editField(19,"");
			hP.editField(21,"");
			//hP.editField(22,"");
			
			hP.selectSubFolder(save);
			cE.selectSubFolderS4(component,1);
			cE.clickOnlyExperienceEditorButton();
			Thread.sleep(40000);
			cE.switchWindow();
			cE.getAttributeValueLabel("User Name");
			cE.getAttributeValueLabel("Password");
			driver.close();
			Thread.sleep(5000);
			cE.switchBackTpParentWindow();
			
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 192, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 192, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 192, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 192, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v+ date2);
				g.setExcelCellValue(xlPath, sheetName, 192, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 192, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 192, 5,
						screenShot + v + "_" + date1);

			}
		}
	}

}
