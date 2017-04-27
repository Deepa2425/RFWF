package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageVerifyUNPwd;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.Login;

public class TC_RFWF_SCL_09_VerifyUnSavedUnPwd_UncheckRemeberMe extends BaseTestNGPageVerifyUNPwd {
	@Test
	public void textTC_RFWF_SCL_09_VerifyUnSavedUnPwd_UncheckRemeberMe() throws InterruptedException {
		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_1();
		String sheetName1 = aPOI.getSheet_2();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();

		String un = g.getExcelCellValue(xlPath, sheetName, 17, 2);
		String pwd = g.getExcelCellValue(xlPath, sheetName, 18, 2);
		boolean b = false;
		ContentEditor cE = new ContentEditor(driver);

		Login l = new Login(driver);

		try {
			l.loginCreds(un, pwd);
			cE.logout1();
			l.verifyUnSavedUN();
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 17, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 17, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 17, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 17, 4, "Executed on - " + date1);

		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 17, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 17, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 17, 5, screenShot + v + "_" + date1);
			}
		}
	}
}
