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

public class TC_RFWF_SC_LOG_49_LoginWithoutUserIdActivation extends BaseTestNGPageSiteCoreV2 {
	@Test(priority = 1)
	public void text_RFWF_SC_LOG_49_LoginWithoutUserIdActivation() throws InterruptedException {

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

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 1442, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 1443, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 1444, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 1445, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 1446, 2);

		String tenantName = g.getExcelCellValue(xlPath, sheetName, 1447, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 1448, 2);
		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 1449, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 1450, 2);
		String frontEndUrlStrt = g.getExcelCellValue(xlPath, sheetName, 1451, 2);
		String frontEndUrl = frontEndUrlStrt + "\\" + folderNameToCreate + "\\" + templateName;
		String templateName2 = g.getExcelCellValue(xlPath, sheetName, 1452, 2);
				String templateName3 = g.getExcelCellValue(xlPath, sheetName, 1453, 2);
		String register_href = "/" + folderNameToCreate + "/" + templateName2;
		String regUser=g.getExcelCellValue(xlPath, sheetName, 1454, 2);
	String  newPswd=g.getExcelCellValue(xlPath, sheetName, 1455, 2);
	String Fname=g.getExcelCellValue(xlPath, sheetName, 1456, 2);
	String Lname=g.getExcelCellValue(xlPath, sheetName, 1457, 2);
	String compName=g.getExcelCellValue(xlPath, sheetName, 1458, 2);
	String jobTitle=g.getExcelCellValue(xlPath, sheetName, 1459, 2);
	String phn=g.getExcelCellValue(xlPath, sheetName, 1460, 2);
	String city=g.getExcelCellValue(xlPath, sheetName, 1461, 2);
	String state=g.getExcelCellValue(xlPath, sheetName, 1462, 2);
	String postalcde=g.getExcelCellValue(xlPath, sheetName, 1463, 2);

	String cntry=g.getExcelCellValue(xlPath, sheetName, 1464, 2);
	String q1=g.getExcelCellValue(xlPath, sheetName, 1465, 2);
	String a1=g.getExcelCellValue(xlPath, sheetName, 1466, 2);
	String q2=g.getExcelCellValue(xlPath, sheetName, 1467, 2);
	String a2=g.getExcelCellValue(xlPath, sheetName, 1468, 2);
	String q3=g.getExcelCellValue(xlPath, sheetName, 1469, 2);
	String a3=g.getExcelCellValue(xlPath, sheetName, 1470, 2);
	String gmailLog=g.getExcelCellValue(xlPath, sheetName, 1471, 2);
	String invmsg=g.getExcelCellValue(xlPath, sheetName, 1472, 2);
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
				//fE.verifyDivErrorMsg("User Name is still provisional and has not been activated. Please check your email and activate your account.");
				fE.verifyDivErrorMsg(invmsg);
				b = true;
			g.setExcelCellValue(xlPath, sheetName, 1442, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 1442, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			// driver.close();
			g.setExcelCellValue(xlPath, sheetName, 1442, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 1442, 4, date1);
		} finally {
			if (b == false) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 1442, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 1442, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 1442, 5, screenShot + v + "_" + date1);

			}
		}
	}

}
