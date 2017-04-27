package com.rfwf.scripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.FrontEnd;

import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.ForgotPassword;
import com.pageobjectmodel.pages.FrontEnd;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;
import com.basetestng.libraries.BaseTestNGPageDLSSiteFrontEnd;
import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.Login;
import com.pageobjectmodel.pages.PageLayout;

public class TC_RFWF_SC_AP_10_EditDetailsAndSave extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_SC_AP_10_EditDetailsAndSave() throws InterruptedException {
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

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 1522, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 1523, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 1524, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 1525, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 1526, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 1527, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 1528, 2);
		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 1529, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 1530, 2);

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
			Thread.sleep(20000);
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
			fE.doubleClick1(templateName1);

			Thread.sleep(3000);
			hP.editField(14, "EditUn");
			hP.editField(12, "EditPw");

			cE.clickOnlyPublishButton();
			hP.clickSave1();

			iFT.logout();
			Thread.sleep(5000);

			l.loginCreds("H138128", "H138128");

			hP.clickOnContentEditor();
			cE.clickOnTenant(tenantName);
			cE.clickOnTenant(subElement);

			Thread.sleep(10000);
			cE.expandFolder1(folderNameToCreate, 1);

			cE.expandFolder1(folderNameToCreate, 2);
			cE.expandFolder1(folderNameToCreate, 3);
			cE.expandFolder1(folderNameToCreate, 4);

			fE.doubleClick1(templateName1);

			Thread.sleep(50000);
			hP.editFieldGetText(14, "EditUn");
			hP.editFieldGetText(12, "EditPw");

			b = true;
			g.setExcelCellValue(xlPath, sheetName, 1522, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 1522, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 1522, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 1522, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 1522, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 1522, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 1522, 4, screenShot + v + "_" + date1);

			}
		}
	}

}
