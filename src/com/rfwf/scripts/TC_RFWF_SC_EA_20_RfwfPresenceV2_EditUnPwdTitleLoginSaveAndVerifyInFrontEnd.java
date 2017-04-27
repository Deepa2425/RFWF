package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;
import com.pageobjectmodel.pages.PageLayout;

public class TC_RFWF_SC_EA_20_RfwfPresenceV2_EditUnPwdTitleLoginSaveAndVerifyInFrontEnd
		extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_SC_EA_20_RfwfPresenceV2_EditUnPwdTitleLoginSaveAndVerifyInFrontEnd()
			throws InterruptedException {
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

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 974, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 975, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 976, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 977, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 978, 2);
		String publish = g.getExcelCellValue(xlPath, sheetName, 979, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 980, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 981, 2);

		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 982, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 984, 2);
		String component = g.getExcelCellValue(xlPath, sheetName, 985, 2);
		String refresh = g.getExcelCellValue(xlPath, sheetName, 986, 2);
		String userActivate = g.getExcelCellValue(xlPath, sheetName, 987, 2);
		String save = g.getExcelCellValue(xlPath, sheetName, 988, 2);
		String login = g.getExcelCellValue(xlPath, sheetName, 720, 2);
		String frontEndURL = g.getExcelCellValue(xlPath, sheetName1, 34, 1);

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
			cE.selectSubFolderS4("Activate Email", 1);
			cE.selectSubFolderS4("Activate Email", 1);
			hP.editField(1,"EditedEmailTitle");

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
			//Update correct argument, currently front end is not working.
			cE.verifyFrontEndFieldsPositive("txtUsername", "EditedEmailTitle");
			
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 974, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 974, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 974, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 974, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 974, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 974, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 974, 5, screenShot + v + "_" + date1);

			}
		}
	}

}
