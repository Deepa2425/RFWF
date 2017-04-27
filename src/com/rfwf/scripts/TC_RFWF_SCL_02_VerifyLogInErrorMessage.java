package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCore;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.Login;
import com.pageobjectmodel.pages.PageLayout;

public class TC_RFWF_SCL_02_VerifyLogInErrorMessage extends BaseTestNGPageSiteCore {
	@Test
	public void textTC_RFWF_SCL_02_VerifyLogInErrorMessage() throws InterruptedException {

		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath ="C:\\RFWF_FRAMEWORK\\RFWF\\test-input\\config.xlsx";;
				//aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_1();
		String sheetName1 = aPOI.getSheet_2();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
		boolean b = false;

		Login l = new Login(driver);
		String errrorMessage = g.getExcelCellValue(xlPath, sheetName, 59, 2);
		PageLayout pL = new PageLayout(driver);

		try {
			System.out.println(xlPath);
			System.out.println(sheetName);
			l.loginCreds("", "");
			pL.verifyerrorMessage("Please enter your login credentials.");
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 996, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 996, 4, "Executed on - " + date1);
			
		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 996, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 996, 4, "Executed on - " + date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 996, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 996, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 996, 5, screenShot + v + "_" + date1);
			}
		}
	}
}
