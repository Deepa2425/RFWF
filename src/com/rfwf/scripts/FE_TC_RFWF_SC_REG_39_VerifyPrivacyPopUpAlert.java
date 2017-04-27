package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageDLSSiteFrontEnd;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.DLSSiteRegisterPage;

public class FE_TC_RFWF_SC_REG_39_VerifyPrivacyPopUpAlert extends BaseTestNGPageDLSSiteFrontEnd {
	@Test
	public void textFE_TC_RFWF_SC_REG_39_VerifyPrivacyPopUpAlert() throws Exception {
		DLSSiteRegisterPage dSSRP = new DLSSiteRegisterPage(driver);
		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_1();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
		
		boolean b = false;
		String userName = g.getExcelCellValue(xlPath, sheetName, 327, 2);
		String password = g.getExcelCellValue(xlPath, sheetName, 328, 2);
		String firstName = g.getExcelCellValue(xlPath, sheetName, 329, 2);
		String lastName = g.getExcelCellValue(xlPath, sheetName, 330, 2);
		String email = g.getExcelCellValue(xlPath, sheetName, 331, 2);
		String company = g.getExcelCellValue(xlPath, sheetName, 332, 2);
		String jobTitle = g.getExcelCellValue(xlPath, sheetName, 333, 2);
		String phone = g.getExcelCellValue(xlPath, sheetName, 334, 2);
		String city = g.getExcelCellValue(xlPath, sheetName, 335, 2);
		String state = g.getExcelCellValue(xlPath, sheetName, 336, 2);
		
		String countryC = g.getExcelCellValue(xlPath, sheetName, 337, 2);
		String q1 = g.getExcelCellValue(xlPath, sheetName, 14, 2);
		String a1 = g.getExcelCellValue(xlPath, sheetName, 340, 2);
		String q2 = g.getExcelCellValue(xlPath, sheetName, 16, 2);
		String a2 = g.getExcelCellValue(xlPath, sheetName, 342, 2);
		String q3 = g.getExcelCellValue(xlPath, sheetName, 18, 2);
		String a3 = g.getExcelCellValue(xlPath, sheetName, 344, 2);
	
		try {
			dSSRP.registerUser(userName,password,password,firstName,lastName,email,email,company,jobTitle,phone,city,state,101,countryC,1,a1,2,a2,3,a3);
			dSSRP.clickOnRegisterButton();

			b = true;
			g.setExcelCellValue(xlPath, sheetName, 327, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 327, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 327, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 327, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 327, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 327, 4, "Executed on - " + date1);

				g.setExcelCellValue(xlPath, sheetName, 327, 5,
						screenShot + v + "_" + date1);
			}
		}
	}

}
