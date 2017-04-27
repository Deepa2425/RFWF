package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageVerifyUNPwd;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.Login;

public class TC_RFWF_SCL_11_VerifyForgotYourPwdLinkWithoutClearingCache extends BaseTestNGPageVerifyUNPwd {
	@Test
	public void textTC_RFWF_SCL_11_VerifyForgotYourPwdLinkWithoutClearingCache() throws InterruptedException {

		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_1();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();

		String forgetLinkName = g.getExcelCellValue(xlPath, sheetName, 124, 2);
		String name = g.getExcelCellValue(xlPath, sheetName, 125, 2);

		boolean b = false;
		ContentEditor cE = new ContentEditor(driver);

		Login l = new Login(driver);

		try {
     		l.loginCreds(name, "");
			cE.clickLink(forgetLinkName);
			//l.forgotPwdUN(name);
			b = true;

			g.setExcelCellValue(xlPath, sheetName, 124, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 124, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 124, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 124, 4, "Executed on - " + date1);
			
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 124, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 124, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 124, 5, screenShot + v + "_" + date1);
			}
		}
	}
}
