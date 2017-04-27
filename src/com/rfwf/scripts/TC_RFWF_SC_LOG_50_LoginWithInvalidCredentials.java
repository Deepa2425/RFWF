package com.rfwf.scripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.ExperienceEditor;
import com.pageobjectmodel.pages.FrontEnd;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;
import com.basetestng.libraries.BaseTestNGPageDLSSiteFrontEnd;
import com.basetestng.libraries.BaseTestNGPageRFWFFrontEnd;
import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.Login;
import com.pageobjectmodel.pages.PageLayout;

public class TC_RFWF_SC_LOG_50_LoginWithInvalidCredentials extends BaseTestNGPageSiteCoreV2 {
	@Test(priority = 1)
	public void text_RFWF_SC_LOG_50_LoginWithInvalidCredentials() throws InterruptedException {

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

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 1476, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 1477, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 1478, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 1479, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 1480, 2);

		String tenantName = g.getExcelCellValue(xlPath, sheetName, 1481, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 1482, 2);
		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 1483, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 1484, 2);
		String frontEndUrlStrt = g.getExcelCellValue(xlPath, sheetName, 1485, 2);
		String frontEndUrl = frontEndUrlStrt + "\\" + folderNameToCreate + "\\" + templateName;
		String templateName2 = g.getExcelCellValue(xlPath, sheetName, 1486, 2);
				String templateName3 = g.getExcelCellValue(xlPath, sheetName, 1487, 2);
		String register_href = "/" + folderNameToCreate + "/" + templateName2;
		String regUser=g.getExcelCellValue(xlPath, sheetName, 1488, 2);
	String  newPswd=g.getExcelCellValue(xlPath, sheetName, 1489, 2);
	String Fname=g.getExcelCellValue(xlPath, sheetName, 1490, 2);
	String Lname=g.getExcelCellValue(xlPath, sheetName, 1491, 2);
	String compName=g.getExcelCellValue(xlPath, sheetName, 1492, 2);
	String jobTitle=g.getExcelCellValue(xlPath, sheetName, 1493, 2);
	String phn=g.getExcelCellValue(xlPath, sheetName, 1494, 2);
	String city=g.getExcelCellValue(xlPath, sheetName, 1495, 2);
	String state=g.getExcelCellValue(xlPath, sheetName, 1496, 2);
	String postalcde=g.getExcelCellValue(xlPath, sheetName, 1497, 2);

	String cntry=g.getExcelCellValue(xlPath, sheetName, 1498, 2);
	String q1=g.getExcelCellValue(xlPath, sheetName, 1499, 2);
	String a1=g.getExcelCellValue(xlPath, sheetName, 1500, 2);
	String q2=g.getExcelCellValue(xlPath, sheetName, 1501, 2);
	String a2=g.getExcelCellValue(xlPath, sheetName, 1502, 2);
	String q3=g.getExcelCellValue(xlPath, sheetName, 1503, 2);
	String a3=g.getExcelCellValue(xlPath, sheetName, 1504, 2);
	String gmailLog=g.getExcelCellValue(xlPath, sheetName, 1505, 2);
	String Invalidmsg=g.getExcelCellValue(xlPath, sheetName, 1506, 2);
	
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
		//
						cE.rtClickOnelement(folderNameToCreate, "Refresh");
			cE.expandFolder1(folderNameToCreate, 2);
			cE.expandFolder1(folderNameToCreate, 3);
			cE.expandFolder1(folderNameToCreate, 4);
			cE.doubleClick1(templateName1);
			Thread.sleep(5000);
			hP.insertRegisterLink();
			Thread.sleep(3000);
			cE.switchFrame();
			iFT.expandFolderInternalLink(tenantName);
			Thread.sleep(3000);

			iFT.expandFolderInternalLink(subElement);
			Thread.sleep(3000);

			iFT.expandFolderInternalLink(folderNameToCreate);
			iFT.clickFolderInternalLink(templateName2);
			iFT.inputText("Text", templateName2);
			Thread.sleep(2000);
			cE.clickOK1();
			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();
			cE.clickSave1();
			cE.publishOptions();
			cE.publishSite();
			iFT.switchFrame();
//			cE.clickIncrementalPublish();
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
			Thread.sleep(5000);
			cE.clickLink(templateName2);

			 fE.FillRegistrationForm(regUser, newPswd, Fname, Lname, gmailLog,
					 compName, jobTitle, phn, city, state, cntry, postalcde, q1, a1,
					 q2, a2, q3, a3);
									Thread.sleep(5000);

			 driver.get(frontEndUrl);
				fE.inputText("UserName", regUser);
				fE.inputText("Password",newPswd );
				fE.clickLoginButton();
				//fE.verifyDivErrorMsg("User ID not found in LDAP.");
				fE.verifyDivErrorMsg(Invalidmsg);
				b = true;
			g.setExcelCellValue(xlPath, sheetName, 1476, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 1476, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			// driver.close();
			g.setExcelCellValue(xlPath, sheetName, 1476, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 1476, 4, date1);
		} finally {
			if (b == false) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 1476, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 1476, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 1476, 5, screenShot + v + "_" + date1);

			}
		}
	}

}
