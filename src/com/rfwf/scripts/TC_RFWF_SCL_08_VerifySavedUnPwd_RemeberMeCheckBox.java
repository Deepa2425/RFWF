package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageVerifyUNPwd;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.Login;

public class TC_RFWF_SCL_08_VerifySavedUnPwd_RemeberMeCheckBox extends BaseTestNGPageVerifyUNPwd {
	@Test
	public void textTC_RFWF_SCL_08_VerifySavedUnPwd_RemeberMeCheckBox() throws InterruptedException {
		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_1();
		String sheetName1 = aPOI.getSheet_2();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();

		String un = g.getExcelCellValue(xlPath, sheetName, 15, 2);
		String pwd = g.getExcelCellValue(xlPath, sheetName, 16, 2);
		System.out.println(un);
		System.out.println(pwd);
		boolean b = false;
		ContentEditor cE = new ContentEditor(driver);
		Login l = new Login(driver);

		try {
			l.verifyRememberMeCheckBox();
			l.loginCreds(un, pwd);
			cE.logout1();
			l.verifySavedUN(un);
			g.setExcelCellValue(xlPath, sheetName, 15, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 15, 4, "Executed on - " + date1);
			b = true;
		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 15, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 15, 4, "Executed on - " + date1);

		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 15, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 15, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 15, 5, screenShot + v + "_" + date1);
			}
		}
	}
}
