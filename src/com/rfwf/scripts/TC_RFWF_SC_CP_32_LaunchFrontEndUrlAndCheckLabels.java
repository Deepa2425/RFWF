package com.rfwf.scripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.ExperienceEditor;
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

public class TC_RFWF_SC_CP_32_LaunchFrontEndUrlAndCheckLabels extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_SC_CP_32_LaunchFrontEndUrlAndCheckLabels() throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		PageLayout pL = new PageLayout(driver);
		Login l = new Login(driver);
		ExperienceEditor eE = new ExperienceEditor(driver);
		ForgotPassword fP = new ForgotPassword(driver);
		FrontEnd fE=new FrontEnd(driver);
		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_4();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
		String sheetName1 = aPOI.getSheet_2();
		boolean b = false;

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 2903, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 2904, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 2905, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 2906, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 2907, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 2908, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 2909, 2);
		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 2910, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 2911, 2);
		String frontEndUrlStrt = g.getExcelCellValue(xlPath, sheetName, 2912, 2);
		String frontEndUrl = frontEndUrlStrt + "\\" + folderNameToCreate + "\\" + templateName;

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

			//	hP.clickSave1();
			Thread.sleep(5000);
			cE.publishOptions();
			cE.publishSite();
			iFT.switchFrame();
			cE.clickPublishButton();
			Thread.sleep(80000);
			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();

			iFT.switchFrame();
			cE.clickClose();
			iFT.switchOutOfFrame();
			cE.logout();
			cE.clearBrowserCache();
			cE.clearBrowserCache();
           
			driver.get(frontEndUrl);
			fE.verifyHeading("Change Password");
			fE.verifyLabelPositive("txtCurrentPassword","Password");
			fE.verifyLabelPositive("txtConfirmationPassword","Confirm Password");
			fE.verifyLabelPositive("txtUsername","User Name");
			fE.verifyLabelPositive("txtNewPassword","New Password");
			
			
			Thread.sleep(4000);
			
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 2903, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 2903, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 2903, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 2903, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 2903, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 2903, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 2903, 5,
						screenShot + v + "_" + date1);

			}
		}
	}

}
