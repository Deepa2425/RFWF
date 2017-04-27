package com.rfwf.scripts;

import org.testng.annotations.Test;
import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.FrontEnd;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;
import com.pageobjectmodel.pages.Login;
import com.pageobjectmodel.pages.PageLayout;

public class TC_RFWF_SC_LOG_39_InsertForgotUserIdSameTenantInLogin extends BaseTestNGPageSiteCoreV2 {
	@Test(priority = 1)
	public void text_RFWF_SC_LOG_39_InsertForgotUserIdSameTenantInLogin() throws InterruptedException {

		// --Publish item code
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		PageLayout pL = new PageLayout(driver);
		FrontEnd fE = new FrontEnd(driver);
		Login l = new Login(driver);

		ReadDataFromExcel g = new ReadDataFromExcel();

		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_4();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
		String sheetName1 = aPOI.getSheet_2();
		boolean b = false;

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 251, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 252, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 253, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 254, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 255, 2);

		String tenantName = g.getExcelCellValue(xlPath, sheetName, 256, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 257, 2);
		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 258, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 259, 2);
		String frontEndUrlStrt = g.getExcelCellValue(xlPath, sheetName, 260, 2);
		String frontEndUrl = frontEndUrlStrt + "\\" + folderNameToCreate + "\\" + templateName;
		String templateName2 = g.getExcelCellValue(xlPath, sheetName, 261, 2);
		String templateName3 = g.getExcelCellValue(xlPath, sheetName, 262, 2);
		String forgotuser_href = "/" + folderNameToCreate + "/" + templateName;
		String bkurl = g.getExcelCellValue(xlPath, sheetName1, 8, 1);

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
			iFT.switchFrame5();
			pL.clickOnSave();
			iFT.switchOutOfFrame();
			driver.close();
			cE.switchBackTpParentWindow();
			Thread.sleep(5000);
			cE.rtClickOnAndInsert(folderNameToCreate);
			iFT.switchFrame();
			iFT.expandRfwPresencePagesSelectSecure();
			iFT.selectSubFolder(secure);
			iFT.createTemplate(templateName2);
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
			iFT.selectSubFolderS1(templateName2, templateName3);
			pL.clickSelect();
			iFT.switchOutOfFrame();
			iFT.switchFrame();
			pL.clickCreateNewContent();
			pL.clickOK();
			iFT.switchOutOfFrame();
			iFT.switchFrame5();
			pL.clickOnSave();
			iFT.switchOutOfFrame();
			driver.close();
			cE.switchBackTpParentWindow();
			Thread.sleep(5000);
			hP.clickSave1();
			Thread.sleep(5000);
			iFT.switchFrame();
			iFT.clickOK();

			cE.publishOptions();
			cE.publishSite();
			iFT.switchFrame();
			cE.clickIncrementalPublish();
			cE.clickPublishButton();
			Thread.sleep(8000);
			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();

			iFT.switchFrame();
			cE.clickClose();
			iFT.switchOutOfFrame();
			cE.rtClickOnelement(folderNameToCreate, "Refresh");
			cE.expandFolder1(folderNameToCreate, 3);
			cE.expandFolder1(folderNameToCreate, 4);
			cE.expandFolder1(folderNameToCreate, 5);
			cE.doubleClick1(templateName3);

			Thread.sleep(5000);
			hP.clickLink("Forget User ID:");
			iFT.switchFrame();
			Thread.sleep(3000);
			iFT.expandFolderInternalLink(tenantName);
			Thread.sleep(3000);

			iFT.expandFolderInternalLink(subElement);
			Thread.sleep(3000);

			iFT.expandFolderInternalLink(folderNameToCreate);
			iFT.clickFolderInternalLink(templateName);
			iFT.inputText("Text", forgotuser_href);
			Thread.sleep(2000);
			cE.clickOK1();
			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();
			cE.clickOnlyPublishButton();
			hP.clickSave();
			cE.publishOptions();

			cE.publishItem();
			iFT.switchFrame();

			cE.checkRelatedItem();
			cE.checkSubItem();
			cE.clickPublishButton();
			Thread.sleep(3000);
			iFT.switchOutOfFrame();

			iFT.switchFrame3();
			cE.clickOK();
			Thread.sleep(5000);
			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();

			iFT.switchFrame();
			cE.clickClose();
			iFT.switchOutOfFrame();

			cE.logout();
			cE.clearBrowserCache();
			cE.clearBrowserCache();

			Thread.sleep(20000);
			driver.get(frontEndUrl);
			Thread.sleep(5000);
			fE = new FrontEnd(driver);
			fE.verifyLinkContent(templateName, forgotuser_href);
			driver.quit();

			b = true;
			g.setExcelCellValue(xlPath, sheetName, 251, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 251, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			// driver.close();
			g.setExcelCellValue(xlPath, sheetName, 251, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 251, 4, date1);
		} finally {
			if (b == false) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 251, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 251, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 251, 5, screenShot + v + "_" + date1);

			}
		}
	}

}
