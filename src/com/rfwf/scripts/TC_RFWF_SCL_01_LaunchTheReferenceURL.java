package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageReferenceURL;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;

public class TC_RFWF_SCL_01_LaunchTheReferenceURL extends BaseTestNGPageReferenceURL {
	@Test
	public void textTC_RFWF_SCL_01_LaunchTheReferenceURL() throws InterruptedException {
		boolean b = false;

		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_1();
		String sheetName1 = aPOI.getSheet_2();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();

		try {
			// Input reference URL in config file->URL Sheet, in a 20
			g.setExcelCellValue(xlPath, sheetName, 2, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 2, 4, "Executed on - " + date1);
			b = true;

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 2, 3, "FAIL");
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 2, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 2, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 2, 5, screenShot + v + "_" + date1);
			}
		}
	}
}
