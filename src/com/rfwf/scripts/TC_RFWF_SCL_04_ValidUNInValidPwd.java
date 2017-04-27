package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageVerifyUNPwd;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.Login;
import com.pageobjectmodel.pages.SitecoreLoginPage;

public class TC_RFWF_SCL_04_ValidUNInValidPwd extends BaseTestNGPageVerifyUNPwd {
	@Test
	public void textTC_RFWF_SCL_04_ValidUNInValidPwd() throws InterruptedException {
		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_1();
		String sheetName1 = aPOI.getSheet_2();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();

		String un = g.getExcelCellValue(xlPath, sheetName, 6, 2);
		String pwd = g.getExcelCellValue(xlPath, sheetName, 7, 2);
		String msg = g.getExcelCellValue(xlPath, sheetName, 8, 2);

		boolean b = false;

		Login l = new Login(driver);
		SitecoreLoginPage sLP = new SitecoreLoginPage(driver);

		try {

			l.loginCreds(un, pwd);
			sLP.verifyErrorMessageInvalidPwd(msg);
			g.setExcelCellValue(xlPath, sheetName, 6, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 6, 4, "Executed on - " + date1);
			b = true;
		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 6, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 6, 4, "Executed on - " + date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 6, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 6, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 6, 5, screenShot + v + "_" + date1);
			}
		}
	}
}
