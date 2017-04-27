package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageVerifyUNPwd;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.Login;

public class TC_RFWF_SCL_07_SelectRememberMeCheckBox extends BaseTestNGPageVerifyUNPwd {
	@Test
	public void textTC_RFWF_SCL_07_SelectRememberMeCheckBox() throws InterruptedException {
		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_1();
		String sheetName1 = aPOI.getSheet_2();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();

		boolean b = false;

		Login l = new Login(driver);

		try {
			l.verifyRememberMeCheckBox();
			l.verifyRememberMeCheckBox();
			g.setExcelCellValue(xlPath, sheetName, 14, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 14, 4, "Executed on - " + date1);
			b = true;
		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 14, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 14, 4, "Executed on - " + date1);

		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 14, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 14, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 14, 5, screenShot + v + "_" + date1);
			}
		}
	}
}
