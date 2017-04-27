package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageDLSSiteFrontEnd;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.DLSSiteRegisterPage;

public class TC_RFWF_SC_REG_41_VerifyHelpMenu extends BaseTestNGPageDLSSiteFrontEnd {
	@Test
	public void textTC_RFWF_SC_REG_41_VerifyHelpMenu() throws InterruptedException {
		DLSSiteRegisterPage dSSRP = new DLSSiteRegisterPage(driver);
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
			dSSRP.clickOnHelpMenu();
			String v[]={"What is a User ID ?","Creating a User ID and Password","How to choose a User ID ?","Password Rules","Security Question Rules","Security Answer Rules"};
			dSSRP.verifyHelpMenu(v);
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 66, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 66, 4, "Executed on - " + date1);
			
		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 66, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 66, 4, "Executed on - " + date1);
			
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v+ date2);
				g.setExcelCellValue(xlPath, sheetName, 66, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 66, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 66, 5,
						screenShot + v + "_" + date1);
			}
		}
	}
}



