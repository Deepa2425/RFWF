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

public class TC_RFWF_SC_AP_37_EnterValidDataInAPandVerifyInputFields extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_SC_AP_37_EnterValidDataInAPandVerifyInputFields() throws InterruptedException {
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

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 1605, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 1606, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 1607, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName,1608, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 1609, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 1610, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 1611, 2);
		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 1612, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 1613, 2);
		String refresh = g.getExcelCellValue(xlPath, sheetName, 1614, 2);

		String templateName2 = g.getExcelCellValue(xlPath, sheetName, 1615, 2);
		String templateName3 = g.getExcelCellValue(xlPath, sheetName, 1616, 2);
		String templateName4 = g.getExcelCellValue(xlPath, sheetName, 1617, 2);
		String templateName5 = g.getExcelCellValue(xlPath, sheetName, 1618, 2);
		String templateName6 = g.getExcelCellValue(xlPath, sheetName, 1619, 2);
		String templateName7 = g.getExcelCellValue(xlPath, sheetName, 1620, 2);
		
			String regUser=g.getExcelCellValue(xlPath, sheetName, 1621, 2);
		String gmailLog=g.getExcelCellValue(xlPath, sheetName, 1622, 2);
		String gmailPswd=g.getExcelCellValue(xlPath, sheetName, 1623, 2);
		String  newPswd=g.getExcelCellValue(xlPath, sheetName, 1624, 2);
		String Fname=g.getExcelCellValue(xlPath, sheetName, 1625, 2);
		String Lname=g.getExcelCellValue(xlPath, sheetName, 1626, 2);
		String compName=g.getExcelCellValue(xlPath, sheetName, 1627, 2);
		String jobTitle=g.getExcelCellValue(xlPath, sheetName, 1628, 2);
		String phn=g.getExcelCellValue(xlPath, sheetName, 1629, 2);
		String city=g.getExcelCellValue(xlPath, sheetName, 1630, 2);
		String state=g.getExcelCellValue(xlPath, sheetName, 1631, 2);
		String postalcde=g.getExcelCellValue(xlPath, sheetName, 1632, 2);

		String cntry=g.getExcelCellValue(xlPath, sheetName, 1633, 2);
		String q1=g.getExcelCellValue(xlPath, sheetName, 1634, 2);
		String a1=g.getExcelCellValue(xlPath, sheetName, 1635, 2);
		String q2=g.getExcelCellValue(xlPath, sheetName, 1636, 2);
		String a2=g.getExcelCellValue(xlPath, sheetName, 1637, 2);
		String q3=g.getExcelCellValue(xlPath, sheetName, 1638, 2);
		String a3=g.getExcelCellValue(xlPath, sheetName, 1639, 2);
String recvryPswd=g.getExcelCellValue(xlPath, sheetName, 1640, 2);
	String InvalidMsg=g.getExcelCellValue(xlPath, sheetName, 1641, 2);
String frontEndUrlStrt = g.getExcelCellValue(xlPath, sheetName,1642 , 2);
String templateName8=g.getExcelCellValue(xlPath, sheetName,1643 , 2);
String templateName9=g.getExcelCellValue(xlPath, sheetName,1644 , 2);

String register_frontEndUrl = frontEndUrlStrt + "\\" + folderNameToCreate + "\\" + templateName2;
String login_frontEndUrl = frontEndUrlStrt + "\\" + folderNameToCreate + "\\" + templateName6;
String activatePassword_frontEndUrl=frontEndUrlStrt + "\\" + folderNameToCreate + "\\" + templateName8;
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
			fE.doubleClick2(templateName3);
			Thread.sleep(5000);
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
			hP.clickSave1();
			Thread.sleep(5000);
//new code
			cE.rtClickOnelement(folderNameToCreate, "Refresh");

			cE.rtClickOnAndInsert2(folderNameToCreate);
			
			
			iFT.switchFrame();
			iFT.expandRfwPresencePagesSelectSecure();
			iFT.selectSubFolder(secure);
			iFT.createTemplate(templateName8);
			iFT.clickInsert();
			iFT.switchOutOfFrame();

			cE.unlockTemplate();
			cE.clickPublishAndExperienceEditor();
			Thread.sleep(40000);
			cE.switchWindow();

			pL.clickPageLayout();
			iFT.switchFrame();
			Thread.sleep(8000);

			iFT.selectSubFolder(pageLayout);
			pL.selectPageLayout(5);
			pL.clickSelect();
			iFT.switchOutOfFrame();

			pL.clickPageLayout();
			iFT.switchFrame();
			Thread.sleep(5000);

			iFT.selectSubFolderS1(templateName8, templateName9);
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
			//insert AP in FP
			cE.rtClickOnelement(folderNameToCreate, "Refresh");

			cE.expandFolder1(folderNameToCreate, 3);
			cE.expandFolder1(folderNameToCreate, 4);
			cE.expandFolder1(folderNameToCreate, 5);
			fP.doubleClickFp2(templateName5);
			hP.insertRedirectionLink("SetTheActivatePasswordUrl:");
			iFT.switchFrame();
			Thread.sleep(3000);
			iFT.expandFolderInternalLink(tenantName);
			Thread.sleep(3000);

			iFT.expandFolderInternalLink(subElement);
			Thread.sleep(15000);

			iFT.expandFolderInternalLink(folderNameToCreate);
			Thread.sleep(10000);
			iFT.clickFolderInternalLink(templateName8);
			
			iFT.inputText("Text", templateName8);
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
			Thread.sleep(120000);
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
			 fE.FillRegistrationForm(regUser, newPswd, Fname, Lname, gmailLog,
			 compName, jobTitle, phn, city, state, cntry, postalcde, q1, a1,
			 q2, a2, q3, a3);
			 				Thread.sleep(50000);
		
			 driver.get("https://www.gmail.com");
			Thread.sleep(20000);

				mL.gmailLogin(gmailLog,gmailPswd);
				Thread.sleep(50000);

				mL.searchEmail("RegistrarEmail@honeywell.com",regUser);
				Thread.sleep(20000);
				mL.clickUserActivationLink();
				Thread.sleep(8000);
				cE.switchWindow();
				dAU.activateUser(newPswd);
				Thread.sleep(20000);
				driver.close();
				cE.switchBackTpParentWindow();
	
				driver.get(login_frontEndUrl);
				System.out.println("frontend of login");
				fP.clickLinkText(templateName4);
				System.out.println("click of login");

				fE.EnterFPUserName(regUser);
				fE.clickSubmitButton("Submit");		
				Thread.sleep(5000);
				fE.clickSubmitButton("Send Email");		
				Thread.sleep(15000);
				//get the code
				//String code=fE.getInputValue("ResetCode");
				String cdm=driver.findElement(By.xpath("//div/input[@id='ResetCode']")).getAttribute("value").toString();
				Thread.sleep(10000);

					driver.get("https://www.gmail.com");
				//	mL.gmailLogin(gmailLog,gmailPswd);
					Thread.sleep(120000);
					String text="Dear "+Fname;
				System.out.println(text);
						mL.searchEmail1("forgotpassword@honeywell.com",text,1);
						Thread.sleep(5000);
						mL.clickUserActivationLink();

						cE.switchWindow();
						fE.inputText("txtUsername2",regUser);
						fE.inputText("txtUnlockCode",cdm);
						Thread.sleep(10000);

						fE.clickSubmitButton("Submit");		
						Thread.sleep(5000);
						//verify the aswerques page

						fE.verifyHeading("Login Information");

						fE.verifyInputText("txtUsername",regUser);
						fE.verifyInputText("txtNewPassword","");
						fE.verifyInputText("txtConfirmationPassword","");

						fE.verifyHeading("Select Question");

						
				b = true;
			g.setExcelCellValue(xlPath, sheetName, 1605, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 1605, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 1605, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 1605, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 1605, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 1605, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 1605, 5, screenShot + v + "_" + date1);

			}
		}
	}

}
