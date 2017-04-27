package com.rfwf.scripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.ExperienceEditor;
import com.pageobjectmodel.pages.ForgotPassword;
import com.pageobjectmodel.pages.FrontEnd;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;
import com.basetestng.libraries.BaseTestNGPageDLSSiteFrontEnd;
import com.basetestng.libraries.BaseTestNGPageRFWFFrontEnd;
import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.Login;
import com.pageobjectmodel.pages.MailLogin;
import com.pageobjectmodel.pages.PageLayout;

public class TC_RFWF_SC_BTP_2_ConfigureBackToTop extends BaseTestNGPageSiteCoreV2 {
	@Test(priority = 1)
	public void text_RFWF_SC_BTP_2_ConfigureBackToTop() throws InterruptedException {

		// --Publish item code
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		PageLayout pL = new PageLayout(driver);
		FrontEnd fE = new FrontEnd(driver);
		Login l = new Login(driver);
		ForgotPassword fP = new ForgotPassword(driver);
		MailLogin mL = new MailLogin(driver);
		ExperienceEditor eE = new ExperienceEditor(driver);

		ReadDataFromExcel g = new ReadDataFromExcel();

		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_4();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
		String sheetName1 = aPOI.getSheet_2();
		boolean b = false;

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 2148, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 2149, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 2150, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 2151, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 2152, 2);

		String tenantName = g.getExcelCellValue(xlPath, sheetName, 2153, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 2154, 2);
		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 2155, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 2156, 2);

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
			Thread.sleep(10000);
			iFT.switchFrame5();
			pL.clickAddComponent();
			iFT.switchOutOfFrame();
			pL.clickAddHere(5);
			cE.switchFrame();
			iFT.selectSubFolder("Navigation");
			iFT.selectSubFolder("Back To Top");
			pL.clickSelect();
			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();

			Thread.sleep(10000);

			cE.switchFrame();
			pL.clickDropDownImg();
			cE.expandFolderImg("rfwfpresence");
			cE.expandFolderImg("Back To Top");
			eE.clickDivImg("scroll-btn-red-Chinese");
			Thread.sleep(10000);
			eE.clickInputButton("OK");
			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();
			iFT.switchFrame5();
			pL.clickOnSave();
			iFT.switchOutOfFrame();
			driver.close();
			cE.switchBackTpParentWindow();
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 2148, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 2148, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 2148, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 2148, 4, date1);
		} finally {
			if (b == false) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 2148, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 2148, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 2148, 5, screenShot + v + "_" + date1);

			}
		}
	}

}
