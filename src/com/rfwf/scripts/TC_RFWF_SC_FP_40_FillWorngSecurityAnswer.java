package com.rfwf.scripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.DLSSiteActivateUser;
import com.pageobjectmodel.pages.ForgotPassword;
import com.pageobjectmodel.pages.FrontEnd;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;
import com.pageobjectmodel.pages.Login;
import com.pageobjectmodel.pages.MailLogin;
import com.pageobjectmodel.pages.PageLayout;

public class TC_RFWF_SC_FP_40_FillWorngSecurityAnswer extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_SC_FP_40_FillWorngSecurityAnswer() throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		PageLayout pL = new PageLayout(driver);
		FrontEnd fE = new FrontEnd(driver);
		MailLogin mL=new MailLogin(driver);
		DLSSiteActivateUser dAU=new DLSSiteActivateUser(driver);
		Login l=new Login(driver);
		ForgotPassword fP=new ForgotPassword(driver);
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_4();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
		String sheetName1 = aPOI.getSheet_2();
		ReadDataFromExcel g = new ReadDataFromExcel();

		boolean b = false;

		String bkurl = g.getExcelCellValue(xlPath, sheetName1, 8, 1);

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 1029, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 1030, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 1031, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 1032, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 1033, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 1034, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 1035, 2);
		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 1036, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 1037, 2);
		String refresh = g.getExcelCellValue(xlPath, sheetName, 1038, 2);

		String templateName2 = g.getExcelCellValue(xlPath, sheetName, 1039, 2);
		String templateName3 = g.getExcelCellValue(xlPath, sheetName, 1040, 2);
		String templateName4 = g.getExcelCellValue(xlPath, sheetName, 1041, 2);
		String templateName5 = g.getExcelCellValue(xlPath, sheetName, 1042, 2);
		String templateName6 = g.getExcelCellValue(xlPath, sheetName, 1043, 2);
		String templateName7 = g.getExcelCellValue(xlPath, sheetName, 1044, 2);
			String regUser=g.getExcelCellValue(xlPath, sheetName, 1045, 2);
		String gmailLog=g.getExcelCellValue(xlPath, sheetName, 1046, 2);
		String gmailPswd=g.getExcelCellValue(xlPath, sheetName, 1047, 2);
		String  newPswd=g.getExcelCellValue(xlPath, sheetName, 1048, 2);
		String Fname=g.getExcelCellValue(xlPath, sheetName, 1049, 2);
		String Lname=g.getExcelCellValue(xlPath, sheetName, 1050, 2);
		String compName=g.getExcelCellValue(xlPath, sheetName, 1051, 2);
		String jobTitle=g.getExcelCellValue(xlPath, sheetName, 1052, 2);
		String phn=g.getExcelCellValue(xlPath, sheetName, 1053, 2);
		String city=g.getExcelCellValue(xlPath, sheetName, 1054, 2);
		String state=g.getExcelCellValue(xlPath, sheetName, 1055, 2);
		String postalcde=g.getExcelCellValue(xlPath, sheetName, 1056, 2);

		String cntry=g.getExcelCellValue(xlPath, sheetName, 1057, 2);
		String q1=g.getExcelCellValue(xlPath, sheetName, 1058, 2);
		String a1=g.getExcelCellValue(xlPath, sheetName, 1059, 2);
		String q2=g.getExcelCellValue(xlPath, sheetName, 1060, 2);
		String a2=g.getExcelCellValue(xlPath, sheetName, 1061, 2);
		String q3=g.getExcelCellValue(xlPath, sheetName, 1062, 2);
		String a3=g.getExcelCellValue(xlPath, sheetName, 1063, 2);
String recvryPswd=g.getExcelCellValue(xlPath, sheetName, 1064, 2);
	String InvalidMsg=g.getExcelCellValue(xlPath, sheetName, 1065, 2);
String frontEndUrlStrt = g.getExcelCellValue(xlPath, sheetName,1066 , 2);

String register_frontEndUrl = frontEndUrlStrt + "\\" + folderNameToCreate + "\\" + templateName2;
String login_frontEndUrl = frontEndUrlStrt + "\\" + folderNameToCreate + "\\" + templateName6;

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
	Thread.sleep(3000);
	cE.switchBackTpParentWindow();

	// register item creation

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
	cE.rtClickOnelement(folderNameToCreate, "Refresh");

	cE.expandFolder1(folderNameToCreate, 2);
	cE.expandFolder1(folderNameToCreate, 3);
	cE.expandFolder1(folderNameToCreate, 4);
	Thread.sleep(3000);

	fE.doubleClick2(templateName3);
	hP.insertRedirectionLink("SetTheUserActivateUrl:");
	iFT.switchFrame();
	Thread.sleep(3000);
	iFT.expandFolderInternalLink(tenantName);
	Thread.sleep(3000);

	iFT.expandFolderInternalLink(subElement);
	Thread.sleep(10000);

	iFT.expandFolderInternalLink(folderNameToCreate);
	Thread.sleep(15000);

	iFT.clickFolderInternalLink(templateName);
	iFT.inputText("Text", templateName);
	Thread.sleep(2000);
	cE.clickOK1();
	iFT.switchOutOfFrame();
	iFT.switchOutOfFrame();
	cE.clickSave1();
	Thread.sleep(2000);

	// insert FP and login
	cE.rtClickOnelement(folderNameToCreate, refresh);

	cE.rtClickOnAndInsert2(folderNameToCreate);
	iFT.switchFrame();
	iFT.expandRfwPresencePagesSelectSecure();
	iFT.selectSubFolder(secure);
	iFT.createTemplate(templateName4);
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
	iFT.selectSubFolderS1(templateName4, templateName5);
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
	Thread.sleep(3000);
	cE.switchBackTpParentWindow();

	// login item creation

	cE.rtClickOnAndInsert2(folderNameToCreate);
	iFT.switchFrame();
	iFT.expandRfwPresencePagesSelectSecure();
	iFT.selectSubFolder(secure);
	iFT.createTemplate(templateName6);
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
	Thread.sleep(5000);

	iFT.selectSubFolderS1(templateName6, templateName7);
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
	cE.rtClickOnelement(folderNameToCreate, "Refresh");

	cE.expandFolder1(folderNameToCreate, 3);
	cE.expandFolder1(folderNameToCreate, 4);
	cE.expandFolder1(folderNameToCreate, 5);
	fE.doubleClick1(templateName7);
	hP.insertForgotPasswordLink();
	iFT.switchFrame();
	Thread.sleep(3000);
	iFT.expandFolderInternalLink(tenantName);
	Thread.sleep(3000);

	iFT.expandFolderInternalLink(subElement);
	Thread.sleep(15000);

	iFT.expandFolderInternalLink(folderNameToCreate);
	Thread.sleep(10000);

	iFT.clickFolderInternalLink(templateName4);
	iFT.inputText("Text", templateName4);
	Thread.sleep(2000);
	cE.clickOK1();
	iFT.switchOutOfFrame();
	iFT.switchOutOfFrame();

	// return and save
	hP.clickSave1();
	Thread.sleep(5000);

	cE.publishOptions();

	cE.publishSite();
	iFT.switchFrame();
	Thread.sleep(5000);

	cE.clickSmartPublish();
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

	Thread.sleep(20000);
	driver.get(register_frontEndUrl);
	fE.FillRegistrationForm(regUser, newPswd, Fname, Lname, gmailLog, compName, jobTitle, phn, city, state,
			cntry, postalcde, q1, a1, q2, a2, q3, a3);
	Thread.sleep(20000);
	driver.get("https://www.gmail.com");
	Thread.sleep(10000);

	mL.gmailLogin(gmailLog, gmailPswd);
	Thread.sleep(50000);

	mL.searchEmail("RegistrarEmail@honeywell.com", regUser);
	Thread.sleep(20000);
	mL.clickUserActivationLink();
	Thread.sleep(8000);
	cE.switchWindow();
	dAU.activateUser(newPswd);
	Thread.sleep(20000);
	driver.close();
	cE.switchBackTpParentWindow();

	driver.get(login_frontEndUrl);
	fP.clickLinkText(templateName4);
	fE.EnterFPUserName(regUser);
	fE.clickSubmitButton("Submit");


fE.EnterRegTextBox("Answer","wrong");
fE.EnterRegTextBox("NewPassword",recvryPswd);
fE.EnterRegTextBox("ConfirmationPassword",recvryPswd);

fE.clickSubmitButton("Submit Your Question");		
				fE.AlertUserMsg("Invalid Security Answer.");
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 1029, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 1029, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 1029, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 1029, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 1029, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 1029, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 1029, 5, screenShot + v + "_" + date1);

			}
		}
	}

}