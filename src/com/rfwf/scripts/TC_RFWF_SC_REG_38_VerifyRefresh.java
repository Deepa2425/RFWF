package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageDLSSiteFrontEnd;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.DLSSiteRegisterPage;

public class TC_RFWF_SC_REG_38_VerifyRefresh extends BaseTestNGPageDLSSiteFrontEnd {
	@Test
	public void textTC_RFWF_SC_REG_34_VerifyRefresh() throws InterruptedException {
		DLSSiteRegisterPage dSSRP = new DLSSiteRegisterPage(driver);
		ReadDataFromExcel g = new ReadDataFromExcel();

		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_1();
		String sheetName1 = aPOI.getSheet_2();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
		String msg = g.getExcelCellValue(xlPath, sheetName, 28, 2);
		boolean b = false;
		
		try { 
			dSSRP.verifyText(msg);
			dSSRP.clickRefresh();
			Thread.sleep(3000);
			dSSRP.clickRefresh();
			Thread.sleep(3000);
			dSSRP.clickRefresh();
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 28, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 28, 4, "Executed on - " + date1);
			
		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 28, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 28, 4, "Executed on - " + date1);
			//ScreenShotClass.captureScreenshot1(driver, "InvalidUNValidPwd" + date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v+ date2);
				g.setExcelCellValue(xlPath, sheetName, 28, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 28, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 28, 5,
						screenShot + v + "_" + date1);
			}
		}
	}
}
