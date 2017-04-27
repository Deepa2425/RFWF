package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.ForgotPassword;
import com.pageobjectmodel.pages.FrontEnd;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;
import com.pageobjectmodel.pages.Login;
import com.pageobjectmodel.pages.PageLayout;

public class TC_RFWF_SC_MP_21_PublishItem extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_SC_MP_21_PublishItem() throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		PageLayout pL = new PageLayout(driver);
		FrontEnd fE = new FrontEnd(driver);
		ForgotPassword fP = new ForgotPassword(driver);
		Login l = new Login(driver);
		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_4();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
		boolean b = false;

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 2313, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 2314, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 2315, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 2316, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 2317, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 2318, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 2319, 2);
		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 2320, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 2321, 2);
		String frontEndUrlStrt = g.getExcelCellValue(xlPath, sheetName,2322 , 2);

		String mp_frontEndUrl = frontEndUrlStrt + "\\" + folderNameToCreate + "\\" + templateName;

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

			cE.rtClickOnelement(folderNameToCreate, "Refresh");

			cE.expandFolder1(folderNameToCreate, 2);
			cE.expandFolder1(folderNameToCreate, 3);
			cE.expandFolder1(folderNameToCreate, 4);
			cE.doubleClick2(templateName1);

			Thread.sleep(3000);
			hP.editField(4, "StartName");
			hP.editField(5, "EndName");
			
			cE.clickOnlyPublishButton();
			hP.clickSave1();
			System.out.println("saved");
			cE.publishOptions();
			cE.publishItem();
			iFT.switchFrame();
			cE.clickPublishButton();
			Thread.sleep(50000);

			iFT.switchOutOfFrame();
			iFT.switchFrame();
			cE.clickClose();
			iFT.switchOutOfFrame();
			cE.logout();
			cE.clearBrowserCache();
			cE.clearBrowserCache();

			driver.get(mp_frontEndUrl);
			Thread.sleep(4000);
			fE.verifyLabelPositive("txtFirstName","StartName");
			fE.verifyLabelPositive("txtLastName","EndName");
			//script failing because of application error
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 2313, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 2313, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 2313, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 2313, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 2313, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 2313, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 2313, 5, screenShot + v + "_" + date1);

			}
		}
	}


}