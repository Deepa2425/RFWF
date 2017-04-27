package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageVerifyUNPwd;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.Login;

public class TC_RFWF_SCL_10_VerifyForgotYourPwdLinkClearCache extends BaseTestNGPageVerifyUNPwd {
	@Test
	public void textTC_RFWF_SCL_10_VerifyForgotYourPwdLinkClearCache() throws InterruptedException {
		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_1();
		String screenShot = aPOI.getSheet_1();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
		String name = g.getExcelCellValue(xlPath, sheetName, 121, 2);

		boolean b = false;
		ContentEditor cE = new ContentEditor(driver);
		Login l = new Login(driver);

		try {
			cE.clearBrowserCache();
			cE.clickLink(name);
			l.forgotPwdUN("");
			b = true;

			g.setExcelCellValue(xlPath, sheetName, 121, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 121, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 121, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 121, 4, "Executed on - " + date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 121, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 121, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 121, 5, screenShot + v + "_" + date1);
			}
		}
	}
}
