package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageDLSSiteFrontEnd;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.Login;

public class FE_TC_RFWF_SC_REG_42_VerifyLoginButtonInRegisterPage extends BaseTestNGPageDLSSiteFrontEnd {
	@Test
	public void textFE_TC_RFWF_SC_REG_42_VerifyLoginButtonInRegisterPage() throws InterruptedException {
		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_1();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();	
		boolean b = false;
		Login l = new Login(driver);
		
		String unAttribute = g.getExcelCellValue(xlPath, sheetName, 353, 2);
		String pwAttribute = g.getExcelCellValue(xlPath, sheetName, 354, 2);

		try {
			l.clcikLogInInRegisterPage();
		    l.verifyAttribute(unAttribute);
		    l.verifyAttribute(pwAttribute);
		    
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 352, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 352, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 352, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 352, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 352, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 352, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 352, 5,
						screenShot + v + "_" + date1);
			}
		}
	}

}
