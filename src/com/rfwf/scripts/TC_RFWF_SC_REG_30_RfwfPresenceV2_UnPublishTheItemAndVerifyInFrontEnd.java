package com.rfwf.scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.FrontEnd;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;
import com.pageobjectmodel.pages.PageLayout;

public class TC_RFWF_SC_REG_30_RfwfPresenceV2_UnPublishTheItemAndVerifyInFrontEnd extends BaseTestNGPageSiteCoreV2 {
	@Test(priority = 1)
	public void textTC_RFWF_SC_REG_30_RfwfPresenceV2_UnPublishTheItemAndVerifyInFrontEnd() throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		PageLayout pL = new PageLayout(driver);
		FrontEnd fe = new FrontEnd(driver);
		boolean b = false;

		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_1();
		String sheetName1 = aPOI.getSheet_2();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 305, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 306, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 307, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 308, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 309, 2);
		String publish = g.getExcelCellValue(xlPath, sheetName, 310, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 311, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 312, 2);

		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 313, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 315, 2);
		String component = g.getExcelCellValue(xlPath, sheetName, 316, 2);
		String refresh = g.getExcelCellValue(xlPath, sheetName, 317, 2);
		String userActivate = g.getExcelCellValue(xlPath, sheetName, 318, 2);
		String save = g.getExcelCellValue(xlPath, sheetName, 319, 2);
		String login = g.getExcelCellValue(xlPath, sheetName, 320, 2);
		String frontEndURL = g.getExcelCellValue(xlPath, sheetName1, 24, 1);

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

			cE.logout();
			driver.get(frontEndURL);
			fe.verifyFrontEndCreationREG_Negative();
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 305, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 305, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 305, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 305, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 305, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 305, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 305, 5, screenShot + v + "_" + date1);

			}
		}
	}

}
