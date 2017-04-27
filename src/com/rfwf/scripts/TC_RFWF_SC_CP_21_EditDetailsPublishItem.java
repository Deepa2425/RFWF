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

public class TC_RFWF_SC_CP_21_EditDetailsPublishItem extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_SC_CP_21_EditDetailsPublishItem() throws InterruptedException {
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

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 2865, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 2866, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 2867, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 2868, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 2869, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 2870, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 2871, 2);
		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 2872, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 2873, 2);
		String frontEndUrlStrt = g.getExcelCellValue(xlPath, sheetName, 2874, 2);
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

			cE.rtClickOnelement(folderNameToCreate, "Refresh");

			cE.expandFolder1(folderNameToCreate, 2);
			cE.expandFolder1(folderNameToCreate, 3);
			cE.expandFolder1(folderNameToCreate, 4);

			cE.doubleClick1(templateName1);
			System.out.println("clicked");
			Thread.sleep(5000);
			hP.editField(8, "Pswd");
		//	hP.editField(10, "EditUn");
			hP.editField(9, "cnfrm Pswd");
		//	hP.editField(13, "new Pswd");
			
			
			//10-un
			//8-pswd
			//9-cnfr
			//13 new
			//12 chng
			
			System.out.println("edited");
			
			Thread.sleep(5000);

			hP.clickSave1();
			Thread.sleep(5000);
			cE.publishOptions();
			cE.publishItem();
			iFT.switchFrame();
			cE.clickPublishButton();
			iFT.switchOutOfFrame();
			iFT.switchFrame3();
			cE.clickOK();
			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();

			iFT.switchFrame();
			cE.clickClose();
			iFT.switchOutOfFrame();
			cE.logout();
			cE.clearBrowserCache();
			cE.clearBrowserCache();

			driver.get(frontEndUrl);
			Thread.sleep(4000);
			//fE.verifyFPUsernameLabelPositive("username");
			fE.verifyLabelPositive("txtCurrentPassword","Pswd");
			fE.verifyLabelPositive("txtConfirmationPassword","cnfrm Pswd");
			//failing because of bug
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 2865, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 2865, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 2865, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 2865, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 2865, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 2865, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 2865, 5,
						screenShot + v + "_" + date1);

			}
		}
	}

}
