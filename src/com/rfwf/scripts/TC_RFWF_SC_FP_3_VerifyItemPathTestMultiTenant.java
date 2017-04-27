package com.rfwf.scripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class TC_RFWF_SC_FP_3_VerifyItemPathTestMultiTenant extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_SC_REG_3_VerifyItemPathTestMultiTenant() throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		ForgotPassword fP = new ForgotPassword(driver);

		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_4();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();	
		String sheetName1 = aPOI.getSheet_2();
		boolean b = false;
				String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 350, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 351, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 352, 2);
		String secure = g.getExcelCellValue(xlPath, sheetName, 353, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 354, 2);

		String tenantName = g.getExcelCellValue(xlPath, sheetName, 355, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 356, 2);
		String refresh = g.getExcelCellValue(xlPath, sheetName, 357, 2);
		String path = g.getExcelCellValue(xlPath, sheetName, 358, 2);

		try {
			hP.clickOnContentEditor();
			cE.clickOnTenant(tenantName);
			cE.rtClickOnAndInsert1(subElement);
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

			hP.getItemPathText(path);

			cE.logout();
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 350, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 350, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 350, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 350, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v+ date2);
				g.setExcelCellValue(xlPath, sheetName, 350, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 350, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 350, 5,
						screenShot+ v + "_" + date1);
			}
		}
	}
}
