package com.rfwf.scripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
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
import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.Login;
import com.pageobjectmodel.pages.PageLayout;

public class TC_RFWF_SC_CP_2_CreateComponent extends BaseTestNGPageSiteCoreV2 {
	@Test(priority = 1)
	public void textTC_RFWF_SC_CP_2_CreateComponent() throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		PageLayout pL = new PageLayout(driver);
		FrontEnd fE = new FrontEnd(driver);
		ForgotPassword fP = new ForgotPassword(driver);

		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_4();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
		String sheetName1 = aPOI.getSheet_2();
		boolean b = false;

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 1940, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 1941, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 1942, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 1943, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 1944, 2);

		String tenantName = g.getExcelCellValue(xlPath, sheetName, 1945, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 1946, 2);
		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 1947, 2);
		String templateName1 = g.getExcelCellValue(xlPath, sheetName, 1948, 2);

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

			iFT.expandFolder(folderNameToCreate);
			fP.verifyComponentCreated(folderNameToCreate, templateName);

		
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 1940, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 1940, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 1940, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 1940, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 1940, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 1940, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 1940, 5, screenShot + v + "_" + date1);

			}
		}
	}

}
